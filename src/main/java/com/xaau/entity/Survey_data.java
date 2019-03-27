package com.xaau.entity;


//保存系统所有的问卷中的问题的数据，实现调查问卷的问题管理
public class Survey_data {
    //问题id，确保问题的唯一
    private int questionID;
    //问题名称，最大长度为20
    private String question;
    //答案的类型，最大长度为10
    private String answerType;
    //对应的调查问卷ID
    private int surveyID;

    public int getQuestionID() {
        return questionID;
    }

    public void setQuestionID(int questionID) {
        this.questionID = questionID;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswerType() {
        return answerType;
    }

    public void setAnswerType(String answerType) {
        this.answerType = answerType;
    }

    public int getSurveyID() {
        return surveyID;
    }

    public void setSurveyID(int surveyID) {
        this.surveyID = surveyID;
    }
}
