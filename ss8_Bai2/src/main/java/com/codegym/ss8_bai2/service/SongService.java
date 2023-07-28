package com.codegym.ss8_bai2.service;

import com.codegym.ss8_bai2.model.Song;
import com.codegym.ss8_bai2.repository.ISongRepository;
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
        Song song1 = songRepository.save(song);
        if (song1 != null) {
            return true;
        }
        return false;
    }

    @Override
    public Song findById(int id) {
        return songRepository.findById(id).orElse(null);
    }
}
