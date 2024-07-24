package com.amdocs.ProductOrder.service;


import com.amdocs.ProductOrder.entity.ProductOrder;
import com.amdocs.ProductOrder.repository.ProductOrderRepository;
import com.amdocs.ProductOrder.request.ProductOrderRequest;
import com.amdocs.ProductOrder.response.ProductOrderResponse;
import jakarta.persistence.EntityNotFoundException;
import jdk.swing.interop.SwingInterOpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


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



    public List<ProductOrderResponse> findByOrderID(Integer orderId) {
        List<ProductOrder> productOrder = productOrderRepository.findByOrderId(orderId);
        List<ProductOrderResponse> productOrderResponsesList = new ArrayList<>();
        for(ProductOrder productResponse: productOrder){
            if(productResponse != null){
                ProductOrderResponse response = new ProductOrderResponse(
                        productResponse.getProductOrderId(),
                        productResponse.getProductId(),
                        productResponse.getQuantity(),
                        productResponse.getOrderId());

                productOrderResponsesList.add(response);
            }
        }
       return productOrderResponsesList;

    }

    public void deleteProductOrder(Integer productOrderId) {
        System.out.println("delete");
        productOrderRepository.deleteById(productOrderId);
    }

    public void deleteProductsUpdate(Integer orderId){
       // ProductOrder existingProductOrder = productOrderRepository.findById(orderId).orElseThrow(() -> new EntityNotFoundException("ProductOrder not found"));
        List<ProductOrder> productOrderList = productOrderRepository.findByOrderId(orderId);
        for(ProductOrder products : productOrderList){
            deleteProductOrder(products.getProductOrderId());
            System.out.println("eliminado");
        }
    }



    public ProductOrderResponse updateProducts(Integer orderId, List<ProductOrderRequest> productOrderRequest) {

        //ProductOrder existingProductOrder = productOrderRepository.findById(orderId).orElseThrow(()
             //   -> new EntityNotFoundException("ProductOrder not found"));
        List<ProductOrder> productOrderList = productOrderRepository.findByOrderId(orderId);
        deleteProductsUpdate(orderId);

        for(ProductOrderRequest products : productOrderRequest) {
            ProductOrder productOrder = new ProductOrder();
            productOrder.setOrderId(orderId);

            productOrder.setProductId(products.getProductId());
            productOrder.setQuantity(products.getQuantity());


            productOrderRepository.save(productOrder);
        }


        ProductOrder existingProductOrder = productOrderList.get(0);

        return new ProductOrderResponse(
                existingProductOrder.getProductOrderId(),
                existingProductOrder.getOrderId(),
                existingProductOrder.getProductId(),
                existingProductOrder.getQuantity());

    }
}
