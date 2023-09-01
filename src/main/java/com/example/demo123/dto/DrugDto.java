package com.example.demo123.dto;

import com.example.demo123.model.DrugModel;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DrugDto {
    private Long id;
    private String name;
    private String description;
    private String image;
    private String expiryDate;
    private String manufacturer;

    public static DrugDto toDrugDtoFromModel(DrugModel drugModel) {
        return DrugDto.builder()
                .id(drugModel.getId())
                .name(drugModel.getName())
                .description(drugModel.getDescription())
                .image(drugModel.getImage())
                .expiryDate(drugModel.getExpiryDate())
                .manufacturer(drugModel.getManufacturer())
                .build();
    }
}
