package cn.jbit.serivce.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.jbit.dao.ClassesDao;
import cn.jbit.pojo.Classes;
import cn.jbit.serivce.ClassesSerivce;

@Service("classesSerivce")
public class ClassesSerivceImpl implements ClassesSerivce {
	@Autowired
	private ClassesDao classesDao;

	public void setClassesDao(ClassesDao classesDao) {
		this.classesDao = classesDao;
	}

	@Override
	public List<Classes> findAll() {
		return classesDao.findAll();
	}

}
