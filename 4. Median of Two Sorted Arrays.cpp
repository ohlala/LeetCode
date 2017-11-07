#include "stdafx.h"
#include<vector> 
#include<iostream>
#include<string>
#include<algorithm>  
#include<functional>  
#include<sstream>


using namespace std;
class Solution {
public:
	double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {
		double result = 0;
		if (nums1.size() == 0)
			return nums2.size() % 2 == 0 ? (nums2.at(nums2.size() / 2) + nums2.at(nums2.size() / 2 - 1))/2.0 : nums2.at(nums2.size() / 2);
		if (nums2.size() == 0)
			return nums1.size() % 2 == 0 ? (nums1.at(nums1.size() / 2) + nums1.at(nums1.size() / 2 - 1))/2.0 : nums1.at(nums1.size() / 2);
		if (nums1.size() == 1 && nums2.size() == 1)
			return (nums1.at(0) + nums2.at(0)) / 2.0;
		int total = nums1.size() + nums2.size();
		int i = 0, j = 0, mid = 0, mid2 = 0, flag=0;
		for (int count = 0; count < total / 2; count++) {
			if (i<nums1.size() && nums1.at(i) <= nums2.at(j)) {
				mid2 = nums1.at(i);
				i++;
				if (i == nums1.size() && flag == 1) {
					mid2 = nums2.at(j);
					j++;
					i--;
				}
				if (i == nums1.size() && flag == 0) {
					i--;
					flag = 1;
				}
			}
			else {
				mid2 = nums2.at(j);
				j++;
				if (j == nums2.size() && flag == 1) {
					mid2 = nums1.at(i);
					i++;
					j--;
				}
				if (j == nums2.size() && flag == 0) {
					j--;
					flag = 1;
				}
			}
		}
        {
			if (i<nums1.size() && nums1.at(i) <= nums2.at(j)) {
				mid = nums1.at(i);
				i++;
				if (i == nums1.size() && flag == 1) {
					mid = nums2.at(j);
					j++;
					i--;
				}
				if (i == nums1.size() && flag == 0) {
					i--;
					flag = 1;
				}
			}
			else {
				mid = nums2.at(j);
				j++;
				if (j == nums2.size() && flag == 1) {
					mid = nums1.at(i);
					i++;
					j--;
				}
				if (j == nums2.size()&&flag==0) {
					j--;
					flag = 1;
				}
			}
		}
		if (total % 2 == 1) {
			result = mid;
		}
		if (total % 2 == 0) {
			result = (mid2 + mid) / 2.0;
		}
		return result;
	}
};

void trimLeftTrailingSpaces(string &input) {
	input.erase(input.begin(), find_if(input.begin(), input.end(), [](int ch) {
		return !isspace(ch);
	}));
}

void trimRightTrailingSpaces(string &input) {
	input.erase(find_if(input.rbegin(), input.rend(), [](int ch) {
		return !isspace(ch);
	}).base(), input.end());
}

vector<int> stringToIntegerVector(string input) {
	vector<int> output;
	trimLeftTrailingSpaces(input);
	trimRightTrailingSpaces(input);
	input = input.substr(1, input.length() - 2);
	stringstream ss;
	ss.str(input);
	string item;
	char delim = ',';
	while (getline(ss, item, delim)) {
		output.push_back(stoi(item));
	}
	return output;
}

int main() {
	string line;
	while (getline(cin, line)) {
		vector<int> nums1 = stringToIntegerVector(line);
		getline(cin, line);
		vector<int> nums2 = stringToIntegerVector(line);

		double ret = Solution().findMedianSortedArrays(nums1, nums2);

		string out = to_string(ret);
		cout << out << endl;
	}
	return 0;
}
