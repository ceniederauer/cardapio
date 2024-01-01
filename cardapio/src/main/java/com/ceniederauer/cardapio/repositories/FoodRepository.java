package com.ceniederauer.cardapio.repositories;

import com.ceniederauer.cardapio.models.Food;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepository extends JpaRepository<Food, Long> {
}
