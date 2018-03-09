#include<stdlib.h> 
#include<stdio.h>
#include<time.h>

void InsertSort(int a[], int n);
void CreatData1(int a[], int n);
void CreatData3(int a[], int n, int low, int high);
void PrintData(int a[], int n);
void test2(int a[], int n);

int main(){
	int *a , n = 20;
	a = malloc(sizeof(int) * n);
	//CreatData1(a, n);
	test2(a, n);

	/*CreatData3(a, n, 100, 999);
	PrintData(a, n);
	InsertSort(a, n);
	PrintData(a, n);*/
	getchar();
}
void test2(int a[], int n){
	FILE *fp, *fq;
	fp = fopen("before.txt", "r");
	fq = fopen("after.txt", "w");
	size_t i, j;
	for (j = 0; j < 5; j++)
	{
		for (i = 0; i < n; i++)
			fscanf(fp, "%d", &a[i]);
		InsertSort(a, n);
		for (i = 0; i < n - 1; i++)
			fprintf(fq, "%d ", a[i]);
		fprintf(fq, "%d\n", a[i]);
	}
	fclose(fp); fclose(fq);
}
void CreatData1(int a[], int n) {
	size_t i;
	for (i = 0; i < n; i++)
		scanf("%d", &a[i]);
}

void CreatData3(int a[], int n, int low, int high) {
	_sleep(1000);
	srand(time(0));
	size_t i; 
	for (i = 0; i < n; i++)
		a[i] = rand() % (high - low) + low;
}
void PrintData(int a[], int n) {
	size_t i;
	for (i = 0; i < n - 1; i++)
		printf("%d ", a[i]);
	printf("%d\n", a[i]);
}
void InsertSort(int a[], int n) {
	size_t i, j;
	for (i = 1; i < n; i++) {
		int temp = a[i];
		for (j = i; j > 0 ; j--) {
			if (temp < a[j - 1])
				a[j] = a[j - 1];
			else
				break;
		}
		a[j] = temp;
	}
}
