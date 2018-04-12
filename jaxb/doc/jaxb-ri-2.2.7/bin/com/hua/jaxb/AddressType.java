//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.7 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2014.07.23 时间 02:48:58 PM CST 
//


package com.hua.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>addressType complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="addressType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="primaryAddress" type="{}primaryAddressType"/>
 *         &lt;element name="billingAddress" type="{}billingAddressType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "addressType", propOrder = {
    "primaryAddress",
    "billingAddress"
})
public class AddressType {

    @XmlElement(required = true)
    protected PrimaryAddressType primaryAddress;
    @XmlElement(required = true)
    protected BillingAddressType billingAddress;

    /**
     * 获取primaryAddress属性的值。
     * 
     * @return
     *     possible object is
     *     {@link PrimaryAddressType }
     *     
     */
    public PrimaryAddressType getPrimaryAddress() {
        return primaryAddress;
    }

    /**
     * 设置primaryAddress属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link PrimaryAddressType }
     *     
     */
    public void setPrimaryAddress(PrimaryAddressType value) {
        this.primaryAddress = value;
    }

    /**
     * 获取billingAddress属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BillingAddressType }
     *     
     */
    public BillingAddressType getBillingAddress() {
        return billingAddress;
    }

    /**
     * 设置billingAddress属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BillingAddressType }
     *     
     */
    public void setBillingAddress(BillingAddressType value) {
        this.billingAddress = value;
    }

}
