#include<stdio.h>
#include<stdlib.h>
#include<unistd.h>
#include<fcntl.h>


int main()
{
	int pid,fd1;
	fd1=open("simple.txt",O_RDONLY);
	char buf[1023];
	memset(buf,'\0',sizeof(buf));

	pid=fork();
	if(pid>0)
	{
		sleep(2);
		//parent
		read(fd1,buf,4);	
		printf("%s\n",buf);
	}
	else
	{
		//child
		read(fd1,buf,4);
		printf("%s\n",buf);
		close(fd1);
	}
//	close(fd1);
	return 0;
}
