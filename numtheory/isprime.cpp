#include<iostream>
#include<list>
#include<algorithm>
#include<vector>
#include<string>
#include<cmath>
 
#define REP(i,n) for(int i=0;i<n;i++)
#define FOR(i,s,n) for(int i=s;i<n;i++)


using namespace std;

bool ispprime(int n){
	if(n%2==0) return false;
	for(int i=3;i<=(int)sqrt(n);i=i+2){
		if(n%i==0)	return false;
	} 
	return true;
} 


int main(){
int n;
cout<<"enter your no \n"<<endl;
cin >> n;
cout<<"your no is "<<endl;
cout<<ispprime(n)<<endl;;
return 0;
}
