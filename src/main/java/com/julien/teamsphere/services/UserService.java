package com.julien.teamsphere.services;

import com.julien.teamsphere.DTO.UserGetDTO;
import com.julien.teamsphere.DTO.UserPostDTO;
import com.julien.teamsphere.entity.UserEntity;
import com.julien.teamsphere.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public List<UserGetDTO> findAll() {
        List<UserEntity> userList = (List<UserEntity>) userRepository.findAll();
        List<UserGetDTO> userDTOList = new ArrayList<>();

        for(UserEntity user : userList) {
            UserGetDTO userDTO = new UserGetDTO(user);
            userDTOList.add(userDTO);
        }
        return userDTOList;
    }

    @Transactional
    public UserGetDTO findById(int id) {
        Optional<UserEntity> userOpt = userRepository.findById(id);
        if (userOpt.isPresent()){
            return new UserGetDTO(userOpt.get());
        }
        return null;
    }

    @Transactional
    public boolean save(UserPostDTO userDTO) throws Exception {
        Optional<UserEntity> emailExists = userRepository.findByUserEmail(userDTO.getUserEmail());
        Optional<UserEntity> usernameExists = userRepository.findByUserName(userDTO.getUserName());

        if (emailExists.isPresent()) {
            String existingEmail = "L'email renseignée est déjà attribuée à un compte.";
            return false;
        }
        if (usernameExists.isPresent()) {
            String existingUserName = "Le nom d'utilisateur est déjà pris.";
            return false;
        }

        UserEntity user = new UserEntity();
        Date currentTime = new Date();
        user.setUserFirstName(userDTO.getUserFirstName());
        user.setUserLastName(userDTO.getUserLastName());
        user.setUserName(userDTO.getUserName());
        String hashedPassword = passwordEncoder.encode(userDTO.getPassword());
        user.setPassword(hashedPassword);
        user.setUserEmail(userDTO.getUserEmail());
        user.setUserInscriptionDate(currentTime);
        user.setUserBirthDate(userDTO.getUserBirthDate());
        user.setUserGender(userDTO.getUserGender());
        user.setUserProfilePicture(userDTO.getUserProfilePicture());
        return true;
    }

    @Transactional
    public boolean deleteById(Integer id){
        Optional<UserEntity> existingUser = userRepository.findById(id);
        if (existingUser.isPresent()) {
            userRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    @Transactional
    public boolean updateById(int id, UserPostDTO userDTO) {
        Optional<UserEntity> userOpt = userRepository.findById(id);
        if (userOpt.isPresent()) {
            UserEntity user = userOpt.get();
            if (null != userDTO.getUserFirstName()) {
                user.setUserFirstName(userDTO.getUserFirstName());
            }
            if (null != userDTO.getUserLastName()) {
                user.setUserLastName(userDTO.getUserLastName());
            }
            if (null != userDTO.getUserName()) {
                user.setUserName(userDTO.getUserName());
            }
            if (null != userDTO.getPassword()) {
                user.setPassword(userDTO.getPassword());
            }
            if (null != userDTO.getUserEmail()) {
                user.setUserEmail(userDTO.getUserEmail());
            }
            if (null != userDTO.getUserGender()) {
                user.setUserGender(userDTO.getUserGender());
            }
            if (null != userDTO.getUserProfilePicture()) {
                user.setUserProfilePicture(userDTO.getUserProfilePicture());
            }
            return true;
        } else {
            return false;
        }
    }
}
