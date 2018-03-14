#include "stdafx.h"
#include <stdio.h>
#include <stdlib.h>
#include <time.h>

#define MAXSIZE 100

void CreatData(int *a, int low, int high, int n) {
	for (int i = 0; i < n; i++)
		a[i] = rand() % (high - low + 1) + low;
}

int Partition(int *a, int left, int right) {
	int temp, i = left - 1, j = left;
	for (;j <= right; j++)
		if (a[j] < a[right])

	}

int randomizedPartition(int *a, int left, int right){
	int random = rand() % (right - left + 1) + left;
	int temp = a[random];
	a[random] = a[right];
	a[right] = temp;
	if (left < right)
		return Partition(a, left, right);
}

int randomizedSelection(int *a, int left, int right, int k) {
	if (left == right)
		return a[left];
	int r = randomizedPartition(a, left, right);
	if (r == k)
		return a[r];
	else if (r > k)
		return randomizedSelection(a, left, r - 1, k);
	else 
		return randomizedSelection(a, r + 1, right, k - r);
}

int main()
{	
	srand(time(0));
	int a[MAXSIZE];
	CreatData(a, 1, 99, MAXSIZE);
	for (int i = 0; i < MAXSIZE; i++)
		printf("%d ", randomizedSelection(a, 0, MAXSIZE-1, 1));
	return 0;
}

