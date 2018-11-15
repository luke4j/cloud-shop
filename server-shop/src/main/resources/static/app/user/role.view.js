define(function(require, exports, module) {
    require("S");
    require("J");
    require("backbone");
    require("bootstrap-table-editable") ;
    var View = Backbone.View.extend({
        el: $("body"),
        events: {
            "click #save_role":"bnt_save_role_handler"
        },
        initialize: function () {
            this.render();
        },
        render: function () {
            var $me = this ;
            J.render($me.pageInit,$me) ;

        },
        pageInit:function($me,$div){
            $me.addRoleForm($div) ;
            $me.showRoleTable($div) ;
        },
        /**添加角色表单*/
        addRoleForm:function($div){
            var jForm =J.createForm("fm_com_role_add",'form-inline') ;
            jForm.fieldset.append(J.formElement({id:'name',name:'name',text:'角色名'}))
                .append(J.formElement({id:'bz',name:'bz',text:'备注'}))
                .append(J.formElement({id:'save_role',name:'save_role',type:'btn',text:'保存角色'}));

            var $panel = J.$panel({
                title:'添加角色',
                content:jForm.form
            }) ;
            $div.append($panel) ;

        },
        showRoleTable:function($div){
            var $tbar = $("<div id='tbr_role_select_role'>") ;
            $tbar.append($("<select id='roleId' placeholder='选择角色' class='form-control'>")) ;

            var $tbl = $("<table id='tbl_role_fun'>") ;
            $div.append($tbl) ;
            var tblCfg = {
                height:650,
                toolbar:$tbar,
                pagination:false,
                //url:'role/findAllFunByRoleId.act',
                columns : [
                    {
                        checkbox:true,
                        field:'id',
                        title:'id'
                    },{
                        field:'c_group',
                        title:'组'
                    },
                    {
                        field:'fid',
                        title:'父ID'
                    },{
                        field:'iconPath',
                        title:'图标'
                    },{
                        field:'name',
                        title:'名称'
                    },{
                        field:'studyPath',
                        title:'视频路径'
                    },{
                        field:'viewPath',
                        title:'入口js'
                    }
                ]
            } ;
            J.bpTable("tbl_role_fun",tblCfg) ;

            J.ajax({
                url:'role/findAllRole.act',
                success:function(data,res){
                    var $roleId = $("#roleId") ;
                    $roleId.html('') ;
                    var aryOptions = J.SelectOptions("空") ;
                    $.each(data,function(i,d){
                        aryOptions.push({val: d.id,text: d.name}) ;
                    }) ;
                    $.each(aryOptions,function(i,d){
                        $roleId.append($("<option>").text(d.text).val(d.val)) ;
                    });
                }
            })
        }
        // ------------------------------------事件代码区-----------------------------------------

    }) ;



    return View ;
}) ;
