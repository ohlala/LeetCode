
#include <stdio.h>
#include <stdlib.h>
#include <time.h>

#define MAXSIZE 5000

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

int main()
{	
	srand(time(0));
	int a[MAXSIZE], b[MAXSIZE], c[MAXSIZE];
	CreatData(a, 1, 32766, MAXSIZE);
	CreatData(b, 1, 32766, MAXSIZE);
	CreatData(c, 1, 32766, MAXSIZE);
	QuickSort(a,0,MAXSIZE-1); 
	QuickSort(b,0,MAXSIZE-1);
	//QuickSort(c,0,MAXSIZE-1);
	for (int k = 0; k < MAXSIZE; k++){
		if (c[k] == c [k-1])
			continue;
		int i = 0, j = MAXSIZE - 1;
		while(j > -1 && i < MAXSIZE){
			if (a[i] + b[j] == c[k]){
				printf("%d=%d+%d\t", c[k], a[i], b[j]); 
				break;
			}
			else if (a[i] + b[j] > c[k])
				j--;
			else 
				i++;
		}
	}
}


