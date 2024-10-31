package com.adocao.api.services;

import com.adocao.api.entities.Animal;
import com.adocao.api.repositories.AnimalRepository;
import com.adocao.api.utils.dto.AnimalDTO;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AnimalService extends BaseService<Animal, UUID, AnimalDTO> {

    public AnimalService(AnimalRepository animalRepository) {
        super(animalRepository, Animal::new);
    }

}
