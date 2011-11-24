#include<iostream>
#include<list>
#include<algorithm>
#include<vector>
#include<string>
 
#define REP(i,n) for(int i=0;i<n;i++)
#define FOR(i,s,n) for(int i=s;i<n;i++)

#define SZ 8

int v[SZ];
int p[SZ];
int d[SZ];
int g[SZ][SZ]={{0,1,0,0,1,0,0,0},
				{1,0,0,0,0,1,0,0},
				{0,0,0,1,0,1,1,0},
				{0,0,1,0,0,0,1,1},
				{1,0,0,0,0,0,0,0},
				{0,1,1,0,0,0,1,0},
				{0,0,1,1,0,1,0,1},
				{0,0,0,1,0,0,1,0}};//this is as graph representation of graph given in cormen.

using namespace std;

int printpath(int i)
{
  if(i==1){
           cout<<1;
           return 1;}
  else{
     cout<<i;
     return printpath(p[i]);
  }
}

int main(){
	
	REP(i,SZ){ v[i]=0; p[i]=0; d[i]=0; }//no vertex is visited 
    	
	list<int> q;
	v[1]=1;
	q.push_back(1);
	p[1]=1;
	
	while(q.size())
	{
		int u;
		u = q.front();
		q.pop_front();
		cout<<u<<endl;
		REP(i,SZ){ if(!v[i] && g[u][i]) {v[i]=1; p[i]=u; d[i]=d[u]+1; q.push_back(i);}}
		 
	}
cout<<endl;
REP(i,SZ) cout<<p[i]<<endl;
cout<<endl;
printpath(3);
cout<<endl;
cout<<d[7]<<endl;
system("pause");
}
	
	
	

