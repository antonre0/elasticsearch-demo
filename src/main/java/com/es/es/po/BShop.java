package com.es.es.po;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BShop {
    private Integer id;

    private Integer companyId;

    private String companyName;

    private String shopName;

    private String address;
    /**省id*/
    private Integer shopProvinceId;
    /**省*/
    private String shopProvince;
    /**市*/
    private Integer shopCityId;
    /**市*/
    private String shopCity;
    /**区*/
    private Integer shopDistrictId;
    /**区*/
    private String shopDistrict;
    /**区*/
    private String shopLng;

    private String shopLat;
    /**营业时间*/
    private String openTime;
    /**是否夜间接车*/
    private String isOpenNight;
    /**夜间接车电话*/
    private String openNightTel;
    /**保险公司*/
    private String insuranceCompany;
    /**是否定损*/
    private Integer isDamage;
    /**保险经理*/
    private String insuranceManager;

    private String insuranceManagerTel;

    private String insuranceManagerBak;

    private String insuranceManagerTelBak;
    /**电话*/
    private String tel;
    /**店主*/
    private String shopOwner;
    /**备注*/
    private String description;
    /**状态*/
    private Integer status;

    private Date createTime;

    private String createBy;
    /**公司分组*/
    private String groupCompanyName;

    private String receiverJob;

    private String receiverName;

    private String receiverTel;

    private String cooperationStatus;

    private Integer meetCarNight;

    private String remark;

    private Date lastUpdateTime;
    /**品牌*/
    private String brand;

    private Integer brandId;

    private String shopSignatory;

    private String shopAbutment;

    private String subordinationArea;

    private String affiliateGroup;
    /**评分*/
    private Integer star;

    private Integer shopIdOld;
    private Integer produce;//是否生产 0：不生产 1：生产
    private Integer employee;//是否管理员工: 1:员工0:非员工

    private String shopOpenTime;//营业时间
    private String shopCloseTime;//关门时间

    private Integer agreementStatus;//是否签协议 1是，0否

    private Date agreementTime;//签署时间
    private Integer scooter;//是否有代步车 0没有 1有
}
