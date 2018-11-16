define(function(require, exports, module) {
    require("S");
    require("J");
    require("backbone");
    require("bootstrap-table-editable") ;
    var View = Backbone.View.extend({
        el: $("body"),
        events: {
            /**保存角色*/
            "click #save_role":"bnt_save_role_handler",
            /**角色下拉改变事件，刷新角色对应的功能列表*/
            "change #roleId":"slt_cchange_roleId_handler",
            /**保存角色与权限关系*/
            "click #saveRoleFun":"btn_saveRoleFun_handler"
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
            var $tbar = $("<div id='tbr_role_select_role' class='form-inline '>") ;
            $tbar.append($("<lable for='roleId' class='form-control margin-left_3'>").text("选择角色")) ;
            $tbar.append($("<select id='roleId' placeholder='选择角色' class='form-control margin-left_3'>")) ;
            $tbar.append($("<a href='#' id='saveRoleFun' class='btn btn-primary form-control margin-left_3'>").text("保存")) ;

            var $tbl = $("<table id='tbl_role_fun'>") ;
            $div.append($tbl) ;
            var tblCfg = {
                height:650,
                toolbar:$tbar,
                pagination:false,
                onLoadSuccess:function(data){
                    $("#tbl_role_fun").bootstrapTable('uncheckAll') ;
                    var funs = data.map.roleFun ;
                    $.each(funs,function(i,d){
                        $("#tbl_role_fun").bootstrapTable("checkBy",{field:'id',values:[d.id]}) ;
                    }) ;
                },
                onCheck:function(row){
                    $("#tbl_role_fun").bootstrapTable("checkBy",{field:'fid',values:[row.id]}) ;
                },
                onUncheck:function(row){
                    $("#tbl_role_fun").bootstrapTable("uncheckBy",{field:'fid',values:[row.id]}) ;
                },
                //url:'role/findAllFunByRoleId.act',
                columns : [
                    {
                        checkbox:true,
                    },
                    {

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
        },
        // ------------------------------------事件代码区-----------------------------------------
        /**保存角色*/
        bnt_save_role_handler:function(jqueryEvent){
            var $form = $("#fm_com_role_add") ;
            var jsnVal = J.formValues($form) ;
            var validate = J.validate(jsnVal,{
                name:{null_able:false,msg:'角色名不能为空'}
            }) ;
            if(validate){
                J.ajax({
                    url:'role/saveRole.act',
                    data:jsnVal,
                    success:function(data,res){
                        /**更新角色下拉元素*/
                        $("#roleId").append($("<option>").val(data.id).text(data.name)) ;
                        J.alertOk() ;
                    }
                }) ;
            }
        },
        /**角色下拉改变事件，刷新角色对应的功能列表*/
        slt_cchange_roleId_handler:function(jqueryEvent){
            var $select = $(jqueryEvent.target) ;
            var roleId = $select.val() ;
            if(!roleId) {
                $("#tbl_role_fun").bootstrapTable('removeAll') ;
                return false ;
            }
            $("#tbl_role_fun").bootstrapTable('refresh', {
                url:'role/findAllFunByRoleId.act',
                query:{id:roleId},
            });
        },
        /**保存角色与权限关系*/
        btn_saveRoleFun_handler:function($e){
            var roleId = $("#roleId").val() ;
            var aryFuns = $("#tbl_role_fun").bootstrapTable('getSelections') ;
            var aryFunIds = [] ;
            $.each(aryFuns,function(i,d){
                aryFunIds.push(d.id) ;
            }) ;
            var data = {
                roleId:roleId,
                funIds:aryFunIds
            }
            J.ajax({
                ajaxOk:true,
                url:'role/saveRoleFun.act',
                data:data
            }) ;
        }
    }) ;



    return View ;
}) ;
