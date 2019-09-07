public class Main {
    String sum(String num1, String num2){
        int len1 = num1.length();
        int len2 = num2.length();
        int i = 0;
        StringBulider res = new StringBulider();
        int temp = 0;
        for (; i < len1 && i < len2; i++){
            if (num1.charAt(len1 - i - 1) == '1')
                temp ++;
            if (num2.charAt(len2 - i - 1) == '1')
                temp ++;
            if (temp % 2 == 0){
                res.append("0");
            }else{
                res.append("1");
            }
            if (temp / 2 == 0){
                temp = 0;
            }else{
                temp = 1;
            }
        }
        if (len2 > len1 ){
            for(;i < len2; i++){
                if (num2.charAt(len2 - i - 1) == '1')
                    temp ++;
                if (temp % 2 == 0){
                    res.append("0");
                }else{
                    res.append("1");
                }
                if (temp / 2 == 0){
                    temp = 0;
                }else{
                    temp = 1;
                }
            }
        }else{
            for(;i < len1; i++){
                if (num1.charAt(len1 - i - 1) == '1')
                    temp ++;
                if (temp % 2 == 0){
                    res.append("0");
                }else{
                    res.append("1");
                }
                if (temp / 2 == 0){
                    temp = 0;
                }else{
                    temp = 1;
                }
            }
        }
        if(temp == 1){
            res.append("1")
        }
        res.reverse();
        return res.toString();
    }
    String multi(String num1, String num2){
        
        
    }
}