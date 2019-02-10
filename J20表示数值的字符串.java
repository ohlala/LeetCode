public class Main { //类名和文件名要一致
    public static void main(String[] args) {
        Main result = new Main();  //要先生成类的实例才可以调用类的方法
        char[] pat = {'3', '.', '4', 'e', '+', '6', '7'};
        char[] pa = {'1', '0', '0'};
        System.out.println(result.isNumeric(pa));
    }

    private int index = 0;

    public boolean isNumeric(char[] str) {
        if (str.length < 1)
            return false;
        boolean flag = scanInt(str);
        if (index < str.length && str[index] == '.'){ //在访问index的时候都要先做数组越界的判断
            index++;
            flag = scanUnsignedInt(str) || flag;       //有'.'的存在才需要判断后面有没有无符号数字
        }
        //在访问index的时候都要先做数组越界的判断，里面的判断条件要加上括号
        if (index < str.length && (str[index] == 'e' || str[index] == 'E')){
            index++;
            flag = scanInt(str) && flag;                //有'e或者E'的存在才需要判断后面有没有数字
        }
        return flag && index == str.length;            //组成部分够不够&& 有没有到头（有没有停在奇怪的地方）
    }

    public boolean scanInt(char[] str) {
        if (index < str.length && (str[index] == '-' || str[index] == '+'))  //在访问index的时候都要先做数组越界的判断
            index++;
        return scanUnsignedInt(str);
    }

    public boolean scanUnsignedInt(char[] str) {
        int start = index;
        while (index < str.length && (str[index] <= '9' && str[index] >= '0'))  //在访问index的时候都要先做数组越界的判断
            index++;
        return start < index;
    }
}
