define(function(require, exports, module) {
    require("S");
    require("J");
    require("backbone");
    require("bootstrap-table-editable") ;
    var View = Backbone.View.extend({
        el: $("body"),
        events: {
            /**添加功能事件*/
            "click #btn_tbr_add":"click_btn_tbr_add_handler"
        },
        initialize: function () {
            this.render();
        },
        render: function () {
            var $me = this ;
            J.render($me.fun_table,$me) ;

        },
        fun_table:function($me,$div){
            var $toolbar = $("<div id='div_tbr_dev_fun'>") ;
            $toolbar.append($("<a id='btn_tbr_add'  class='btn'>").text("添加新功能")) ;
            var $table = $("<table id='tbl_fun'>") ;
            $div.append($table) ;
            var tblCfg = {
                height:650,
                toolbar:$toolbar,
                pagination:false,
                url:'dev/findAllFun.act',
                /**编辑完后保存事件*/
                onEditableSave:function(columnFild,record,columnText,edit){
                    var param = record ;
                    if(param.c_group&&param.name&&param.fid){
                        J.ajax({
                            url:'dev/editFun.act',
                            ajaxOk:true,
                            data:param,
                            success:function(data){
                                $("#tbl_fun").bootstrapTable('refresh',{url:'dev/findAllFun.act'}) ;
                            }
                        }) ;
                    }

                },
                columns : [
                    {
                        field:'id',
                        title:'id'
                        //visible:false
                    },{
                        field:'c_group',
                        title:'组',
                        editable:true
                    },
                    {
                        field:'fid',
                        title:'父ID',
                        editable:true
                    },{
                        field:'iconPath',
                        title:'图标',
                        editable: true
                    },{
                        field:'name',
                        title:'名称',
                        editable:true
                    },{
                        field:'studyPath',
                        title:'视频路径',
                        editable:true
                    },{
                        field:'viewPath',
                        title:'入口js',
                        editable:true
                    }
                ]
            } ;
            J.bpTable("tbl_fun",tblCfg) ;
        },
        // ------------------------------------事件代码区-----------------------------------------
        /**添加功能事件*/
        click_btn_tbr_add_handler:function(e){
            var $bt = $("#tbl_fun") ;
            $bt.bootstrapTable('insertRow',{index:0,row:{
                c_group: null,
                fid: null,
                htmlPath: null,
                iconPath: null,
                name:null,
                studyPath: null,
                viewPath:null
            }}) ;
        }
    }) ;



    return View ;
}) ;
