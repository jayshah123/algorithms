

#include<iostream>
#include<cstdlib>
using namespace std;

#define SZ 6

int v[SZ];
int p[SZ];
int g[SZ][SZ]={{0,1,0,1,0,0},
               {0,0,0,0,1,0},
               {0,0,0,0,1,1},
               {0,1,0,0,0,0},
               {0,0,0,1,0,0},
               {0,0,0,0,0,1}};
               
int printpath(int i)
{
  if(p[i]==i){
           cout<<i;
           return i;}
  else{
     cout<<i;
     return printpath(p[i]);
  }
}

void dfs(int u){
if(v[u]) return;//if vertex already visited return

v[u] = 1;//else visit the vertex
cout << u;
for(int i = 0 ; i < SZ ; i++)//check for
if(g[u][i]&&!v[i])//adjacents
{
               
                      p[i]=u;
                      dfs(i);//call
}

}
int main()
{
 
    
// function calls
for(int i = 0 ; i < SZ ; i++)
      {  v[i] = 0;//no vertex has been visited
         p[i]=0;
      } 
for(int i = 0 ; i < SZ ; i++)
        if(!v[i]){
                  p[i]=i;
                dfs(i);
        }
cout<<endl;
for(int i=0;i<6;i++)
        cout<<endl<<p[i];

cout<<endl<<endl;
printpath(1);
    system("pause");
    return 0;
}
