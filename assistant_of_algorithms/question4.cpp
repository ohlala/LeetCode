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

//����С��ʵ����С���ȶ���
//��1�� Build(S); //������ S[1��n]��������С����
//��2�� Insert(S, x); //��Ԫ�� x ���뵽���� S ��
//��3�� Minimum(S)�� //���� S �о�����С���ֵ�Ԫ��
//��4�� ExtractMin(S); //ȥ�������� S �еľ�����С���ֵ�Ԫ��
//��5�� DecreaseKey(S, x, k); //��Ԫ�� x �Ĺؼ���ֵ���� k��ʹ�ùؼ���ֵ��Ϊ x-k

void SiftDown(int *a, int n, int i) {
	int min = i, temp;
	if (i * 2 + 1 < n && a[min] > a[i * 2 + 1])
		min = i * 2 + 1;
	if (i * 2 + 2 < n && a[min] > a[i * 2 + 2])
		min = i * 2 + 2;
	if (min == i)	//�ǵ÷���
		return;
	temp = a[min]; a[min] = a[i]; a[i] = temp;  //���ӽ���
	SiftDown(a, n, min); //�������
}

void BulidMinHeap(int *a, int n) {
	int i; //��ط�������SIZE_T
	for (i = n / 2 - 1; i >= 0; i--) // �Ӹ��ڵ㵽���ڵ�
		SiftDown(a, n, i);
}

void Insert(int *a, int x, int& n){
	a[n] = x;
	n++;
	int i;
	for (i = n - 1; (i-1)/2 > 0; i = (i-1)/2)
		if (a[i] < a[(i - 1) / 2]) {
			int temp = a[i]; a[i] = a[(i-1)/2]; a[(i-1)/2] = temp;  //���ӽ���
		}
	if (a[i] < a[(i - 1) / 2]) {
		int temp = a[i]; a[i] = a[(i - 1) / 2]; a[(i - 1) / 2] = temp;  //���ӽ���
	}
}

int ExtractMin(int *a, int& n) {
	int min = a[0];
	a[0] = a[n - 1];
	SiftDown(a, --n, 0);
	return min;
}

int Minimum(int *a, int& n) {
	return a[0];
}

void DecreaseKey(int *a, int x, int k, int n) {
	int i;
	for (i = 0; i < n; i++)
		if (a[i] == x)
			break;
	if (a[i] != x)
		return;
	a[i] -= k;
	for (i = n - 1; (i - 1) / 2 > 0; i = (i - 1) / 2)
		if (a[i] < a[(i - 1) / 2]) {
			int temp = a[i]; a[i] = a[(i - 1) / 2]; a[(i - 1) / 2] = temp;  //���ӽ���
		}
	if (a[i] < a[(i - 1) / 2]) {
		int temp = a[i]; a[i] = a[(i - 1) / 2]; a[(i - 1) / 2] = temp;  //���ӽ���
	}
}

void HeapSort(int *a, int n) {
	BulidMinHeap(a, n);
	int i;
	for (i = n - 1; i > 0; i--) {
		int temp = a[i]; a[i] = a[0]; a[0] = temp; //ÿ�ν��Ѷ�Ԫ��ȡ���ŵ��������
		SiftDown(a, --n, 0);
	}
}

int main() {
	int n;
	//CreatData(10, 0, 99);
	FILE *fp, *fq;
	fp = fopen("2.in", "r");
	fq = fopen("1.out", "w");
	size_t i, j;
	fscanf(fp, "%d", &n);
	while (n != 0)
	{
		int *a = (int *)malloc(sizeof(int) * (n*2));
		for (i = 0; i < n; i++)
			fscanf(fp, "%d", &a[i]);
		printf("ԭ����:");
		PrintData(a, n);
		printf("buildheap:");
		BulidMinHeap(a, n);
		PrintData(a, n);
		printf("minimum:%d\t", Minimum(a, n));
		PrintData(a, n);
		printf("extractmin:%d\t", ExtractMin(a, n));
		PrintData(a, n);
		printf("insert:");
		Insert(a, 9, n);
		PrintData(a, n);
		printf("decreasekey:");
		DecreaseKey(a, 23, 18, n);
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
		printf("----------------------------\n");
	}
	fclose(fp); fclose(fq);
	getchar();
}
