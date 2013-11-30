#include<stdio.h>
#include<string.h>
using namespace std;
int N;
//int used[3];
int cnt=0;
int ptr=0;

void swap(char str[],int a,int b){
	char t;
	t=str[a];
	str[a]=str[b];
	str[b]=t;
}

void permute(char str[],int n,int used[],char out[])//find all permutations from index n to N
{
	
	if(n==N){
		printf("%d %s\n",++cnt,out);
		
		return;
	}
	//used[n]=1;
	
	for(int j=0;j<N;j++){
		if(used[j])
		continue;
		out[ptr++]=str[j];
		used[j]=1;
		permute(str,n+1,used,out);
		used[j]=0;
		ptr--;
	}
	
}
	
int main()
{

char str[]="abc";
N=strlen(str);
char out[N];
int used[N];
for(int i=0;i<N;i++)
used[i]=0;
permute(str,0,used,out);
return 0;
}