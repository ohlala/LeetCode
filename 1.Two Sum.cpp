#include<iostream>
#include<vector>
using namespace std;
//太久没有用c++写过东西了，一写全是错的，要多练习了
//这个题不难，两次循环找一个相加和
//c++中vector的函数不太会用
//.at()返回指定位置的元素 .push_back()向后添加元素 vector不能直接初始化 
//索引从0开始  
class Solution {
public:
    vector<int> result;
    vector<int> twoSum(vector<int>& nums, int target) {
        for(int i = 0;i<nums.size();i++){
            for(int j = nums.size()-1;j!=i;j--){
                if (nums.at(i)+nums.at(j)==target){
                    result.push_back(i);
                    result.push_back(j);
                    return result;
                }
            }
        }

    }
};

int main(){
    int arr[] = {2,3,4};
    vector<int> nums(arr,arr+3);
    int target = 6;
    Solution sol;
    cout <<  sol.twoSum(nums, target).at(0);
    cout <<  sol.twoSum(nums, target).at(1);
    return 0;
}
