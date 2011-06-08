#include<algorithm>
#include<vector>
#include<string>
#include<vector>
#include<cstdio>
#include<iostream>
#define REP(i,n) for( int i = 0 ; i < n ; i++ )
int n;

using namespace std;

int main(){
	cout << " N = ";
	cin >> n;
	int A[n][n],B[n][n],C[n][n];
	cout << "first "<<endl;
	REP(i,n) REP(j,n) scanf("%d",&A[i][j]);
	cout << "second "<<endl;
	REP(i,n) REP(j,n) scanf("%d",&B[i][j]);
	REP(i,n)REP(j,n){C[i][j]=0; REP(k,n) C[i][j]+=A[i][k]*B[k][j];}
	REP(i,n) REP(j,n) cout << C[i][j];
	return 0;
}
