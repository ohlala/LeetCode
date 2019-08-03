//第二题是一堆数围成一个圈，每个数都小于相邻两个数的和。
//方法1 AC：第一大的数小于第二大的数+第三大的数就可以，否则不行。
//如果最小的加第二大的没办法比最大的大，那我们就看一下第二大加第三大的能不能比最大的大，如果能，那我们就可以产生这样的队列，如果不能，那最大的数就没有那两个数的和能比它大了
//方法2 首先对数组进行排序，除了最后一个数字，都满足相邻两个数字大于自己 对于最后一个数字，交换最后两个数字，判断是否满足条件即可。
//方法1&2其实是一个意思

//作者：NotDeep
//链接：https://www.nowcoder.com/discuss/216237
//来源：牛客网

#include <stdio.h>
#include <string.h>
#include <algorithm>
#include <iostream>
#include <string>
using namespace std;
 
const int N = 1e5 + 10;
int a[N];
int main()
{
    int t;
    scanf("%d",&t);
    while (t--)
    {
        int n;
        scanf("%d",&n);
        for (int i = 0;i < n;i++) scanf("%d",&a[i]);
        sort(a,a+n);
        swap(a[n-2],a[n-1]);
        bool f = 0;
        for (int i = 0;i < n;i++)
        {
            int pre = (i-1+n)%n;
            int sub = (i+1) % n;
            if (a[pre] + a[sub] <= a[i]) f = 1;
        }
        if (f) puts("NO");
        else
        {
            puts("YES");
        }
    }
    return 0;
}