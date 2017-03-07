package cn.jbit.serivce.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.jbit.dao.FaqsDao;
import cn.jbit.pojo.Faqs;
import cn.jbit.serivce.FaqsSerivce;

@Service("faqsSerivce")
public class FaqsSerivceImpl implements FaqsSerivce {
	@Autowired
	private FaqsDao faqsDao;
	
	public void setFaqsDao(FaqsDao faqsDao) {
		this.faqsDao = faqsDao;
	}

	@Override
	public void deleteById(Integer id) {
		faqsDao.deleteById(id);
	}

	@Override
	public void insert(Faqs faqs) {
		faqsDao.insert(faqs);
	}

	@Override
	public Faqs findById(Integer id) {
		return faqsDao.findById(id);
	}

	@Override
	public void update(Faqs faqs) {
		faqsDao.update(faqs);
	}

	@Override
	public List<Faqs> findAll(Map<String, Object> map) {
		return faqsDao.findAll(map);
	}

	@Override
	public Integer getCount(Faqs faqs) {
		return faqsDao.getCount(faqs);
	}

	@Override
	public List<Faqs> findByTitle(Map<String, Object> map) {
		return faqsDao.findByTitle(map);
	}

}
