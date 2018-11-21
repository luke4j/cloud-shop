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
            .append(J.formElement({id:'jg_center_cf',name:'jg_center_cf',text:'中心存放',type:'select',options: J.SelectOptions("是否")}))
            .append(J.formElement({id:'xs_zd_cf',name:'xs_zd_cf',text:'站点存放',type:'select',options: J.SelectOptions("是否")}));
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
        if(ext.kind.lens==='true'){
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
    kind_setup : {} ,
    /**
     *
     * 商品表单，会使用到goods_help.kind_setup这个变量
     * @param param{_kindId:Long ;_colorId:Long}   _kindId用于确定使用哪些扩展属性，_colorId是goods的必须属性
     * @param use
     * @returns {{form: (*|jQuery), fieldset: (*|jQuery|HTMLElement)}}
     */

    fm_goods:function(param,use){
        var $me = this ;
        if(!param._kindId) J.error("没有品类ID") ;
        use = use||null ;
        var $jForm = J.createForm("fm_goods",'form-horizontal',use) ;
        $jForm.fieldset
            .append(J.formElement({id:'id',name:'id',text:'ID',type:'hidden'}))
            .append(J.formElement({id:'name',name:'name',text:'商品名'}))
            .append(J.formElement({id:'colorId',name:'colorId',text:'颜色ID',type:'hidden',value:param._colorId}))
            .append(J.formElement({id:'kcjb',name:'kcjb',text:'库存级别',type:'select',options: J.SelectOptions("库存级别")}))
            .append(J.formElement({id:'c_code',name:'c_code',text:'商品编码'})) ;
        var aryGoodsAttr = [] ;
        if(this.kind_setup[param._kindId]){
            aryGoodsAttr = this.kind_setup[param._kindId] ;
        }else{
            J.ajax({
                url:'goods/findKindSetupByKindId.act',
                data:{id:param._kindId},
                async:false,
                success:function(data,res){
                    aryGoodsAttr = $me.kind_setup[param._kindId] = data ;
                }
            }) ;
        }
        /**添加商品配置的扩展属性*/
        for(var i in aryGoodsAttr){
            var el = aryGoodsAttr[i] ;//需要生成的元素
            /**现在这里只有两种类型，一种是下拉列表，一种是文本*/
            if(el.htmlType=='select'&&el.defVal){
                var option = [{val:'',text:''}];
                var def = el.defVal.split(";") ;
                for(var i in def){
                    option.push({val:def[i],text:def[i]}) ;
                }
                $jForm.fieldset.append(J.formElement({id:el.name,name:el.name,text:el.msg,type:'select',options:option})) ;
            }else{
                $jForm.fieldset.append(J.formElement({id:el.name,name:el.name,text:el.msg})) ;
            }
        }
        /**系统配置销售价与进货价*/
        $.each(LukeApp.info.listSetupCom,function(i,d){
            if(d.name=='writeGoodsAddPriceOut'&&d.val==="1"){
                $jForm.fieldset.append(J.formElement({id:'priceOut',name:'priceOut',text:"销售价"})) ;
            }
            if(d.name=='writeGoodsAddPriceIn'&&d.val==="1"){
                $jForm.fieldset.append(J.formElement({id:'priceIn',name:'priceIn',text:"进货价"})) ;
            }
        }) ;
        /**如果是度数商品显示配置度数功能*/
        if(param._lens){
            $jForm.fieldset.append(J.formElement({id:'btn_Lens',name:'btn_Lens',text:"配置度数",type:'btn'})) ;
        }
        return $jForm ;
    }


} ;
