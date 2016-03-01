(function($){
	var treeObj = $.fn.zTree.getZTreeObj("menu_manage_tree"),
		node = treeObj.getSelectedNodes()[0];
	$('#menu_datagrid').treegrid({
		method:'GET',
		url:'sys/findAllMenu.action',
		fit:true,
		singleSelect:false,
		rownumbers:true,
		fitColumns:true,
		//striped:false,
		toolbar:'#menu_toolbar',
		idField:'menuId',
		treeField:'menuName',
		/*pagination:true,
		pageNumber:1,
		pageSize:10,
		pageList:[5,10,20,30,50,100],*/
		columns:[[{
			field:'menuId',
			checkbox:true
		},{
			title:'菜单名称',
			width:100,
			field:'menuName'
		},{
			title:'英文名称',
			width:100,
			field:'menuEnglish'
		},{
			title:'菜单层级',
			width:70,
			field:'menuLevel'
		},{
			title:'URL',
			width:150,
			field:'actionUrl'
		},{
			title:'是否有效',
			width:50,
			field:'isActive',
			formatter:function(value){
				if(value == 0){
					return '有效';
				}else{
					return '无效';
				}
			}
		},{
			title:'排序值',
			field:'sort'
		},{
			title:'描述',
			width:200,
			field:'description'
		}]]
	});
//	$('#menu_datagrid').treegrid({
//		url:'sys/findAllMenu.action',
//		height:329,
//		//pagination:true,
//		toolbar:[{
//			text:'添加',
//			iconCls:'icon-add',
//			handler:addMenu
//		},'-',{
//			text:'修改',
//			iconCls:'icon-edit'
//		},'-',{
//			text:'删除',
//			iconCls:'icon-remove'
//		},'-',{
//			text:'刷新',
//			iconCls:'icon-reload'
//		}],
//		queryParams:{
//			'menu.menuParent':node['id']
//		},
//		idField:'id',
//		treeField:'menuName',
//		rownumbers:true,
//		columns:[[
//		          {field:'id',checkbox:true},
//		          {field:'menuName',title:'菜单名称',width:100},    
//		          {field:'menuUrl',title:'菜单路径',width:100},
//		          {field:'available', title:'是否可用', width:100,formatter:function(value){
//		        	  if(value === 0){
//		        		  return '不可用';
//		        	  }else if(value === 1){
//		        		  return '可用';
//		        	  }else{
//		        		  return '无效值';
//		        	  }
//		          }},
//		          {field:'createTime', title:'创建时间', width:120},
//		          {field:'updateTime', title:'最后修改时间', width:120},    
//		          {field:'description',title:'菜单描述',width:250}
//		      ]] 
//	});
	function addMenu(){
		menuDialog('添加菜单');
	}
	function menuDialog(title, fn){
		var dialog = $('<div>').dialog({
			title:title,
			modal:true,
			width:400,
			href:'system/menu.html',
			height:300
		});
	}
})(jQuery);