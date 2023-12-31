package com.julien.teamsphere.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "USER")

public class UserEntity {

    public enum Gender {
        Male,
        Female,
        Other,
        notPronounced
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID")
    private int userId;

    @Column(name = "USER_FIRST_NAME")
    public String userFirstName;

    @Column(name = "USER_LAST_NAME")
    public String userLastName;

    @Column(name = "USER_USERNAME")
    public String userName;

    @Column(name = "USER_PASSWORD")
    public String password;

    @Column(name = "USER_EMAIL")
    public String userEmail;

    @Column(name = "USER_INSCRIPTION_DATE")
    public Date userInscriptionDate;

    @Column(name = "USER_BIRTH_DATE")
    public String userBirthDate;

    @Column(name = "USER_GENDER")
    @Enumerated(EnumType.STRING)
    public Gender userGender;

    @Column(name = "USER_PROFILE_PICTURE")
    public String userProfilePicture;

    @Column(name = "USER_ROLE")
    public String userRole;

    public UserEntity() { }

    public UserEntity(int userId, String userFirstName, String userLastName, String userName, String password, String userEmail, Date userInscriptionDate, String userBirthDate, Gender userGender, String userProfilePicture, String userRole) {
        this.userId = userId;
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
        this.userName = userName;
        this.password = password;
        this.userEmail = userEmail;
        this.userInscriptionDate = userInscriptionDate;
        this.userBirthDate = userBirthDate;
        this.userGender = userGender;
        this.userProfilePicture = userProfilePicture;
        this.userRole = userRole;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
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

    public Gender getUserGender() {
        return userGender;
    }

    public void setUserGender(Gender userGender) {
        this.userGender = userGender;
    }

    public String getUserProfilePicture() {
        return userProfilePicture;
    }

    public void setUserProfilePicture(String userProfilePicture) {
        this.userProfilePicture = userProfilePicture;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity that = (UserEntity) o;
        return userId == that.userId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId);
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "userId=" + userId +
                ", userFirstName='" + userFirstName + '\'' +
                ", userLastName='" + userLastName + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userInscriptionDate=" + userInscriptionDate +
                ", userBirthDate='" + userBirthDate + '\'' +
                ", userGender=" + userGender +
                ", userProfilePicture='" + userProfilePicture + '\'' +
                ", userRole='" + userRole + '\'' +
                '}';
    }
}

