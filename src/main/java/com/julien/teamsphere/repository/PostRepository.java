package com.julien.teamsphere.repository;

import com.julien.teamsphere.entity.PostEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends CrudRepository<PostEntity, Integer> {
}
