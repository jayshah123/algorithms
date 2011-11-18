#include<getopt.h>
#include<stdio.h>
#include<stdlib.h>

const char* program_name;


//array of structures specifying options
const struct option long_options[] = {
	{"help",0,NULL,'h'},//first longname,arguments expected,NULL,shortname
	{"output",1,NULL,'o'},
	{"verbose",0,NULL,'v'},
	{NULL,0,NULL,0},//last all zeroes
};

//getopt_long takes argc argv shortvalidoptions and long_options

//each time you call get_optlong, it parses a single option, returning short option for that letter

void print_usage(FILE* stream, int exit_code)  //print usage information ot stream and exit with exit code 
{
	fprintf(stream,"usage : %s options [ inputfile ... ] \n",program_name);
	fprintf(stream,
		"	-h	--help			Display this usage information.\n"
		"	-o	--output filename 	Write output to file filename.\n"
		"	-v	--verbose		Print Verbose Messages.\n");
	exit(exit_code);
}

int main(int argc, char * argv[])
{
	int next_option=0;
	
	const char* const short_options="ho:v";//a string listing valid short option letters

	//initial settings
	const char* output_filename = NULL;
	int verbose = 0;
	
	//name of the program
	program_name=argv[0];
	
	while(next_option!=-1){
		next_option=getopt_long(argc,argv,short_options,long_options,NULL);
		printf("option : %d\n",next_option);
		switch(next_option)
		{
			case 'h': print_usage(stdout,0);
				  break;
			
			case 'o': output_filename=optarg;
				  break;

			case 'v': verbose =1;
				  break;

			case '?': print_usage(stderr,1);//invalid option
				  break;
	
			case -1:  break;

			default: abort();
		}
	}

	//done with options . OPTIND points to first nonoption argument.
	
	if(verbose){
		int i;
		for( i = optind;i<argc;i++)
			printf("Argument : %s\n",argv[i]);
		return 0;
	}
}	
