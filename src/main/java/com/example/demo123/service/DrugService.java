package com.example.demo123.service;

import com.example.demo123.dto.DrugDto;
import com.example.demo123.model.DrugModel;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DrugService {
    List<DrugDto> getAll();
    DrugDto createNewDrug(DrugDto drugDto);

    DrugDto getSingleDrugDetails(Long id);
}
