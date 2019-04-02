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
            survey_name.setDescription("第二篇问卷调查");
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
        String a = "abc";
        a = "efg";
        System.out.println("efg" == "abc");
//        Session session=null;
//        Backstage backstage = null;
//        Survey_name survey_name = null;
//        try {
//            session = sessionFactory.openSession();
//            Transaction tx = session.beginTransaction();
//            String sql = "select DISTINCT(Survey_name.title) , Survey_name.description , Survey_name.create_time from Survey_name ,Survey_answer WHERE Survey_name.surveyID = ?";
//            Query query = session.createSQLQuery(sql);
//            query.setResultTransformer(Transformers.aliasToBean(Backstage.class));
//            query.setParameter(0 , 5);
//            backstage = (Backstage)query.uniqueResult();
//            sql = "select sum(poll) as member_nums from Survey_answer a LEFT JOIN Survey_data b ON a.questionID = b.questionID ";
//            query = session.createSQLQuery(sql);
//            backstage.setMember_nums(Integer.parseInt(query.uniqueResult().toString()));
//            System.out.println(backstage);
//            tx.commit();
//        } catch (HibernateException e) {
//            e.printStackTrace();
//        }finally{
//            session.close();
//        }
    }
}
