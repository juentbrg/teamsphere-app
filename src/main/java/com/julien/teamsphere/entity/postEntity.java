package com.julien.teamsphere.entity;

import jakarta.persistence.*;
import com.julien.teamsphere.entity.userEntity;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "POST")
public class postEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "POST_ID")
    private int postId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID")
    private userEntity user;

    @Column(name = "POST_CONTENT")
    public String postContent;

    @Column(name = "POST_DATE_PUBLICATION")
    public LocalDateTime postDatePublication;

    public postEntity() { }

    public postEntity(int postId, userEntity user, String postContent, LocalDateTime postDatePublication) {
        this.postId = postId;
        this.user = user;
        this.postContent = postContent;
        this.postDatePublication = postDatePublication;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public userEntity getUser() {
        return user;
    }

    public void setUser(userEntity user) {
        this.user = user;
    }

    public String getPostContent() {
        return postContent;
    }

    public void setPostContent(String postContent) {
        this.postContent = postContent;
    }

    public LocalDateTime getPostDatePublication() {
        return postDatePublication;
    }

    public void setPostDatePublication(LocalDateTime postDatePublication) {
        this.postDatePublication = postDatePublication;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        postEntity that = (postEntity) o;
        return postId == that.postId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(postId);
    }

    @Override
    public String toString() {
        return "postEntity{" +
                "postId=" + postId +
                ", user=" + user +
                ", postContent='" + postContent + '\'' +
                ", postDatePublication=" + postDatePublication +
                '}';
    }
}
