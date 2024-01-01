package com.ceniederauer.cardapio.services;

import com.ceniederauer.cardapio.models.Food;
import com.ceniederauer.cardapio.models.requests.FoodRequestDTO;
import com.ceniederauer.cardapio.models.responses.FoodResponseDTO;
import com.ceniederauer.cardapio.repositories.FoodRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FoodService {

    @Autowired
    private final FoodRepository foodRepository;

    public List<FoodResponseDTO> getAll() {
        List<FoodResponseDTO> allFood = foodRepository.findAll()
                .stream()
                .map(FoodResponseDTO::new)
                .collect(Collectors.toList());
        return allFood;
    }

    public void saveFood(FoodRequestDTO data) throws Exception {
        if(data.price().isNaN() || data.price() <= 0) {
            throw new Exception("[400] Check the price, something is wrong.");
        }
        if(data.title().isEmpty()) {
            throw new Exception("[400] Check the title, something is wrong.");
        }
        Food foodData = new Food(data);
        foodRepository.save(foodData);
    }
}
