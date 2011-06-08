#include<iostream>
#include<algorithm>
#include<string>
#include<vector>
#include<cstdlib>
#include<cstdio>

using namespace std;

int main()
{
	int arr[]={1,2,-3,4,6,-5};
	int mx[]={0,0,0,0,0,0};
	int m=0;
	for(int i=0;i<6;i++){
		mx[i]=max(arr[i]+mx[i-1],arr[i]);
		if(m<mx[i])
			m=mx[i];
		cout<<mx[i]<<" "<<m<<endl;}
	cout<<endl<<"max is "<<m;
	return 0;
}
		
