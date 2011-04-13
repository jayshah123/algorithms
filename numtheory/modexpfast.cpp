#include<iostream>
#include<cstdlib>
using namespace std;

long modexpfast(long b,long n,long m)//to calculate b^n mod m
{
    long ans,power=b%m,x;
    x=1;
    
    while(n){
    //cout<<n<<endl;
    if(n%2==1)
    x=(x*power)%m;
    power=(power*power)%m;
    n>>=1;
}
    
    return x;
}
int main()
{

long k;
k=modexpfast(3,644,645);
cout<<k<<endl;
    system("pause");
    return 0;
}
