#include<iostream>
#include<vector>
using namespace std;
//̫��û����c++д�������ˣ�һдȫ�Ǵ�ģ�Ҫ����ϰ��
//����ⲻ�ѣ�����ѭ����һ����Ӻ�
//c++��vector�ĺ�����̫����
//.at()����ָ��λ�õ�Ԫ�� .push_back()������Ԫ�� vector����ֱ�ӳ�ʼ�� 
//������0��ʼ  
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
