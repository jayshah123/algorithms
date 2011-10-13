#include<cstdlib>
#include<cctype>
#include<cstring>
#include<cstdio>
#include<algorithm>
#include<cmath>
#include<vector>
#include<string>
#include<iostream>
#include<sstream>
#include<map>
#include<set>
#include<queue>
#include<stack>

using namespace std;

typedef long long int64;
typedef long double real;

#define pb push_back
#define mp make_pair
#define x first
#define y second
#define FORI(i,l,r) for(int i=l;i<r;++i)
#define REP(i,n) for(int i=0;i<n;i++)

int fi(int n)
{
    int result=n;
    FORI(i,2,sqrt(n)) {
                if(n%i==0)
                          result = result - result/i;
                while(n%i==0) n/=i;
                }
    if(n>1) result -= result/n;
    return result;
}


int main()
{
    printf("%d\n",fi(12)); 
    system("pause");
    return 0;
}
