//�ڶ�����һ����Χ��һ��Ȧ��ÿ������С�������������ĺ͡�
//����1 AC����һ�����С�ڵڶ������+����������Ϳ��ԣ������С�
//�����С�ļӵڶ����û�취�����Ĵ������ǾͿ�һ�µڶ���ӵ�������ܲ��ܱ����Ĵ�����ܣ������ǾͿ��Բ��������Ķ��У�������ܣ�����������û�����������ĺ��ܱ�������
//����2 ���ȶ�����������򣬳������һ�����֣������������������ִ����Լ� �������һ�����֣���������������֣��ж��Ƿ������������ɡ�
//����1&2��ʵ��һ����˼

//���ߣ�NotDeep
//���ӣ�https://www.nowcoder.com/discuss/216237
//��Դ��ţ����

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