#include<iostream>
#include<string>

using namespace std;

#define REP(i,n) for(int i=0;i<n;i++)
#define N 4

int A[N][N],L[N][N],U[N][N];

int main(){
	
	REP(i,N) REP(j,N) scanf("%d",&A[i][j]);
		//scan A complete
	int n=N;
	REP(k,N){
		U[k][k]=A[k][k];
		for(int i=k+1;i<n;i++){
			L[i][k]=A[i][k]/U[k][k];
			U[k][i]=A[k][i];
		}
		for(int i=k+1;i<n;i++){
			for(int j=k+1;j<n;j++){
				A[i][j]=A[i][j]-L[i][k]*U[k][j];
			}
		}
	}
		
	REP(i,N) L[i][i]=1;
	cout<<"l======="<<endl;
	REP(i,N){ REP(j,N) { printf("%d ",L[i][j]);} cout<<endl;}
	cout<<"U========"<<endl;
	REP(i,N){ REP(j,N) { printf("%d ",U[i][j]);} cout<<endl;}
		
	
	
	return 0;
	}
