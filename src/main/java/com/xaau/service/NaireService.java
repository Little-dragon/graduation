package com.xaau.service;

import com.xaau.entity.Backstage;
import com.xaau.entity.Survey_name;
import java.util.List;

public interface NaireService {
    public void add(String survey);
    public void update(Survey_name survey_name);
    public void delete(int surveyID);
    public Survey_name findByName(String keyword);
    public Backstage findById(int surveyID);
    public List<Backstage> findAll();
}
