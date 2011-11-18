#include<stdio.h>
#include<stdlib.h>
#include<sys/types.h>
#include<unistd.h>

int main()
{
	char* arglist[]={NULL};
	int retpid;
	
	retpid=fork();
	if(retpid==0)
	{
	
		execvp("ls",arglist);
		fprintf(stderr,"something went wrong with execvp\n");
	}
	else
	{
		sleep(2);
		printf("parent pid %d\n",getpid());
		return ;
	}
	printf("done with main program\n");
	return 0;
}
