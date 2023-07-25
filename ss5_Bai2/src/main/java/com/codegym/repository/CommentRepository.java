package com.codegym.repository;

import com.codegym.model.Comment;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class CommentRepository implements ICommentRepository {


    @Override
    public Comment update(Comment comment) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = ConnectionUtil.sessionFactory.openSession();
            transaction = session.beginTransaction();
            Comment origin = findById(comment.getId());
            origin.setRate(comment.getRate());
            origin.setAuthor(comment.getAuthor());
            origin.setMessage(comment.getMessage());
            session.saveOrUpdate(origin);
            transaction.commit();
            return origin;
        } catch (Exception ex) {
            ex.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return null;
    }

    @Override
    public List<Comment> findAll() {
        String queryStr = "SELECT c FROM Comment c";
        TypedQuery<Comment> query = ConnectionUtil.entityManager.createQuery(queryStr, Comment.class);
        return query.getResultList();
    }

    @Override
    public void save(Comment comment) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = ConnectionUtil.sessionFactory.openSession();
            transaction = session.beginTransaction();
            comment.setLikeCount(0);
            session.saveOrUpdate(comment);
            transaction.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public Comment like(int id) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = ConnectionUtil.sessionFactory.openSession();
            transaction = session.beginTransaction();
            Comment comment = findById(id);
            comment.setLikeCount(comment.getLikeCount()+1);
            session.saveOrUpdate(comment);
            transaction.commit();
            return comment;
        } catch (Exception ex) {
            ex.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return null;
    }

    @Override
    public Comment findById(int id) {
        String queryStr = "SELECT c FROM Comment c WHERE c.id = :id";
        TypedQuery<Comment> query = ConnectionUtil.entityManager.createQuery(queryStr, Comment.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }
}
