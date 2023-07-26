package com.codegym.ss7_bai2.reposiotry;






import com.codegym.ss7_bai2.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICommentRepository extends JpaRepository<Comment,Integer> {

}
