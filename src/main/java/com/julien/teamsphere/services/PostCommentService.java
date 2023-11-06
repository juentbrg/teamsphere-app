package com.julien.teamsphere.services;

import com.julien.teamsphere.DTO.PostCommentDTO;
import com.julien.teamsphere.entity.PostCommentEntity;
import com.julien.teamsphere.entity.PostEntity;
import com.julien.teamsphere.entity.UserEntity;
import com.julien.teamsphere.repository.PostCommentRepository;
import com.julien.teamsphere.repository.PostRepository;
import com.julien.teamsphere.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PostCommentService {

    private final PostCommentRepository postCommentRepository;
    private final PostRepository postRepository;
    private final UserRepository userRepository;

    @Autowired
    public PostCommentService(PostCommentRepository postCommentRepository, PostRepository postRepository, UserRepository userRepository) {
        this.postCommentRepository = postCommentRepository;
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    @Transactional
    public List<PostCommentDTO> findAll() {
        List<PostCommentEntity> commentList = (List<PostCommentEntity>) postCommentRepository.findAll();
        List<PostCommentDTO> commentDTOList = new ArrayList<>();

        for (PostCommentEntity commentEntity : commentList) {
            PostCommentDTO commentDTO = new PostCommentDTO(commentEntity);
            commentDTOList.add(commentDTO);
        }
        return commentDTOList;
    }

    @Transactional
    public PostCommentDTO findById(int id) {
        Optional<PostCommentEntity> commentOpt = postCommentRepository.findById(id);

        if (commentOpt.isPresent()) {
            return new PostCommentDTO(commentOpt.get());
        }
        return null;
    }

    @Transactional
    public boolean save(PostCommentDTO commentDTO) {
        PostCommentEntity commentEntity = new PostCommentEntity();
        Optional<PostEntity> postOpt = postRepository.findById(commentDTO.getPostId());
        Optional<UserEntity> userOpt = userRepository.findById(commentDTO.getAuthorId());

        if (postOpt.isPresent() && userOpt.isPresent()) {
            commentEntity.setPost(postOpt.get());
            commentEntity.setUser(userOpt.get());
            commentEntity.setCommentContent(commentDTO.getCommentContent());
            commentEntity.setCommentPublicationDate(new Date());
            postCommentRepository.save(commentEntity);
            return true;
        }
        return false;
    }

    @Transactional
    public boolean updateById(int id, PostCommentDTO commentDTO) {
        Optional<PostCommentEntity> commentOpt = postCommentRepository.findById(id);

        if (commentOpt.isPresent()) {
            PostCommentEntity commentEntity = commentOpt.get();
            if (null != commentDTO.getCommentContent()) {
                commentEntity.setCommentContent(commentDTO.getCommentContent());
            }
            return true;
        } else {
            return false;
        }
    }

    @Transactional
    public boolean deleteById(int id) {
        Optional<PostCommentEntity> commentOpt = postCommentRepository.findById(id);

        if (commentOpt.isPresent()) {
            postCommentRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
