package com.codegym.ss8_bai2.repository;

import com.codegym.ss8_bai2.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISongRepository extends JpaRepository<Song,Integer> {

}
