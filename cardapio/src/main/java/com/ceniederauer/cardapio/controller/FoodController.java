package com.ceniederauer.cardapio.controller;

import com.ceniederauer.cardapio.models.Food;
import com.ceniederauer.cardapio.models.requests.FoodRequestDTO;
import com.ceniederauer.cardapio.models.responses.FoodResponseDTO;
import com.ceniederauer.cardapio.services.FoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
}
