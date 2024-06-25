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
    private Integer productID;



    private Integer quantity;

    @Column(name = "order_id")
    private Integer orderID;

    public ProductOrder (){

    }


    public ProductOrder(Integer productOrderId, Integer productID, Integer quantity, Integer orderID) {
        this.productOrderId = productOrderId;
        this.productID = productID;
        this.quantity = quantity;
        this.orderID = orderID;
    }

    public Integer getProductOrderId() {
        return productOrderId;
    }

    public void setId(Integer productOrderId) {
        this.productOrderId = productOrderId;
    }

    public Integer getProductID() {
        return productID;
    }

    public void setProductID(Integer productID) {
        this.productID = productID;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getOrderID() {
        return orderID;
    }

    public void setOrderID(Integer orderID) {
        this.orderID = orderID;
    }

    @Override
    public String toString() {
        return "ProductOrder{" +
                "productOrderId=" + productOrderId +
                ", productID=" + productID +
                ", quantity=" + quantity +
                ", orderID=" + orderID +
                '}';
    }
}
