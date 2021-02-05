package com.library.repository;

import com.library.domain.CustomUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<CustomUser, Long> {
    List<CustomUser> findAll();
    Optional<CustomUser> findByName(String name);
    void deleteById(Long id);
}
