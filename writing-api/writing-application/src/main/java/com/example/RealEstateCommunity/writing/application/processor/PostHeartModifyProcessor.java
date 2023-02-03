package com.example.RealEstateCommunity.writing.application.processor;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.example.RealEstateCommunity.writing.domain.Heart;
import com.example.RealEstateCommunity.writing.domain.Post;
import com.example.RealEstateCommunity.writing.domain.repository.HeartRepository;
import com.example.RealEstateCommunity.writing.domain.repository.PostRepository;

@Component
public class PostHeartModifyProcessor {

    private final HeartRepository heartRepository;
    private final PostRepository postRepository;
    private Map<Long, Long> heartMap;

    public PostHeartModifyProcessor(
        HeartRepository heartRepository,
        PostRepository postRepository) {
        this.heartRepository = heartRepository;
        this.postRepository = postRepository;
    }

    @Scheduled(fixedDelay = 50000)
    @Transactional
    public void execute() {
        List<Heart> heartList = heartRepository.findByChecked(false);
        heartMap = new HashMap<>();
        setHeartMap(heartList);
        setHeartNumber();
    }

    private void setHeartMap(List<Heart> heartList){
        Long start = 1L;

        for(Heart heart : heartList) {
            Long key = heart.getPostId();

            heart.setChecked(true);
            heartRepository.save(heart);

            if(heartMap.get(key) == null) {
                heartMap.put(key, start);
                continue;
            }
            heartMap.put(key, heartMap.get(key)+1 );
        }
    }

    private void setHeartNumber() {
        Long addNumber;

        for( Long postId : heartMap.keySet() ){
            addNumber = heartMap.get(postId);
            Post post = postRepository.findById(postId).get();
            post.addHeartNumber(addNumber);
            postRepository.save(post);
        }
    }
}


