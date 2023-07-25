package com.codegym.repository;

import com.codegym.model.Song;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

@Repository
public class SongRepository implements ISongRepository{

    @Override
    public List<Song> findAll() {
        List<Song> songList = new ArrayList<>();
        Session session = ConnectionUtil.sessionFactory.openSession();
        TypedQuery<Song> query = session.createQuery("from Song",Song.class);
        songList = query.getResultList();
        session.close();
        return songList;
    }

    @Override
    public boolean save(Song song) {
        Session session = ConnectionUtil.sessionFactory.openSession();
        Transaction transaction = session.getTransaction();
        try{
            transaction.begin();
            session.save(song);
            transaction.commit();
            session.close();
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public Song findById(int id) {
        Session session = ConnectionUtil.sessionFactory.openSession();
        TypedQuery<Song> query = session.createQuery("from Song where id =:id",Song.class);
        query.setParameter("id",id);
        return query.getSingleResult();
    }

    @Override
    public boolean update(int id, Song song) {
        Session session = ConnectionUtil.sessionFactory.openSession();
        Transaction transaction = session.getTransaction();
        try {
            transaction.begin();

            Song existingSong = findById(id);
            if (existingSong != null) {
                existingSong.setName(song.getName());
                existingSong.setSinger(song.getSinger());
                existingSong.setType(song.getType());
                existingSong.setSong(song.getSong());
                // Cập nhật các thuộc tính khác của bài hát theo cần thiết

                session.update(existingSong);
                transaction.commit();
            } else {
                throw new IllegalArgumentException("Song with id " + id + " does not exist.");
            }

            session.close();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean remove(int id) {
        Session session = ConnectionUtil.sessionFactory.openSession();
        Transaction transaction = session.getTransaction();
        Song song = findById(id);
        try{
            transaction.begin();
            session.delete(song);
            transaction.commit();
            session.close();
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
