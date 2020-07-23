package vn.woodsland.byserp.framework.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

/**
 * General date manipulation utilities.
 */
public class Dates {

	private Dates() {
	}

	/**
	 * Retrieve date now
	 *
	 * @return {@link Date} now
	 */
	public static Date now() {
		return new Date();
	}

	/**
	 * parse String source to date with format pattern and time zone
	 *
	 * @param source   date String
	 * @param format   pattern convert
	 * @param timeZone time zone
	 * @return the Date {@link Date}
	 */
	public static Date parseExact(final String source, final String format, final TimeZone timeZone) {
		SimpleDateFormat formatter = new SimpleDateFormat(format);
		if (timeZone != null) {
			formatter.setTimeZone(timeZone);
		}
		formatter.setLenient(false);
		try {
			return formatter.parse(source);
		} catch (ParseException ex) {
			throw new IllegalArgumentException(ex);
		}
	}

	/**
	 * this method to check if the date is between the start date and the end date
	 *
	 * @param date      the date
	 * @param startDate the start date
	 * @param endDate   the end date
	 * @return true if the date is between the start date & end date
	 */
	public static boolean isWithinRange(Date date, Date startDate, Date endDate) {
		return !(date.before(startDate) || date.after(endDate));
	}

	/**
	 * this method is used to check if the date (string) is between the start date (string) and the end date (string)
	 *
	 * @param dateStr      the date (string)
	 * @param startDateStr the start date (string)
	 * @param endDateStr   the end date (string)
	 * @return true if the date (string) is between the start date & end date
	 */
	public static boolean isWithinRange(String dateStr, String startDateStr, String endDateStr) {
		return dateStr.compareTo(startDateStr) >= 0 && dateStr.compareTo(endDateStr) <= 0;
	}

	/**
	 * format Date to String with format pattern
	 *
	 * @param source the Date
	 * @param format the pattern
	 * @return the String
	 */
	public static String format(final Date source, final String format) {
		return format(source, format, null);
	}

	/**
	 * Format date with pattern format anf time zone
	 *
	 * @param source   the date String
	 * @param format   the pattern
	 * @param timeZone the time zone
	 * @return the String
	 */
	public static String format(final Date source, final String format, final TimeZone timeZone) {
		if (source == null) {
			return null;
		}
		if (format == null || format.length() == 0) {
			return null;
		}

		SimpleDateFormat sdf = new SimpleDateFormat(format);
		if (timeZone != null) {
			sdf.setTimeZone(timeZone);
		}
		return sdf.format(source);
	}


	/**
	 * Parse string date to date in format pattern
	 *
	 * @param source the date String
	 * @param format the pattern
	 * @return the Date {@link Date}
	 */
	public static Date parseExact(final String source, final String format) {
		return parseExact(source, format, null);
	}

	/**
	 * Get minutes between 2 date
	 *
	 * @param date1 the date value
	 * @param date2 the date value
	 * @return minutes between 2 date
	 */
	public static int getMinutesBetweenTwoDate(Date date1, Date date2) {
		return (int) TimeUnit.MINUTES.convert(Math.abs(date1.getTime() - date2.getTime()), TimeUnit.MINUTES);
	}
}
