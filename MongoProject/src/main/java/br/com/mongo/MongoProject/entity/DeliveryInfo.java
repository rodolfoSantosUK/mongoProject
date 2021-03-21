package br.com.mongo.MongoProject.entity;

import java.time.LocalDate;

public class DeliveryInfo {
    private LocalDate deliveryDate;
    private int deliveryFee;
    private boolean inStock;

    public DeliveryInfo(LocalDate deliveryDate,
                        int deliveryFee,
                        boolean inStock) {
        this.deliveryDate = deliveryDate;
        this.deliveryFee = deliveryFee;
        this.inStock = inStock;
    }

    public int getDeliveryFee() {
        return this.deliveryFee;
    }

    public LocalDate getDeliveryDate() {
        return this.deliveryDate;
    }

    public boolean isInStock() {
        return this.inStock;
    }
}
