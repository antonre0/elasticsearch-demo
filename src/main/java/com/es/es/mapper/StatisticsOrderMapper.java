package com.es.es.mapper;


import com.es.es.po.StatisticsOrder;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * @Author: chenandong
 * @Date: 15:53 2018/12/7
 */
@Mapper
public interface StatisticsOrderMapper extends BaseMapper<StatisticsOrder> {

    @Select("select * from tj_statistics_order where order_id = #{v}")
    StatisticsOrder findByOrderId(String orderNo);


}
