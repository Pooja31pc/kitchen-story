package com.pooja.ecommerce.kitchenstoryapp.model;

import com.pooja.ecommerce.kitchenstoryapp.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchService {

    @Autowired
    private FoodRepository foodRepository;

    public List<Food> search(String keyword) {
            return foodRepository.search(keyword);
    }

}
