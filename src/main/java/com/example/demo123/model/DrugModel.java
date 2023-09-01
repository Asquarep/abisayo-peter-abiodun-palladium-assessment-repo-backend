package com.example.demo123.model;

import com.example.demo123.dto.DrugDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "drugs")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DrugModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String description;
    private String image;
    private String expiryDate;
    @Column(nullable = false)
    private String manufacturer;


    public static DrugModel createFromDto(DrugDto drugDto){
        return DrugModel.builder()
                .name(drugDto.getName())
                .description(drugDto.getDescription())
                .image(drugDto.getImage())
                .expiryDate(drugDto.getExpiryDate())
                .manufacturer(drugDto.getManufacturer())
                .build();
    }

}
