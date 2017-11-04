#include<iostream>
#include<vector>
using namespace std;

struct ListNode {
	int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};
 
 
class Solution {
public:
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        vector<int> reverseList1,reverseList2;
        vector<int>::iterator theIterator = reverseList1.begin(); 
        for(;l1!=NULL;) {
//        	        	cout << l1->val<<endl; 
        	vector<int>::iterator theIterator = reverseList1.begin(); 
        	reverseList1.insert(theIterator,l1->val);
        	l1 = l1->next;
        }

        reverseList1.push_back(0); 
		reverseList1.push_back(0); 
    	reverseList1.push_back(0);	
		reverseList1.push_back(0); 
		reverseList1.push_back(0); 
		reverseList1.push_back(0); 
    	reverseList1.push_back(0);	
		reverseList1.push_back(0); 
		reverseList1.push_back(0); 
		reverseList1.push_back(0); 
    	reverseList1.push_back(0);	
		reverseList1.push_back(0); 
//	    for(vector<int>::iterator it=reverseList1.begin();it!=reverseList1.end();it++)
//			cout<<*it<<" ";   //3 4 2 0 
    
	    for(int i=0;l2!=NULL;i++) {
        	reverseList1.at(i)+=l2->val;
        	if (reverseList1.at(i) >= 10){
        		reverseList1.at(i) = reverseList1.at(i) % 10;
        		reverseList1.at(i+1) += 1; 
        	}
        	l2 = l2->next;
        }
    

	    vector<int>::reverse_iterator riter;
		for (riter=reverseList1.rbegin();riter!=reverseList1.rend();riter++)
		{
		    reverseList2.push_back(*riter);
		}

	
		int i = 0; 
		for(;reverseList2.at(i) == 0;i++) {
//			cout << i; 
			if(i>=reverseList2.size()-1)
				return (new ListNode(0)); 
        }
        
        
			
        ListNode  *result,*temp;
		temp =new ListNode(reverseList2.at(i));
		i++; 
		result = temp;
    
	    for(;i<reverseList2.size();i++) {
        	(result->next) =new ListNode(reverseList2.at(i));
			result = result->next;
        }
        return temp;
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


//    

//	for (;l1!=NULL;){
//		cout << l1->val << ' ';
//		l1 = l1->next;
//	} 
//    cout << endl;
//    
//    for (;l2!=NULL;){
//		cout << l2->val << ' ';
//		l2 = l2->next;
//	} 
//    cout << endl;
    return 0;
}
