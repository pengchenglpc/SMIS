(function($){
	window.login = function(){
		var userId = $('#userId').val();
		var password = $('#password').val();
		if(!userId){
			$('.login-tip').html("请输入用户名");
			return;
		}
		if(!password){
			$('.login-tip').html("请输入密码");
			return;
		}
	}
	window.reset = function(){
		
	}
})(jQuery);