package com.adocao.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.function.Function;

public abstract class BaseService<T, ID, DTO> {

    @Autowired
    protected JpaRepository<T, ID> repository;
    private final Function<DTO, T> entityCreator;

    public BaseService(JpaRepository<T, ID> repository, Function<DTO, T> entityCreator) {
        this.repository = repository;
        this.entityCreator = entityCreator;
    }

    public Page<T> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public T findById(ID id) {
        return repository.findById(id).orElse(null);
    }

    public T save(DTO dto) {
        T entity = entityCreator.apply(dto);
        return repository.save(entity);
    }

    public T update(ID id, DTO dto) {
        T entity = repository.findById(id).orElse(null);
        if (entity == null) {
            return null;
        }
        entity = entityCreator.apply(dto);
        return repository.save(entity);
    }

    public void deleteById(ID id) {
        repository.deleteById(id);
    }

}
