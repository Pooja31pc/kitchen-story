package com.pooja.ecommerce.kitchenstoryapp.repository;

import com.pooja.ecommerce.kitchenstoryapp.model.Cart;
import com.pooja.ecommerce.kitchenstoryapp.model.Cuisine;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CuisineRepository extends CrudRepository<Cuisine, Integer> {
}
