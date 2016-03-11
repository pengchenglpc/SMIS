(function($){
	$(function(){
		var procedureChart = echarts.init(document.getElementById('procedure'));
		$.get('production/analysisProduction.action', null, function(data){
			procedureChart.setOption({
				title : {
			        text: '工序责任统计',
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
			            //center: ['50%', '60%'],
			            data:data
			        }
			    ]
			});
		}, 'json');
		
	});
})(jQuery);