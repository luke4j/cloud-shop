define(function(require, exports, module) {
    require("md5");
    require("S");
    require("J");
    require("backbone");
    require("bootstrap");
    require("ztree") ;
    var View = Backbone.View.extend({
        el: $("body"),
        events: {
            "click #btn_add_kind":"btn_add_kind_handler"
            /**因传递参数问题，ztree中的添加修改作废事件都在定义时添加*/
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
                    return {fid:treeNode.id} ;
                },
                check: {
                    enable: false
                },
                data: {
                    simpleData: {
                        enable: false
                    }
                },
                callback: {
                    beforeExpand: function(treeId, treeNode){
                        console.dir(treeNode) ;
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
                        console.dir(treeNode) ;
                        var zTree = $.fn.zTree.getZTreeObj(treeId);
                        var aObj = $("#" + treeNode.tId + "_a");
                        aObj.addClass("treeNode_50") ;
                        if(treeNode.count!=null)
                            aObj.append("<span class='badge'>"+treeNode.count+"</span>") ;

                        var $btn_del = $("<a>").addClass("ztree_btn_del btn btn-default float_right a_btn").text("作废") ;
                        aObj.append($btn_del) ;
                        $btn_del.on("click",function(e){$me.ztree_btn_del_click_handler(e,treeNode) ;}) ;


                        var $btn_edit = $("<a>").addClass('ztree_btn_edit btn btn-default float_right a_btn').text("修改") ;
                        aObj.append($btn_edit) ;
                        $btn_edit.on("click",function(e){$me.ztree_btn_edit_click_handler(e,treeNode)}) ;

                        if(treeNode.kindLvl!='商品'){
                            var $btn_add = $("<a>").addClass("ztree_btn_add btn btn-default float_right a_btn").text("新增下一级") ;
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
        /**弹出 商品 属性窗口*/
        showAlert:function (title,data,okCallBack){
            var $jFrom = goodsTree_view_help.fm_goodsBaseInfo() ;
            J.alert({
                title:title+data.name,
                btns:'YN',
                msg:$jFrom.form,
                okFunction:function(e,alt){
                    if(okCallBack&& (typeof(okCallBack)==='function') ){
                        var $f = $("form",alt) ;
                        okCallBack($f,alt) ;
                    }
                }
            }) ;
            var $f_goodstree = $("#f_goodstree") ;
            $f_goodstree[0].reset() ;
            $("#ajaxdo",$f_goodstree).val("add") ;

            $("#c_group",$f_goodstree).addClass("disabled").attr("disabled","disabled") ;
            $("#fname",$f_goodstree).addClass("disabled").attr("disabled","disabled") ;

            $("#a1,#a2,#a3",$f_goodstree).parent().parent().fadeOut("fast") ;
            $("#fid",$f_goodstree).val(data.id) ;
            return $f_goodstree ;
        }  ,
        // ------------------------------------事件代码区-----------------------------------------
        /** ztree树中作废按钮事件*/
        ztree_btn_del_click_handler:function(e,treeNode){

        },
        /** ztree树中修改按钮事件*/
        ztree_btn_edit_click_handler:function(e,treeNode){

        },
        /** ztree树中新增下一级按钮事件*/
        ztree_btn_add_click_handler:function(e,treeNode){

        },
    }) ;



    return View ;
}) ;
