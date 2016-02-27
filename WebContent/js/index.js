(function($){
	$(function(){
		$('#sys_tree').tree({
			url:'sys/findAllMenu.action',
			onClick:function(node){
				var tab = $('#center_tab').tabs('getTab', node.text);
				if(tab){
					$('#center_tab').tabs('select', node.text);
				}else{
					$('#center_tab').tabs('add',{    
					    title:node.text,    
					    href:node.menuUrl,
					    closable:true   
					});  
				}
			}
		});
	});
})(jQuery);