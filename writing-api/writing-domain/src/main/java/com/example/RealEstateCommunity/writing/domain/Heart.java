package com.example.RealEstateCommunity.writing.domain;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;

@Entity
public class Heart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "post_id")
    private Long postId;
    @Column(name = "account_id")
    private Long accountId;
    private Boolean checked;
    @CreationTimestamp
    @Column(name = "created_at")
    private Instant createdAt;

    protected Heart() {

    }

    public Heart(Long id, Long postId, Long accountId) {
        this.id = id;
        this.postId = postId;
        this.accountId = accountId;
        this.checked = false;
    }

    public Long getPostId() {
        return postId;
    }

    public Long getAccountId() {
        return accountId;
    }

    public Boolean getChecked() {
        return checked;
    }

    public void setChecked(Boolean checked) {
        this.checked = checked;
    }
}


