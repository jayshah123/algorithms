#include<iostream>
#include<cstdlib>
using namespace std;

#define SZ 6

int v[SZ];
int g[SZ][SZ]={{0,1,1,0,0,0},
               {0,0,0,1,0,0},
               {0,1,0,0,1,0},
               {0,0,0,0,0,0},
               {0,0,0,0,0,1},
               {0,0,0,0,0,0}};
void dfs(int a){
if(v[a]) return;//if vertex already visited return

v[a] = 1;//else visit the vertex
cout << a;
for(int i = 0 ; i < SZ ; i++)//check for
if(g[a][i])//adjacents
dfs(i);//call
}


int main()
{
 
    
// function calls
for(int i = 0 ; i < SZ ; i++)
        v[i] = 0;//no vertex has been visited
for(int i = 0 ; i < SZ ; i++)
        if(!v[i])
                dfs(i);

//for(int i=0;i<6;i++)
  //      cout<<endl<<v[i];
    system("pause");
    return 0;
}
