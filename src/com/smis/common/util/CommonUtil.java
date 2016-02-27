package com.smis.common.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class CommonUtil {
	
	/**
	 * 生成UUID 
	 * @return
	 */
	public static String id(){
		UUID uuid = UUID.randomUUID();
		return uuid.toString().replace("-", "");
	}
	
	
	/**
	 * 获取当前时间
	 * @return
	 */
	public static Date getCurrentDate(){
		return new Date();
	}
	
	/**
	 * 使用默认的日期格式yyyy-MM-dd HH:mm:ss进行时间格式化
	 * @param date
	 * @return
	 */
	public static String dateFormat(Date date){
		return dateFormat(date, "yyyy-MM-dd HH:mm:ss");
	}
	/**
	 * 格式化时间
	 * @param date
	 * @param format
	 * @return
	 */
	public static String dateFormat(Date date, String format){
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(date);
	}
	public static void main(String[] args) {
		System.out.println(id());
	}
}
