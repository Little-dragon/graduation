package com.xaau.action;

import com.xaau.entity.Backstage;
import com.xaau.service.NaireService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

@Component
public class ManageAction implements ServletRequestAware {

    @Resource
    private NaireService naireService;
    private HttpServletRequest request;
    private Backstage backstage;
    private HashMap<String , String> content;

    public String select(){
        backstage = naireService.findById(Integer.parseInt(request.getParameter("surveyID")));
        return "select";
    }

    public String delete(){
        naireService.delete(Integer.parseInt(request.getParameter("surveyID")));
        return "delete";
    }

    public String edit(){
        String surveyID = request.getParameter("surveyID");
        System.out.println(surveyID);
        if(surveyID != null)
            backstage = naireService.findById(Integer.parseInt(request.getParameter("surveyID")));
        return "edit";
    }

    public String add(){
        return "add";
    }

    public String resolve(){
        JSONArray jsonArray = JSONArray.fromObject(content);
        JSONObject job = jsonArray.getJSONObject(0);
        String result = job.entrySet().toString();
        naireService.add(result.substring(1, result.length() - 1));
        return "resolve";
    }

    public HashMap<String, String> getContent() {
        return content;
    }

    public void setContent(HashMap<String, String> content) {
        this.content = content;
    }

    @Override
    public void setServletRequest(HttpServletRequest request) {
        this.request = request;
    }

    public Backstage getBackstage() {
        return backstage;
    }

    public void setBackstage(Backstage backstage) {
        this.backstage = backstage;
    }
}
