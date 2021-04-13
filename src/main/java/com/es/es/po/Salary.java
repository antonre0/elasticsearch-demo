package com.es.es.po;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.math.BigDecimal;
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
@Document(indexName = "salarytest",type = "salarytest",shards = 1,replicas = 0, refreshInterval = "-1")
public class Salary {
    @Id
    private Integer id;
    /**
     * 及时雨id
     */
    @Field(type = FieldType.Keyword)
    private String month;

    @Field(type = FieldType.Keyword)
    private String year;

    @Field(type = FieldType.Keyword)
    private String level;



    @Field(type = FieldType.Keyword)
    private String price;

    @Field(type = FieldType.Text)
    private String name;

    @Field(type = FieldType.Integer)
    private Integer price3;
    @Field(type = FieldType.Integer)
    private Integer price4;
    @Field(type = FieldType.Text)
    private String text;
    @Field(type = FieldType.Integer)
    private Integer area;

    @Field(type = FieldType.Keyword)
    private String city;


    @Field(type = FieldType.Date)
    private Date dateTime;

}
