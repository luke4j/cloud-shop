package club.luke.cloud.shop.app.web;


import club.luke.cloud.shop.app.util.tool.LKMap;

/**
 * Created by luke on 2018/10/31.
 */
public class SessionUser {

    public static final String SessionUser = "SessionUser" ;

    /**用户标志，可以是数据库id，也可以是其它*/
    
    private String tuken ;
    /**用户是否有效*/
    
    private Boolean you_xiao = true ;
    /**用户是否过期*/
    
    private Boolean guo_qi = false ;

    /**用户登录名*/
    private String loginName ;

    private LKMap<String,Object> userInfo = new LKMap<String,Object>() ;


    public String getTuken() {
        return tuken;
    }

    public void setTuken(String tuken) {
        this.tuken = tuken;
    }

    public Boolean getYou_xiao() {
        return you_xiao;
    }

    public void setYou_xiao(Boolean you_xiao) {
        this.you_xiao = you_xiao;
    }

    public Boolean getGuo_qi() {
        return guo_qi;
    }

    public void setGuo_qi(Boolean guo_qi) {
        this.guo_qi = guo_qi;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public LKMap<String, Object> getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(LKMap<String, Object> userInfo) {
        this.userInfo = userInfo;
    }
}
