package Tools.dateTimes;

import java.util.Calendar;

public class yearmonth {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		java.text.SimpleDateFormat format = new java.text.SimpleDateFormat("yyyyMM");
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MONTH,-1);
       System.out.println( format.format(cal.getTime()));

	}

}
