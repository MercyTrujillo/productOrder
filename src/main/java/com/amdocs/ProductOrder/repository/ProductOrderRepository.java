package com.amdocs.ProductOrder.repository;


import com.amdocs.ProductOrder.entity.ProductOrder;
import com.amdocs.ProductOrder.request.ProductOrderRequest;
import com.amdocs.ProductOrder.response.ProductOrderResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductOrderRepository extends JpaRepository<ProductOrder, Integer> {

    List<ProductOrder> findByOrderId(Integer orderId);
    void deleteByIdIn(List<Long> ids);


}
