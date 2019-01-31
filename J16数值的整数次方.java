public class Solution {
    public double Power(double base, int exponent) {
        if (base == 0)
        	return 0;
        if (exponent == 0)
        	return 1;
        double result = 1;
        int flag = 1;
        if (exponent < 0){
        	exponent = exponent * -1;
        	flag = -1;
       	}
        while (exponent > 0){
        	result = result * base;
        	exponent--;
        }
        if (flag < 0)
        	result = 1 / result;
        return result;
    }
}