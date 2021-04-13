package com.es.es.repository;

import com.es.es.po.Order;
import com.es.es.po.Shop;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @Author: chenandong
 * @Date: 2019/3/28 14:15
 * @Description:
 */
public interface OrderRepository  extends ElasticsearchRepository<Order,Integer> {
}
