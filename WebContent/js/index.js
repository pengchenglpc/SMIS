(function($){
	$(function(){
		$('#nav_accordion').accordion({
			onSelect:function(title, index){
				//面板选中时加载该Panel菜单项目数据
				var panel = $('#nav_accordion').accordion('getPanel', index);
				panel.children('ul').tree({
					url:'sys/findParentMenu.action',
					queryParams:{'menu.menuParent':panel.attr('id')},
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
			}
		});
		$.ajax('sys/findRootMenu.action',{
			dataType:'json',
			async:false,
			success:function(data){
				if(data){
					for(var i = 0; i < data.length; i++){
						var menu = data[i];
						$('#nav_accordion').accordion('add', {
							id:menu.id,
							title: menu.menuName,
							content: '<ul></ul>',
							selected: i === 0 ? true : false
						});
					}
				}
			}
		});

	});
})(jQuery);