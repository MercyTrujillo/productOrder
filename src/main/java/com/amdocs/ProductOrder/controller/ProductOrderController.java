package com.amdocs.ProductOrder.controller;
import com.amdocs.ProductOrder.entity.ProductOrder;
import com.amdocs.ProductOrder.repository.ProductOrderRepository;
import com.amdocs.ProductOrder.request.ProductOrderRequest;
import com.amdocs.ProductOrder.response.ProductOrderResponse;
import com.amdocs.ProductOrder.service.ProductOrderService;
import org.aspectj.lang.annotation.DeclareWarning;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ProductOrderController {

    @Autowired
    private ProductOrderService productOrderService;

    @Autowired
    private ProductOrderRepository repository;

    private static final Logger log = LoggerFactory.getLogger(ProductOrderController.class);

    @RequestMapping(method = RequestMethod.POST, value = "/productorder")
    public ResponseEntity<Integer> addProductOrder(@RequestBody ProductOrderRequest productOrderRequest){
        ProductOrder response = productOrderService.addProductOrder(productOrderRequest);
        Integer productOrderId = response.getProductOrderId();
        return ResponseEntity.status(HttpStatus.OK).body(productOrderId);
    }


    @RequestMapping(method = RequestMethod.GET, value = "/productorder/{orderId}")
    public List<ProductOrderResponse> findByOrderID(@PathVariable Integer orderId){
        return productOrderService.findByOrderID(orderId);
    }


    @DeleteMapping(value = "/productorder/{productOrderId}")
    public ResponseEntity<String> deleteProductOrder(@PathVariable Integer productOrderId){

        productOrderService.deleteProductOrder(productOrderId);
        return ResponseEntity.ok("Product order deleted");

    }





    @RequestMapping(method = RequestMethod.PUT, value = "/productorder/{orderId}")
    public ResponseEntity<ProductOrderResponse> updateProducts(@PathVariable Integer orderId,  @RequestBody  List<ProductOrderRequest> productOrderRequest) {
        ProductOrderResponse productResponse = productOrderService.updateProducts(orderId, productOrderRequest);
        return ResponseEntity.ok(productResponse);
    }



}
