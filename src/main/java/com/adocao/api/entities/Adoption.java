package com.adocao.api.entities;

import com.adocao.api.enums.AdoptionStatus;
import com.adocao.api.utils.dto.AdoptionDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "adoption")
@NoArgsConstructor
@Getter
@Setter
public class Adoption {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "animal_id", nullable = false)
    private Animal animal;
    @Enumerated(EnumType.STRING)
    private AdoptionStatus status;
    private String observation;
    private LocalDate adoptionDate;

    public Adoption(AdoptionDTO adoptionDTO) {
        this.customer = adoptionDTO.getCustomer();
        this.animal = adoptionDTO.getAnimal();
        this.status = adoptionDTO.getStatus();
        this.observation = adoptionDTO.getObservation();
        this.adoptionDate = LocalDate.now();
    }

}
