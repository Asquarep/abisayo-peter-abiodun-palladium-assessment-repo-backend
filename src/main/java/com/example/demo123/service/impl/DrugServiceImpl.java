package com.example.demo123.service.impl;

import static com.example.demo123.dto.DrugDto.toDrugDtoFromModel;
import static com.example.demo123.model.DrugModel.createFromDto;
import com.example.demo123.DrugRepository;
import com.example.demo123.dto.DrugDto;
import com.example.demo123.model.DrugModel;
import com.example.demo123.service.DrugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DrugServiceImpl implements DrugService {
    @Autowired
    private DrugRepository drugRepository;
    @Override
    public List<DrugDto> getAll() {
        List<DrugModel> listOfDrugs = drugRepository.findAll();
        List<DrugDto> dtos = new ArrayList<>();
        for (DrugModel drug: listOfDrugs) {
            DrugDto dto = toDrugDtoFromModel(drug);
            dtos.add(dto);
        }
        return dtos;
    }

    @Override
    public DrugDto createNewDrug(DrugDto drugDto) {
        DrugModel drugToSave = createFromDto(drugDto);

        DrugModel drug = drugRepository.save(drugToSave);

        return toDrugDtoFromModel(drug);
    }

    @Override
    public DrugDto getSingleDrugDetails(Long id) {
        Optional<DrugModel> foundDrug = drugRepository.findById(id);
        if (foundDrug.isPresent()){
            return toDrugDtoFromModel(foundDrug.get());
        }
        throw new RuntimeException("Drug by provided ID Not Found");
    }
}
