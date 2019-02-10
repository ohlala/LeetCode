public class Main { //类名和文件名要一致
    public static void main(String[] args) {
        Main result = new Main();  //要先生成类的实例才可以调用类的方法
        char[] str = {'a', 'a', 'a'};
        char[] pat = {'a', 'b', '*', 'a', 'c', '*', 'a'};
        System.out.println(result.match(str, pat));
    }

    public boolean match(char[] str, char[] pattern) {
        if (str == null || pattern == null) {
            return false;
        }
        int strIndex = 0;
        int pattrenIndex = 0;
        return matchCore(str, strIndex, pattern, pattrenIndex);
    }

    public boolean matchCore(char[] str, int strIndex, char[] pattern, int patternIndex) {
        if (strIndex == str.length && patternIndex == pattern.length) { //两个都到尽头
            return true;
        }
        if (strIndex != str.length && patternIndex == pattern.length) { //模式先到尽头，字符串没有匹配完
            return false;
        }
        if (strIndex == str.length && patternIndex != pattern.length) { //字符串先到尽头，模式可以继续匹配0个那种
            if (patternIndex + 1 < pattern.length && pattern[patternIndex + 1] == '*')
                return matchCore(str, strIndex, pattern, patternIndex + 2);
            return false;
        }
        //都没到尽头的一般情况下，如果下一位是通配符
        if (patternIndex + 1 < pattern.length && pattern[patternIndex + 1] == '*') {
            //前一位满足匹配条件，则可以匹配 0 1 或者多个
            if (str[strIndex] == pattern[patternIndex] || pattern[patternIndex] == '.')
                return (matchCore(str, strIndex, pattern, patternIndex + 2) || 				//0个
                        matchCore(str, strIndex + 1, pattern, patternIndex + 2) ||		//1个(可以由0个和多个组成)
                        matchCore(str, strIndex + 1, pattern, patternIndex));					//多个
            //前一位不满足匹配条件，只可以匹配 0 个
            else
                return matchCore(str, strIndex, pattern, patternIndex + 2);					
        }
        //都没到尽头的一般情况下，如果下一位是不通配符，判断匹不匹配，不匹配则返回false
        if (str[strIndex] == pattern[patternIndex] || pattern[patternIndex] == '.') {
            return matchCore(str, strIndex + 1, pattern, patternIndex + 1);
        }
        return false;
    }
}
