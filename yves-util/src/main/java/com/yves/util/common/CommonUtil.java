package com.yves.util.common;


import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 工具类
 * @author 李小君
 * @date 2012-4-18 下午02:42:59
 * @Description
 */
public class CommonUtil {
	
	//单号格式，后面几位数
	public static final int NUMBER_LENGTH = 2;
	
	public static final String EXE_STATUS = "EXE_STATUS" ;
	
	public static final String RESULT = "RESULT";

	public static final String ERROR_MSG = "ERROR_MSG" ;
	
	public static final String NUMBER_LENGTH_STRING = "00";
	
	public static final String MATERIADISTRIBUTION_NUMBER_PRIFEX = "A";
	
	public static final String FIXEDASSETSAPPLY_NUMBER_PRIFEX = "B";

	public static final String MATERIALMAINTAIN_NUMBER_PRIFEX = "C";
	
	public static final String MATERIALMOBILIZE_NUMBER_PRIFEX = "D";
	
	public static final String MATERIALSCRAPPED_NUMBER_PRIFEX = "E";
	
	public static final String NONASSETMAINTAIN_NUMBER_PRIFEX = "F";
	
	public static final String COSTADJUST_NUMBER_PRIFEX = "G";
	
	public static final String INITFIXEDASSETS_NUMBER_PRIFEX = "H";
	
	public final static String CUSTOMER_PREFIX="KH";//客户编号前缀
	
	public final static String COMPUTER_MAINTENANCE_GROUP = "电脑维护";
	
	public final static String CHIEF_COMPREHENSIVE = "行政专员";
	
	public final static String SYNERROR_SUCCESS = "1"; //同步成功
	
	public final static String SYNERROR_ERROR = "0"; //同步失败
	
	public final static String imageIp = "img2.qfang.com";

	public final static String[] imagesSize = new String[]{"800x600","320x240","600x600","100x75","190x110"};
	
	//有效天数为45天
	public static final int VALID = 90;
	
	public static final String SPLITEURL = "\\|\\|\\|";
	
	public static final String APPENDSPLITEURL = "|||";
	
	public static String loggerVisits(String number,String ip ,String houseLoggerVisits){
		StringBuilder builder = new StringBuilder();
		builder.append(CommonUtil.formatDate(CommonUtil.getCurrentDate()))
		.append("#").append(number)
		.append("#template")
		.append("#").append(houseLoggerVisits)
		.append("#").append(ip);
		return builder.toString();
	}
	
	public static List<String> getKeyNumbers(String prifex){
		List<String> reuslt = new ArrayList<String>();
		for(int i = 1 ; i <= 300  ; i++){
			String str = "00"+i;
			reuslt.add(prifex+str.substring(str.length() - 3));
		}
		return reuslt;
	}
	public static String convertImage(String url){
		if(CommonUtil.isEmpty(url))return "";
		return url.replace("i.image.qfang",imageIp);
	}
	public static boolean isEmpty(String value){
		return value == null || value.trim().length() == 0;
	}
	
	public static boolean isNotEmpty(String value){
		return !(value == null || value.trim().length() == 0);
	}
	
	public static boolean isEmpty(List list){
		return list == null || list.size() == 0;
	}

	public static boolean isEmpty(Map map){
		return map == null || map.size() == 0;
	}

	public static boolean isEmpty(Set set) {
		return set == null || set.size() == 0;
	}

	public static boolean isEmpty(Collection collection) {
		return collection == null || collection.size() == 0;
	}

	public static boolean isNotEmpty(Collection list){
		return !(list == null || list.size() == 0);
	}
	
	public static Date getCurrentDate(){
		return Calendar.getInstance().getTime();
	}
	
	public static Date getCurrentDate(String f) throws Exception{
		SimpleDateFormat format = new SimpleDateFormat(f);
		return format.parse(format.format(getCurrentDate()));
	}
	
	/**
	 * 获得月起始日
	 * @return
	 */
	public static String getCurrentMonthBegin(){
		Calendar cal = Calendar.getInstance();     
        cal.set(Calendar.YEAR ,  cal.get(Calendar.YEAR));     
        cal.set(Calendar.MONTH, cal.get(Calendar.MONDAY));     
        cal.set(Calendar.DAY_OF_MONTH,cal.getMinimum(Calendar.DATE));  
        return new SimpleDateFormat( "yyyy-MM-dd ").format(cal.getTime());  
	}

	/**
	 * 获得结束日
	 * @return
	 */
	public static String getCurrentMonthEnd(Date date){

		Calendar cal = Calendar.getInstance();
		if (null != date) {
			cal.setTime(date);
		}
		cal.set(Calendar.YEAR ,  cal.get(Calendar.YEAR));
		cal.set(Calendar.MONTH, cal.get(Calendar.MONDAY));
		cal.set(Calendar.DAY_OF_MONTH,cal.getActualMaximum(Calendar.DATE));
		return	new SimpleDateFormat( "yyyy-MM-dd ").format(cal.getTime());
	}
	
	/**
	 * 获得结束日
	 * @return
	 */
	public static String getCurrentMonthEnd(){
	   return getCurrentMonthEnd(null);
	}
	
	public static String formatDate(Date date){
		if(date == null)return null;
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
	}
	
	public static String formatDate(Date date,String format){
		if(date == null)return "";
		return new SimpleDateFormat(format).format(date);
	}
	
	public static String formatDateYMD(Date date){
		if(date == null) return null;
		return new SimpleDateFormat("yyyy-MM-dd").format(date);
	}
	
	public static Date parseDate(String time , String  fmt){
		if(CommonUtil.isEmpty(time))return null;
		try{
			return new SimpleDateFormat(fmt).parse(time);
		}catch(Exception e){
			return null;
		}
	}
	
	public static String getUrl(){
		// FTP服务器上的文件夹路径
		Calendar calendar = Calendar.getInstance();
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH);
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		String folderPath = "broker" + "/" + year + "/" + month + "/" + day;
		return folderPath;
	}


	public static String getAudioFileUrl(){
		// FTP服务器上的文件夹路径
		Calendar calendar = Calendar.getInstance();
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH);
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		String folderPath = "AudioFile/" + year + "/" + month + "/" + day;
		return folderPath;
	}

	public static String getHrPath(){
		Calendar calendar = Calendar.getInstance();
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH)+1;
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		String folderPath = "hr" + "/" + year + "/" + month + "/" + day;
		return folderPath;
	}
	
	public static String getComplaintUrl(){
		// FTP服务器上的文件夹路径
		Calendar calendar = Calendar.getInstance();
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH);
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		String folderPath = "net/complaint/" + "/" + year + "/" + month + "/" + day;
		return folderPath;
	}
	
	public static String replaceUrlSize(String url){
		if(CommonUtil.isEmpty(url))return url;
		return url.replace("{size}","original");
	}
	
	public static String replaceUrlOriginalToSize(String url){
		if(CommonUtil.isEmpty(url))return url;
		return url.replace("original","{size}");
	}
	
	public static String replaceUrlSize100x135(String url){
		if(CommonUtil.isEmpty(url))return url;
		return url.replace("original","100x135");
	}
	
	public static String replaceUrlSizeOriginal(String url){
		if(CommonUtil.isEmpty(url))return url;
		return url.replace("100x135","original");
	}
	
	
	public static String getString(Map<String, Object> requestMap,String key){
		Object val = requestMap.get(key);
		return val == null ? null : ("".equals(val.toString()) ? "" : StringUtil.html(val.toString()));
	}
	
	public static String getString(Map<String, Object> requestMap,String key , boolean bool){
		Object val = requestMap.get(key);
		return val == null ? null : (bool ? StringUtil.html(val.toString()) : val.toString()); 
	}
	
	public static int getInt(Map<String, Object> requestMap,String key){
		if(!requestMap.containsKey(key))return 0;
		Object obj = requestMap.get(key);

		if (null == obj) return 0;

		if (obj instanceof String){
			String val = String.valueOf(obj == null ? "0" : obj);
			return CommonUtil.isEmpty(val) ? 0 : Integer.parseInt(val);
		}else{
			return (Integer)obj;
		}
	}
	
	public static Double getDouble(Map<String, Object> requestMap,String key){
		if(!requestMap.containsKey(key))return null;
		Object obj = requestMap.get(key);
		if(obj instanceof String){
			String o =  (String)obj;
			return CommonUtil.isEmpty(o)  ? null : Double.parseDouble(o);
		}else if(obj instanceof BigDecimal){
			return ((BigDecimal) obj).doubleValue();
		}
		else{
			return (Double)obj;
		}
	}

	public static boolean getBool(Map<String, Object> requestMap,String key){
		String value = getString(requestMap,key);
		return ("true".equalsIgnoreCase(value)) ||
				("1".equals(value) ||
				("Y".equals(value)) ||
				("on".equals(value)));
	}
	
	public static boolean equals(String begin,String end){
		if(CommonUtil.isEmpty(begin) || "null".equals(begin) || "undifined".equals(begin))begin = "";
		if(CommonUtil.isEmpty(end) || "null".equals(end) || "undifined".equals(end) )end = "";
		return begin.equals(end);
	}
	
	public static Object format(Object value){
		if(value  != null && value instanceof String){
			if(value.toString().equals("undifined") 
					|| value.toString().equals("null")
					)return null;
			
		}
		return value;
	}
	
	
	public static String fmtValue(String Value){
		 Pattern p = Pattern.compile("\\t|\r|\n"); 
		 Matcher m = p.matcher(Value); 
		 return m.replaceAll(""); 
	}
	
	public static String formatBigDecimal(Object value){
		return formatBigDecimal(value, "0");
	}

	public static String formatBigDecimal(Object value , String fmt){
	    if (null == value) {
	        return "0";
	    }
	    
		DecimalFormat format = new DecimalFormat(fmt);
		return format.format(value);
	}

	public static String formatBigDecimal(Object value , String fmt,boolean defaultFmt){
		if (null == value) {
			if(defaultFmt){
				value = 0;
			}else {
				return "0";
			}
		}

		DecimalFormat format = new DecimalFormat(fmt);
		return format.format(value);
	}

	/**  
     * 产生一个任意长度的随机数
     * @param len 长度  
     * @return 
     */   
    public static String genRandomNum(int len) {   
        int maxNum = 10;   
        int i;    
        int count = 0; 
        char[] str = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };   
        StringBuffer num = new StringBuffer("");   
        Random r = new Random();   
        while (count < len) {   
            // 生成随机数，取绝对值，防止生成负数，    生成的数最大为36-1  
            i = Math.abs(r.nextInt(maxNum)); 
            if (i >= 0 && i < str.length) {   
                num.append(str[i]);   
                count++;   
            }   
        }   
        return num.toString();   
    }
    
    public static List<String> converList(String[] array){
    	List<String> result = new ArrayList<String>();
    	if(array !=null){
    		for(String id : array){
    			result.add(id);
    		}
    	}
    	return result;
    }

	public static float processNameWeights(String name){
		float n1  = 0; 
		if(name==null || "".equals(name)){
			return n1;
		}
		char[] sc1 =  name.toCharArray();
		for(char c : sc1){
			int intval = (int)c;
			BigDecimal s1 = new BigDecimal(intval).movePointLeft((intval+"").length() -1);
			n1 += s1.floatValue();
		}
		return new BigDecimal(n1)
						.movePointLeft((new BigDecimal(n1).intValue()+"").length() - 1)
						.setScale(5,BigDecimal.ROUND_HALF_UP).floatValue();
	}
	

	public static Map<String, String> urldecode(String repString) throws UnsupportedEncodingException {
        Map<String, String> repData = new LinkedHashMap<String, String>();
        for (String kvs : repString.split("&")) {
            String[] kv = kvs.split("=");
            if (kv.length == 2) {
                repData.put(kv[0], URLDecoder.decode(kv[1], "UTF-8"));
            }
        }
        return repData;
    }
	
	public static String urlencode(Map<String, String> reqParams) {
        StringBuffer sb = new StringBuffer();
        for (Map.Entry<String, String> reqItem : reqParams.entrySet()) {
            if (sb.length()>0) {
                sb.append('&');
            }
            String value = null;
            try {
                value = URLEncoder.encode(reqItem.getValue(), "UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            sb.append(reqItem.getKey()).append('=').append(value);
        }
        return sb.toString();
}
    

	public static String formatSecond(Integer second){
		if(second  == null ||  second.intValue() == 0) return "0秒";
		int _s = second.intValue() % 60;
		int _m = second.intValue() / 60;
		String _str = "";
		if(_m > 0) _str += _m + "分";
		if(_s > 0) _str += _s + "秒";
		return _str;
	}
	

	

	public static String checkNull(Object obj) {
		return obj == null ? "" : obj.toString();
	}
	
	
	public static boolean isMp3(String url){
		return isNotEmpty(url) && url.indexOf("mp3") != -1;
	}
	
	public static String formatViewDate(Date date){
		if(date == null)return "";
		Date now = DateUtil.getCurrentDate();
		
		//今天
		if(DateUtil.formatYMD(date).equals(DateUtil.formatYMD(now))){
			return  "今天"+DateUtil.format(date, "HH:mm:ss");
		}
		
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_YEAR, -1);
		
		if(DateUtil.formatYMD(date).equals(DateUtil.formatYMD(calendar.getTime()))){
			return  "昨天"+DateUtil.format(date, "HH:mm:ss");
		}
		
		return DateUtil.format(date, DateUtil.TIME_PATTERN_24);
	}
	
	
	public static String formatViewDateMobile(Date date){
		if(date == null)return "";
		Date now = DateUtil.getCurrentDate();
		
		//今天
		if(DateUtil.formatYMD(date).equals(DateUtil.formatYMD(now))){
			return  ""+DateUtil.format(date, "HH:mm");
		}
		
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_YEAR, -1);
		
		if(DateUtil.formatYMD(date).equals(DateUtil.formatYMD(calendar.getTime()))){
			return  "昨天 "+DateUtil.format(date, "HH:mm");
		}
		
		calendar.add(Calendar.DAY_OF_YEAR, -1);

		if(DateUtil.formatYMD(date).equals(DateUtil.formatYMD(calendar.getTime()))){
			return  "前天 "+DateUtil.format(date, "HH:mm");
		}
		
		
		if(DateUtil.format(date, "yyyy").equals(DateUtil.format(now, "yyyy"))){
			return  ""+DateUtil.format(date, "MM月dd日 HH:mm");
		}
		
		return DateUtil.format(date, DateUtil.TIME_PATTERN_24_YMDHM);
	}


	/**
	 * V3.10 时间格式统一 ,［二天内时间］今天 10:22、昨天10:22；［当年时间］月日时分，5-12 10:22；［跨年时间］年月日时分，2016-5-12 10:20
	 * @param date
	 * @return
	 */
	public static String formatDateForMobile(Date date){
		if(date == null)return "";
		Date now = DateUtil.getCurrentDate();

		//今天
		if(formatDateYMD(date).equals(formatDateYMD(now))){
			return  "今天 "+DateUtil.format(date, "HH:mm");
		}

		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_YEAR, -1);

		if(formatDateYMD(date).equals(formatDateYMD(calendar.getTime()))){
			return  "昨天 "+DateUtil.format(date, "HH:mm");
		}


		if(DateUtil.format(date, "yyyy").equals(DateUtil.format(now, "yyyy"))){
			return  ""+DateUtil.format(date, "MM月dd日 HH:mm");
		}

		return DateUtil.format(date, DateUtil.TIME_PATTERN_24_YMDHM);
	}

	/**
	 * V3.11 交易报告时间格式  ,［二天内时间］今天  、昨天 ；［当年时间］月日 ，5-12  ；［跨年时间］年月日 ，2016-5-12
	 * @param date
	 * @return
	 */
	public static String formatDateForMobile2(Date date){
		if(date == null)return "";
		Date now = DateUtil.getCurrentDate();

		//今天
		if(formatDateYMD(date).equals(formatDateYMD(now))){
			return  "今天 ";
		}

		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_YEAR, -1);

		if(formatDateYMD(date).equals(formatDateYMD(calendar.getTime()))){
			return  "昨天 ";
		}

/*		calendar.add(Calendar.DAY_OF_YEAR, -1);

		if(DateUtil.formatYMD(date).equals(DateUtil.formatYMD(calendar.getTime()))){
			return  "前天 "+DateUtil.format(date, "HH:mm");
		}*/


		if(DateUtil.format(date, "yyyy").equals(DateUtil.format(now, "yyyy"))){
			return  ""+DateUtil.format(date, "MM-dd");
		}

		return DateUtil.format(date, DateUtil.DATE_PATTERN);
	}

	/**
	 * 时间格式,每个产品需要不一样的的格式。呵呵！！！
	 * ［当年时间］月日，5-12 ；［跨年时间］年月日，2016-5-12
	 * @param date
	 * @return
	 */
	public static String formatDateForMobile3(Date date){
		if(date == null)return "";
		Date now = DateUtil.getCurrentDate();

		if(DateUtil.format(date, "yyyy").equals(DateUtil.format(now, "yyyy"))){
			return  ""+DateUtil.format(date, "MM-dd");
		}

		return DateUtil.format(date, DateUtil.DATE_PATTERN);
	}

	/**
	 * 时间格式,每个产品需要不一样的的格式。呵呵！！！
	 * ［当年时间］月日，5-12 12:12:12 ；［跨年时间］年月日，2016-5-12 12:12:12
	 * @param date
	 * @return
	 */
	public static String formatDateForMobile4(Date date){
		if(date == null)return "";
		Date now = DateUtil.getCurrentDate();

		if(DateUtil.format(date, "yyyy").equals(DateUtil.format(now, "yyyy"))){
			return  ""+DateUtil.format(date, "MM-dd HH:mm:ss");
		}

		return DateUtil.format(date, DateUtil.TIME_PATTERN_24);
	}

	public static  String formatDateUTC(Date time) {
		if(time == null)return null;
		DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss:SSS'Z'");
		sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
		return sdf.format(time);
	}
	public static  String getTmpdir(){
		String dir = System.getProperty("java.io.tmpdir");
		return dir.endsWith("/") ? dir : dir +"/";
	}


	/**
	 * 获取FTP服务器上的文件夹路径
	 * <p>eg: broker/2015/1/1</p>
	 * @param subject 主题
	 * @return url
	 */
	public static String getFolderPath(String subject){
		String tmp=subject;
		if(subject==null) {
			tmp = "";
		}
		// FTP服务器上的文件夹路径
		Calendar calendar = Calendar.getInstance();
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH);
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		return tmp + "/" + year + "/" + month + "/" + day;
	}
	
    /**
     * @MethodName endWithPunctuation
     * @Description 判断一个字符串是否以标点符号结尾
     * 
     * @author zhangliancai
     * @date 2016年7月12日 上午11:23:25
     * @param str
     * @return
     */
    public static boolean endsWithPunctuation(String str) {
        if (isEmpty(str)) {
            return false;
        }
        
        Pattern patPunc = Pattern.compile("[!;,.?！；。，、？]$");
        
        Matcher matcher = patPunc.matcher(str);
        
        return matcher.find();
    }
    
    /**
     * @MethodName Html2TextArea
     * @Description Html转换为TextArea文本:编辑时拿来做转换
     * 
     * @author zhangliancai
     * @date 2016年9月22日 下午3:04:38
     * @param str
     * @return
     */
    public static String Html2TextArea(String str) {
        if (isEmpty(str)) {
            return "";
        }
        
        str = str.replaceAll("<br />", "\n");
//        str = str.replaceAll("<br />", "\r");
        return str;
    }
    
    /**
     * @MethodName TextArea2Html
     * @Description TextArea文本转换为Html:写入数据库时使用
     * 
     * @author zhangliancai
     * @date 2016年9月22日 下午3:04:55
     * @param str
     * @return
     */
    public static String TextArea2Html(String str) {
        if (isEmpty(str)) {
            return "";
        } 
        
        str = str.replaceAll("\n", "<br />");
//        str = str.replaceAll("\r", "<br />");
        return str;
    }





	//截取数字
	public static String getNumbers(String content) {
		Pattern pattern = Pattern.compile("\\d+");
		Matcher matcher = pattern.matcher(content);
		while (matcher.find()) {
			return matcher.group(0);
		}
		return "";
	}

	public boolean isNum(String str){
		Pattern pattern = Pattern.compile("[0-9]*");
		Matcher isNum = pattern.matcher(str);
		return isNum.matches();
	}

	public boolean isLetter(String str){
		Pattern pattern = Pattern.compile("[a-zA-Z]*");
		Matcher isLetter = pattern.matcher(str);
		return isLetter.matches();
	}

	public static <T> Set buildSet(T t) {
		Set<T> set = new HashSet<>();
		set.add(t);
		return set;
	}

	public static <T> List buildList(T t) {
		List<T> list = new ArrayList<>();
		list.add(t);
		return list;
	}

	public static Set buildEmptySet() {
		return new HashSet();
	}

	/**
	 * 根据开始结束日期拿到所有的，日期map
	 * @param beginDate
	 * @param endDate
	 * @param keyFmt
	 * @param valueFmt
	 * @return
	 */
	public static LinkedHashMap<String,String> getRangeDayMap(Date beginDate,Date endDate,String keyFmt,String valueFmt){
		LinkedHashMap<String,String> resultMap = new LinkedHashMap<>();
		if(beginDate == null || endDate == null) return resultMap;
		if(StringUtil.isEmpty(keyFmt)){
			keyFmt = DateUtil.DATE_FORMAT_FOR_YMD;
		}
		if(StringUtil.isEmpty(valueFmt)){
			valueFmt = DateUtil.DATE_FORMAT_FOR_YMD;
		}
		int dayDiff = DateUtil.daysBetween(endDate,beginDate);
		Calendar beginCalendar = Calendar.getInstance();
		beginCalendar.setTime(beginDate);
		for(int i=0;i<dayDiff;i++){
			String key = formatDate(beginCalendar.getTime(),keyFmt);
			String value = formatDate(beginCalendar.getTime(),valueFmt);
			resultMap.put(key,value);
			beginCalendar.add(Calendar.DATE, 1);
		}
		return  resultMap;
	}

	/**
	 * 根据开始结束日期拿到所有的月 map
	 * @param beginDate
	 * @param endDate
	 * @param keyFmt
	 * @return
	 */
	public static LinkedHashMap<String,String> getRangeMonthMap(Date beginDate,Date endDate,String keyFmt){
		LinkedHashMap<String,String> resultMap = new LinkedHashMap<>();
		if(beginDate == null || endDate == null) return resultMap;
		if(StringUtil.isEmpty(keyFmt)){
			keyFmt = DateUtil.DATE_FORMAT_FOR_YMD;
		}
		int monthDiff = DateUtil.getMonths(beginDate,endDate) + 1;
		Calendar beginCalendar = Calendar.getInstance();
		beginCalendar.setTime(beginDate);
		for(int i=0;i<monthDiff;i++){
			String key = formatDate(beginCalendar.getTime(),keyFmt);
			String[] values = key.split("-");
			resultMap.put(key,values[0] + "年"+ values[1]+"月");
			beginCalendar.add(Calendar.MONTH, 1);
		}
		return  resultMap;
	}


	public static int getWeekNumByYear(int year){
		if(year<1900 || year >9999){
			throw new NullPointerException("年度必须大于等于1900年小于等于9999年");
		}
		int result = 52;//每年至少有52个周 ，最多有53个周。
		String date = getYearWeekFirstDay(year,53);
		if(date.substring(0, 4).equals(year+"")){ //判断年度是否相符，如果相符说明有53个周。
			result = 53;
		}
		return result;
	}
	/**
	 * 等到当期时间的周系数。
	 * 星期日：1，
	 * 星期一：2，
	 * 星期二：3，
	 * 星期三：4，
	 * 星期四：5，
	 * 星期五：6，
	 * 星期六：7
	 */
	public static Integer getDayForWeek(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.DAY_OF_WEEK);
	}


	/**
	 * 计算某年某周的开始日期
	 * @param yearNum 格式 yyyy  ，必须大于1900年度 小于9999年
	 * @param weekNum 1到52或者53
	 * @return 日期，格式为yyyy-MM-dd
	 */
	public static String getYearWeekFirstDay(int yearNum,int weekNum)  {
		DateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		if(yearNum<1900 || yearNum >9999){
			throw new NullPointerException("年度必须大于等于1900年小于等于9999年");
		}
		Calendar cal = Calendar.getInstance();
		cal.setFirstDayOfWeek(Calendar.MONDAY); //设置每周的第一天为星期一
		cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);//每周从周一开始
//       上面两句代码配合，才能实现，每年度的第一个周，是包含第一个星期一的那个周。
		cal.setMinimalDaysInFirstWeek(7);  //设置每周最少为7天
		cal.set(Calendar.YEAR, yearNum);
		cal.set(Calendar.WEEK_OF_YEAR, weekNum);
		//分别取得当前日期的年、月、日
		return sdf.format(cal.getTime());
	}

	public static String formatDayExpression(Date date){
		if(date == null)return null;
		Date current = getCurrentDate();
		DecimalFormat format = new DecimalFormat("#");
		double second = (current.getTime() - date.getTime()) / 1000.0;
		if(second <= 0)return "1秒前";
		if(second < 60)return format.format(Math.floor(second))+"秒前";
		double minute = second / 60.0;
		if(minute < 60)return format.format(Math.floor(minute))+"分钟前";
		double hour = minute / 60.0;
		if(hour < 24) return format.format(Math.floor(hour))+"小时前";
		if(hour < 48) return "昨天";
		double day = hour / 24.0;
		if(day < 181) return format.format(Math.floor(day))+"天前";
		if(day < 366) return "半年前";
		if(day < 731) return "一年前";
		return format.format(Math.floor(day / 365.0))+"年前";
	}


	public static BigDecimal divide(BigDecimal one, BigDecimal two,Integer setPrecision){
		if(one == null || two == null || two.doubleValue() == 0) return null;
		BigDecimal decimal = one.divide(two,setPrecision,BigDecimal.ROUND_HALF_UP);

		return decimal;
	}
	public static Object formatDoubleTwo(Double s){
		DecimalFormat  df = new DecimalFormat("######0.00");
		return df.format(s);
	}
	public static Double formatDoubleOne(Double s){
		DecimalFormat  df = new DecimalFormat("######0.0");
		return Double.parseDouble(df.format(s));
	}

	public static void main(String[] args) {
//		double number = divide(new BigDecimal("10"),new BigDecimal("3.5"),2).doubleValue();
//		Double a = null;
//		String s = (String) CommonUtil.formatDoubleTwo(1111.2222 );
//		System.out.println(s);
//		System.err.println(a+0);

		Date begin = parseDate("2018-03-09 23:59:59","yyyy-MM-dd HH:mm:ss");
		Date end = parseDate("2018-03-11 23:59:58","yyyy-MM-dd HH:mm:ss");

		double day = DateUtil.getMinuteDiff(begin,end) / 60.0 / 24;

		System.err.println(day);
	}
}
