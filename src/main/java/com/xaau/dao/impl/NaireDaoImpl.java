package com.xaau.dao.impl;

import com.xaau.dao.NaireDao;
import com.xaau.entity.Backstage;
import com.xaau.entity.Survey_name;
import org.hibernate.*;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component("naireDao")
public class NaireDaoImpl implements NaireDao {

    @Autowired
    private SessionFactory sessionFactory;

    public Session getSession() {
        return sessionFactory.openSession();
    }

    @Override
    public void add(Survey_name survey_name) {
        Session session = null;
        try {
            session = getSession();
            Transaction tx = session.beginTransaction();
            session.save(survey_name);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            session.close();
        }
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
    public Backstage findById(int surveyID) {
        Session session=null;
        Backstage backstage = null;
        Survey_name survey_name = null;
        try {
            session = getSession();
            Transaction tx = session.beginTransaction();
            String sql = "select DISTINCT(Survey_name.title) , Survey_name.description , Survey_name.create_time from Survey_name ,Survey_answer WHERE Survey_name.surveyID = ?";
            Query query = session.createSQLQuery(sql);
            query.setResultTransformer(Transformers.aliasToBean(Backstage.class));
            query.setParameter(0 , surveyID);
            backstage = (Backstage)query.uniqueResult();
            sql = "select sum(poll) as member_nums from Survey_answer a LEFT JOIN Survey_data b ON a.questionID = b.questionID ";
            query = session.createSQLQuery(sql);
            backstage.setMember_nums(Integer.parseInt(query.uniqueResult().toString()));
            tx.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        }finally{
            session.close();
        }
        return backstage;
    }

    @Override
    public List<Backstage> findAll() {
        Session session = null;
        List<Backstage> backstages = null;
        Backstage backstage = null;
        try {
            session = getSession();
            Transaction tx = session.beginTransaction();
            String sql = "select a.surveyID , a.title , a.description , a.create_time from Survey_name a LEFT JOIN Survey_data b ON a.surveyID = b.surveyID ";
            Query query = session.createSQLQuery(sql);
            query.setResultTransformer(Transformers.aliasToBean(Backstage.class));
            backstages = query.list();
            System.out.println(backstages.get(0).getSurveyID());
            tx.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        }finally {
            session.close();
        }
        return backstages;
    }
}