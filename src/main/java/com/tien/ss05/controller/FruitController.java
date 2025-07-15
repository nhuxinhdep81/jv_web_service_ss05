package com.tien.ss05.controller;

import com.tien.ss05.model.dto.FruitDTO;
import com.tien.ss05.model.dto.response.DataResponse;
import com.tien.ss05.model.entity.Fruit;
import com.tien.ss05.service.FruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/fruits")
public class FruitController {

    @Autowired
    private FruitService fruitService;

    @GetMapping
    public ResponseEntity<DataResponse<List<FruitDTO>>> getAllFruits() {
        List<FruitDTO> fruits = fruitService.getAllFruits().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
        return new ResponseEntity<>(new DataResponse<>(fruits, HttpStatus.OK), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DataResponse<FruitDTO>> getFruitById(@PathVariable Long id) {
        Fruit fruit = fruitService.getFruitById(id);
        return new ResponseEntity<>(new DataResponse<>(toDTO(fruit), HttpStatus.OK), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<DataResponse<Fruit>> createFruit(@RequestBody Fruit fruit) {
        Fruit created = fruitService.createFruit(fruit);
        return new ResponseEntity<>(new DataResponse<>(created, HttpStatus.CREATED), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DataResponse<Fruit>> updateFruit(@PathVariable Long id, @RequestBody Fruit fruit) {
        Fruit updated = fruitService.updateFruit(id, fruit);
        return new ResponseEntity<>(new DataResponse<>(updated, HttpStatus.OK), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DataResponse<String>> deleteFruit(@PathVariable Long id) {
        fruitService.deleteFruit(id);
        return new ResponseEntity<>(new DataResponse<>("Fruit deleted successfully", HttpStatus.NO_CONTENT), HttpStatus.NO_CONTENT);
    }

    // convert Entity → DTO
    private FruitDTO toDTO(Fruit fruit) {
        FruitDTO dto = new FruitDTO();
        dto.setId(fruit.getId());
        dto.setName(fruit.getName());
        dto.setPrice(fruit.getPrice());
        dto.setStatus(fruit.getStatus());
        dto.setCreatedAt(fruit.getCreateAt());
        return dto;
    }
}
