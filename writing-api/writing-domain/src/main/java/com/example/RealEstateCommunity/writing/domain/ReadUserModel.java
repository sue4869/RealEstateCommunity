package com.example.RealEstateCommunity.writing.domain;


import com.example.RealEstateCommunity.common.AccountType;

public class ReadUserModel {

    private String nickname;
    private AccountType accountType;
    private Long accountId;
    private Boolean quit;

    public String getNickname() {
        return nickname;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public Long getAccountId() {
        return accountId;
    }

    public Boolean getQuit() {
        return quit;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public void setQuit(Boolean quit) {
        this.quit = quit;
    }
}


