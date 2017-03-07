package cn.jbit.t19.test;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.jbit.dao.FaqsDao;
import cn.jbit.pojo.Classes;
import cn.jbit.pojo.Faqs;

public class test {
	private ApplicationContext context=null;
	private FaqsDao faqsDao=null;
	
	@Before
	public void setUp() throws Exception {
		context=new ClassPathXmlApplicationContext("applicationContext.xml");
		faqsDao=(FaqsDao) context.getBean("faqsDao");
	}

	@After
	public void tearDown() throws Exception {
		context=null;
		faqsDao=null;
	}

	@Test
	public void test() {
	}
	
	@Test
	public void findAll() {
		Map<String, Object> map=new HashMap<String,Object>();
		map.put("startRow", 0);
		map.put("endRow", 2);
		List<Faqs> list=faqsDao.findAll(map);
		System.out.println(list.size());
	}

	@Test
	public void insert() {
		Faqs faqs=new Faqs();
		faqs.setCreatedate(new Date());
		faqs.setContent("222");
		faqs.setTitle("java不报错");
		Classes classes=new Classes();
		classes.setId(2);
		faqs.setClasses(classes);
		faqsDao.insert(faqs);
	}

	@Test
	public void getCount() {
		System.out.println(faqsDao.getCount(null));
	}
	
	@Test
	public void update() {
		Faqs faqs=new Faqs();
		faqs.setId(2);
		faqs.setTitle("VS2016安装");
		faqsDao.update(faqs);
	}
	
	@Test
	public void init() {
		System.out.println(faqsDao.findById(2).getTitle());
		System.out.println(faqsDao.findById(2).getClassid());
	}
}
