package com.codegym.ss6_bucanh.reposiotry;





import com.codegym.ss6_bucanh.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICommentRepository extends JpaRepository<Comment,Integer> {

}
