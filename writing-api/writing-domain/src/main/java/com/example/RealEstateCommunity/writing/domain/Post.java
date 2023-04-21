package com.example.RealEstateCommunity.writing.domain;

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
import com.sun.istack.NotNull;

@Entity(name = "post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String title;
    @NotNull
    @Column(name = "account_id")
    private Long accountId;
    @Column(name = "account_type")
    @Enumerated(EnumType.STRING)
    private AccountType accountType;
    @Column(name = "account_nickname")
    private String accountNickname;
    @NotNull
    private String contents;
    private boolean actived;
    @Column(name = "heart_number")
    private Long heartNumber;
    @CreationTimestamp
    @Column(name = "created_at")
    private Instant createdAt;
    @UpdateTimestamp
    @Column(name = "updated_at")
    private Instant updatedAt;
    @Column(name = "deleted_at")
    private Instant deletedAt;

    protected Post() {

    }

    public Post(String title, Long accountId, AccountType accountType, String accountNickname, String contents) {
        this.id = 0L;
        this.title = title;
        this.accountId = accountId;
        this.accountType = accountType;
        this.accountNickname = accountNickname;
        this.contents = contents;
        this.actived = true;
        this.heartNumber = 0L;
    }

    public String getTitle() {
        return title;
    }

    public Long getId() {
        return id;
    }

    public Long getAccountId() {
        return accountId;
    }

    public String getContents() {
        return contents;
    }

    public Long getHeartNumber() {
        return heartNumber;
    }

    public String getAccountNickname() {
        return accountNickname;
    }

    public boolean isActived() {
        return actived;
    }

    public void setActived(boolean actived) {
        this.actived = actived;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }



    public void setDeletedAt(Instant deletedAt) {
        this.deletedAt = deletedAt;
    }

    public void addHeartNumber(Long likedPeopleNumber) {
        this.heartNumber += likedPeopleNumber;
    }
}


