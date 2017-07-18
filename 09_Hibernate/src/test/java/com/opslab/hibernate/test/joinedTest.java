package com.opslab.hibernate.test;



import com.opslab.hibernate.entity.extend.joined.computer;
import com.opslab.hibernate.entity.extend.joined.goods;
import com.opslab.hibernate.entity.extend.joined.mobilePhone;
import org.junit.Test;

/**
 *@description 测试joined映射
 */
public class joinedTest extends SuperTest{

	@Test
	public void testJoinedSave(){
		goods goods1 = new goods();
		goods1.setGoodsName("衣服");
		goods1.setGoodsFunction("用来穿的，不让你曝光");
		
		computer con = new computer();
		con.setGoodsName("电脑");
		con.setGoodsFunction("学习/赚钱/娱乐");
		con.setCpu("intel");
		con.setGpu("影驰");
		con.setMemory("海盗船");
		con.setMainboard("华硕");
		
		mobilePhone iphone = new mobilePhone();
		iphone.setGoodsName("手机");
		iphone.setGoodsFunction("交流/娱乐");
		iphone.setCpu("三星");
		iphone.setMemory("三星");
		iphone.setNetworkChip("三星3G/4G");
		
		session.save(goods1);
		session.save(con);
		session.save(iphone);
	}
}
