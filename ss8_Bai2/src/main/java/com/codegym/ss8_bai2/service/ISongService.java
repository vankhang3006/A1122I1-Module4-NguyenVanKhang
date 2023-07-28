package com.codegym.ss8_bai2.service;

import com.codegym.ss8_bai2.model.Song;

import java.util.List;

public interface ISongService {
    List<Song> findAll();

    boolean save(Song song);

    Song findById(int id);
}
