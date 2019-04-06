package com.xaau.service.impl;

import com.xaau.dao.NaireDao;
import com.xaau.entity.Backstage;
import com.xaau.entity.Survey_name;
import com.xaau.service.NaireService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component("naireService")
public class NaireServiceImpl implements NaireService {

    @Resource
    private NaireDao naireDao;

    @Override
    public void add(String survey) {
        naireDao.add(survey);
    }

    @Override
    public void update(Survey_name survey_name) {

    }

    @Override
    public void delete(int surveyID) {

    }

    @Override
    public Survey_name findByName(String keyword) {
        return null;
    }

    @Override
    public Backstage findById(int survey_id) {
        return naireDao.findById(survey_id);
    }

    @Override
    public List<Backstage> findAll() {
        return naireDao.findAll();
    }

}
