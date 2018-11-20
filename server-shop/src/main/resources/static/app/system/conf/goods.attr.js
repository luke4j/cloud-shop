define(function(require, exports, module) {
    require("md5");
    require("S");
    require("J");
    require("backbone");
    require("bootstrap-table-editable") ;
    var View = Backbone.View.extend({
        el: $("body"),
        events: {
            /**商品品类改变事件，列表加载相应的商品扩展属性*/
            "change #kindId":"slt_kindId_chnage_handler"

        },
        initialize: function () {
            this.render();
        },
        render: function () {
            var me = this ;
            J.render(function(view,$div_Row){
                $div_Row.append('<table id="tbl_goodsAttrs"></table>') ;
                var $tbar = $("<div id='tbr' class='form-inline '>") ;
                $tbar.append($("<lable for='kindId' class='form-control margin-left_3'>").text("选择品类")) ;
                $tbar.append($("<select id='kindId' placeholder='选择品类' class='form-control margin-left_3'>")) ;
                $tbar.append($("<a href='#' id='saveGoodsAttr' class='btn btn-primary form-control margin-left_3'>").text("保存")) ;
                var tblCfg = {
                    height:650,
                    toolbar:$tbar,
                    pagination:false,
                    /**编辑完后保存事件*/
                    onEditableSave:function(columnFild,record,columnText,edit){
                        var param = record ;
                        var kindId = record.kind.id ;
                        J.ajax({
                            url:'goods/editKindSetupConfigById.act',
                            data:param,
                            success:function(data){
                                $("#tbl_kindAttrSetup").bootstrapTable('goods/findKindSetupConfig.act',{url:'',query:{id:kindId}}) ;
                            }
                        }) ;
                    },
                    columns : [
                        {
                            field:'id',
                            title:'id',
                            visible:false
                        },{
                            field:'name',
                            title:'序号'
                        },
                        {
                            field:'msg',
                            title:'代表意义',
                            editable:true
                        },{
                            field:'htmlType',
                            title:'显示类型',
                            editable: {
                                type: 'select',
                                pk: 1,
                                source: [
                                    {value: 'input', text: '文本'},
                                    {value: 'select', text: '下拉列表'}
                                ]
                            }
                        },{
                            field:'defVal',
                            title:'默认值',
                            editable:true
                        }
                    ]
                } ;
                J.bpTable("tbl_goodsAttrs",tblCfg) ;
                /**加载所有品类*/
                J.ajax({
                    url: 'goods/findGoodsNode.act',
                    data:{fid:0,kindLvl:'品类'},
                    success: function (data, res) {
                        $("#kindId").empty() ;
                        $("#kindId").append($("<option>").val("").text("")) ;
                        $.each(data,function(i,d){
                            $("#kindId").append($("<option>").val(d.id).text(d.name)) ;
                        }) ;

                    }
                });
            },this) ;
        },
        // ------------------------------------事件代码区-----------------------------------------
        /**商品品类改变事件，列表加载相应的商品扩展属性*/
        slt_kindId_chnage_handler:function(e){
            var kindId = $(e.target).val() ;
            if(kindId){
                $("#tbl_goodsAttrs").bootstrapTable('refresh',{url:'goods/findKindSetupConfig.act',query:{"id":kindId}}) ;
            }else{
                J.alert("品类不能为空") ;
                return false ;
            }
        }
    }) ;
    return View ;
}) ;
