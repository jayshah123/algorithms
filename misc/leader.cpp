//Find a leader in an array- a no. which repeats more than n/2 time
#include<iostream>
//the trick is O(n)
//maintain a stack and eliminate when two consecutive entries are different
using namespace std;
int main()
{

int nos[]={4,6,6,6,6,8,8};

int candidate, candidatecnt;
candidatecnt=1;
candidate = nos[0];

for(int i=1;i<7;i++){

	if(nos[i]!=candidate){
		candidatecnt--;
		if(candidatecnt==0)
			candidate=nos[i];
	} else {
		candidatecnt++;
		//candidate=nos[i]
	}
	
}


cout<<"candidate is "<<candidate<<endl;
return 0;
}

