package com.es.es.po;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import javax.persistence.Transient;
import java.util.Date;

/**
 * @Author: chenandong
 * @Date: 2019/3/28 14:10
 * @Description:
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor//shards分片，replicas备份
@Document(indexName = "order",type = "order",shards = 1,replicas = 0, refreshInterval = "-1")
public class Order {
    @Id
    private Integer id;
    /**
     * 及时雨id
     */
    @Field(type = FieldType.Keyword)
    private String userId;
    @Field(type = FieldType.Keyword)
    private String userName;
    @Field(type = FieldType.Keyword)
    private String orderId;

    /**
     * 里程数
     */
    private Double mileage;

    @Field(type = FieldType.Date)
    private Date createTime;

    @Field(type = FieldType.Date)
    private Date terminalTime;
    /**
     * 城市
     */
    @Field(type = FieldType.Keyword)
    private Integer cityId;
    @Field(type = FieldType.Keyword)
    private String cityName;
    @Field(type = FieldType.Keyword)
    private String areaName;
    /**
     * 区域
     */
    @Field(type = FieldType.Keyword)
    private Integer areaId;
    /**
     * 订单数据
     */
    @Field(type = FieldType.Keyword)
    private String orderStatistics;

    /**
     * 0.有效；1.重复；2.无效
     */
    @Field(type = FieldType.Keyword)
    private Integer infoStatus;


    /**
     * 奖励金
     */
    @Field(type = FieldType.Keyword)
    private Integer rewardPrice;

    @Field(type = FieldType.Keyword)
    private Integer orderFirstStatus;
    @Field(type = FieldType.Keyword)
    private Integer orderLastStatus;
}
