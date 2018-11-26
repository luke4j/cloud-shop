define(function(require, exports, module) {
    require("md5");
    require("S");
    require("J");
    require("backbone");
    require("bootstrap");
    require("ztree") ;
    require("app/goods/goods.help") ;
    var View = Backbone.View.extend({
        el: $("body"),
        events: {
            "click #btn_add_kind":"btn_add_kind_handler"

        },
        initialize: function () {
            this.render();
        },
        render: function () {
            var $me = this ;
            J.render($me.goods_tree,$me) ;
        },
        /**商品树*/
        goods_tree:function($me,$div){
            var $btn_add_kind = $("<a id='btn_add_kind'>").addClass("btn btn-default").addClass(S.btn_add_tag_css).text("添加品类") ;
            $div.append($btn_add_kind) ;
            /**添加商品树*/
            $div.append("<ul id='zt_goodsTree' class='ztree'></ul>");
            /**查询第一级*/
            var rootData  ;
            J.ajax({
                url: 'goods/findGoodsNode.act',
                data:{fid:0,kindLvl:'品类'},
                async: false,
                success: function (data, res) {
                    rootData = data;
                }
            });
            /**ztree配置*/
            var setting = {
                asyncUrl:'goods/findGoodsNode.act',
                asyncParam:function(treeId,treeNode){
                    if(treeNode){
                        return {fid:treeNode.id} ;
                    }else{
                        return {fid:0} ;
                    }

                },
                callback: {
                    /**
                     * 用于捕获父节点展开之前的事件回调函数，并且根据返回值确定是否允许展开操作
                     * 返回值是 true / false
                     *  如果返回 false，zTree 将不会展开节点，也无法触发 onExpand 事件回调函数
                     * */
                    beforeExpand: function(treeId, treeNode){
                        if(treeNode.kindLvl=='商品'){
                            J.alert("商品没有下一级") ;
                            return false ;
                        }
                        if(!treeNode.isAjaxing){
                            var zTree = $.fn.zTree.getZTreeObj(treeId);
                            zTree.reAsyncChildNodes(treeNode,"refresh") ;
                            return true ;
                        }else{
                            return false ;
                        }
                    }
                },
                view: {
                    expandSpeed: "",
                    addDiyDom: function(treeId, treeNode){
                        var zTree = $.fn.zTree.getZTreeObj(treeId);
                        var aObj = $("#" + treeNode.tId + "_a");
                        aObj.addClass("treeNode_50") ;
                        if(treeNode.count!=null)
                            aObj.append("<span class='badge'>"+treeNode.count+"</span>") ;

                        var $btn_del = $("<a style='margin-right:5px;'>").addClass("ztree_btn_del btn btn-default float_right a_btn").text("作废") ;
                        aObj.append($btn_del) ;
                        $btn_del.on("click",function(e){$me.ztree_btn_del_click_handler(e,treeNode) ;}) ;


                        var $btn_edit = $("<a style='margin-right:5px;'>").addClass('ztree_btn_edit btn btn-default float_right a_btn').text("修改") ;
                        aObj.append($btn_edit) ;
                        $btn_edit.on("click",function(e){$me.ztree_btn_edit_click_handler(e,treeNode)}) ;

                        if(treeNode.kindLvl&&treeNode.kindLvl!='商品'){
                            var $btn_add = $("<a style='margin-right:5px;'>").addClass("ztree_btn_add btn btn-default float_right a_btn ").text("新增下一级") ;
                            aObj.append($btn_add) ;
                            $btn_add.on('click',function(e){$me.ztree_btn_add_click_handler(e,treeNode)}) ;
                        }
                    }
                }
            };
            //$.fn.zTree.init($("#zt_goodsTree"), setting,rootData);
            J.ztree(setting,"zt_goodsTree",rootData) ;
        },
        //-------------------------------------页面公用方法区-------------------------------------
        /**
         * 弹出 商品 类型 属性窗口
         * @param title  窗口标题
         * @param data   使用参数 商品类型{fid:Long,kindLvl:类型级别}  商品{fid:就是colorId,_kindId:商品品类Id}
         * @param okCallBack  窗口点击OK按钮调用事件 okCallBack($f,alt) $f 窗口中的form表单jquery对象，alt为弹出窗的jquery对象
         */
        showAlert:function (title,data,okCallBack){
            var $jFrom = null ;
            if(data.kindLvl=='商品'){
                $jFrom = goods_help.fm_goods(data) ;
            }else{
                $jFrom = goods_help.fm_kind() ;
                $("#kindLvl",$jFrom.form).val(data.kindLvl).attr('disabled',"disabled")  ;
                /**设置默认值*/
                J.setFormValue($jFrom.form,data) ;
                /**调整页面元素*/
                if(data.kindLvl!='品类'){
                    $("#lens",$jFrom.form).parent().parent().hide() ;
                    $("#sw",$jFrom.form).parent().parent().hide() ;
                    $("#xq",$jFrom.form).parent().parent().hide() ;
                    $("#jg_center_cf",$jFrom.form).parent().parent().hide() ;
                    $("#xs_zd_cf",$jFrom.form).parent().parent().hide() ;
                }
            }
            J.alert({
                title:title,
                btns:'YN',
                msg:$jFrom.form,
                okFunction:function(e,alt){
                    if(okCallBack&& (typeof(okCallBack)==='function') ){
                        var $f = $("form",alt) ;
                        okCallBack($f,alt) ;
                    }
                }
            }) ;

        }  ,
        // ------------------------------------事件代码区-----------------------------------------
        /**添加品类*/
        btn_add_kind_handler:function(e){
            var $me = this ;
            $me.ztree_btn_add_click_handler(e) ;
        },
        /** ztree树中作废按钮事件*/
        ztree_btn_del_click_handler:function(e,treeNode){

        },
        /** ztree树中修改按钮事件*/
        ztree_btn_edit_click_handler:function(e,treeNode){

        },
        /** ztree树中新增下一级按钮事件*/
        ztree_btn_add_click_handler:function(e,treeNode){
            var $me = this ,data = {},idx = "";
            /**因为是添加下一级，所以当前treeNode.kindLvl=品类  的要设置为 品牌 以此类推*/
            if(!treeNode){
                data.kindLvl = "品类" ;
            }else if(treeNode.kindLvl=='品类'){
                data.kindLvl = "品牌" ;
                idx = "品类:"+treeNode.name+"下品牌" ;
            }else if(treeNode.kindLvl=='品牌'){
                data.kindLvl = "型号" ;
                idx = "品类:"+treeNode.getParentNode().name+"->品牌："+treeNode.name+"下型号" ;
            }else if(treeNode.kindLvl=='型号'){
                data.kindLvl = "颜色" ;
                idx = "品类:"+treeNode.getParentNode().getParentNode().name+"->品牌:"+treeNode.getParentNode().name+"->型号："+treeNode.name+"下颜色" ;
            }else if(treeNode.kindLvl=='颜色'){
                data.kindLvl = "商品" ;
                idx = "品类:"+treeNode.getParentNode().getParentNode().getParentNode().name+"->品牌:"+treeNode.getParentNode().getParentNode().name+"->型号:"+treeNode.getParentNode().name+"->颜色:"+treeNode.name+"下商品" ;
                data._kindId = treeNode.getParentNode().getParentNode().getParentNode().id ;
                data._colorId = treeNode.id ;
                data._lens = treeNode.getParentNode().getParentNode().getParentNode().lens ;
            }
            data.fid = treeNode?treeNode.id:0 ;
            $me.showAlert("添加"+data.kindLvl+":"+idx,data,function($f,alt){
                var val = J.formValues($f) ;
                val.kindLvl = val.kindLvl||"商品" ;
                J.ajax({
                    url:'goods/addKindAndGoods.act',
                    data:val,
                    success:function(data,res){
                        if(res.success){
                            J.alertOk() ;
                            var treeObj = $.fn.zTree.getZTreeObj("zt_goodsTree");
                            treeObj.reAsyncChildNodes(treeNode, "refresh");
                        }
                    }
                }) ;
            }) ;
        },
    }) ;

    return View ;
}) ;
