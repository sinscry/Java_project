package d_formatter.formatter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import org.springframework.format.Formatter;
public class MyFormatter implements Formatter<Date> {
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    public String print(Date object, Locale arg1) {
        return dateFormat.format(object);
    }
    public Date parse(String source, Locale arg1) throws ParseException {
        return dateFormat.parse(source); // Formatter只能对字符串转换
    }
}