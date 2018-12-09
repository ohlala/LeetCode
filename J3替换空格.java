public class Solution {
    public String replaceSpace(StringBuffer str) {
    	// return str.toString().replaceAll(" " , "%20");
        if (str == null)
            return null;
        while(str.lastIndexOf(" ") != -1){
            int index = str.lastIndexOf(" ");
            str.replace(index, index + 1, "%20");
        }
        return str.toString();
    }
}