package com.ceniederauer.cardapio.services;

import com.ceniederauer.cardapio.models.Food;
import com.ceniederauer.cardapio.repositories.FoodRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class FoodServiceTest {

    @InjectMocks
    FoodService foodService;

    @Mock
    FoodRepository  foodRepository;

    Food food;

    @BeforeEach
    public void setUp() {
       food = new Food(5L, "peixe", "image", 25.0);
    }

    @Test
    void findFoods() {
        when(foodRepository.findById(food.getId())).thenReturn(Optional.ofNullable(food));
        Optional<Food> foods = foodService.getById(food.getId());
        assertEquals(Optional.ofNullable(food), foods);
        verify(foodRepository).findById(food.getId());
        verifyNoMoreInteractions(foodRepository);
    }
}
