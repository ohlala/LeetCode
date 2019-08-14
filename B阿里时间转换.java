import java.util.Date;

//字符	数值
//        ^	1
//        %	5
//        &	10
//        *	50
//        $	100
//        #	500
//        @	1000
//        -	5000
//        柯克船长抬头看了一眼日历，瓦肯星日历上今天是
//        星历 “@-$$$&$%^^^ 年 &^^ 月 ^& 日 %^^ 时 &*%^^^ 分 *%^ 秒”
//
//        柯克船长又抬起手腕看了看手表，显示的地球时间是
//        星历 “4398年12月9日 07时48分56秒”
public class Main {
    public  static  String wathinsDateConverter(String earthDate) {
        String year = earthDate.split("年")[0].trim();
        String last = earthDate.split("年")[1];
        String month = last.split("月")[0].trim();
        last = last.split("月")[1];
        String day = last.split("日")[0].trim();
        last = last.split("日")[1];
        String hour = last.split("时")[0].trim();
        last = last.split("时")[1];
        String minute = last.split("分")[0].trim();
        last = last.split("分")[1];
        String second = last.split("秒")[0].trim();


        StringBuilder res = new StringBuilder();
        res.append(convert(year));res.append(" 年 ");
        res.append(convert(month));res.append(" 月 ");
        res.append(convert(day));res.append(" 日 ");
        res.append(convert(hour));res.append(" 时 ");
        res.append(convert(minute));res.append(" 分 ");
        res.append(convert(second));res.append(" 秒");
        return res.toString();
    }

    public static String convert(String earthTime){
        Integer integer = Integer.valueOf(earthTime);
        StringBuilder temp = new StringBuilder();
        for (int i = integer / 5000; i > 0; i--){
            temp.append("-");
        }
        integer = integer % 5000;
        for (int i = integer / 1000; i > 0; i--){
            temp.append("@");
        }
        integer = integer % 1000;
        for (int i = integer / 500; i > 0; i--){
            temp.append("#");
        }
        integer = integer % 500;
        for (int i = integer / 100; i > 0; i--){
            temp.append("$");
        }
        integer = integer % 100;
        for (int i = integer / 50; i > 0; i--){
            temp.append("*");
        }
        integer = integer % 50;
        for (int i = integer / 10; i > 0; i--){
            temp.append("&");
        }
        integer = integer % 10;
        for (int i = integer / 5; i > 0; i--){
            temp.append("%");
        }
        integer = integer % 5;
        for (int i = integer; i > 0; i--){
            temp.append("^");
        }
        String res = temp.toString();
        res = res.replaceAll("@@@@", "@-");
        res = res.replace("$$$$", "$#");
        res = res.replace("&&&&", "&*");
        res = res.replace("^^^^", "^%");
        res = res.replace("#$#", "$@");
        res = res.replace("*&*", "&$");
        res = res.replace("%^%", "^&");
        return res;
    }
    
    public static void main(String[] args) {
        String input = "4398年12月9日 07时48分56秒";
        System.out.println(wathinsDateConverter(input));
    }
}