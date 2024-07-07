import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

public class Date {
    public static void main(String[] args){
        Calendar now = Calendar.getInstance(TimeZone.getTimeZone("Asia/Seoul"));
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String answer = dateFormat.format(now.getTime());
        System.out.println(answer);
    }
}
