(function($){
	$(function(){
		$('#menu_datagrid').treegrid({
			url:'sys/findTreeMenu.action',
			rownumbers: true,
			toolbar:[{
				text:'添加',
				iconCls:'icon-add',
				handler:addMenu
			},'-',{
				text:'修改',
				iconCls:'icon-edit',
				handler:edit
			},'-',{
				text:'删除',
				iconCls:'icon-remove',
				handler:remove
			},'-',{
				text:'刷新',
				iconCls:'icon-reload',
				handler:refresh
			}],
			idField:'id',
			treeField:'menuName',
			height:500,
			//rownumbers:true,
			columns:[[
			          {field:'id',checkbox:true},
			          {field:'menuName',title:'菜单名称',width:100},    
			          {field:'menuUrl',title:'菜单路径',width:100},
			          {field:'available', title:'是否可用', width:100,formatter:function(value){
			        	  if(value === 0){
			        		  return '不可用';
			        	  }else if(value === 1){
			        		  return '可用';
			        	  }else{
			        		  return '无效值';
			        	  }
			          }},
			          {field:'createTime', title:'创建时间', width:120},
			          {field:'updateTime', title:'最后修改时间', width:120},
			          {field:'description',title:'菜单描述',width:250}
			      ]] 
		});
	});
	function edit(){
		var row = $('#menu_datagrid').treegrid('getSelected');
		if(!row){
			$.messager.alert('警告','请选择您要修改的菜单项');
			return;
		}
		var dialog = menuDialog('修改菜单',function(){
			$('#menu_form').form('submit', {
				url:'sys/editMenu.action',
				success:function(data){
					data = $.parseJSON(data);
					if(data['status'] === 1){
						$('#menu_datagrid').treegrid('reload');
						dialog.dialog('destroy');
					}
				}
			});
		}, function(){
			var _row = {};
			for(var key in row){
				_row['menu.' + key] = row[key];
			}
			$('#menu_form').form('load',_row);
			//$('#menu_form').find('label[name="menu.parent"]').html(row['menuName']);
		});
	}
	function remove(){
		var row = $('#menu_datagrid').treegrid('getSelected');
		if(!row){
			$.messager.alert('警告','请选择您要删除的菜单项');
			return;
		}
		if(row['children']){
			$.messager.alert('警告','该菜单项包含有子菜单，请先删除子菜单');
			return;
		}
		$.messager.confirm('确认','您确定要删除该菜单项吗？',function(r){    
		    if (r){    
		        $.get('sys/removeMenu.action', {'menu.id':row['id']}, function(data){
		        	if(data['status'] === 0){
		        		$.messager.alert('警告','菜单项删除失败');
		        		return;
		        	}
		        	refresh();
		        }, 'json');  
		    }    
		});  
	}
	function refresh(){
		$('#menu_datagrid').treegrid('reload');
	}
	function addMenu(){
		var row = $('#menu_datagrid').treegrid('getSelected');
		if(row && row['leaf'] === 0){
			$.messager.alert('警告','该菜单项不能添加子节点');   
			return;
		}
		var dialog = menuDialog('添加菜单',function(){
			$('#menu_form').form('submit', {
				url:'sys/addMenu.action',
				success:function(data){
					data = $.parseJSON(data);
					if(data['status'] === 1){
						$('#menu_datagrid').treegrid('reload');
						dialog.dialog('destroy');
					}
				}
			});
		}, function(){
			if(row){
				$('#menu_form').form('load',{
					'menu.menuParent':row['id']
				});
				$('#menu_form').find('label[name="menu.parent"]').html(row['menuName']);
			}
		});
	}
	function menuDialog(title, fn, load){
		var dialog = $('<div>').dialog({
			title:title,
			modal:true,
			width:600,
			href:'system/menu.html',
			height:260,
			onLoad:load,
			buttons:[{
				text:'确定',
				width:50,
				handler:fn
			},{
				text:'取消',
				handler:function(){
					dialog.dialog('destroy');
				},
				width:50
			}]
		});
		return dialog;
	}
})(jQuery);