#include<stdio.h>
#include<stdlib.h>
//stdout is buffered and hence "hello jay shah" is printed after 10 s when the program is closed and stdout is needed to be flushed
int main(){
	int k;
	printf("hello jay shah");
	fflush(stdout);
	k=sleep(10);
	printf("%d\n",k);
	return 0;
}
