#include<stdio.h>
#include<stdlib.h>
#include<unistd.h>
#include<wait.h>
#include<signal.h>
int main()
{
	int pid,status;
	
	pid = fork();
	
	if(pid>0)
	{
		wait(&status);
		if(WIFEXITED(status))
			printf("child exited normally with status %d\n",WEXITSTATUS(status));
		else
			printf("child exited abnormally with status %d\n",WEXITSTATUS(status));
		
	} else {
		printf("child sleeping for 3 secs ...\n");
		sleep(3);	
		exit(11);
	}

	return 0;
}	
