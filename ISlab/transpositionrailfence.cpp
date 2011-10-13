#include<algorithm>
#include<vector>
#include<string>
#include<iostream>

#define rep(t,n) for(int t=0;t<n;t++);

using namespace std;

#define down 2
#define up 1

int main()
{
    string pt;
    
    cin >> pt;
    int nofar;
    cin>>nofar;
    int cnt=0;
    int dir=2;
    int count[nofar];
    memset(count,0,sizeof(count));        
    string arr[nofar],keystring,decrarr[nofar],finaloutp="",fullcipher="";
  int prevpos=-1;
    
    cout<<"enter the keyword of lenght less than or equal to no. of arry"<<endl;
    cin>>keystring;
    int key[keystring.size()];
    for(int i=0;i<26;i++){
            for(int j=0;j<keystring.size();j++){
            if('a'+i==pt[j])
                            key[j]=cnt++;
            }
    }
    for(int i=0;i<keystring.size();i++)
            cout<<key[i];
    
    for(int i=0;i<nofar;i++)
    {        arr[i].resize(pt.size());
             arr[i]="";
     }
    
    for(int i=0;i<pt.size();i++){
                                   
           if(prevpos>=nofar-1)
           dir=up;
           
           
           if(prevpos<=0)
           dir=down;
           
           if(dir==down)
           prevpos++;
           
           
           if(dir==up)
           prevpos--;
           
            //cout<<prevpos<<endl;
           arr[prevpos]+=pt[i];                      
    }
          
    for(int i=0;i<nofar;i++){
    cout<<arr[key[i]];
    fullcipher+=arr[key[i]];
}
    cout<<endl;
//--------decryption
                    prevpos=-1;
    for(int i=0;i<pt.size();i++){
                                   
           if(prevpos>=nofar-1)
           dir=up;
           
           
           if(prevpos<=0)
           dir=down;
           
           if(dir==down)
           prevpos++;
           
           
           if(dir==up)
           prevpos--;
           
           cout<<prevpos<<endl;
           count[prevpos]++;                      
    
    }
cout<<endl;
int var=0;
for(int i = 0;i<nofar;i++){
        
        cout<<count[i];
        decrarr[key[i]]=fullcipher.substr(var,count[key[i]]);
        var+=count[key[i]];
}
int cn[nofar];
memset(cn,0,sizeof(cn));
for(int i=0;i<nofar;i++)
        cout<<decrarr[i]<<endl;

                         prevpos=-1;
    for(int i=0;i<pt.size();i++){
                                   
           if(prevpos>=nofar-1)
           dir=up;
           
           
           if(prevpos<=0)
           dir=down;
           
           if(dir==down)
           prevpos++;
           
           
           if(dir==up)
           prevpos--;
           
           //cout<<prevpos<<endl;
           cout<<arr[prevpos][cn[prevpos]++ ];                     
    
    }
    cout<<endl;
    system("pause");   
    return 0;
}
