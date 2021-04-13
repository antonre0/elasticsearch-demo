package com.es.es.mapper;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @Author: chenandong
 * @Date: 2019/3/18 14:03
 * @Description:
 */
public interface BaseMapper<T> extends Mapper<T> ,MySqlMapper<T> {
}
