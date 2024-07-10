package com.amdocs.ProductOrder.entity;

import jakarta.persistence.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "product_order")
public class ProductOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "productOderId")

    private Integer productOrderId;

    @Column(name = "product_id")
    private Integer productId;



    private Integer quantity;

    @Column(name = "order_id")
    private Integer orderId;

    public ProductOrder (){

    }


    public ProductOrder(Integer productOrderId, Integer productId, Integer quantity, Integer orderId) {
        this.productOrderId = productOrderId;
        this.productId = productId;
        this.quantity = quantity;
        this.orderId = orderId;
    }

    public Integer getProductOrderId() {
        return productOrderId;
    }

    public void setId(Integer productOrderId) {
        this.productOrderId = productOrderId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    @Override
    public String toString() {
        return "ProductOrder{" +
                "productOrderId=" + productOrderId +
                ", productId=" + productId +
                ", quantity=" + quantity +
                ", orderId=" + orderId +
                '}';
    }
}
