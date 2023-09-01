package com.example.demo123.controller;

import com.example.demo123.dto.DrugDto;
import com.example.demo123.model.DrugModel;
import com.example.demo123.service.DrugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value= "api/v1")
@CrossOrigin(origins = "http://localhost:3000")
public class DrugsController {
    @Autowired
    private DrugService drugService;
    @GetMapping("/drugs")
    public ResponseEntity<List<DrugDto>> getAllDrugs() {
        return ResponseEntity.of(Optional.ofNullable(drugService.getAll()));
    }
    @PostMapping("/drugs")
    public ResponseEntity<DrugDto> createNewDrug(@RequestBody DrugDto drugDto) {
        return ResponseEntity.of(Optional.ofNullable(drugService.createNewDrug(drugDto)));
    }
    @GetMapping("/drugs/{id}")
    public ResponseEntity<DrugDto> getSingleDrugDetails(@PathVariable Long id) {
        return ResponseEntity.of(Optional.ofNullable(drugService.getSingleDrugDetails(id)));
    }
}
