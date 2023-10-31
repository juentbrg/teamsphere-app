package com.julien.teamsphere.DTO;

import com.julien.teamsphere.entity.UserEntity;

import java.util.Date;

public class UserGetDTO {

    private  String userFirstName;

    private String userLastName;

    private String userName;

    private String userEmail;

    private Date userInscriptionDate;

    private String userBirthDate;

    private String userGender;

    private String userProfilePicture;

    public UserGetDTO() { }

    public UserGetDTO(UserEntity userEntity) {
        this.userFirstName = userEntity.getUserFirstName();
        this.userLastName = userEntity.getUserLastName();
        this.userName = userEntity.getUserName();
        this.userEmail = userEntity.getUserEmail();
        this.userInscriptionDate = userEntity.getUserInscriptionDate();
        this.userBirthDate = userEntity.getUserBirthDate();
        this.userGender = userEntity.getUserGender().toString();
        this.userProfilePicture = userEntity.getUserProfilePicture();
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getUserInscriptionDate() {
        return userInscriptionDate;
    }

    public void setUserInscriptionDate(Date userInscriptionDate) {
        this.userInscriptionDate = userInscriptionDate;
    }

    public String getUserBirthDate() {
        return userBirthDate;
    }

    public void setUserBirthDate(String userBirthDate) {
        this.userBirthDate = userBirthDate;
    }

    public String getUserGender() {
        return userGender;
    }

    public void setUserGender(String userGender) {
        this.userGender = userGender;
    }

    public String getUserProfilePicture() {
        return userProfilePicture;
    }

    public void setUserProfilePicture(String userProfilePicture) {
        this.userProfilePicture = userProfilePicture;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    @Override
    public String toString() {
        return "UserGetDTO{" +
                "userFirstName='" + userFirstName + '\'' +
                ", userLastName='" + userLastName + '\'' +
                ", userName='" + userName + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userInscriptionDate=" + userInscriptionDate +
                ", userBirthDate='" + userBirthDate + '\'' +
                ", userGender='" + userGender + '\'' +
                ", userProfilePicture='" + userProfilePicture + '\'' +
                '}';
    }
}
