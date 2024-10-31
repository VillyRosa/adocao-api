package com.adocao.api.utils.dto;

import com.adocao.api.entities.Animal;
import com.adocao.api.entities.Customer;
import com.adocao.api.enums.AdoptionStatus;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@NoArgsConstructor
@Getter
@Setter
public class AdoptionDTO {

    private Customer customer;
    private Animal animal;
    private UUID customerId;
    private UUID animalId;
    @NotBlank(message = "Status is mandatory")
    @Enumerated(EnumType.STRING)
    private AdoptionStatus status;
    private String observation;
    private LocalDate adoptionDate;

}
