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
		$('.login-tip').html("");
		$.get('sys/loginUser.action',{'user.userId':userId, 'user.password':password}, function(result){
			if(result['status'] === 0){
				$('.login-tip').html(result['message']);
				return;
			}
			window.location.href = "index.html";
		}, 'json');
	}
	window.reset = function(){
		$('#userId').val('');
		$('#password').val('');
	}
})(jQuery);