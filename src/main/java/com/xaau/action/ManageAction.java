package com.xaau.action;

import com.xaau.entity.Backstage;
import com.xaau.service.NaireService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class ManageAction implements ServletRequestAware {

    @Resource
    private NaireService naireService;

    private HttpServletRequest request;
    private Backstage backstage;
    private List<Backstage> backstages;
    private String content;

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

    public String resolve() throws IOException {
        String mpsStr = getRequestPostData(request);
        System.out.println(mpsStr);
        JSONObject mpsObject = JSONObject.fromObject(mpsStr);
        // 通过key获取value
        String jsonString = mpsObject.getString("content");
        System.out.println(jsonString);
        JSONArray contentArray = JSONArray.fromObject(content);
//        List<String> list = (List<String>) JSONArray.toCollection(contentArray);
//        for (int i = 0;i < list.size();i++){
//            System.out.println(list.get(i));
//        }
        return "resolve";
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
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

    public List<Backstage> getBackstages() {
        return backstages;
    }

    public void setBackstages(List<Backstage> backstages) {
        this.backstages = backstages;
    }

    private String getRequestPostData(HttpServletRequest request) throws IOException {
        int contentLength = request.getContentLength();
        if(contentLength<0){
            return null;
        }
        byte buffer[] = new byte[contentLength];
        for (int i = 0; i < contentLength;) {
            int len = request.getInputStream().read(buffer, i, contentLength - i);
            if (len == -1) {
                break;
            }
            i += len;
        }
        return new String(buffer, "utf-8");
    }

}
