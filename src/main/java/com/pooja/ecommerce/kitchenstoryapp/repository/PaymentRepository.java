package com.pooja.ecommerce.kitchenstoryapp.repository;

import com.pooja.ecommerce.kitchenstoryapp.model.Cart;
import com.pooja.ecommerce.kitchenstoryapp.model.Payment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends CrudRepository<Payment, Integer> {
}
