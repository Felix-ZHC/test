package cn.jbit.dao;

import cn.jbit.pojo.Faqs;
import java.util.List;
import java.util.Map;

public interface FaqsDao {
    void deleteById(Integer id);

    void insert(Faqs faqs);

    Faqs findById(Integer id);

    void update(Faqs faqs);

    List<Faqs> findAll(Map<String, Object> map);
    
    Integer getCount(Faqs faqs);
    
    List<Faqs> findByTitle(Map<String, Object> map);
}