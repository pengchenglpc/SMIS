(function($){
    //备份jquery的ajax方法  
    var _ajax=$.ajax;  
    //重写jquery的ajax方法  
    $.ajax=function(url ,opt){
    	if(typeof url === 'object'){
    		opt = url;
    	}
        //备份opt中error和success方法  
        var fn = {  
            error:function(XMLHttpRequest, textStatus, errorThrown){},  
            success:function(data, textStatus, xhr){},
            overtime:function(){
            	window.location.href = "login.html";
            }
        }  
        if(opt.error){  
            fn.error=opt.error;  
        }  
        if(opt.success){  
            fn.success=opt.success;  
        }  
        if(opt.overtime){
        	fn.overtime = opt.overtime;
        }
        //扩展增强处理  
        var _opt = $.extend(opt,{  
            error:function(XMLHttpRequest, textStatus, errorThrown){  
                //错误方法增强处理
            	var session_status = XMLHttpRequest.getResponseHeader('session_status');
            	if(session_status && session_status === 'timeout'){
            		fn.overtime.call(this);
            	}else{
            		fn.error(this,XMLHttpRequest, textStatus, errorThrown);
            	}
            },  
            success:function(data, textStatus, xhr){  
                //成功回调方法增强处理  
                var session_status = xhr.getResponseHeader('session_status');
                if(session_status && session_status === 'timeout'){
                	fn.overtime.call(this);
                }else{
                	fn.success.call(this,data, textStatus, xhr);
                }
            }  
        });  
        _ajax(url ,_opt);  
    };  
})(jQuery); 