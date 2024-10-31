package com.adocao.api.controllers;

import com.adocao.api.services.AnimalService;
import com.adocao.api.utils.dto.AnimalDTO;
import com.adocao.api.entities.Animal;
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
@RequestMapping("/animal")
public class AnimalController {

    @Autowired
    private AnimalService animalService;

    @GetMapping
    public ResponseEntity<CustomResponse<List<Animal>>> getAll(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        Pageable pageable = PageRequest.of(page-1, size);
        Page<Animal> animalsPage = animalService.findAll(pageable);
        List<Animal> animals = animalsPage.getContent();
        CustomResponse<List<Animal>> response = new CustomResponse<>(animals.size(), page, animalsPage.getTotalPages(), animals);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public Animal getById(@PathVariable UUID id) {
        return animalService.findById(id);
    }

    @PostMapping
    public Animal create(@RequestBody AnimalDTO animal) {
        return animalService.save(animal);
    }

    @PutMapping("/{id}")
    public Animal update(@PathVariable UUID id, @RequestBody AnimalDTO animal) {
        return animalService.update(id, animal);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        animalService.deleteById(id);
    }

}
