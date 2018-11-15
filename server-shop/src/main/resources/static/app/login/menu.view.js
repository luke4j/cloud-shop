define(function(require, exports, module) {
    require("J") ;
    require("backbone") ;
    require("bootstrap") ;
    var View = Backbone.View.extend({
        el: $("#wm_workspace"),
        events: {
            //"click #a_mt_userInfo":"a_mt_userInfo_handler"
        },
        initialize: function () {
            /**页面工作区*/
            LukeApp.jqWorkSpace = $("#wm_workspace") ;
            this.render() ;
        },
        render:function(){
            /**页面改变参数*/
            var $me = this ;
            var menus = $("<div />").addClass('container-fluid').attr("id","main_menu");
            LukeApp.jqWorkSpace.html("") ;
            LukeApp.jqWorkSpace.append(menus) ;
            var $groupRow ;

            /**先处理fid为0的数据*/
            for(var i in LukeApp.info.funs){
                var fun = LukeApp.info.funs[i] ;
                if(fun.fid===0){
                    $groupRow = $("<div >").addClass("row").attr("row_id",fun.id) ;
                    menus.append($groupRow) ;
                    continue ;
                }
            }

            /**动态构建菜单*/
            for(var i in LukeApp.info.funs){
                var fun = LukeApp.info.funs[i] ;
                if(fun.fid===0){
                    continue ;
                }
                if(!fun.viewPath){
                    console.dir("fun.id "+ fun.id +" viewPath is null") ;
                    continue ;
                }
                /**加载菜单组件，为后面显示菜单做准备*/
                var item = J.htmlTemp("app/login/menu_item.tmp.html") ;
                var $item = $(item) ;

                $item.attr("viewPath",fun.viewPath).attr("viewName",fun.name) ;
                /**为每一个菜单增加事件*/
                $item.on('click',function(e){
                    requirejs([$(e.currentTarget).attr('viewPath')],function(VClass){
                        $("#main_menu").remove() ;
                        var viewPath = $(e.currentTarget).attr('viewPath') ;
                        J.changeView($me,viewPath) ;
                        $("#lmt_name").html("").append($("<span/>").addClass("glyphicon glyphicon-cloud")).append("当前功能："+$(e.currentTarget).attr('viewName')) ;
                    }) ;
                }) ;
                if(fun.iconPath){
                    $("h3",$item).html("") ;
                    $("h3",$item).append($("<p>").addClass("glyphicon").addClass(fun.iconPath)).append(fun.name) ;
                }else{
                    $("h3",$item).text(fun.name) ;
                }
                $("div[row_id='"+fun.fid+"']").append($item)
            }


        }

    });
    return View ;
}) ;