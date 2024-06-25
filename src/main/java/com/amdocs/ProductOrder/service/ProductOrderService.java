package com.amdocs.ProductOrder.service;


import com.amdocs.ProductOrder.entity.ProductOrder;
import com.amdocs.ProductOrder.repository.ProductOrderRepository;
import com.amdocs.ProductOrder.request.ProductOrderRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;


@Service
public class ProductOrderService {

    @Autowired
    private ProductOrderRepository productOrderRepository;

    public ProductOrder addProductOrder(ProductOrderRequest productOrderRequest) {
        ProductOrder productOrder = new ProductOrder();
        productOrder.setProductID(productOrderRequest.getProductID());
        productOrder.setOrderID(productOrderRequest.getOrderID());
        productOrder.setQuantity(productOrderRequest.getQuantity());
        return productOrderRepository.save(productOrder);
    }

    public Optional<ProductOrder> getProductOrderById(Integer productOrderId) {
        Optional<ProductOrder> productOrder = productOrderRepository.findById(productOrderId);
        System.out.println("product order id" +productOrderId);

        return productOrder;
    }


    public Optional<ProductOrder> getOrderByIdProductOrder(Integer orderId) {
        Optional<ProductOrder> productOrder = productOrderRepository.findById(orderId);
        System.out.println(" order id" +orderId);
        return productOrder;
    }
}
