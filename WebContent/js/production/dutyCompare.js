(function($){
	$(function(){
		var year = new Date().getFullYear();
		var yearData = [];
		for(var i = 0; i < 10; i++){
			var _year = year--;
			yearData.push({
				name:_year + '年',
				value:_year
			});
		}
		$('#yearCombo').combobox({data:yearData});
		
		
	});
	window.dutytAnalysis = function(){
		var dept = $('#dutyDept').combobox('getValue'),
			productNo = $('#dutyProduceNo').combobox('getValue'),
			year = $('#yearCombo').combobox('getValue'),
			quarter = $('#quarterCombo').combobox('getValue'),
			way = $('#duty_search_form input[type=radio][name=analysisType]:checked').val();
		debugger
		$.get('production/dutyCompareProduction.action', {
			'plan.comtinueNo':productNo,
			//'plan.working':working,
			'plan.department':dept,
			'plan.year':year,
			'plan.quarter':quarter,
			'plan.way':way
		}, function(data){
			var _datas = data['data'],
				series = [];
			for(var key in _datas){
				var _data = _datas[key];
				series.push({
		            name: key,
		            type: 'bar',
		            markLine : {
		                lineStyle: {
		                    normal: {
		                        type: 'dashed'
		                    }
		                }
		            },
//		            stack: '总量',
//		            label: {
//		                normal: {
//		                    show: true,
//		                    position: 'insideRight'
//		                }
//		            },
		            data: _data
		        });
			}
			var dutyCompare = echarts.init(document.getElementById('dutyCompare')),
			option = {
			    tooltip : {
			        trigger: 'axis',
			        axisPointer : {            // 坐标轴指示器，坐标轴触发有效
			            type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
			        }
			    },
			    legend: {
			        data: data['technology']
			    },
			    grid: {
			        left: '3%',
			        right: '4%',
			        bottom: '3%',
			        containLabel: true
			    },
			    yAxis:  {
			        type: 'value'
			    },
			    xAxis: {
			        type: 'category',
			        data: data['month']
			    },
			    series: series
			};
		dutyCompare.setOption(option);
		}, 'json');
	}
})(jQuery);