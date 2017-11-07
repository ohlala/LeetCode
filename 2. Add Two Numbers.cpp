#include<iostream>
#include<vector>
using namespace std;

struct ListNode {
	int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}  // c++结构体的用法，c中没有 

//2017.10.31 周二  这道题刷了好久刷，晚上还没有刷完。一直通过不了，
//第二天起来一看自己题意理解错了重新做，其实不难，害我头疼了好久。
//遍历两个链表，有数则相加，没有轮空。通过标志来进行判断是否进1。
//主要是标志放置的位置要注意和程序顺序相结合。

class Solution {
public:
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        ListNode *l, *result =new ListNode(0); 
  		l = result; 
    	int flag = 0;
	    for(int i=0;l1!=NULL|l2!=NULL;i++) {
        	int temp = l1->val + l2->val + flag; 
        	l->next = new ListNode(0);
        	flag = 0;
        	if (temp >= 10){
        		temp = temp % 10;
        		flag = 1; 
        	}	
        	l = l->next;
        	l->val += temp; 
        	if (l2->next==NULL&&l1->next==NULL)
				break;
        	if (l1->next!=NULL)
				l1 = l1->next; 
			else l1->val = 0; 
        	if (l2->next!=NULL)
				l2 = l2->next;
        	else l2->val = 0;
		}
        if (flag == 1)
        	l->next = new ListNode(flag);
        return result->next;
    }
};

int main(){
    ListNode *l,*l1,*l2;
    l1  =new ListNode(5); 
//	l = l1;
//	(l->next) =new ListNode(4);
//	l = l->next;
//	(l->next)=new ListNode(3);
//
	l2  = new ListNode(5);
//	l = l2;
//	(l->next) =new ListNode(4);
//	l = l->next;
//	(l->next)=new ListNode(4);
	Solution sol;
	l = sol.addTwoNumbers( l1, l2) ; 
    for (;l!=NULL;){
		cout << l->val << ' ';
		l = l->next;
	} 
    return 0;
}
