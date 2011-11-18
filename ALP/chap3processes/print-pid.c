#include<stdio.h>
#include<unistd.h>

int main()
{
	printf("the process id of this process is %d\n",(int) getpid());
	printf("the parent process id is %d\n",(int) getppid());
	return 0;
}
