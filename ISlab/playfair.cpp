#include<iostream>
#include<cstdio>
#include<vector>
#include<cstring>
#define MX 5
#define rep(i,n) for(int i=0;i<n;i++)

using namespace std;
void playfair(char ch1,char ch2, int keymatrix[MX][MX])
{
 int i,j,w,x,y,z;
 

 for(i=0;i<MX;i++)
 {
  for(j=0;j<MX;j++)
  {
   if(ch1==keymatrix[i][j])
   {
    w=i;
    x=j;
   }
   else if(ch2==keymatrix[i][j])
   {
    y=i;
    z=j;
   }
  }
 }
 
 if(w==y)
 {
  x=(x+1)%5;z=(z+1)%5;
  printf("%c%c ",keymatrix[w][x],keymatrix[y][z]);
  
 }
 else if(x==z)
 {
  w=(w+1)%5;y=(y+1)%5;
  printf("%c%c ",keymatrix[w][x],keymatrix[y][z]);
  
 }
 else
 {
  printf("%c%c ",keymatrix[w][z],keymatrix[y][x]);
  
  }

}
void displaymatrix(int a[][5])
{
     rep(i,5){
              rep(j,5) { 
                       cout<<(char)a[i][j]<<' ';
                       } 
                       cout<<endl;
              }
}
     
bool isrep(char val,int st,int stop,char *str)
{
     for(int i = st;i<stop;i++)
     {        if(str[i]==val)
             return true;
             }
     return false;
}

int main()
{
    int keymatrix[5][5];
    char inp[100],key[25],pt[1024];
    int keylen;
    char alpha[]="abcdefghiklmnopqrstuvwxyz";
    printf("enter key\n");
    scanf("%s",inp);
    memset(key,'\0',sizeof(key));
    int j=0;
    for(int i=0;i<strlen(inp);i++)
    {
     if(strchr(inp,inp[i])<inp+i)
     continue;     
     key[j]=inp[i];
     j++;
    }        
    keylen=j;
    cout<<keylen<<endl;
        
    for(int i=0;i<25;i++)
    {
     if(isrep(alpha[i],0,keylen,key))
     continue;
     key[j]=alpha[i];
     j++;
    }
 // cout<<key<<endl;
    
    for(int i=0;i<strlen(key);i++)
    {
            keymatrix[i/5][i%5]=key[i];
    }
    displaymatrix(keymatrix);
    cout<<"Enter Plain Text :-"<<endl;
    scanf("%s",pt);
    for(int i=0;i<strlen(pt);i=i+2){
    if(pt[i]==pt[i+1])
    {playfair(pt[i],'x',keymatrix);
    i--;}
    else
    playfair(pt[i],pt[i+1],keymatrix);
}
    system("pause");
    return 0;
}
