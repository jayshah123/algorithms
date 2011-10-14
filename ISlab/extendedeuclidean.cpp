#include<iostream>
#include<string>
#include<vector>

#include<map>
#include<algorithm>
#include<set>
#include<utility>
#define Rep(i,n)  for(int i=0;i<n;i++)
using namespace std;
pair<int,int> extendedgcd(pair<int,int> ab)
{
              if(ab.second==0)
                              return make_pair(1,0);
              else {
                              pair<int,int> qr = make_pair(ab.first/ab.second,ab.first%ab.second);
                              pair<int,int> st = extendedgcd(make_pair(ab.second,qr.second));
                              return make_pair(st.second,st.first-qr.first*st.second);
                              }
}


int main()
{
    pair<int,int> q = make_pair(23,120);
    pair<int,int> ans = extendedgcd(q);
    cout<< ans.first<<endl;

system("pause");
return 0;
}
