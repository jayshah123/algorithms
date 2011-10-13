#include<iostream>
#include<algorithm>
#include<string>
#include<vector>

using namespace std;

string encrypt(string key,string inp)
{
       string output;
       output.resize(inp.size());
       for(int i=0;i<inp.size();i++)
            key[i]=key[i%key.size()];
             
    for(int i=0;i<inp.size();i++)
            output[i]=((inp[i]+key[i])%26)+'A';
       
       return output;
}

string decrypt(string key,string inp)
{
       string output;
       output.resize(inp.size());
       for(int i=0;i<inp.size();i++)
            key[i]=key[i%key.size()];
       cout<<key;
    for(int i=0;i<inp.size();i++)
            output[i]=((inp[i]-key[i]+26)%26)+'A';
       
       return output;
}


int main()
{
    string inp,key,outp,fin;
    
    cin>>inp;
    cin>>key;
    int j=key.size();
    key.resize(inp.size());
    outp.resize(inp.size());
    fin.resize(inp.size());
    for(int i=0;i<inp.size();i++){
            if(inp[i]>90)
                         inp[i]=inp[i]-32;
    }
    for(int i=0;i<key.size();i++)
    {       if(key[i]>90)
                         key[i]=key[i]-32;
    }
    
    outp=encrypt(key,inp);
    fin=decrypt(key,outp);
    
   cout<<endl<<outp;
   cout<<endl<<fin;
    system("pause");   
    return 0;
}
