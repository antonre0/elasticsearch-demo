package com.es.es.repository;

import com.es.es.po.Salary;
import com.es.es.po.Shop;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Stream;

/**
 * @Author: chenandong
 * @Date: 2019/3/25 15:08
 * @Description:
 */
@Repository
public interface SalaryRepository extends ElasticsearchRepository<Salary,Integer> {


}
