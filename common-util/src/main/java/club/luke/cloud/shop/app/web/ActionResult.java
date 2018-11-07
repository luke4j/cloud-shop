package club.luke.cloud.shop.app.web;


import club.luke.cloud.shop.app.util.tool.Assertion;
import club.luke.cloud.shop.app.util.tool.LK;
import club.luke.cloud.shop.app.util.tool.LKMap;
import org.json.JSONObject;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

/**
 * Created by luke on 2018/10/31.
 */
public class ActionResult {
    HttpServletRequest request ;
    HttpServletResponse response ;
    Boolean success ;
    String doing ;
   
    Object data ;
   
    LKMap<String,Object> map = new LKMap<String,Object>() ;

    String errInfo ;



    public ActionResult init( HttpServletRequest request , HttpServletResponse response ){
        this.request = request ;
        this.response = response ;
        if(this.request==null||this.response==null)
            Assertion.Error("ActionResult:request and response must not null");
        SessionUser sessionUser = (SessionUser)request.getSession().getAttribute(SessionUser.SessionUser) ;
        this.map.put1(SessionUser.SessionUser,sessionUser)
                .put1("url", request.getRequestURL().toString());
        this.map.put1("doStartTime", LK.DateToStr(new Date(), "yyyy-MM-dd:HH:mm:ss SSS")) ;

        return this ;
    }
    public ActionResult OK(String doing , Object data,LKMap<String,Object> map ){
        this.doing = doing ;
        this.data = data ;
        this.map.put1("doEndTime",LK.DateToStr(new Date(),"yyyy-MM-dd HH:mm:ss SSS")) ;
        if(map!=null){
            this.map.put2(map) ;
        }
        this.success = true ;
        return this ;
    }
    public ActionResult OK(String doing ,Object data ){
        return this.OK(doing,data,null) ;
    }
    public ActionResult Fial(Throwable e,String errInfo){
        if(LK.StrIsNotEmpty(errInfo)){
            this.errInfo = errInfo ;
        }else if(e!=null&&LK.StrIsNotEmpty(e.getMessage())){
            this.errInfo = e.getMessage() ;
        }else{
            this.errInfo = "出现异常" ;
        }
        this.doing = request.getRequestURL().toString() ;
        this.success = false ;
        this.map.put1("StackTrace",e) ;
        return this ;
    }

    public ActionResult Fial(Throwable e){
        return this.Fial(e,null) ;
    }
    public ActionResult Fial(String errInfo){
        return this.Fial(null,errInfo) ;
    }

    public void write(){
        JSONObject jsonObject = new JSONObject(this);
        this.response.setCharacterEncoding("UTF-8");
        this.response.setContentType("application/Json");
        try {
            PrintWriter pw = response.getWriter();
            pw.print(jsonObject.toString());
            pw.flush();
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public Boolean getSuccess() {
        return success;
    }

    public String getDoing() {
        return doing;
    }

    public Object getData() {
        return data;
    }

    public String getErrInfo() {
        return errInfo;
    }

    public LKMap<String, Object> getMap() {
        return map;
    }
}
