package com.xaau.action;

import com.xaau.entity.Backstage;
import com.xaau.service.NaireService;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Component
public class IndexAction implements ServletRequestAware {

    @Resource
    private NaireService naireService;

    private HttpServletRequest request;
    private Backstage backstage;
    private List<Backstage> backstages;

    public String index(){
        return "index";
    }

    public String manage(){
        backstages = naireService.findAll();
        return "manage";
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

    @Override
    public void setServletRequest(HttpServletRequest request) {
        this.request = request;
    }
}
