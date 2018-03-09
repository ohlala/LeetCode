#include<stdlib.h> 
#include<stdio.h>
#include<time.h>

void CreatData(int row, int low, int high) {
	srand(time(0));
	size_t i, j, count;
	FILE *fr;
	fr = fopen("2.in", "w");
	for (j = 0; j < row; j++) {
		count = rand() % 10 + 5;
		fprintf(fr, "%d\n", count);
		for (i = 0; i < count - 1; i++)
			fprintf(fr, "%d ", rand() % (high - low) + low);
		fprintf(fr, "%d\n", rand() % (high - low) + low);
	}
	fprintf(fr, "0");
	fclose(fr);
}

void PrintData(int a[], int n) {
	size_t i;
	for (i = 0; i < n - 1; i++)
		printf("%d ", a[i]);
	printf("%d\n", a[i]);
}

//用最小堆实现最小优先队列
//（1） Build(S); //将数组 S[1…n]创建成最小队列
//（2） Insert(S, x); //把元素 x 插入到集合 S 中
//（3） Minimum(S)； //返回 S 中具有最小键字的元素
//（4） ExtractMin(S); //去掉并返回 S 中的具有最小键字的元素
//（5） DecreaseKey(S, x, k); //将元素 x 的关键字值减少 k，使得关键字值变为 x-k

void InsertSort(int a[], int n) {
	size_t i, j;
	for (i = 1; i < n; i++) {
		int temp = a[i];
		for (j = i; j > 0; j--) {	
			if (temp < a[j - 1])  //从后向前比较，大就后移
				a[j] = a[j - 1];
			else
				break;
		}
		a[j] = temp;		/*插入*/
	}
}

void MergeSort1(int a[], int temp[], int n) {
	if (n == 1)
		return;
	int mid = n / 2;		//分成两边
	MergeSort1(a, temp, mid);
	MergeSort1(a + mid, temp + mid, n - mid);
	for (int i = 0; i < n; i++)
		temp[i] = a[i];		//辅助数组
	int i = 0, j = mid;
	for (int curr = 0; curr < n; curr++) //从辅助数组两边取大
		if (i == mid)
			a[curr] = temp[j++];
		else if (j == n)
			a[curr] = temp[i++];
		else if (temp[i] > temp[j])
			a[curr] = temp[j++];
		else
			a[curr] = temp[i++];
}

void MergeSort(int a[], int temp[], int n) {
	if (n == 1)
		return;
	int mid = n / 2;
	MergeSort(a, temp, mid);
	MergeSort(a + mid, temp + mid, n - mid);
	for (int i = 0; i < mid; i++)
		temp[i] = a[i];
	for (int i = n - 1; i >= mid; i--) // 辅助数组后半段逆序
		temp[mid + n - i - 1] = a[i];
	int i = 0, j = n - 1;
	for (int curr = 0; curr < n; curr++) //辅助数组前后互为判断边界
		if (temp[i] > temp[j])
			a[curr] = temp[j--];
		else
			a[curr] = temp[i++];
}

void SiftDown(int *a, int n, int i) {
	int max = i, temp;
	if (i * 2 + 1 < n && a[max] < a[i * 2 + 1])
		max = i * 2 + 1;
	if (i * 2 + 2 < n && a[max] < a[i * 2 + 2])
		max = i * 2 + 2;
	if (max == i)	//记得返回
		return;
	temp = a[max]; a[max] = a[i]; a[i] = temp;  //父子交换
	SiftDown(a, n, max); //逐次向下
}

void BulidMaxHeap(int *a, int n) {
	int i; //这地方不能用SIZE_T
	for (i = n / 2 - 1; i >= 0; i--) // 从父节点到根节点
		SiftDown(a, n, i);
}

void HeapSort(int *a, int n) {
	BulidMaxHeap(a, n);
	size_t i;
	for (i = n - 1; i > 0; i--) {
		int temp = a[i]; a[i] = a[0]; a[0] = temp; //每次将堆顶元素取出放到数组最后
		SiftDown(a, --n, 0);
	}
}

int main() {
	int n = 0;
//	CreatData(10, 0, 99);
	FILE *fp, *fq;
	fp = fopen("2.in", "r");
	fq = fopen("1.out", "w");
	size_t i, j;
	fscanf(fp, "%d", &n);
	while (n != 0)
	{
		int *a = (int *)malloc(sizeof(int) * (n));
		for (i = 0; i < n; i++)
			fscanf(fp, "%d", &a[i]);
		PrintData(a, n);
		//InsertSort(a, n);
		//HeapSort(a, n);
		//int *temp = (int *)malloc(sizeof(int) * n);
		//MergeSort(a, temp, n);
		//free(temp);
		PrintData(a, n);
		for (i = 0; i < n; i++)
			fprintf(fq, "%d ", a[i]);
		fprintf(fq, "%d\n", a[i]);
		fscanf(fp, "%d", &n);
		free(a);
	}
	fclose(fp); fclose(fq);
	getchar();
}
