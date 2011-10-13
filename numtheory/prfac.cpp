#include<iostream>
#include<string>
#include<vector>
#include<cmath>
#include<algorithm>

#define REP(i,n) for(int i=0;i<n;i++)
using namespace std;

int main()
{
	int x;
	cin >> x;
	int n=x;
    int c=0;
	int k[n];
	int ans=1;
	REP(i,n) k[i]=1;
	//////////////////////////
	for(int i=2;i*i<=x;i++)
	{
		
        while(x%i==0){
             // k[i]++;
        			printf("%d\n",i);
			x=x/i;
		}
	}
	//c+=((x!=1)?1:0);
	///////////////////////////
	if(x!=1)
	        printf("%d\n",x);
 
  //  REP(i,n){ //cout<<k[i]<<endl;
    //           ans=ans*k[i];
    //}
    //ans = ans -2;
 //   cout << /*c<<" "<<*/ans<<endl;
    system("pause");
	return 0;
}
