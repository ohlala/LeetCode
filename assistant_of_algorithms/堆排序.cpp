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

void InsertSort(int a[], int n) {
	size_t i, j;
	for (i = 1; i < n; i++) {
		int temp = a[i];
		for (j = i; j > 0; j--) {	
			if (temp < a[j - 1])  //�Ӻ���ǰ�Ƚϣ���ͺ���
				a[j] = a[j - 1];
			else
				break;
		}
		a[j] = temp;		/*����*/
	}
}

void MergeSort1(int a[], int temp[], int n) {
	if (n == 1)
		return;
	int mid = n / 2;		//�ֳ�����
	MergeSort1(a, temp, mid);
	MergeSort1(a + mid, temp + mid, n - mid);
	for (int i = 0; i < n; i++)
		temp[i] = a[i];		//��������
	int i = 0, j = mid;
	for (int curr = 0; curr < n; curr++) //�Ӹ�����������ȡ��
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
	for (int i = n - 1; i >= mid; i--) // ���������������
		temp[mid + n - i - 1] = a[i];
	int i = 0, j = n - 1;
	for (int curr = 0; curr < n; curr++) //��������ǰ��Ϊ�жϱ߽�
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
	if (max == i)	//�ǵ÷���
		return;
	temp = a[max]; a[max] = a[i]; a[i] = temp;  //���ӽ���
	SiftDown(a, n, max); //�������
}

void BulidMaxHeap(int *a, int n) {
	int i; //��ط�������SIZE_T
	for (i = n / 2 - 1; i >= 0; i--) // �Ӹ��ڵ㵽���ڵ�
		SiftDown(a, n, i);
}

void HeapSort(int *a, int n) {
	BulidMaxHeap(a, n);
	size_t i;
	for (i = n - 1; i > 0; i--) {
		int temp = a[i]; a[i] = a[0]; a[0] = temp; //ÿ�ν��Ѷ�Ԫ��ȡ���ŵ��������
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
