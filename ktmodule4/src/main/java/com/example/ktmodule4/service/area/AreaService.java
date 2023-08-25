package com.example.ktmodule4.service.area;

import com.example.ktmodule4.model.Area;
import com.example.ktmodule4.repository.IAreaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AreaService implements IAreaService{
    @Autowired
    private IAreaRepository areaRepository;
    @Override
    public Optional<Area> findById(int id) {
        return Optional.empty();
    }

    @Override
    public void save(Area area) {
        areaRepository.save(area);
    }

    @Override
    public void remove(int id) {

    }

    @Override
    public List<Area> findAll() {
        return areaRepository.findAll();
    }
}
