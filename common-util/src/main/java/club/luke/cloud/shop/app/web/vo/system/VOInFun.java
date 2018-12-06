package club.luke.cloud.shop.app.web.vo.system;

import club.luke.cloud.shop.app.web.vo.VOIn;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by luke on 2018/11/15.
 */
public class VOInFun extends VOIn {

    @ApiModelProperty(name = "分组")
    String c_group ;
    @ApiModelProperty(name = "父ID")
    Long fid ;
    @ApiModelProperty(name = "页面模板")
    String htmlPath ;
    @ApiModelProperty(name = "功能图标")
    String iconPath ;
    @ApiModelProperty(name = "功能ID")
    Long id ;
    @ApiModelProperty(name = "名称")
    String name ;
    @ApiModelProperty(name = "视频路径")
    String studyPath ;
    @ApiModelProperty(name = "js入口文件")
    String viewPath ;

    public String getC_group() {
        return c_group;
    }

    public void setC_group(String c_group) {
        this.c_group = c_group;
    }

    public Long getFid() {
        return fid;
    }

    public void setFid(Long fid) {
        this.fid = fid;
    }

    public String getHtmlPath() {
        return htmlPath;
    }

    public void setHtmlPath(String htmlPath) {
        this.htmlPath = htmlPath;
    }

    public String getIconPath() {
        return iconPath;
    }

    public void setIconPath(String iconPath) {
        this.iconPath = iconPath;
    }

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

    public String getStudyPath() {
        return studyPath;
    }

    public void setStudyPath(String studyPath) {
        this.studyPath = studyPath;
    }

    public String getViewPath() {
        return viewPath;
    }

    public void setViewPath(String viewPath) {
        this.viewPath = viewPath;
    }
}
