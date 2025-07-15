package com.tien.ss05.service;

import com.tien.ss05.model.entity.Fruit;
import com.tien.ss05.repository.FruitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class FruitService {

    @Autowired
    private FruitRepository fruitRepository;

    public List<Fruit> getAllFruits() {
        return fruitRepository.findAll();
    }

    public Fruit getFruitById(Long id) {
        return fruitRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Fruit not found"));
    }

    public Fruit createFruit(Fruit fruit) {
        return fruitRepository.save(fruit);
    }

    public Fruit updateFruit(Long id, Fruit fruit) {
        fruitRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Fruit not found"));
        fruit.setId(id);
        return fruitRepository.save(fruit);
    }

    public void deleteFruit(Long id) {
        fruitRepository.deleteById(id);
    }
}
