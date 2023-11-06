package com.julien.teamsphere.DTO;

import com.julien.teamsphere.entity.PostCommentEntity;

import java.util.Date;

public class PostCommentDTO {

    private int postId;

    private int authorId;

    private String commentContent;

    private Date commentPublicationDate;

    public PostCommentDTO() {}

    public PostCommentDTO(PostCommentEntity postCommentEntity) {
        this.postId = postCommentEntity.getPost().getPostId();
        this.authorId = postCommentEntity.getUser().getUserId();
        this.commentContent = postCommentEntity.getCommentContent();
        this.commentPublicationDate = postCommentEntity.getCommentPublicationDate();
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
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
    public String toString() {
        return "PostCommentDTO{" +
                "postId=" + postId +
                ", authorId=" + authorId +
                ", commentContent='" + commentContent + '\'' +
                ", commentPublicationDate=" + commentPublicationDate +
                '}';
    }
}
