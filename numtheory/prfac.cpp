#include<iostream>
#include<string>
#include<vector>
#include<cmath>
#include<algorithm>

using namespace std;

int main()
{
	int x;
	cin >> x;
	int c=0;
	//////////////////////////
	for(int i=2;i*i<=x;i++)
	{
		while(x%i==0){
			c++;
			x=x/i;
		}
	}
	c+=((x!=1)?1:0);
	///////////////////////////
	cout << c<<" "<<x;
	return 0;
}
