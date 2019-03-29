package com.xaau.entity;


//给后台传递数值的对象
public class Backstage {
    private int surveyID;
    private int member_nums;
    private String title;
    private String description;
    private String create_time;
    private String image_name;

    public String getImage_name() {
        return image_name;
    }

    public void setImage_name(String image_name) {
        this.image_name = image_name;
    }
    public int getMember_nums() {
        return member_nums;
    }

    public void setMember_nums(int member_nums) {
        this.member_nums = member_nums;
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

    public int getSurveyID() {
        return surveyID;
    }

    public void setSurveyID(int surveyID) {
        this.surveyID = surveyID;
    }

    @Override
    public String toString() {
        return "Backstage{" +
                "surveyID=" + surveyID +
                ", member_nums=" + member_nums +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", create_time='" + create_time + '\'' +
                '}';
    }
}
