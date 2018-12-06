package club.luke.cloud.shop.app.web.vo.system;

import club.luke.cloud.shop.app.util.V;
import club.luke.cloud.shop.app.web.vo.VOIn;

public class VOInKindSetup extends VOIn {
    Long id ;
    String name ;
    String msg ;
    V.HtmlType htmlType ;
    String defVal ;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public V.HtmlType getHtmlType() {
        return htmlType;
    }

    public void setHtmlType(V.HtmlType htmlType) {
        this.htmlType = htmlType;
    }

    public String getDefVal() {
        return defVal;
    }

    public void setDefVal(String defVal) {
        this.defVal = defVal;
    }
}
