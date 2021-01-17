/**
 * 描述: 
 * ConvertTest.java
 * 
 * @author qye.zheng
 *  version 1.0
 */
package com.hua.test.xml;

//静态导入
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.Assumptions.assumeFalse;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assumptions.assumingThat;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import com.hua.entity.ConvertEntity;
import com.hua.test.BaseTest;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.HierarchicalStreamDriver;
import com.thoughtworks.xstream.io.naming.NoNameCoder;
import com.thoughtworks.xstream.io.xml.StaxDriver;


/**
 * 描述: 
 * 
 * @author qye.zheng
 * ConvertTest
 */
//@DisplayName("测试类名称")
//@Tag("测试类标签")
//@Tags({@Tag("测试类标签1"), @Tag("测试类标签2")})
public final class ConvertTest extends BaseTest {

	
    /**
     * 
     * 描述: 
     * @author qye.zheng
     * 
     */
    //@DisplayName("test")
    @Test
    public void testConvert() {
        try {
            ConvertEntity entity = new ConvertEntity();
            entity.setFirstname("guanghua");
            entity.setLastname("li");
            entity.setGender("male");
            entity.setPhoneNumber("021-564697654");
            //entity.setXmlns("dddddddd");
            
            entity.setDate(LocalDate.now());
            entity.setDateTime(LocalDateTime.now());
            entity.setNumber(123);
            // 空值不输出
            entity.setFlag(Boolean.TRUE);
            
            ConvertEntity.Address address = new ConvertEntity.Address();
            List<ConvertEntity.Address.PrimaryAddress> primaryAddresses = new ArrayList<>();
            List<ConvertEntity.Address.BillingAddress> billingAddresses = new ArrayList<>();
            ConvertEntity.Address.PrimaryAddress pa = new ConvertEntity.Address.PrimaryAddress();
            pa.setPostalCode("524211");
            pa.setAddressLine("广东省广州市天河区平云路526号");
            primaryAddresses.add(pa);
            ConvertEntity.Address.BillingAddress ba = new ConvertEntity.Address.BillingAddress();
            ba.setReceiver("王某人");
            ba.setPostalCode("5679851");
            ba.setAddressLine("广东省广州市天河区开泰路158号");
            billingAddresses.add(ba);
            address.setBillingAddresses(billingAddresses);
            address.setPrimaryAddresses(primaryAddresses);
            
            entity.setAddress(address);
            
            /*
             * 无参方式: @XStreamAlias 或字段名有下划线时，
             * 输出xml多了一个下划线
             * 解决方式: 
             */
            //XStream xstream = new XStream();
            // 解决多一个下划线的问题
            // 对名称不进行编码
            //final HierarchicalStreamDriver driver = new Xpp3Driver(new NoNameCoder());
            final StaxDriver driver = new StaxDriver(new NoNameCoder());
            // 对特殊字符不转义，输出没有格式，为简单模式 (在正式场合上使用)
            driver.getOutputFactory().setProperty("escapeCharacters", false);
            final XStream xstream = new XStream(driver);
            xstream.autodetectAnnotations(true);
            
            /**
             * 结果显示类似
             <com.hua.entity.xml.Customer>
                <id>5646761321324132</id>
            根节点使用了类的全限定名，可以使用别名来解决
            
             */
            
            // 解决 对象节点使用类全限定名或者使用 @XStreamAlias 标注class
            //xstream.alias("convertEntity", ConvertEntity.class);
            //xstream.alias("primaryAddress", PrimaryAddress.class);
            //xstream.alias("billingAddress", BillingAddress.class);
            
            // 输出为字符串
            resultXml = xstream.toXML(entity);
            assertNotNull(resultXml);
            
            System.out.println(resultXml);
            
        } catch (Exception e) {
            log.error("test =====> ", e);
        }
    }
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	//@DisplayName("test")
	@Test
	public void test() {
		try {
			
			
		} catch (Exception e) {
			log.error("test =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@DisplayName("testTemp")
	@Test
	public void testTemp() {
		try {
		    System.out.println(String.class.isPrimitive());
		} catch (Exception e) {
			log.error("testTemp=====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@DisplayName("testCommon")
	@Test
	public void testCommon() {
		try {
			
			
		} catch (Exception e) {
			log.error("testCommon =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@DisplayName("testSimple")
	@Test
	public void testSimple() {
		try {
			
			
		} catch (Exception e) {
			log.error("testSimple =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@DisplayName("testBase")
	@Test
	public void testBase() {
		try {
			
			
		} catch (Exception e) {
			log.error("testBase =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: [每个测试-方法]开始之前运行
	 * @author qye.zheng
	 * 
	 */
	@DisplayName("beforeMethod")
	@Tag(" [每个测试-方法]结束之后运行")
	@BeforeEach
	public void beforeMethod() {
		System.out.println("beforeMethod()");
	}
	
	/**
	 * 
	 * 描述: [每个测试-方法]结束之后运行
	 * @author qye.zheng
	 * 
	 */
	@DisplayName("afterMethod")
	@Tag(" [每个测试-方法]结束之后运行")
	@AfterEach
	public void afterMethod() {
		System.out.println("afterMethod()");
	}
	
	/**
	 * 
	 * 描述: 测试忽略的方法
	 * @author qye.zheng
	 * 
	 */
	@Disabled
	@DisplayName("ignoreMethod")
	@Test
	public void ignoreMethod() {
		System.out.println("ignoreMethod()");
	}
	
	/**
	 * 
	 * 描述: 解决ide静态导入消除问题 
	 * @author qye.zheng
	 * 
	 */
	@DisplayName("noUse")
	@Disabled("解决ide静态导入消除问题 ")
	private void noUse() {
		String expected = null;
		String actual = null;
		Object[] expecteds = null;
		Object[] actuals = null;
		String message = null;
		
		assertEquals(expected, actual);
		assertEquals(message, expected, actual);
		assertNotEquals(expected, actual);
		assertNotEquals(message, expected, actual);
		
		assertArrayEquals(expecteds, actuals);
		assertArrayEquals(expecteds, actuals, message);
		
		assertFalse(true);
		assertTrue(true);
		assertFalse(true, message);
		assertTrue(true, message);
		
		assertSame(expecteds, actuals);
		assertNotSame(expecteds, actuals);
		assertSame(expecteds, actuals, message);
		assertNotSame(expecteds, actuals, message);
		
		assertNull(actuals);
		assertNotNull(actuals);
		assertNull(actuals, message);
		assertNotNull(actuals, message);
		
		fail();
		fail("Not yet implemented");
		
		dynamicTest(null, null);
		
		assumeFalse(false);
		assumeTrue(true);
		assumingThat(true, null);
	}

}
