package com.xaau.dao;

import com.xaau.entity.Backstage;
import com.xaau.entity.Survey_name;

import java.util.List;

public interface NaireDao {
    public void add(Survey_name survey_name);
    public void update(Survey_name survey_name);
    public void delete(int surveyID);
    public Survey_name findByName(String keyword);
    public Backstage findById(int surveyID);
    public List<Backstage> findAll();
}
