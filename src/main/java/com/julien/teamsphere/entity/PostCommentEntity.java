package com.julien.teamsphere.entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "POST_COMMENT")
public class PostCommentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COMMENT_ID")
    private int commentId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "POST_ID")
    private PostEntity post;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "AUTHOR_ID")
    private UserEntity user;

    @Column(name = "COMMENT_CONTENT")
    public String commentContent;

    @Column(name = "COMMENT_PUBLICATION_DATE")
    public Date commentPublicationDate;

    public PostCommentEntity() { }

    public PostCommentEntity(int commentId, PostEntity post, UserEntity user, String commentContent, Date commentPublicationDate) {
        this.commentId = commentId;
        this.post = post;
        this.user = user;
        this.commentContent = commentContent;
        this.commentPublicationDate = commentPublicationDate;
    }

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public PostEntity getPost() {
        return post;
    }

    public void setPost(PostEntity post) {
        this.post = post;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public Date getCommentPublicationDate() {
        return commentPublicationDate;
    }

    public void setCommentPublicationDate(Date commentPublicationDate) {
        this.commentPublicationDate = commentPublicationDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PostCommentEntity that = (PostCommentEntity) o;
        return commentId == that.commentId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(commentId);
    }

    @Override
    public String toString() {
        return "PostCommentEntity{" +
                "commentId=" + commentId +
                ", post=" + post +
                ", user=" + user +
                ", commentContent='" + commentContent + '\'' +
                ", commentPublicationDate=" + commentPublicationDate +
                '}';
    }
}
