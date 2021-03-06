#include "stdafx.h"
#include <stdio.h>
#include <stdlib.h>
#include <time.h>

#define MAXSIZE 1000

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
	int a[MAXSIZE];
	CreatData(a, 1, 99, MAXSIZE);
	for (int i = 0; i < MAXSIZE; i++)
		printf("%d ", a[i]);
	printf("\n");
	for (int i = 0; i < MAXSIZE; i++)
		printf("%d ", randomizedSelection(a, 0, MAXSIZE-1, i));
	getchar();
	return 0;
}

