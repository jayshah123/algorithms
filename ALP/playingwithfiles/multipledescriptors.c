#include<stdio.h>
#include<stdlib.h>
#include<unistd.h>
#include<fcntl.h>

int main()
{
	int fd1,fd2;
	char buf[1024];
	char buf2[1024];
	memset(buf2,'\0',sizeof(buf2));
	memset(buf,'\0',sizeof(buf));
	fd1 = open("simple.txt",O_RDONLY);
	fd2 = open("simple.txt",O_RDONLY);
	read(fd1,buf,4);
	printf("%s\n",buf);
	read(fd2,buf2,4);
	printf("%s\n",buf2);
	close(fd1);
	close(fd2);

	fd1 = open("simple.txt",O_RDONLY);
	fd2 = dup(fd1);
	read(fd1,buf,4);
	printf("%s\n",buf);
	read(fd2,buf2,4);
	printf("%s\n",buf2);	
	close(fd1);
	close(fd2);

	return 0;



}
