package com.adocao.api.entities;

import com.adocao.api.utils.dto.AnimalDTO;
import com.adocao.api.enums.Gender;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "animal")
@NoArgsConstructor
@Setter
@Getter
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "pet_name")
    private String petName;
    private String breed;
    @Enumerated(EnumType.STRING)
    private Gender gender;

    public Animal(AnimalDTO animalDTO) {
        this.petName = animalDTO.getPetName();
        this.breed = animalDTO.getBreed();
        this.gender = animalDTO.getGender();
    }
}
