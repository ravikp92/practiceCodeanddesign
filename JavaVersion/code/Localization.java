package code;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class Localization {

	public static void main(String[] args) throws ParseException {
		double a=2300.01;
		System.out.println(NumberFormat.getInstance().format(a));
		System.out.println(NumberFormat.getNumberInstance(Locale.US).format(a));
		System.out.println(NumberFormat.getCurrencyInstance(Locale.GERMANY).format(a));
		
		
		String usnumber="23,000.01";
		String uscurncy="$23.22";
		System.out.println(NumberFormat.getNumberInstance(Locale.US).parse(usnumber));
		System.out.println(NumberFormat.getCurrencyInstance(Locale.US).parse(uscurncy));

		double n=77_000.17;
		System.out.println(new DecimalFormat("$#,##,###.##").format(n));
		
		LocalDateTime ldt=LocalDateTime.now();
		System.out.println("LDT IS :"+ldt);
		DateTimeFormatter dateTimeUS=DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM);
		System.out.println(dateTimeUS.withLocale(Locale.US).format(ldt));
		DateTimeFormatter dateTimeUS1=DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
		System.out.println(dateTimeUS1.withLocale(Locale.US).format(ldt));
		DateTimeFormatter dateTimeUS4=DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG);
		System.out.println(dateTimeUS4.withLocale(Locale.US).format(ldt));
		DateTimeFormatter dateTimeUS2=DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
		System.out.println(dateTimeUS2.withLocale(Locale.US).format(ldt));
		
		DateTimeFormatter TimeUS2=DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT);
		System.out.println(TimeUS2.withLocale(Locale.US).format(ldt));
		
		
		
		
		
		


	}
}
