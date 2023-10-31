package com.julien.teamsphere.DTO;

import com.julien.teamsphere.entity.PostEntity;
import com.julien.teamsphere.entity.UserEntity;

import java.time.LocalDateTime;
import java.util.Date;

public class PostDTO {

    private int user;

    private String postContent;

    private Date postDatePublication;

    public PostDTO() { }

    public PostDTO(PostEntity postEntity) {
        this.user = postEntity.getUser().getUserId();
        this.postContent = postEntity.getPostContent();
        this.postDatePublication = postEntity.getPostDatePublication();
    }

    public int getUser() {
        return user;
    }

    public void setUser(int user) {
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
    public String toString() {
        return "PostDTO{" +
                "user=" + user +
                ", postContent='" + postContent + '\'' +
                ", postDatePublication=" + postDatePublication +
                '}';
    }
}
