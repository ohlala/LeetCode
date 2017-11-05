#include <string>
#include "assert.h" 
#include <iostream> 
using  std::string;
using namespace std;
class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        int maxLength = 0, thisLength = 1;
		for (int i = 0; i <s.length(); i++) {
			thisLength = 1;
			if (thisLength > maxLength)
				maxLength = thisLength;
			for (int j = i+1;j<s.length();j++){
				int flag = 0;
				for (int k = i;k<j;k++){
					if (s[j] == s[k])
						flag = 1;
				}
				if(flag != 1){
					thisLength++;
					if (thisLength > maxLength)
							maxLength = thisLength;
				}else{
					break;
				}
			}
		}
		return maxLength;	
    }
};

string stringToString(string input) {
    assert(input.length() >= 2);
    string result;
    for (int i = 1; i < input.length() -1; i++) {
        char currentChar = input[i];
        if (input[i] == '\\') {
            char nextChar = input[i+1];
            switch (nextChar) {
                case '\"': result.push_back('\"'); break;
                case '/' : result.push_back('/'); break;
                case '\\': result.push_back('\\'); break;
                case 'b' : result.push_back('\b'); break;
                case 'f' : result.push_back('\f'); break;
                case 'r' : result.push_back('\r'); break;
                case 'n' : result.push_back('\n'); break;
                case 't' : result.push_back('\t'); break;
                default: break;
            }
            i++;
        } else {
          result.push_back(currentChar);
        }
    }
    return result;
}

int main() {
    string line;
    while (getline(cin, line)) {
        cout << line <<endl;
//		string s = stringToString(line);
//        cout << s << endl;
        int ret = Solution().lengthOfLongestSubstring(line);

        ///string out = to_string(ret);
        cout << ret << endl;
    }
    return 0;
}
