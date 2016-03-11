(function($){
	$(function(){
		
		
	});
	window.analysis = function(){
		var productNo = $('#produceNo').combobox('getValue');
		var working = $('#working').combobox('getValue');
		if(!productNo){
			$.messager.alert("提示", "请选择生产单号");
			return;
		}
		if(!working){
			$.messager.alert("提示", "请选择工序");
			return;
		}
		var procedureChart = echarts.init(document.getElementById('procedure'));
		$.get('production/analysisProduction.action', {
			'plan.comtinueNo':productNo,
			'plan.working':working
		}, function(data){
			procedureChart.setOption({
				title : {
			        text: working + '责任统计',
			        //subtext: '纯属虚构',
			        x:'center'
			    },
			    legend: {
			        orient: 'vertical',
			        left: 'left',
			        formatter:function(name){
			        	var total = 0,
			        		current = 0;
			        	for(var i = 0; i < data.length; i++){
			        		total += data[i]['value'];
			        		if(name === data[i]['name']){
			        			current = data[i]['value'];
			        		}
			        	}
			        	return name + ":" + current + '(' + ((current / total) * 100).toFixed(2) + '%)';
			        },
			        data: data
			    },
			    series : [
			        {
			            name: '工序责任统计',
			            type: 'pie',
			            radius: '75%',
			            center: ['50%', '60%'],
			            data:data
			        }
			    ]
			});
		}, 'json');
	}
})(jQuery);