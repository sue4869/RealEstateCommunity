package com.example.RealEstateCommunity.writing.application.processor;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

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
        Map<Long, Long> heartMap = new ConcurrentHashMap<>();
        setHeartMap(heartList, heartMap);
        setHeartNumber(heartMap);
    }

    private void setHeartMap(List<Heart> heartList, Map<Long, Long> heartMap){

        for(Heart heart : heartList) {
            Long postId = heart.getPostId();

            heart.setChecked(true);
            heartRepository.save(heart);
            heartMap.compute(postId,(k,v) -> (v == null) ? 1 : v + 1 );
        }
    }

    private void setHeartNumber(Map<Long, Long> heartMap) {

        for( Long postId : heartMap.keySet() ){
            Long addNumber = heartMap.get(postId);
            Post post = postRepository.findById(postId).get();
            post.addHeartNumber(addNumber);
            postRepository.save(post);
        }
    }
}


