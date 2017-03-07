package cn.jbit.serivce;

import java.util.List;
import java.util.Map;

import cn.jbit.pojo.Faqs;

public interface FaqsSerivce {
    void deleteById(Integer id);

    void insert(Faqs faqs);

    Faqs findById(Integer id);

    void update(Faqs faqs);

    List<Faqs> findAll(Map<String, Object> map);
    
    Integer getCount(Faqs faqs);
    
    List<Faqs> findByTitle(Map<String, Object> map);
}
