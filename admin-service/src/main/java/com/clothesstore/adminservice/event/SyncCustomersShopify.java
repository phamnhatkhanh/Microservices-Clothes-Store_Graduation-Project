package com.clothesstore.adminservice.event;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;


@Getter
@Setter
public class SyncCustomersShopify extends ApplicationEvent {
    private String orderNumber;

    public SyncCustomersShopify(Object source, String orderNumber) {
        super(source);
        this.orderNumber = orderNumber;
    }

    public SyncCustomersShopify(String orderNumber) {
        super(orderNumber);
        this.orderNumber = orderNumber;
    }
}