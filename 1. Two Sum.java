class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i){
                return new int[] {map.get(complement), i};   //�ҵ����ǵڶ�������һ���Ѿ���������
            }
            map.put(nums[i] ,i);
        }
        throw new IllegalArgumentException();
    }
}

class Solution2 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            map.put(nums[i], i); //���������ͬ��ֻ������һ��
        }
        for (int i = 0; i < nums.length; i++){
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i){
                return new int[] {i, map.get(complement)}; //���ص�һ�����ڶ���
            }
        }
        throw new IllegalArgumentException();
    }
}