package com.es.es.po;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author: chenandong
 * @Date: 2019/6/25 11:25
 * @Description:
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(indexName = "salary",type = "salary",shards = 1,replicas = 0, refreshInterval = "-1")
public class SalaryIndexDto {

    @Id
    private String id;

    @Field(type = FieldType.Keyword)
    private Integer cityId;

    @Field(type = FieldType.Keyword)
    private Integer teamId;

    @Field(type = FieldType.Keyword)
    private Integer staffId;

    @Field(type = FieldType.Keyword)
    private String cityLevel;

    /**
     * 时间
     */
    @Field(type = FieldType.Keyword)
    private String time;

    /**
     * 搜索用时间
     */
    @Field(type = FieldType.Date,store = false,index = true)
    private Date dateTime;


    /***基础信息***/

    /**城市*/
    @Field(type = FieldType.Keyword,store = true,index = true,analyzer = "ik_smart")
    private String cityName;
    /**分组*/
    @Field(type = FieldType.Keyword,store = true,index = true,analyzer = "ik_smart")
    private String teamName;
    /**姓名*/
    @Field(type = FieldType.Text,store = true,index = true,analyzer = "ik_smart")
    private String staffName;
    /**入职时长*/
    @Field(type = FieldType.Integer,store = true,index = false)
    private Integer workMonth;

    /***任务字段***/

    /**默认级别*/
    @Field(type = FieldType.Text,store = true,index = false)
    private String defaultLevel;
    /**调整级别*/
    @Field(type = FieldType.Text,store = true,index = false)
    private String adjustLevel;
    /**现场任务*/
    @Field(type = FieldType.Integer,store = true,index = false)
    private Integer sceneTask;
    /**台次任务*/
    @Field(type = FieldType.Integer,store = true,index = false)
    private Integer pushTask;
    /**产值任务*/
    @Field(type = FieldType.Text,store = true,index = false)
    private String outputTask;

    /** 聚合字段 **/

    /**总工资*/
    @Field(type = FieldType.Double)
    private BigDecimal staffSalary;

    /**推送台次*/
    @Field(type = FieldType.Integer)
    private Integer pushNum;
    /**定损金额*/
    @Field(type = FieldType.Double)
    private BigDecimal fixLossPrice;
    /**基础计提*/
    @Field(type = FieldType.Double)
    private BigDecimal baseStaffPrice;
    /**台次系数*/
    @Field(type = FieldType.Double)
    private BigDecimal pushRate;
    /**产值系数*/
    @Field(type = FieldType.Double)
    private BigDecimal outputRate;
    /**绩效提成*/
    @Field(type = FieldType.Double)
    private BigDecimal staffPrice;

    /**成功*/
    @Field(type = FieldType.Integer)
    private Integer success;
    /**失败*/
    @Field(type = FieldType.Integer)
    private Integer failed;
    /**扑空*/
    @Field(type = FieldType.Integer)
    private Integer empty;
    /**完成上限*/
    @Field(type = FieldType.Double)
    private Double completionCap;
    /**不完成上限*/
    @Field(type = FieldType.Double)
    private Double nonCompletionCap;
    /**补助调整前*/
    @Field(type = FieldType.Double)
    private BigDecimal subsidy;
    /**补助*/
    @Field(type = FieldType.Double)
    private BigDecimal subsidyAdjust;

    /**任务奖励*/
    @Field(type = FieldType.Double)
    private BigDecimal pushReward;
    /**底薪*/
    @Field(type = FieldType.Double)
    private BigDecimal basicSalary;
    /**往月调整*/
    @Field(type = FieldType.Double)
    private BigDecimal monthChange;
    /**其他调整*/
    @Field(type = FieldType.Double)
    private BigDecimal otherAdjust;
}
