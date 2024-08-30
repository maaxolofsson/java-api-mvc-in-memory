package com.booleanuk.api.bagels.controller;

import com.booleanuk.api.bagels.model.Bagel;
import com.booleanuk.api.bagels.repository.BagelRepository;

import java.util.List;

public class BagelController {
    BagelRepository repository;

    public BagelController(BagelRepository repository) {
        this.repository = repository;
    }

    public List<Bagel> getAll() {
        return this.repository.findAll();
    }
}
