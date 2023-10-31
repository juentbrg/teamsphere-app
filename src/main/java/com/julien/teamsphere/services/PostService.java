package com.julien.teamsphere.services;

import com.julien.teamsphere.DTO.PostDTO;
import com.julien.teamsphere.entity.PostEntity;
import com.julien.teamsphere.entity.UserEntity;
import com.julien.teamsphere.repository.PostRepository;
import com.julien.teamsphere.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;

    @Autowired
    public PostService(PostRepository postRepository, UserRepository userRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    @Transactional
    public List<PostDTO> findAll() {
        List<PostEntity> PostList = (List<PostEntity>) postRepository.findAll();
        List<PostDTO> PostDTOList = new ArrayList<>();

        for (PostEntity post : PostList) {
            PostDTO postDTO = new PostDTO(post);
            PostDTOList.add(postDTO);
        }
        return PostDTOList;
    }

    @Transactional
    public PostDTO findById(int id) {
        Optional<PostEntity> postOpt = postRepository.findById(id);
        if (postOpt.isPresent()) {
            return new PostDTO(postOpt.get());
        }
        return null;
    }

    @Transactional
    public void save(PostDTO postDTO) {
        PostEntity post = new PostEntity();
        Date currentDate = new Date();
        Optional<UserEntity> userOpt = userRepository.findById(postDTO.getUser());

        if (userOpt.isPresent()) {
            post.setUser(userOpt.get());
            post.setPostContent(postDTO.getPostContent());
            post.setPostDatePublication(currentDate);
        }
    }

    @Transactional
    public boolean deleteById(int id) {
        Optional<PostEntity> postOpt = postRepository.findById(id);
        if (postOpt.isPresent()) {
            postRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    @Transactional
    public void updateById(int id, PostDTO postDTO) {
        Optional<PostEntity> postOpt = postRepository.findById(id);
        if (postOpt.isPresent()) {
            PostEntity post = postOpt.get();
            if (null != postDTO.getPostContent()) {
                post.setPostContent(postDTO.getPostContent());
            }
        }
    }
}
