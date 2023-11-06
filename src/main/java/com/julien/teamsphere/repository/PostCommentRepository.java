package com.julien.teamsphere.repository;

import com.julien.teamsphere.entity.PostCommentEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostCommentRepository extends CrudRepository<PostCommentEntity, Integer> {
}
