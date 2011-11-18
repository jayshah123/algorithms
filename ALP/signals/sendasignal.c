//use kill(pidofreciepent,signaltype) to send a signal
#include<stdio.h>
#include<stdlib.h>
#include<signal.h>
#include<unistd.h>
#include<wait.h>
void catch_signal(int signo)
{
	fprintf(stderr,"Signal Caught\n");
}

int main()
{
	int status;
	int pid;
	struct sigaction act;

	act.sa_handler=catch_signal;
	sigemptyset(&act.sa_mask);
	act.sa_flags=0;

	if(sigaction(SIGINT,&act,NULL) == -1) exit(1);

	pid=fork();
	if(pid>0){ /*parent*/
		pause();
		kill(pid,SIGTERM);
		wait(&status);
		if(WIFEXITED(status))
			printf("child exited normally with status %d\n",WEXITSTATUS(status));
		else
			printf("child exited abnormally with exit code %d\n",WEXITSTATUS(status));
	} else {
		sleep(10);
		kill(getppid(),SIGINT);
		pause();
	}
	
	return 0;
}
