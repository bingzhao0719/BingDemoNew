package com.bing.order;

import com.ibalife.base_service.IOrder;

public class OrderService implements IOrder {
    @Override
    public int getOrderCount() {
        return 100;
    }
}
