#include<stdlib.h> 
#include<stdio.h>
#include<time.h>

#define MAXSIZE 10000
/* in.txt
6 
-2 11 -4 13 -5 -2
10
-10 1 2 3 4 -5 -23 3 7 -21
0
*/ 
 

int maximum_subarray(int * a, int n){  //在线处理 
	int i = 0, max = 0, temp = 0;
	for ( ; i < n; i++){
			temp += a[i];
			if (temp < 0)	//如果把temp说成a[....i]这一数据中包含a[i]的最大连续子序列的和的话，它就是dp
				temp = 0;
			if (temp > max)
				max = temp;
	}
	return max;
}

int maximum_subarray3(int * a, int n) {  //动态规划


}

int find_maximum_crossing_subarray(int* a ,int n){
	int mid = n / 2, temp = 0, maxl = 0, maxr = 0;
	for (int i = mid - 1; i >= 0; i--){
			temp += a[i];
			if (temp > maxl)
				maxl = temp;
	}
	temp = 0;
	for (int i = mid; i < n; i++){
			temp += a[i];
			if (temp > maxr)
				maxr = temp;
	}
	return maxl + maxr; 
}

int maximum_subarray2(int * a, int n){ //分治策略 
	//int i = 0, j = 0, max = 0, temp = 0;
	if (n == 1)
		return a[0];
	int mid = n / 2, max = 0;
	int maxmid = find_maximum_crossing_subarray(a, n);
	int maxleft = maximum_subarray2(a, mid);
	int maxright = maximum_subarray2(a + mid, n - mid);
	if (max < maxleft)
		max = maxleft; 
	if (max < maxright)
		max = maxright; 
	if (max < maxmid)
		max = maxmid; 
	return max;
}

int main() { 
	FILE *fp;
	fp = fopen("in.txt", "r");
	int n; 
	fscanf(fp, "%d", &n); 
	while (n > 0) {
		int *arr = (int*) malloc(sizeof(int) * n);
		int i = 0;
		for ( ; i<n; i++){
			fscanf(fp,"%d", &arr[i]);
		}
		printf("%d",maximum_subarray2(arr , n));
		free(arr); 
		fscanf(fp, "%d", &n); 
		if (n > 0)
			printf("\n");
	}
	fclose(fp);
	getchar();
}
