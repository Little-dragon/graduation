package com.xaau.test;

import com.xaau.entity.Backstage;
import com.xaau.entity.Survey_data;
import com.xaau.entity.Survey_name;
import org.hibernate.*;
import org.hibernate.transform.Transformers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.SimpleDateFormat;
import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class MyTest {
    @Autowired
    private SessionFactory sessionFactory;

    @Test
    public void My(){
        Session session = null;
        try {
            session = sessionFactory.openSession();
            Transaction tx = session.beginTransaction();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYYMMdd");
            Survey_name survey_name = new Survey_name();
            survey_name.setTitle("汽车使用情况调查");
            survey_name.setCreate_time(simpleDateFormat.format(new Date()));
            session.save(survey_name);
            tx.commit();
//            Survey_data survey_data = new Survey_data();
//            survey_data.setSurveyID(5);
//            survey_data.setQuestionID(1);
//            survey_data.setQuestion("你喜欢学英语吗？");
//            survey_data.setAnswerType("S");
//			  session.save(survey_data);
//            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(session != null)
                session.close();
        }
    }

    @Test
    public void My1(){
        Session session = null;
        try {
            String survey = "cab=b*#b*#, ca=b*#b*#b*#b*#";
            session = sessionFactory.openSession();
            Transaction tx = session.beginTransaction();
            String answerType = "";
            String question_name = "你好吗";
            Date date = new Date();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");

            //survey_name
            String sql = "Insert into Survey_name(title, create_time, image_name) values(? , ? , '3ac79f3df8dcd1001531c4cc798b4710b8122fa9.jpg')";
            Query query = session.createSQLQuery(sql);
            query.setParameter(0 , question_name);
            query.setParameter(1 , simpleDateFormat.format(date));
            query.executeUpdate();
            tx.commit();

            tx = session.beginTransaction();
            //surveyID
            sql = "select max(surveyID) from Survey_name";
            query = session.createSQLQuery(sql);
            int surveyID = Integer.parseInt(query.uniqueResult().toString());
            int questionID = 0;
            tx.commit();

            String[] list = survey.split(",");
            for(int i = 0;i < list.length;i++){
                tx = session.beginTransaction();
                //questionID
                sql = "select max(questionID) from Survey_data";
                query = session.createQuery(sql);
                questionID = Integer.parseInt(query.uniqueResult().toString()) + 1;

                sql = "insert into Survey_data(questionID , question , answerType , surveyID) values(?,?,?,?)";
                answerType = list[i].trim().substring(0,1);
                String[] temp = list[0].trim().split("=");
                question_name = temp[0].substring(1 , temp[0].length());
                query = session.createSQLQuery(sql);
                query.setParameter(0 , questionID);
                query.setParameter(1 , question_name);
                query.setParameter(2 , answerType);
                query.setParameter(3 , surveyID);
                query.executeUpdate();
                tx.commit();
                System.out.println(temp[1]);
                String[] answers = temp[1].split("\\*#");
                for(int j = 0;j < answers.length;j++){
                    tx = session.beginTransaction();
                    sql = "insert into Survey_answer(questionID , choiceText , poll) values(?,?,0)";
                    answerType = list[i].trim().substring(0,1);

                    query = session.createSQLQuery(sql);
                    query.setParameter(0 , questionID);
                    System.out.println(answers[j]);
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
}
