package com.library.repository;

import com.library.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findAll();
    void deleteById(Long id);
    List<Book> findAllByCustomUserIsNotNull();
    List<Book> findAllByCustomUserIsNull();
    @Modifying
    @Query("update Book b set b.customUser.id = null where b.customUser.id = :id")
    void updateAllBooksByCustomUser_Id(@Param("id")Long id);
//    void deleteBookByCustomUser_Id(Long id);
}
