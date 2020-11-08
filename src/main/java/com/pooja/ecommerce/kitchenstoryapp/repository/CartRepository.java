package com.pooja.ecommerce.kitchenstoryapp.repository;

import com.pooja.ecommerce.kitchenstoryapp.model.Cart;
import com.pooja.ecommerce.kitchenstoryapp.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface CartRepository extends CrudRepository<Cart, Integer> {

    @Query("select d from Cart d where d.ordered=false AND d.user=:user")
    List<Cart> getUnorderedCartList(
            @Param("user") User user);


}
