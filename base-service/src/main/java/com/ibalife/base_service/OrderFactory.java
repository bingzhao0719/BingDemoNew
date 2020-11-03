package com.ibalife.base_service;

public class OrderFactory {
    private IOrder iOrder;
    private OrderFactory(){

    }
    private static class Inner{
        private static OrderFactory orderFactory = new OrderFactory();
    }

    public IOrder getOrder() {
        return iOrder;
    }

    public void setOrder(IOrder iOrder) {
        this.iOrder = iOrder;
    }
    public static OrderFactory getInstance(){
        return Inner.orderFactory;
    }
}
