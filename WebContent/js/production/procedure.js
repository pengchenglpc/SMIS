(function($){
	$(function(){
		
		
	});
	window.analysis = function(){
		var productNo = $('#produceNo').combobox('getValue'),
			working = $('#working').combobox('getValue'),
			dept = $('#dept').combobox('getValue'),
			startDate = $('#startDate').datebox('getValue'),
			endDate = $('#endDate').datebox('getValue');
		
		if(startDate && !endDate){
			$.messager.alert("提示", "请选择结束时间");
			return;
		}
		
		if(!startDate && endDate){
			$.messager.alert("提示", "请选择开始时间");
			return;
		}
		
		if(startDate > endDate){
			$.messager.alert("提示", "开始时间不能大于结束时间");
			return;
		}
		var procedureChart = echarts.init(document.getElementById('procedure'));
		$.get('production/analysisProduction.action', {
			'plan.comtinueNo':productNo,
			'plan.working':working,
			'plan.department':dept,
			'plan.startDate':startDate,
			'plan.endDate':endDate
		}, function(data){
			procedureChart.setOption({
				title : {
			        text: '工序问题统计',
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
			            center: ['60%', '55%'],
			            data:data
			        }
			    ]
			});
		}, 'json');
	}
})(jQuery);