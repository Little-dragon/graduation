package com.xaau.action;

import com.xaau.entity.Backstage;
import com.xaau.service.NaireService;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Component
public class ManageAction implements ServletRequestAware {

    @Resource
    private NaireService naireService;

    private HttpServletRequest request;
    private Backstage backstage;
    private List<Backstage> backstages;

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

    public List<Backstage> getBackstages() {
        return backstages;
    }

    public void setBackstages(List<Backstage> backstages) {
        this.backstages = backstages;
    }
}
