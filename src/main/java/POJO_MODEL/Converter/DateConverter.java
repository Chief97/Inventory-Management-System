package POJO_MODEL.Converter;
import java.sql.Date;
import java.text.SimpleDateFormat;
public class DateConverter {
	public static Date getSqlDateFromString(String date) {
		java.util.Date date1 = null;
		try {
			date1 = new SimpleDateFormat("yyyy-MM-dd").parse(date);
		} catch (Exception e) {
			System.out.println("Date stuff wrong...");
			e.printStackTrace();
		}
		Date date01 = new java.sql.Date(date1.getTime());
		
		return date01;
	}

}
