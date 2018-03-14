#include<stdlib.h> 
#include<stdio.h>
#include<time.h>
#include<string.h>

#define MAXSIZE 100
/* in.txt
AGCTAG
ACTCC

ATCGTTGAAT
ACGTGATA
*/ 
 
void printlcs(int b[][MAXSIZE], char str1[], int i, int j){
	if (i == 0 || j ==0)
		return ;
	else if (b[i][j] == 0){
		printlcs(b, str1, i-1, j-1);
		printf("%c",str1[i-1]);
	}else if (b[i][j] == 1)
		printlcs(b, str1, i-1, j);
	else 
		printlcs(b, str1, i, j-1);
}

int lcs(char str1[], char str2[]){	
	int m = strlen(str1), n = strlen(str2);
	int c[MAXSIZE][MAXSIZE], b[MAXSIZE][MAXSIZE];
	int i ,j;
	for (i = 0; i <= m ; i++)
		c[i][n] = 0;
	for (j = 0; j <= n ; j++)
		c[m][j] = 0;
	for (i = 1; i <= m ; i++)
		for (j = 1; j <= n ; j++){
			if (str1[i-1]==str2[j-1]){
				c[i][j] = c[i-1][j-1] +1;
				b[i][j] = 0;
			}else if(c[i-1][j]>c[i][j-1]){
				c[i][j] = c[i-1][j];
				b[i][j] = 1;
			}else {
				c[i][j] = c[i][j-1];
				b[i][j] = 2;
			}
		} 
//	for (i = 1; i <= m ; i++){
//		for (j = 1; j <= n ; j++)
//			printf("%d",b[i][j]);
//		printf("\n");	
//	}
	printlcs(b, str1, m, n);	
	return c[m][n];
}

int main() {
	FILE *fp;
	fp = fopen("in.txt", "r");
	char A[MAXSIZE], B[MAXSIZE];
	while (fscanf(fp, "%s", A) > 0) {
		fscanf(fp, "%s", B);
		printf("%s\n", A);
		printf("%s\n",B);
		printf("\t%d\n",lcs(A, B));
	}
	fclose(fp);
	//getchar();
}
