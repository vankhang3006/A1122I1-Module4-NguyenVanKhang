package com.codegym.service;

import com.codegym.model.Song;

import java.util.List;

public interface ISongService {
    List<Song> findAll();

    boolean save(Song song);

    Song findById(int id);

    boolean update(int id, Song song);

    boolean remove(int id);
    
}
