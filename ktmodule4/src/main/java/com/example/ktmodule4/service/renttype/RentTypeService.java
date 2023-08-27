package com.example.ktmodule4.service.renttype;

import com.example.ktmodule4.model.RentType;
import com.example.ktmodule4.model.Stadium;
import com.example.ktmodule4.repository.IRentTypeRepository;
import com.example.ktmodule4.repository.IStadiumRepository;
import com.example.ktmodule4.utils.FormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RentTypeService implements IRentTypeService{
    @Autowired
    private IRentTypeRepository rentTypeRepository;
    @Autowired
    private IStadiumRepository stadiumRepository;

    @Override
    public Optional<RentType> findById(int id) {
        return Optional.empty();
    }

    @Override
    public void save(RentType rentType) {
        rentTypeRepository.save(rentType);
    }

    @Override
    public void remove(int id) {

    }

    @Override
    public List<RentType> findAll() {
        return rentTypeRepository.findAll();
    }

    @Override
    public Map<Integer, String> priceList() {
        // Danh sách các đối tượng Stadium
        List<Stadium> stadiumList = stadiumRepository.findAll();
        Map<Integer, String> formattedPrices = new HashMap<>();

        for (Stadium stadium : stadiumList) {
            long price = stadium.getRentType().getPrice();
            String formattedPrice = FormatUtils.formatPrice(price);
            formattedPrices.put(stadium.getId(), formattedPrice);
        }
        return formattedPrices;
    }
}
