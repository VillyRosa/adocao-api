package com.adocao.api.repositories;

import com.adocao.api.entities.Adoption;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AdoptionRepository extends JpaRepository<Adoption, UUID> {
}
