package com.xaau.entity;

//保存系统所有的调查问卷名称数据，实现调查问卷的管理
public class Survey_name {

    //问卷ID
    private int surveyID;
    //问卷名称
    private String title;
    //问卷创建时间
    private String create_time;
    //问卷对应图片的名称
    private String image_name;

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

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public String getImage_name() {
        return image_name;
    }

    public void setImage_name(String image_name) {
        this.image_name = image_name;
    }
}