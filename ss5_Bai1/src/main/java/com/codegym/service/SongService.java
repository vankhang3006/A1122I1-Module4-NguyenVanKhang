package com.codegym.service;

import com.codegym.model.Song;
import com.codegym.repository.ISongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class SongService implements ISongService{

    @Autowired
    private ISongRepository songRepository;

    @Override
    public List<Song> findAll() {
        return songRepository.findAll();
    }

    @Override
    public boolean save(Song song) {
        return songRepository.save(song);
    }

    @Override
    public Song findById(int id) {
        return songRepository.findById(id);
    }

    @Override
    public boolean update(int id, Song song) {
        return songRepository.update(id,song);
    }

    @Override
    public boolean remove(int id) {
       return songRepository.remove(id);
    }
}
