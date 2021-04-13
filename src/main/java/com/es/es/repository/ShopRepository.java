package com.es.es.repository;

import com.es.es.po.Shop;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author: chenandong
 * @Date: 2019/3/25 15:08
 * @Description:
 */
@Repository
public interface ShopRepository extends ElasticsearchRepository<Shop,Integer> {
}
