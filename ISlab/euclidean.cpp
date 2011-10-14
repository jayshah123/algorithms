#include<iostream>
#include<string>
#include<vector>
#define Rep(i,n)  for(int i=0;i<n;i++)
using namespace std;
int gcd(int a, int b){
    if(b==0)
    return a;
    else
    return gcd(b,a%b);    
}
    
int main()
{
int a,b;
cout<<"enter no. for  which u want to find gcd "<<endl;
cin>>a>>b;
cout << gcd(a,b);
system("pause");
return 0;
}
