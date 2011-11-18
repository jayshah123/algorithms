#include<stdio.h>
#include<stdlib.h>
//proof that stdout is buffered value printed only when stdout is filled by 1024 bytes;
//and stderr is not . is printed every second
int main(int argc, char * argv[]){
	
	int casenum = atoi(argv[1]);
	switch(casenum){

	case 0:	while(1){
			printf("aaaaaaaabbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb.");
			sleep(1);
		}
		break;
	case 1: while(1){
			fprintf(stderr,".");
			sleep(1);
		}
		break;
	default : fprintf(stderr,"invalid option\n");
	}
	return 0;

}
