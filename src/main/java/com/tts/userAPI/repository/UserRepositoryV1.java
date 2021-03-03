package com.tts.userAPI.repository;

import com.tts.userAPI.model.UserV1;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepositoryV1 extends CrudRepository<UserV1, Long> {
   UserV1 findByState(String state);
}
