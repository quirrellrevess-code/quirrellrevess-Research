package javax.mail.internet;

import java.text.FieldPosition;
import java.text.NumberFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes.dex */
public class MailDateFormat extends SimpleDateFormat {
    public static boolean debug = false;
    private static final long serialVersionUID = -8148227605210628779L;

    /* JADX INFO: renamed from: tz */
    private static TimeZone f865tz = TimeZone.getTimeZone("GMT");
    private static Calendar cal = new GregorianCalendar(f865tz);

    public MailDateFormat() {
        super("EEE, d MMM yyyy HH:mm:ss 'XXXXX' (z)", Locale.US);
    }

    private static synchronized Date ourUTC(int i, int i2, int i3, int i4, int i5, int i6, int i7, boolean z) {
        cal.clear();
        cal.setLenient(z);
        cal.set(1, i);
        cal.set(2, i2);
        cal.set(5, i3);
        cal.set(11, i4);
        cal.set(12, i5 + i7);
        cal.set(13, i6);
        return cal.getTime();
    }

    private static Date parseDate(char[] cArr, ParsePosition parsePosition, boolean z) throws java.text.ParseException {
        try {
            MailDateParser mailDateParser = new MailDateParser(cArr);
            mailDateParser.skipUntilNumber();
            int number = mailDateParser.parseNumber();
            if (!mailDateParser.skipIfChar('-')) {
                mailDateParser.skipWhiteSpace();
            }
            int month = mailDateParser.parseMonth();
            if (!mailDateParser.skipIfChar('-')) {
                mailDateParser.skipWhiteSpace();
            }
            int number2 = mailDateParser.parseNumber();
            if (number2 < 50) {
                number2 += 2000;
            } else if (number2 < 100) {
                number2 += 1900;
            }
            mailDateParser.skipWhiteSpace();
            int number3 = mailDateParser.parseNumber();
            mailDateParser.skipChar(':');
            int number4 = mailDateParser.parseNumber();
            int timeZone = 0;
            int number5 = mailDateParser.skipIfChar(':') ? mailDateParser.parseNumber() : 0;
            try {
                mailDateParser.skipWhiteSpace();
                timeZone = mailDateParser.parseTimeZone();
            } catch (java.text.ParseException unused) {
                if (debug) {
                    System.out.println("No timezone? : '" + new String(cArr) + "'");
                }
            }
            parsePosition.setIndex(mailDateParser.getIndex());
            return ourUTC(number2, month, number, number3, number4, number5, timeZone, z);
        } catch (Exception e) {
            if (debug) {
                System.out.println("Bad date: '" + new String(cArr) + "'");
                e.printStackTrace();
            }
            parsePosition.setIndex(1);
            return null;
        }
    }

    @Override // java.text.SimpleDateFormat, java.text.DateFormat
    public StringBuffer format(Date date, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        int i;
        int length = stringBuffer.length();
        super.format(date, stringBuffer, fieldPosition);
        int i2 = length + 25;
        while (stringBuffer.charAt(i2) != 'X') {
            i2++;
        }
        ((SimpleDateFormat) this).calendar.clear();
        ((SimpleDateFormat) this).calendar.setTime(date);
        int i3 = ((SimpleDateFormat) this).calendar.get(15) + ((SimpleDateFormat) this).calendar.get(16);
        if (i3 < 0) {
            i = i2 + 1;
            stringBuffer.setCharAt(i2, '-');
            i3 = -i3;
        } else {
            i = i2 + 1;
            stringBuffer.setCharAt(i2, '+');
        }
        int i4 = (i3 / 60) / 1000;
        int i5 = i4 / 60;
        int i6 = i4 % 60;
        int i7 = i + 1;
        stringBuffer.setCharAt(i, Character.forDigit(i5 / 10, 10));
        int i8 = i7 + 1;
        stringBuffer.setCharAt(i7, Character.forDigit(i5 % 10, 10));
        stringBuffer.setCharAt(i8, Character.forDigit(i6 / 10, 10));
        stringBuffer.setCharAt(i8 + 1, Character.forDigit(i6 % 10, 10));
        return stringBuffer;
    }

    @Override // java.text.SimpleDateFormat, java.text.DateFormat
    public Date parse(String str, ParsePosition parsePosition) {
        return parseDate(str.toCharArray(), parsePosition, isLenient());
    }

    @Override // java.text.DateFormat
    public void setCalendar(Calendar calendar) {
        throw new RuntimeException("Method setCalendar() shouldn't be called");
    }

    @Override // java.text.DateFormat
    public void setNumberFormat(NumberFormat numberFormat) {
        throw new RuntimeException("Method setNumberFormat() shouldn't be called");
    }
}
