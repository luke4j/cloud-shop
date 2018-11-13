package club.luke.cloud.shop.app.util;

/**
 * Created by luke on 2018/11/13.
 */
public class V {

    /**性别*/
    public enum SexType{
        男,
        女
    }

    /**库存级别*/
    public enum KcJbType{
        现库,
        零订,
        车房
    }

    public enum EyeType{
        /**右眼*/
        od,
        /**左眼*/
        os
    }
    /**使用类型*/
    public enum UseType{
        近用,
        远用
    }

    /**验光类型*/
    public enum YGType{
        电脑验光,
        检影验光,
        精调验光,
        处方,
        销售单使用
    }

    /**销售单组类型*/
    public enum GroupType{
        加工,
        成品,
        效期,
        服务
    }
    /**流程类型*/
    public enum  Streamtype{
        成品,
        定制,
        加工,
        定制加工
    }

    /**销售类型*/
    public enum MessageType{
        个人,
        站点,
        角色,
        公司,
        系统
    }

    /**站点类型*/
    public enum ComKind{
        总公司,
        分公司,
        站点
    }

    /**页面元素*/
    public enum HtmlType{
        input,
        select
    }

    /**付款方式*/
    public enum PayType{
        现金,
        银行卡,
        支付宝,
        微信,
        支票,
        转帐,
        代金券,
        欠条
    }


}
