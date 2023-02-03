package com.example.RealEstateCommunity.writing.application.processor;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Configuration;

import com.example.RealEstateCommunity.writing.domain.DTO.UserDTO;
import com.example.RealEstateCommunity.writing.domain.exception.UnAuthorizedUserException;

@Configuration
public class UserCheckProcessor {

    public UserDTO execute(HttpServletRequest httpServletRequest, boolean limitedAccess) {
        String authentication = httpServletRequest.getHeader("authentication");

        if(authentication == null && limitedAccess) throw new UnAuthorizedUserException();
        if (authentication == null && !limitedAccess) return new UserDTO(null,null);
        String[] auth = authentication.split(" ");
        return new UserDTO(auth[0],auth[1]);
    }
}


