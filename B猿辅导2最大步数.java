//�Թ����߹��������:
//        [1 ]���Է���N��
//        [2 ]ÿ��ֻ���߱ȵ�ǰ��ֵ����ĸ���
//        [3 ]����ܾ����������
//
//        ����:3 * 3  1��
//        1 3 3
//        2 4 9
//        8 9 2
//        ���:6
//        ·��:
//        (0,0) (0,1) (0,0) (1,0) (2,0) (2,1)


���ߣ�sunyinkai
���ӣ�https://www.nowcoder.com/discuss/216316?type=0&order=0&pos=53&page=1
��Դ��ţ����

#include<cstdio>
#include<cstring>
#include<algorithm>
using namespace std;
const int MAXK=17;
const int MAXN=507;
int  a[MAXN][MAXN];
int dp[MAXN][MAXN][MAXK];
int dx[4]={-1,1,0,0},dy[4]={0,0,1,-1};
int N,M,K;
int dfs(int x,int y,int k){
    if(dp[x][y][k]!=-1)return dp[x][y][k];
    int ans=0;
    for(int i=0;i<4;++i){
        int nx=x+dx[i],ny=y+dy[i];
        if(nx>=0&&nx<N&&ny>=0&&ny<M){
            if(a[x][y]<=a[nx][ny]){
                if(k>=1){
                    ans=max(ans,dfs(nx,ny,k-1)+1);
                }
                else ans=max(ans,0);
            }
            else{
                ans=max(ans,dfs(nx,ny,k)+1);
            }
        }
    }
    return dp[x][y][k]=ans;
}

int main(){
    scanf("%d%d%d",&N,&M,&K);
    for(int i=0;i<N;++i){
        for(int j=0;j<M;++j){
            scanf("%d",&a[i][j]);
        }
    }
    memset(dp,-1,sizeof(dp));
    int ans=0;
    for(int i=0;i<N;++i){
        for(int j=0;j<M;++j){
            for(int k=0;k<=K;++k){
                ans=max(ans,dfs(i,j,k)+1);
            }
        }
    }
    printf("%d\n",ans);
    return 0;
}