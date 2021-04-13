package com.es.es.po;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Date;

/**
 * @Author: chenandong
 * @Date: 2019/6/24 17:53
 * @Description:
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor//shards分片，replicas备份
@Document(indexName = "salary",type = "salary",shards = 1,replicas = 0, refreshInterval = "-1")
public class SalaryDetil {
    private Integer id;
    /**
     * 及时雨id
     */
    private String month;

    private String year;

    private String level;

    private String city;

    private Integer price3;
    private Integer price4;

    private Date dateTime;

}
