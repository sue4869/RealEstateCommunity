package com.example.RealEstateCommunity.user.domain;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.example.RealEstateCommunity.common.AccountType;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nickname;
    @Enumerated(value = EnumType.STRING)
    @Column(name = "account_type",columnDefinition="ENUM('REALTOR','LESSOR','LESSEE')")
    private AccountType accountType;
    @Column(name = "account_id")
    private Long accountId;
    private Boolean quit;
    @CreationTimestamp
    @Column(name = "created_at")
    private Instant createdAt;
    @UpdateTimestamp
    @Column(name = "updated_at")
    private Instant updatedAt;

    protected User() {

    }

    public User(Long id,String userName, String nickname, AccountType accountType) {
        this.id = 0L;
        this.nickname = nickname;
        this.accountType = accountType;
        this.quit = false;
    }

    public Long getId() {
        return id;
    }

    public String getNickname() {
        return nickname;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public Boolean getQuit() {
        return quit;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }
}


