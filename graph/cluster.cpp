#include<iostream>
#include<vector>
#include<algorithm>
#include<cassert>

using namespace std;

#define rep(i,n) for(int i=0;i<n;i++)
    int dist[6][6]={
                        {0,662,877,255,412,996},
                        {662,0,295,468,268,400},
                        {877,295,0,754,564,138},
                        {255,468,754,0,219,869},
                        {412,268,564,219,0,669},
                        {996,400,138,869,669,0}
};


int main()
{

int n=6; // initially every node is a cluster.
int m;     //sequence number
int mindist=99999;

for(int m=0;m<5;m++){//sequence no.

rep(i,6){ 
          rep(j,6) { 
                   if(dist[i][j]>0)
                   if(dist[i][j]<mindist)
                   mindist=dist[i][j];
                   }
          }


}

    
    system("pause");
    return 0;
}
