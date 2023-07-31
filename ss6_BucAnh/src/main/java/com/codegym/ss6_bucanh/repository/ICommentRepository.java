package com.codegym.ss6_bucanh.repository;





import com.codegym.ss6_bucanh.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface ICommentRepository extends JpaRepository<Comment,Integer> {
    List<Comment> findCommentByDateCreate(LocalDate date);

}
