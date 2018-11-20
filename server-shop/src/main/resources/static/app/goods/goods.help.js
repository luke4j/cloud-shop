var goods_help = {

    /**商品品类，品牌，型号，颜色*/
    fm_kind:function(use){
        use = use||null ;
        var $jForm = J.createForm("fm_kind",'form-horizontal',use) ;
        $jForm.fieldset.append(J.formElement({id:'fid',name:'fid',text:'父结点id',type:'hidden'}))
            .append(J.formElement({id:'kindLvl',name:'kindLvl',text:'级别',type:'select',options: J.SelectOptions('商品级别')}))
            .append(J.formElement({id:'name',name:'name',text:'名称'}))
            .append(J.formElement({id:'lens',name:'lens',text:'是否度数',type:'select',options: J.SelectOptions("是否")}))
            .append(J.formElement({id:'sw',name:'sw',text:'是否实物',type:'select',options: J.SelectOptions("是否")}))
            .append(J.formElement({id:'xq',name:'xq',text:'是否效期',type:'select',options: J.SelectOptions("是否")}))
        return $jForm ;
    },

    /**
     * 表单显示商品详细信息
     * @param goodsExtAttr  商品扩展属性
     * @param ext  商品属性对象 品类，品牌，型号，颜色
     * @returns {{form, fieldset}|{form: (*|jQuery), fieldset: (*|jQuery|HTMLElement)}}
     */
    fm_goodsInfo:function(goodsExtAttr,ext){
        var jFrom = J.createForm('fm_goodsInf') ;
        /**基本属性*/
        jFrom.fieldset
            .append(J.formElement({id:'id',name:'id',text:'ID',type:'hidden'}))
            .append(J.formElement({id:'name',name:'name',text:'商品名'}))
            .append(J.formElement({id:'colorId',name:'colorId',text:'颜色ID',type:'hidden',value:ext.color.id}))
            .append(J.formElement({id:'kcjb',name:'kcjb',text:'库存级别',type:'select',options: J.SelectOptions("库存级别")}))
            .append(J.formElement({id:'c_code',name:'c_code',text:'商品编码'})) ;
        /**扩展属性*/
        for(var i in goodsExtAttr){
            var el = goodsExtAttr[i] ;//需要生成的元素
            if(el.c_type=='select'&&el.defaults){
                var option = [{val:'',text:''}];
                var def = el.defaults.split(";") ;
                for(var i in def){
                    option.push({val:def[i],text:def[i]}) ;
                }
                jFrom.fieldset.append(J.formElement({id:el.columnName,name:el.columnName,text:el.columnValue,type:'select',options:option})) ;
            }else{
                jFrom.fieldset.append(J.formElement({id:el.columnName,name:el.columnName,text:el.columnValue})) ;
            }
        }
        /**是否度数*/
        if(ext.kind.a1==='true'){
            /**度数商品显示度数配置*/
            var btnSetLens = J.formElement({id:'btn_set_lens',name:'btn_set_lens',text:'配置度数',type:'btn'}) ;
            /**显示配置度数弹出窗*/
            btnSetLens.on('click',
                function(e){
                    requirejs(['app/goods/lens.help'],function(){
                        var valForm = J.formValues($("#fm_goodsInf")) ;
                        if(valForm.id){
                            lens_help.showLensWindow(valForm.id) ;
                        }else{
                            var validate = J.validate(valForm,{
                                name:{null_able:false,msg:'商品名不能为空'},
                                kcjb:{null_able:false,msg:'库存级别不能为空'}
                            }) ;
                            if(validate){
                                J.ajax({
                                    url:'goods/addGoods',
                                    data:valForm,
                                    success:function(d,res){
                                        lens_help.showLensWindow(d.id) ;
                                        $('#id',$("#fm_goodsInf")).val(d.id) ;
                                    }
                                });
                            }
                        }
                    }) ;
                }
            ) ;
            jFrom.fieldset.append(btnSetLens) ;
        }else{
            /**是否添加价格*/
            if(LukeApp.info!=null&&LukeApp.info.listSetupCom!=null){
                /**是否配置了在录入时录入价格*/
                var setups = LukeApp.info.listSetupCom ;
                for(var i in setups){
                    if(setups[i].name==="save_not_lens_add_price"&&setups[i].val==="true"){
                        jFrom.fieldset.append(J.formElement({id:'pin',name:'pin',text:"进货价"})) ;
                        jFrom.fieldset.append(J.formElement({id:'pout',name:'pout',text:"销售价"})) ;
                        break ;
                    }
                }
            }
        }
        return jFrom ;
    },

    fm_goods:function(use){
        use = use||null ;
        var $jForm = J.createForm("fm_kind",'form-horizontal',use) ;
    }


} ;
