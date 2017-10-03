package com.theironyard.charlotte.cookiesjar.repositories;

import com.theironyard.charlotte.cookiesjar.models.Ingredient;
import org.springframework.data.repository.CrudRepository;

public interface IngredientRepository extends CrudRepository<Ingredient, Integer> {
    Ingredient findByName(String SOMEDUMBCRAP);
}
