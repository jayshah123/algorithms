#include<pthread.h>
#include<stdio.h>

void * printxs (void * unused)
{
	while(1)
	{
		sleep(1);
		fputc('x',stderr);
	}
	return NULL;
}

int main()
{
	pthread_t threadid;
	pthread_create (&threadid, NULL, &printxs, NULL);
	while(1){
		sleep(1);
		fputc('o',stderr);
		}
	return 0;
}
	
	
