//
// ���ļ����� JavaTM Architecture for XML Binding (JAXB) ����ʵ�� v2.2.7 ���ɵ�
// ����� <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �����±���Դģʽʱ, �Դ��ļ��������޸Ķ�����ʧ��
// ����ʱ��: 2014.07.23 ʱ�� 02:48:58 PM CST 
//


package com.hua.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>addressType complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
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
     * ��ȡprimaryAddress���Ե�ֵ��
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
     * ����primaryAddress���Ե�ֵ��
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
     * ��ȡbillingAddress���Ե�ֵ��
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
     * ����billingAddress���Ե�ֵ��
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
