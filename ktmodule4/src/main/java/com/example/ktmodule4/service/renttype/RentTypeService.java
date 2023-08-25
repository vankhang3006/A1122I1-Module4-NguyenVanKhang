package com.example.ktmodule4.service.renttype;

import com.example.ktmodule4.model.RentType;
import com.example.ktmodule4.repository.IRentTypeRepository;
import com.example.ktmodule4.utils.FormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RentTypeService implements IRentTypeService{
    @Autowired
    private IRentTypeRepository rentTypeRepository;

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
    public List<String> priceList() {
        List<Long> oldList = rentTypeRepository.findAllPrices();
        List<String> formatList = new ArrayList<>();
        for(long num : oldList){
            formatList.add(FormatUtils.formatPrice(num));
        }
        return formatList;
    }
}
