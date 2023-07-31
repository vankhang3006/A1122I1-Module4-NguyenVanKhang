package com.codegym.ss7_bai2.repository;






import com.codegym.ss7_bai2.model.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface ICommentRepository extends JpaRepository<Comment,Integer> {
    Page<Comment> findCommentByDateCreate(Pageable pageable, LocalDate date);
}
