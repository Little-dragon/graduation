package com.xaau.dao.impl;

import com.xaau.dao.NaireDao;
import com.xaau.entity.Backstage;
import com.xaau.entity.Survey_name;
import org.hibernate.*;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@Component("naireDao")
public class NaireDaoImpl implements NaireDao {

    @Autowired
    private SessionFactory sessionFactory;

    public Session getSession() {
        return sessionFactory.openSession();
    }

    @Override
    public void add(String survey) {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            Transaction tx = session.beginTransaction();
            String answerType = "";
            String question_name = "";
            String survey_name = "";
            Date date = new Date();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");

            int surveyID = 0;
            String sql = "";
            String[] list = survey.split(",");
            Query query;
            int questionID = 0;
            for(int i = 0;i < list.length - 1;i++){
                if(i == 0){
                    survey_name = list[list.length - 1].split(",")[1];
                    //survey_name
                    sql = "Insert into Survey_name(title, create_time, image_name) values(? , ? , '3ac79f3df8dcd1001531c4cc798b4710b8122fa9.jpg')";
                    query = session.createSQLQuery(sql);
                    query.setParameter(0 , survey_name);
                    query.setParameter(1 , simpleDateFormat.format(date));
                    query.executeUpdate();
                    tx.commit();

                    tx = session.beginTransaction();
                    //surveyID
                    sql = "select max(surveyID) from Survey_name";
                    query = session.createSQLQuery(sql);
                    surveyID = Integer.parseInt(query.uniqueResult().toString());
                    tx.commit();
                }

                tx = session.beginTransaction();
                //questionID
                sql = "select max(questionID) from Survey_data";
                query = session.createQuery(sql);
                questionID = Integer.parseInt(query.uniqueResult().toString()) + 1;
                tx.commit();

                tx = session.beginTransaction();
                sql = "insert into Survey_data(questionID , question , answerType , surveyID) values(?,?,?,?)";
                answerType = list[i].trim().substring(0,1);
                String[] temp = list[i].trim().split("=");
                question_name = temp[0].substring(1 , temp[0].length());
                query = session.createSQLQuery(sql);
                query.setParameter(0 , questionID);
                query.setParameter(1 , question_name);
                query.setParameter(2 , answerType);
                query.setParameter(3 , surveyID);
                query.executeUpdate();
                tx.commit();

                String[] answers = temp[1].split("\\*#");
                for(int j = 0;j < answers.length;j++){
                    tx = session.beginTransaction();
                    sql = "insert into Survey_answer(questionID , choiceText , poll) values(?,?,0)";
                    query = session.createSQLQuery(sql);
                    query.setParameter(0 , questionID);
                    query.setParameter(1 , answers[j]);
                    query.executeUpdate();
                    tx.commit();
                }
            }
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
        try {
            session = getSession();
            Transaction tx = session.beginTransaction();
            String sql = "select Survey_name.title , Survey_name.description , Survey_name.create_time from Survey_name WHERE Survey_name.surveyID = ?";
            Query query = session.createSQLQuery(sql);
            query.setResultTransformer(Transformers.aliasToBean(Backstage.class));
            query.setParameter(0 , surveyID);
            backstage = (Backstage)query.uniqueResult();
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
            String sql = "select a.surveyID , a.title , a.create_time , a.image_name from Survey_name a LEFT JOIN Survey_data b ON a.surveyID = b.surveyID ";
            Query query = session.createSQLQuery(sql);
            query.setResultTransformer(Transformers.aliasToBean(Backstage.class));
            backstages = query.list();
            for(int i = 0;i < backstages.size();i++){
                sql = "select sum(poll) as member_nums from Survey_answer a LEFT JOIN Survey_data b ON a.questionID = b.questionID where b.surveyID = " + backstages.get(i).getSurveyID();
                query = session.createSQLQuery(sql);
                backstages.get(i).setMember_nums(Integer.parseInt(query.uniqueResult().toString()));
            }
            tx.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        }finally {
            session.close();
        }
        return backstages;
    }
}
