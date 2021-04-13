package com.es.es;

import com.es.es.po.Order;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        List<Order> userlist = new ArrayList<>();
            Order order = new Order();
            order.setOrderId("zhangsan ");
            order.setId(1);
            userlist.add(order);
        Order order2 = new Order();
        order2.setOrderId("zhangsan2 ");
        order2.setId(12);
        userlist.add(order2);
        Map<String, Order> collect = userlist.stream().collect(Collectors.toMap(Order::getOrderId, Function.identity()));

    }





}