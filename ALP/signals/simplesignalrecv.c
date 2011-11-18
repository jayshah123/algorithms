#include<stdio.h>
#include<stdlib.h>
#include<unistd.h>
#include<signal.h>

void signal_catch(int signo)
{
	fprintf(stderr,"\ncaught a signal %d\n",signo);
}

int main()
{
	struct sigaction act;

	act.sa_handler=signal_catch;
	act.sa_flags=0;
	sigemptyset(&act.sa_mask);
	
	sigaction(SIGINT,&act,NULL);
	sigaction(SIGALRM,&act,NULL);
//interrupt disturbs a single sleep() or a pause()
	sleep(10);
	sleep(10);
	printf("end of a program \n recvd a signal\n");
	
	return 0;
}
