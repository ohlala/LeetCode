public class Solution {
    public boolean VerifySquenceOfBST(int [] sequence) {
    		if (sequence.length == 0)   //��Ҫ���жϲ����ڵ���� ��֤�����³����
    				return false;
				return VerifySquenceOfBST(sequence, 0,sequence.length-1);			              
    }
    
    public boolean VerifySquenceOfBST(int [] sequence, int star, int root) {
 				if (root - star <= 1 )
 						return true;
 				int indexOfMid = star;
 				for (; indexOfMid < root && sequence[indexOfMid] < sequence[root]; indexOfMid++){
 				}
 				for (; indexOfMid < root; indexOfMid++){
 					  if (sequence[indexOfMid] < sequence[root])
 								return false;
 				}
 				return VerifySquenceOfBST(sequence, star, indexOfMid-1)&&VerifySquenceOfBST(sequence, indexOfMid, root-1);
 			 				       
    }
}