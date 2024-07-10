package com.amdocs.ProductOrder.repository;


import com.amdocs.ProductOrder.entity.ProductOrder;
import com.amdocs.ProductOrder.response.ProductOrderResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductOrderRepository extends JpaRepository<ProductOrder, Integer> {

    List<ProductOrder> findByorderId(Integer orderId);

}
