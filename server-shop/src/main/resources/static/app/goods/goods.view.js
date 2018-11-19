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
            var me = this;
            var $btn_add_kind = $("<a id='btn_add_kind'>").addClass("btn").addClass(S.btn_add_tag_css).text("添加品类") ;
            $div.append($btn_add_kind) ;
            /**添加商品树*/
            $div.append("<ul id='zt_goodsTree' class='ztree'></ul>");
            /**查询第一级*/
            var rootData  ;
            J.ajax({
                url: 'goods/findGoodsNode.act',
                data:{fid:0},
                async: false,
                success: function (data, res) {
                    rootData = data;
                }
            });
            /**ztree配置*/
            var setting = {
                async: {
                    enable: true,
                    type: 'POST',
                    dataType:'json',
                    contentType: 'application/json', //很重要
                    traditional: true,
                    url:'goodsTree/findNode.act',
                    otherParam:function(treeId,treeNode){
                        if(treeNode!=null){
                            return {id:treeNode.id} ;
                        }else{
                            return {id:0} ;
                        }
                    },
                    dataFilter:function(treeId, parentNode, responseData){
                        return responseData.data ;
                    }
                },
                check: {
                    enable: false
                },
                data: {
                    simpleData: {
                        enable: false
                    }
                },
                view: {
                    expandSpeed: "",
                    addDiyDom: function(treeId, treeNode){
                        var zTree = $.fn.zTree.getZTreeObj(treeId);
                        var aObj = $("#" + treeNode.tId + "_a");
                        aObj.addClass("treeNode_50") ;
                        if(treeNode.count)
                            aObj.append("<span class='badge'>"+treeNode.count+"</span>") ;

                        var $btn_del = $("<a>").addClass("ztree_btn_del btn float_right a_btn").text("作废") ;
                        aObj.append($btn_del) ;
                        $btn_del.on("click",function(e){view.ztree_btn_del_click_handler(e,treeNode.id,treeNode) ;}) ;


                        var $btn_edit = $("<a>").addClass('ztree_btn_edit btn float_right a_btn').text("修改") ;
                        aObj.append($btn_edit) ;
                        $btn_edit.on("click",function(e){view.ztree_btn_edit_click_handler(e,treeNode.id,treeNode)}) ;

                        if(treeNode.c_group!='商品'){
                            var $btn_add = $("<a>").addClass("ztree_btn_add btn float_right a_btn").text("新增") ;
                            aObj.append($btn_add) ;
                            $btn_add.on('click',function(e){view.ztree_btn_add_click_handler(e,treeNode.id,treeNode)}) ;
                        }

                        if(treeNode.c_group=='品类'){
                            var $btn_setup= $("<a>").addClass("ztree_btn_setup btn float_right a_btn").text("配置属性") ;
                            aObj.append($btn_setup) ;
                            $btn_setup.on('click',function(e){view.ztree_btn_pzsx_click_handler(e,treeNode.id,treeNode) ;}) ;
                        }
                    }
                },
                callback: {
                    beforeExpand: me.ztreeBeforeExpand_handler
                }
            };
            $.fn.zTree.init($("#zt_goodsTree"), setting,rootData);

        }
        // ------------------------------------事件代码区-----------------------------------------

    }) ;



    return View ;
}) ;
