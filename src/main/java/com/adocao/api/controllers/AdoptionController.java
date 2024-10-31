package com.adocao.api.controllers;

import com.adocao.api.entities.Adoption;
import com.adocao.api.entities.Animal;
import com.adocao.api.services.AdoptionService;
import com.adocao.api.utils.dto.AdoptionDTO;
import com.adocao.api.utils.responses.CustomResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/adoption")
public class AdoptionController {

    @Autowired
    AdoptionService adoptionService;

    @GetMapping
    public ResponseEntity<CustomResponse<List<Adoption>>> getAll(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        Pageable pageable = PageRequest.of(page-1, size);
        Page<Adoption> adoptionsPage = adoptionService.findAll(pageable);
        List<Adoption> adoptions = adoptionsPage.getContent();
        CustomResponse<List<Adoption>> response = new CustomResponse<>(adoptions.size(), page, adoptionsPage.getTotalPages(), adoptions);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public Adoption getById(@PathVariable UUID id) {
        return adoptionService.findById(id);
    }

    @PostMapping
    public Adoption create(@RequestBody AdoptionDTO adoption) {
        return adoptionService.save(adoption);
    }

    @PutMapping("/{id}")
    public Adoption update(@PathVariable UUID id, @RequestBody AdoptionDTO adoption) {
        return adoptionService.update(id, adoption);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        adoptionService.deleteById(id);
    }

}
