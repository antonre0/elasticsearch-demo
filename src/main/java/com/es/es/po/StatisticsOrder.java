package com.es.es.po;

/**
 * @Author: chenandong
 * @Date: 15:50 2018/12/7
 * 订单统计实体
 */

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tj_statistics_order")
public class StatisticsOrder implements Serializable {

    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;
    /**
     * 及时雨id
     */
    private String userId;

    private String userName;

    private String orderId;

    /**
     * 里程数
     */
    private Double mileage;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createTime;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date terminalTime;
    /**
     * 城市
     */
    private Integer cityId;
    private String cityName;
    private String areaName;
    /**
     * 区域
     */
    private Integer areaId;
    /**
     * 订单数据
     */
    private String orderStatistics;

    /**
     * 0.有效；1.重复；2.无效
     */
    private Integer infoStatus;

    /**
     * 订单状态
     */
    @Transient
    private Integer orderStatus;

    /**
     * 奖励金
     */
    private Integer rewardPrice;

    private Integer orderFirstStatus;
    private Integer orderLastStatus;


}