package com.pooja.ecommerce.kitchenstoryapp.controller;

import com.pooja.ecommerce.kitchenstoryapp.model.*;
import com.pooja.ecommerce.kitchenstoryapp.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserRepository userRepo;

    @GetMapping("user")
    public List<User> getUser()
    {
        List<User> user = (List<User>) userRepo.findAll();

        return user;
    }

    @Autowired
    private CartRepository cartRepo;

    @GetMapping("cart")
    public List<Cart> getCart()
    {
        List<Cart> cart = (List<Cart>) cartRepo.findAll();

        return cart;
    }

    @Autowired
    private CuisineRepository cuisineRepo;

    @GetMapping("cuisine")
    public List<Cuisine> getCuisine()
    {
        List<Cuisine> cuisine = (List<Cuisine>) cuisineRepo.findAll();

        return cuisine;
    }

    @Autowired
    private FoodRepository foodRepo;

    @GetMapping("food")
    public List<Food> getFood()
    {
        List<Food> food = (List<Food>) foodRepo.findAll();

        return food;
    }


    @Autowired
    private PaymentRepository payRepo;

    @GetMapping("payment")
    public List<Payment> getPayment()
    {
        List<Payment> payment = (List<Payment>) payRepo.findAll();

        return payment;
    }

    @Autowired
    private CartfoodItemRepository cartfoodItemRepo;

    @GetMapping("cartfoodItem")
    public List<CartfoodItem> getCartfoodItem()
    {
        List<CartfoodItem> cartfoodItem = (List<CartfoodItem>) cartfoodItemRepo.findAll();

        return cartfoodItem;
    }


    @GetMapping("addfood")
    public String addFood(@RequestParam("food_id") int foodid, @RequestParam("description") String description, @RequestParam("food_name") String foodname, @RequestParam("price") double price, @RequestParam("cuisine_cuisine_id") Cuisine cuisineid)
    {
        Food food =new Food(foodid,description,foodname,price,cuisineid);
        foodRepo.save(food);
        return "Success";
    }

    @PostMapping("addfood")
    public String postFood(@RequestBody AddFoodAdmin addfoodAdmin){
            Optional<Cuisine> cuisine = cuisineRepo.findById(addfoodAdmin.getCuisineId());
            if (cuisine.isPresent()){
                Cuisine category =cuisine.get();
               Food food = new Food(addfoodAdmin.getFoodName(),addfoodAdmin.getDescription(),addfoodAdmin.getPrice(),category);
                foodRepo.save(food);
                return "Success";
            }

        Food food =new Food();
        foodRepo.save(food);
        return "Success";

    }

    @DeleteMapping("dltfood")
    private String deleteBook(@RequestParam("foodId") int foodId)
    {

        foodRepo.deleteById(foodId);
        return "Success";
    }


    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @PostMapping("register")
    public String auth(@RequestBody Admin admin)
    {
        admin.setPassword(bCryptPasswordEncoder.encode(admin.getPassword()));
        adminrepo.save(admin);
        return "Success";
    }

    @Autowired
    AdminRepository adminrepo;


}
