//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.7 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2014.07.23 时间 02:48:58 PM CST 
//


package com.hua.jaxb;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>anonymous complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="customer" type="{}customerType" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "customer"
})
@XmlRootElement(name = "customers")
public class Customers {

    @XmlElement(required = true)
    protected List<CustomerType> customer;

    /**
     * Gets the value of the customer property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the customer property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCustomer().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CustomerType }
     * 
     * 
     */
    public List<CustomerType> getCustomer() {
        if (customer == null) {
            customer = new ArrayList<CustomerType>();
        }
        return this.customer;
    }

}
