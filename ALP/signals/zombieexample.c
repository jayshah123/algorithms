//it is always the responsibbilty of parent to clean up it's child

//in cases if it does not happen so child is zombie and is taken care of by init.

#include<stdio.h>
#include<stdlib.h>
#include<sys/types.h>
#include<unistd.h>

int main()
{
	int pid;
	pid = fork();
	if(pid>0){
		sleep(60);
	} else {
		exit(0);
	}
	return 0;
}
