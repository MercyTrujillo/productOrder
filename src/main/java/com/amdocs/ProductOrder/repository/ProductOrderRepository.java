package com.amdocs.ProductOrder.repository;


import com.amdocs.ProductOrder.entity.ProductOrder;
import org.springframework.data.repository.CrudRepository;

public interface ProductOrderRepository extends CrudRepository <ProductOrder, Integer> {
}
