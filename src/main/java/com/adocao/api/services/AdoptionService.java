package com.adocao.api.services;

import com.adocao.api.entities.Adoption;
import com.adocao.api.repositories.AdoptionRepository;
import com.adocao.api.repositories.AnimalRepository;
import com.adocao.api.repositories.CustomerRepository;
import com.adocao.api.utils.dto.AdoptionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AdoptionService extends BaseService<Adoption, UUID, AdoptionDTO> {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private AnimalRepository animalRepository;

    public AdoptionService(AdoptionRepository adoptionRepository) {
        super(adoptionRepository, Adoption::new);
    }

    @Override
    public Adoption save(AdoptionDTO dto) {
        if (dto.getCustomerId() != null) {
            dto.setCustomer(customerRepository.findById(dto.getCustomerId()).orElse(null));
        }
        if (dto.getAnimalId() != null) {
            dto.setAnimal(animalRepository.findById(dto.getAnimalId()).orElse(null));
        }
        return super.save(dto);
    }

    @Override
    public Adoption update(UUID id, AdoptionDTO dto) {
        Adoption adoption = repository.findById(id).orElse(null);
        if (adoption == null) {
            return null;
        }
        if (dto.getCustomerId() != null) {
            dto.setCustomer(customerRepository.findById(dto.getCustomerId()).orElse(null));
        }
        if (dto.getAnimalId() != null) {
            dto.setAnimal(animalRepository.findById(dto.getAnimalId()).orElse(null));
        }
        return super.update(id, dto);
    }

}
