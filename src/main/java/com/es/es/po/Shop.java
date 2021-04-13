package com.es.es.po;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.GeoPointField;
import org.springframework.data.elasticsearch.core.geo.GeoPoint;

import java.util.Date;

/**
 * @Author: chenandong
 * @Date: 2019/3/25 14:09
 * @Description:
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor//shards分片，replicas备份
@Document(indexName = "text",type = "shop",shards = 1,replicas = 0, refreshInterval = "-1")
public class Shop {
    @Id
    @Field(type = FieldType.Keyword)
    private Integer id;

    @Field(type = FieldType.Keyword)
    private Integer companyId;
    @Field(type = FieldType.Text)
    private String companyName;
    @Field(type = FieldType.Text)
    private String shopName;
    @Field(type = FieldType.Text)
    private String address;
    /**省id*/
    @Field(type = FieldType.Keyword)
    private Integer shopProvinceId;
    /**省*/
    @Field(type = FieldType.Text)
    private String shopProvince;
    /**市*/
    @Field(type = FieldType.Keyword)
    private Integer shopCityId;
    /**市*/
    @Field(type = FieldType.Text)
    private String shopCity;
    /**区*/
    @Field(type = FieldType.Keyword)
    private Integer shopDistrictId;
    /**区*/
    @Field(type = FieldType.Text)
    private String shopDistrict;

    @GeoPointField
    private GeoPoint location;

    /**状态*/
    @Field(type = FieldType.Keyword)
    private Integer status;

    @Field(type = FieldType.Keyword)
    private Integer meetCarNight;

    /**品牌*/
    private String brand;
    @Field(type = FieldType.Keyword)
    private Integer brandId;

    /**评分*/
    @Field(type = FieldType.Keyword)
    private Integer star;
    @Field(type = FieldType.Keyword)
    private Integer shopIdOld;
    @Field(type = FieldType.Keyword)
    private Integer produce;//是否生产 0：不生产 1：生产
    @Field(type = FieldType.Keyword)
    private Integer employee;//是否管理员工: 1:员工0:非员工

    @Field(type = FieldType.Keyword)
    private Integer scooter;//是否有代步车 0没有 1有
}
