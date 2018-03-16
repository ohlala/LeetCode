
#include <stdio.h>
#include <stdlib.h>
#include <time.h>

#define MAXSIZE 30000

void CreatData(int *a, int low, int high, int n) {
	for (int i = 0; i < n; i++)
		a[i] = rand() % (high - low + 1) + low;
}

int Partition(int *a, int left, int right) {
	int temp, i = left - 1, j = left;
	for (; j < right; j++)
		if (a[j] < a[right]) {
			i++;
			temp = a[i];
			a[i] = a[j];
			a[j] = temp;
		}
	temp = a[right];
	a[right] = a[++i];
	a[i] = temp;
	return i;
}

void QuickSort(int *a, int left, int right){
	if (left < right){
		int mid = Partition(a, left, right);
		QuickSort(a, left, mid-1);
		QuickSort(a, mid+1, right);    
	} 
}

int randomizedPartition(int *a, int left, int right){
	int random = rand() % (right - left + 1) + left;  //a[right]是有效的
	int temp = a[random];
	a[random] = a[right];
	a[right] = temp;
	if (left < right) {
		return Partition(a, left, right);
	}
}

int randomizedSelection(int a[], int left, int right, int rank) { //rank从0开始计算
	if (left == right)
		return a[left];
	int mid = randomizedPartition(a, left, right);
	int k = mid - left;   //从0开始与从left开始的转换
	if (rank == k)
		return a[mid];
	else if (rank < k)
		return randomizedSelection(a, left, mid - 1, rank);
	else
		return randomizedSelection(a, mid + 1, right, rank - (k+1));
}

int main()
{	
	srand(time(0));
	int a[MAXSIZE], b[MAXSIZE], c[MAXSIZE];
	CreatData(a, 1, 32766, MAXSIZE);
	
	
	clock_t t1, t2, t3;	
	t1 = clock();
	for (int i = 0; i < 100; i++){
		for (int i = 0; i < MAXSIZE; i++){
			c[i] = a[i];
		}	
		randomizedSelection(c, 0, MAXSIZE-1, MAXSIZE/2);
		//printf("%d\n", randomizedSelection(c, 0, MAXSIZE-1, MAXSIZE/2));	
	}
	t2 = clock(); 
	for (int i = 0; i < 100; i++){
		for (int i = 0; i < MAXSIZE; i++){
			b[i] = a[i];
		}	
		QuickSort(b,0,MAXSIZE-1);
		//printf("%d\n", b[MAXSIZE/2]);
	}
	t3 = clock(); 
	printf("\n%d ms", (t2 - t1)); //需要转换为double类型 
	printf("\n%d ms", (t3 - t2));
	//getchar();

}


