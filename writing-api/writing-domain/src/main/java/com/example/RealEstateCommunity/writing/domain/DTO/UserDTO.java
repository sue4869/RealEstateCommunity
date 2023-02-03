package com.example.RealEstateCommunity.writing.domain.DTO;

import org.springframework.lang.Nullable;

public class UserDTO {

    @Nullable
    private Long accountId;
    @Nullable
    private String accountType;

    protected UserDTO() {

    }

    public UserDTO(String type,String accountId) {
        if(accountId == null) this.accountId = null;
        else this.accountId = Long.parseLong(accountId);
        this.accountType = type;
    }

    public Long getAccountId() {
        return accountId;
    }

    public String getAccountType() {
        return accountType;
    }

}


