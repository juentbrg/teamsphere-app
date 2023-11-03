package com.julien.teamsphere.entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "POST")
public class PostEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "POST_ID")
    private int postId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "AUTHOR_ID")
    private UserEntity user;

    @Column(name = "POST_CONTENT")
    public String postContent;

    @Column(name = "POST_DATE_PUBLICATION")
    public Date postDatePublication;

    public PostEntity() { }

    public PostEntity(int postId, UserEntity user, String postContent, Date postDatePublication) {
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

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public String getPostContent() {
        return postContent;
    }

    public void setPostContent(String postContent) {
        this.postContent = postContent;
    }

    public Date getPostDatePublication() {
        return postDatePublication;
    }

    public void setPostDatePublication(Date postDatePublication) {
        this.postDatePublication = postDatePublication;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PostEntity that = (PostEntity) o;
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
