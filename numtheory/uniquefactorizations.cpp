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

int count(int n, int lastFactor) {
    int result = 0;
    for (int a = lastFactor; a*a <= n; a++) 
    if (n % a == 0) 
        result += count(n/a, a) + 1;
    return result;
}

int main()
{
     printf("%d\n",count(9240,2));
    system("pause");
    return 0;
}
