package com.clothesstore.adminservice.event;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;


@Getter
@Setter
public class SyncProductsShopify extends ApplicationEvent {
    private String orderNumber;

    public SyncProductsShopify(Object source, String orderNumber) {
        super(source);
        this.orderNumber = orderNumber;
    }

    public SyncProductsShopify(String orderNumber) {
        super(orderNumber);
        this.orderNumber = orderNumber;
    }
}