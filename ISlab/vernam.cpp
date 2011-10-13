#include<iostream>
#include<string>
#include<vector>
#define Rep(i,n)  for(int i=0;i<n;i++)
using namespace std;
int main()
{
string key,pt,ct;
cout<<"enter plaintext"<<endl;
key.resize(pt.size());
cin>>pt>>key;
Rep(i,pt.size())
ct[i]=pt[i]^key[i];
system("pause");
return 0;
}
