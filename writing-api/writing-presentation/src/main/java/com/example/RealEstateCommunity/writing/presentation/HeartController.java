package com.example.RealEstateCommunity.writing.presentation;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.example.RealEstateCommunity.writing.application.processor.PostHeartModifyProcessor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.RealEstateCommunity.writing.domain.DTO.UserDTO;
import com.example.RealEstateCommunity.common.response.CommonApiResponse;
import com.example.RealEstateCommunity.writing.application.processor.HeartCreateProcessor;
import com.example.RealEstateCommunity.writing.application.processor.MyHeartFetchProcessor;
import com.example.RealEstateCommunity.writing.application.processor.UserCheckProcessor;
import com.example.RealEstateCommunity.writing.domain.Heart;
import com.example.RealEstateCommunity.writing.presentation.request.HeartCreateRequest;

@RestController
@RequestMapping("/heart")
public class HeartController {

    private final HeartCreateProcessor heartCreateProcessor;
    private final MyHeartFetchProcessor myHeartFetchProcessor;
    private final UserCheckProcessor userCheckProcessor;


    public HeartController(
            HeartCreateProcessor heartCreateProcessor,
            MyHeartFetchProcessor myHeartFetchProcessor,
            UserCheckProcessor userCheckProcessor, PostHeartModifyProcessor postHeartModifyProcessor) {
        this.heartCreateProcessor = heartCreateProcessor;
        this.myHeartFetchProcessor = myHeartFetchProcessor;
        this.userCheckProcessor = userCheckProcessor;
    }

    @PostMapping("/giveHeart")
    public CommonApiResponse<Heart> giveHeart(@RequestBody HeartCreateRequest request, HttpServletRequest httpServletRequest) {
        UserDTO userDTO = userCheckProcessor.execute(httpServletRequest, true);
        Heart heart = heartCreateProcessor.execute(request.toCommand(),userDTO);
        return CommonApiResponse.success(heart);
    }

    @GetMapping("/getMyHearts")
    public CommonApiResponse<List<Heart>> getMyHeartList(HttpServletRequest httpServletRequest) {
        UserDTO userDTO = userCheckProcessor.execute(httpServletRequest, true);
        List<Heart> heartList = myHeartFetchProcessor.execute(userDTO);
        return CommonApiResponse.success(heartList);
    }

}


