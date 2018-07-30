package com.pmd.test.demo;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Commonutils for sweep striim
 */
final public class CommonUtil {

	/**
	 * Logger Added
	 */
	private final static Logger LOGGER = LoggerFactory.getLogger(CommonUtil.class);
	
	

	/**
	 * Private Constructor
	 */
	private CommonUtil() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	/**
	 * Converts string to big decimal
	 * 
	 * @param val
	 *            to be converted
	 * @return {@link BigDecimal} value or ZERO if val is invalid numeric string
	 */
	public static BigDecimal getNumericVal(final String val) {
		return Optional.ofNullable(val).map(value -> new BigDecimal(value)).orElse(BigDecimal.ZERO);
	}

	/**
	 * Converts string to boolean
	 * 
	 * @param val
	 *            to be converted
	 * @return {@link Boolean} value or FALSE if val is invalid string
	 */
	public static Boolean getBooleanVal(final String val) {
		return Optional.ofNullable(val).map(value -> Boolean.valueOf(value)).orElse(Boolean.FALSE);
	}

	/**
	 * Checking Empty String
	 * 
	 * @param val
	 *            to be converted
	 * @return {@link Boolean} value or FALSE if val is invalid string
	 */

	public static Boolean isEmptyCheck(final String val) {
		
		if (val != null && val.length() == 0 &&  val.isEmpty()) {
			return true;
		}
		return false;
	}

	/**
	 * Split Data
	 * 
	 * @param data
	 *            to be converted
	 * @param delimiter
	 *            to be converted
	 * @return {@link List<String>} value or null if val is invalid string
	 */

	public static List<String> getSplitDataWithStrem(final String data, final String delimiter) {
		return Stream.of(data.split(delimiter)).map(elem -> String.valueOf(elem)).collect(Collectors.toList());

	}

	/**
	 * Split Data
	 * 
	 * @param data
	 *            to be converted
	 * @param delimiter
	 *            to be converted
	 * @return {@link List<String>} value or null if val is invalid string
	 */
	public static List<String> getSplitData(final String data, final String delimiter)
	{
		LOGGER.debug("Entering getSplitData...");
		final List<String> dataList = new ArrayList<>();
		final String[] splittedData = data.split(delimiter);
		for (final String str : splittedData) {
			dataList.add(str);
		}
		LOGGER.debug("Leaving getSplitData...");
		return dataList;
	}

	/**
	 * Date Formatting
	 * 
	 * @param dateTime
	 *            datetime
	 * @param fromDateFormat
	 *            dateFormat
	 * @param toDateFormat
	 *            dateFormat
	 * @return {@link String} get formated datetime
	 */

	public static String dateFormatter(final String dateTime, final String fromDateFormat, final String toDateFormat)
			throws ParseException {
		LOGGER.debug("Entering dateFormatter...");
		final String outFormat ;
		if (isEmptyCheck(dateTime) && isEmptyCheck(fromDateFormat) && isEmptyCheck(toDateFormat)) {
			final Date date = new SimpleDateFormat(fromDateFormat,Locale.getDefault()).parse(dateTime);
			final SimpleDateFormat simpleDateFormat = new SimpleDateFormat(toDateFormat,Locale.getDefault());
			outFormat = simpleDateFormat.format(date);
		}
		else
		{
			outFormat=null;
		}
		LOGGER.debug("Leaving dateFormatter...");
		return outFormat;
	}
	
	/** Check field value is null or not
	 * @param args The arguments
	 * @return boolean Return the result
	 */
	public static boolean checkObjectNull(final String... args) {
		boolean isObjectNull = true;
		for (final String arg : args) {
			if(arg != null){
				isObjectNull = false;
				break;
			}
		}
		return isObjectNull;
	}

	/** Check field value is null or not
	 * @param arg The argument
	 * @return boolean Return the result
	 */
	public static boolean checkNull(final String arg) {
		if(arg != null && !arg.isEmpty() && arg.equals("")) {
			return false;
		}
		return true;
	}

	/**
	 * Main Class To Tests
	 * 
	 * @param args
	 *            to be converted
	 * @return {@link Void}
	 */
	public static void main(final String[] args) throws ParseException {
		LOGGER.debug(

				dateFormatter("2018/07/09 13:26:59.000", "yyyy/MM/dd hh:mm:ss.SSS", "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"));

	}
	


}
