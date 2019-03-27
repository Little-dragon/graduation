package com.xaau.entity;

//保存系统所有的调查问卷名称数据，实现调查问卷的管理
public class Survey_name {

    //问卷ID
    private int surveyID;
    //问卷名称
    private String title;
    //问卷简单描述
    private String description;
    //问卷创建时间
    private String create_time;

    public int getSurveyID() {
        return surveyID;
    }

    public void setSurveyID(int surveyID) {
        this.surveyID = surveyID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }
}