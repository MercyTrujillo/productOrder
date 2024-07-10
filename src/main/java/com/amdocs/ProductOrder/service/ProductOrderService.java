package com.amdocs.ProductOrder.service;


import com.amdocs.ProductOrder.entity.ProductOrder;
import com.amdocs.ProductOrder.repository.ProductOrderRepository;
import com.amdocs.ProductOrder.request.ProductOrderRequest;
import com.amdocs.ProductOrder.response.ProductOrderResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class ProductOrderService {

    @Autowired
    private ProductOrderRepository productOrderRepository;

    public ProductOrder addProductOrder(ProductOrderRequest productOrderRequest) {
        ProductOrder productOrder = new ProductOrder();
        productOrder.setProductId(productOrderRequest.getProductId());
        productOrder.setOrderId(productOrderRequest.getOrderId());
        productOrder.setQuantity(productOrderRequest.getQuantity());
        return productOrderRepository.save(productOrder);
    }

//    public Optional<ProductOrder> getProductOrderById(Integer productOrderId) {
//        Optional<ProductOrder> productOrder = productOrderRepository.findById(productOrderId);
//        System.out.println("product order id" +productOrderId);
//
//        return productOrder;
//    }



    public List<ProductOrderResponse> findByOrderID(Integer orderId) {
        List<ProductOrder> productOrder = productOrderRepository.findByorderId(orderId);
        List<ProductOrderResponse> productOrderResponsesList = new ArrayList<>();
        for(ProductOrder productResponse: productOrder){
            if(productResponse == null){

            }
                ProductOrderResponse response = new ProductOrderResponse(productResponse.getProductOrderId(),
                        productResponse.getOrderId(),
                        productResponse.getProductId(),
                        productResponse.getQuantity());

            productOrderResponsesList.add(response);


        }
       return productOrderResponsesList;

    }


//    public Optional<ProductOrder> getOrderByIdProductOrder(Integer orderId) {
//        Optional<ProductOrder> productOrder = productOrderRepository.findById(orderId);
//        System.out.println(" order id" +orderId);
//        return productOrder;
//    }


}
