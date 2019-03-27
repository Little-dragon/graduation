package com.xaau.entity;

public class Survey_answer {
    //选项ID
    private int answerID;
    //对于的问题ID
    private int questionID;
    //选项的字符串，总长度为40
    private String choiceText;
    //选项的得票数量
    private int poll;

    public int getAnswerID() {
        return answerID;
    }

    public void setAnswerID(int answerID) {
        this.answerID = answerID;
    }

    public int getQuestionID() {
        return questionID;
    }

    public void setQuestionID(int questionID) {
        this.questionID = questionID;
    }

    public String getChoiceText() {
        return choiceText;
    }

    public void setChoiceText(String choiceText) {
        this.choiceText = choiceText;
    }

    public int getPoll() {
        return poll;
    }

    public void setPoll(int poll) {
        this.poll = poll;
    }
}
