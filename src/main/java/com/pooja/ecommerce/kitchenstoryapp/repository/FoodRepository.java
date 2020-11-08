package com.pooja.ecommerce.kitchenstoryapp.repository;

import com.pooja.ecommerce.kitchenstoryapp.model.Cart;
import com.pooja.ecommerce.kitchenstoryapp.model.Food;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodRepository extends CrudRepository<Food, Integer> {

    @Query(value = " SELECT * FROM food WHERE MATCH(description, food_name) AGAINST (?1)",
        nativeQuery = true)
    public List<Food> search(String keyword);

}
