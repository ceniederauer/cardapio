package com.ceniederauer.cardapio.controller;

import com.ceniederauer.cardapio.models.Food;
import com.ceniederauer.cardapio.models.requests.FoodRequestDTO;
import com.ceniederauer.cardapio.models.responses.FoodResponseDTO;
import com.ceniederauer.cardapio.services.FoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/food")
@RequiredArgsConstructor
public class FoodController {

    private final FoodService foodService;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    public List<FoodResponseDTO> getAll(){
        List<FoodResponseDTO> getAll = foodService.getAll();
        return getAll;
    };

    @CrossOrigin(origins = "*", allowedHeaders = "*") 
    @PostMapping("/save-food")
    public void saveFood(@RequestBody FoodRequestDTO data) throws Exception {
        foodService.saveFood(data);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/{id}")
    public FoodResponseDTO getById(@PathVariable Long id) throws Exception {
        Optional<Food> foodFound = foodService.getById(id);
        if(foodFound.isPresent()) {
            return new FoodResponseDTO(foodFound.get());
        } else {
            throw new Exception("[404] food not found");
        }
    }

}
