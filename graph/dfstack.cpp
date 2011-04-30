#include<iostream>
#include<cstdlib>
#include<stack>
using namespace std;


#define SZ 6

int v[SZ];
int g[SZ][SZ]={{0,1,1,0,0,0},
               {0,0,0,1,0,0},
               {0,1,0,0,1,0},
               {0,0,0,0,0,0},
               {0,0,0,0,0,1},
               {0,0,0,0,0,0}};

void dfs(int st_ver)
{
     stack<int> s;
     int top;
     s.push(st_ver);
     while(s.empty()==false){
                           top=s.top();
                           //cout<<"checking "<<top<<endl;
                           s.pop();
                           if(v[top]){ //cout<<"ignoring "<<top<<endl;
                                       continue;}
                           v[top]=1;
                           cout<<"visited "<<top<<endl;  
                           for(int i = 0 ; i < SZ ; i++)//check for
                                   if(g[top][i]){
                                                // cout<<"pushing row "<<top<<"col "<<i<<endl;
                                              s.push(i);
                           }}
}

int main()
{
for(int i = 0 ; i < SZ ; i++)
        v[i] = 0;//no vertex has been visited
for(int i = 0 ; i < SZ ; i++)
        if(!v[i])
                dfs(i);
    system("pause");
    return 0;
}
