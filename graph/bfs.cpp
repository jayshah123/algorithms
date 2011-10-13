#include<iostream>
#include<list>
#include<algorithm>
#include<vector>
#include<string>
 
#define REP(i,n) for(int i=0;i<n;i++)
#define FOR(i,s,n) for(int i=s;i<n;i++)

#define SZ 8

int v[SZ];
int g[SZ][SZ]={{0,1,0,0,1,0,0,0},
				{1,0,0,0,0,1,0,0},
				{0,0,0,1,0,1,1,0},
				{0,0,1,0,0,0,1,1},
				{1,0,0,0,0,0,0,0},
				{0,1,1,0,0,0,1,0},
				{0,0,1,1,0,1,0,1},
				{0,0,0,1,0,0,1,0}};//this is as graph representation of graph given in cormen.

using namespace std;

int main(){
	
	REP(i,SZ) v[i]=0;//no vertex is visited 
	
	list<int> q;
	v[1]=1;
	q.push_back(1);
	
	while(q.size())
	{
		int a;
		a = q.front();
		q.pop_front();
		cout<<a<<endl;
		REP(i,SZ){ if(!v[i] && g[a][i]) {v[i]=1; q.push_back(i);}}
		 
	}

}
	
	
	

