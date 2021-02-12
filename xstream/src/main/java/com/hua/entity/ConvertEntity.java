/**
  * @filename ConvertEntity.java
  * @description 
  * @version 1.0
  * @author qianye.zheng
 */
package com.hua.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import com.hua.constant.ConvertConstant;
import com.hua.convert.BooleanYNConvert;
import com.hua.convert.CdataConvert;
import com.hua.convert.LocalDateConvert;
import com.hua.convert.LocalDateTimeConvert;
import com.hua.convert.ListValueConvert;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamConverter;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @type ConvertEntity
 * @description 
 * @author qianye.zheng
 */
@Data
@XStreamAlias("ConvertEntity")
public final class ConvertEntity {
    
    private String gender;
    
    @XStreamAlias("first_name")  
    private String firstname;
    
    @XStreamAlias("last-name")  
    private String lastname;
    
    @XStreamAlias("phone_number")  
    private String phoneNumber;
    
    private Address address;
    
    @XStreamAsAttribute  
    @XStreamAlias("xmlns")  //  -> <convertEntity xmlns="dddddddd">
    private String xmlns;
    
    @XStreamConverter(value = LocalDateConvert.class)
    private LocalDate date;
    
    @XStreamConverter(value = LocalDateTimeConvert.class)
    private LocalDateTime dateTime;
    
    @XStreamAlias("flag_1")
    @XStreamConverter(value = BooleanYNConvert.class)
    private Boolean flag;
    
    private Integer number;
    
    @XStreamAlias(ConvertConstant.REPLACE_TAG)
    @XStreamConverter(value = ListValueConvert.class)
    private ListValueType values;
    
    @XStreamAlias(ConvertConstant.REPLACE_TAG)
    @XStreamConverter(value = ListValueConvert.class)
    private ListValueType types;
    
    private Map<String, Object> someMap;
    
    /**
     * 
     * @type Address
     * @description 
     * @author qianye.zheng
     */
    @XStreamAlias("Address")
    @Data
    @EqualsAndHashCode(callSuper=false)
    public static final class Address
    {
        private List<PrimaryAddress> primaryAddresses;
        
        private List<BillingAddress> billingAddresses;

        /**
         * 
         * PrimaryAddress
         * 描述: 首要地址
         * @author  qye.zheng
         * 
         */
        @XStreamAlias("PrimaryAddress")
        @Data
        @EqualsAndHashCode(callSuper=false)
        public static class PrimaryAddress {
            // 邮政编码
            //@XStreamConverter(value = CdataConvert.class)
            private String postalCode;
            // 地址行
            //@XStreamConverter(value = CdataConvert.class)
            private String addressLine;
        }
        
        /**
         * 
         * BillingAddress
         * 描述: 订单地址
         * @author  qye.zheng
         * 
         */
        @XStreamAlias("BillingAddress")
        @Data
        @EqualsAndHashCode(callSuper=false)
        public static class BillingAddress {
            // 接收人
            //@XStreamConverter(value = CdataConvert.class)
            private String receiver;
            // 邮政编码
            //@XStreamConverter(value = CdataConvert.class)
            private String postalCode;
            // 地址行
            @XStreamConverter(value = CdataConvert.class)
            private String addressLine;
        }
    }
}
