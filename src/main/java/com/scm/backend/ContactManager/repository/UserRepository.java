package com.scm.backend.ContactManager.repository;

import com.scm.backend.ContactManager.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RepositoryRestResource(path = "users")
public interface UserRepository extends JpaRepository<User, String> {

    @RestResource(path = "by-email", rel = "by-email")
    List<User> findByEmail(@Param("email") String email);

}
