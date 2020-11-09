package com.pooja.ecommerce.kitchenstoryapp.controller;

import com.pooja.ecommerce.kitchenstoryapp.model.*;
import com.pooja.ecommerce.kitchenstoryapp.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private CartRepository cartRepo;

    @Autowired
    private CuisineRepository cuisineRepo;

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

    @Autowired
    private CartfoodItemRepository cartfoodItemRepo;

    @Autowired
    private SearchService service;

    //=======================================
//    @PostMapping("addcartitem")
//    public String postCartItem(@RequestBody AddItemUser addItemUser){
//        Optional<Cart> cart = cartRepo.findById(addItemUser.getCartId());
//        if (cart.isPresent()) {
//            //yaha query likhna hai
//            Cart cart1 = cart.get();
//            Optional<Food> food = foodRepo.findById(addItemUser.getFoodId());
//            if (food.isPresent()){
//                Food khana =food.get();
//                CartfoodItem cartfoodItem = new CartfoodItem(khana,cart1,addItemUser.getQuantity(),addItemUser.getPrice());
//                cartfoodItemRepo.save(cartfoodItem);
//                return "Success";
//            }
//
//        }
//        CartfoodItem cartfoodItem =new CartfoodItem();
//        cartfoodItemRepo.save(cartfoodItem);
//        return "Success";
//    }
//====================================
    @PostMapping("addpayment")
    public String postPayment(@RequestBody PaymentUser paymentUser) {
        Optional<Cart> cart = cartRepo.findById(paymentUser.getCartId());
        if (cart.isPresent()) {
            Cart cart1 = cart.get();
            //User user = cart1.getUser();
            int amount = 0;
            for (CartfoodItem item : cart1.getCartfoodItem()) {
                amount += item.getQuantity() * item.getFood().getPrice();
            }
            cart1.setOrdered(true);
            cart1.setOrderedtime(new Date());
            cart1 = cartRepo.save(cart1);
            Payment payment = new Payment(cart1.getUser(), cart1, paymentUser.getPaymentMethod(), paymentUser.getCardNumber(), amount);
            payRepo.save(payment);

            return "Success";

        }
        return "Error";
    }


    @GetMapping("search")
    public List<Food> showlist(@RequestParam("keyword") String keyword) {
        List<Food> listProducts = service.search(keyword);
        return listProducts;
    }


//    @PostMapping("addorderitem")
//    public String postOrderItem(@RequestBody AddOrderItemRequest orderItemRequest){
//        Optional<Customer> customer = repo.findById(orderItemRequest.getCustomerId());
//        if (customer.isPresent()) {
//            Customer customer1 = customer.get();
//            Optional<Shoe> shoe = shoerepo.findById(orderItemRequest.getShoeId());
//            if (shoe.isPresent()){
//                Shoe boot =shoe.get();
//                OrderItem orderItem = new OrderItem(orderItemRequest.getQuantity(),orderItemRequest.getTotalPrice(),orderItemRequest.getSize(),orderItemRequest.getDate(),customer1,boot);
//                orderitemrepo.save(orderItem);
//                return "Success";
//            }
//
//        }
//        OrderItem orderItem =new OrderItem();
//        orderitemrepo.save(orderItem);
//        return "Success";
//    }

    @PostMapping("addcartitem")
    public String postCartItem(@RequestBody AddItemUser addItemUser) {
        Optional<Food> food = foodRepo.findById(addItemUser.getFoodId());
        Optional<User> user = userRepo.findById(addItemUser.getUserId());
        if (user.isPresent()) {
            User userObj = user.get();
            List<Cart> carts = cartRepo.getUnorderedCartList(userObj);
            Cart cart;
            if (carts.size() < 1) {
                cart = cartRepo.save(new Cart(false, userObj));
            } else {
                cart = carts.get(0);
            }
            if (food.isPresent()) {
                Food khana = food.get();
                CartfoodItem cartfoodItem = new CartfoodItem(khana, cart, addItemUser.getQuantity());
                cartfoodItemRepo.save(cartfoodItem);
                return "Success";
            }
        }
        return "Error";
    }

//    @GetMapping("getcart")
//    public Cart getCart(@RequestParam("user_id")int userId){
//        Optional<User> user = userRepo.findById(userId);
//        if (user.isPresent()) {
//            User userObj = user.get();
//            List<Cart> carts = cartRepo.getUnorderedCartList(userObj);
//            Cart cart;
//            if (carts.size() < 1) {
//                cart = cartRepo.save(new Cart(false, userObj));
//            } else {
//                cart = carts.get(0);
//            }
//            return cart;
//        }
//        return null;
//    }


}
