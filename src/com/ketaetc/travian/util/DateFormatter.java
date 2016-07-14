package ketaetc.travian.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Author: ketaetc (ketaetc@gmail.com)
 * Date: 13.07.16 0:14
 */
public class DateFormatter {
    private static Date curDate;
    private static String time;
    private static SimpleDateFormat sdf;

    public DateFormatter() {
        //null;
    }

    public static String getTime() {
        sdf = new SimpleDateFormat("HH:mm:ss dd/mm/yyyy");
        curDate = new Date();
        time = sdf.format(curDate);

        return time;
    }
}
