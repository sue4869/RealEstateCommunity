package com.example.RealEstateCommunity.writing.infrastructure.reader;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.SqlSessionTemplate;

import com.example.RealEstateCommunity.writing.domain.ReadUserModel;
import com.example.RealEstateCommunity.writing.domain.UserReader;

@Mapper
public class MyBatisUserReader implements UserReader {

    private final SqlSessionTemplate template;

    public MyBatisUserReader(SqlSessionTemplate template) {
        this.template = template;
    }

    @Override
    public ReadUserModel getUserByAccountId(Long accountId) {
        return template.getMapper(UserReader.class).getUserByAccountId(accountId);
    }
}


