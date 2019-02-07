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
        if (strIndex == str.length && patternIndex == pattern.length) {
            return true;
        }
        if (strIndex != str.length && patternIndex == pattern.length) {
            return false;
        }
        if (strIndex == str.length && patternIndex != pattern.length) {
            if (patternIndex + 1 < pattern.length && pattern[patternIndex + 1] == '*')
                return matchCore(str, strIndex, pattern, patternIndex + 2);
            return false;
        }
        if (patternIndex + 1 < pattern.length && pattern[patternIndex + 1] == '*') {
            if (str[strIndex] == pattern[patternIndex] || pattern[patternIndex] == '.')
                return (matchCore(str, strIndex, pattern, patternIndex + 2) ||
                        matchCore(str, strIndex + 1, pattern, patternIndex + 2) ||
                        matchCore(str, strIndex + 1, pattern, patternIndex));
            else
                return matchCore(str, strIndex, pattern, patternIndex + 2);
        }
        if (str[strIndex] == pattern[patternIndex] || pattern[patternIndex] == '.') {
            return matchCore(str, strIndex + 1, pattern, patternIndex + 1);
        }
        return false;
    }
}
