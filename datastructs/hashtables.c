#include<stdio.h>

#define NHASH 1000

typedef struct NameVal NameVal;
struct NameVal{
	char *name;
	int value;
	NameVal* next;
};

/* symbol table */
NameVal* symtab[NHASH];

/*
	Computes hash value of a string
	
	@param : string input for hash
	@return : hash value
	
*/

unsigned int hash(char *ptr)
{
	unsigned int h;
	unsigned char *p;
	
	for( p = (unsigned char *)ptr ; *p != '\0' ; p++ )
		h = 31*h+*p;
		
	return h%NHASH;
}
	
	
/*
	lookup an element inside the hash table with an option of adding entry if not found
	
	@param searchKey : char key we are searching for
	@param create    : whether or not we want to add item
	@param value     : value corresponding to key
	
	@return NameVal* : pointer to struct that contains the key we are searching for
	
*/

NameVal* lookup(char *searchKey, int create, int value)
{
	NameVal* sym;
	unsigned int h;
	
	h = hash(searchKey);
	for(sym = symtab[h];sym != NULL; sym=sym->next){
		if(strcmp(sym->name,searchKey) == 0){
			return sym;
		}
	}
	if(create){
		sym = (NameVal *)malloc(sizeof(NameVal));
		sym->name= searchKey; //assume allocated elsewhere
		sym->value = value;
		sym->next = symtab[h];
		symtab[h] = sym;
	}
	return sym;
}

	
void initializeHashTable(void)
{
	int i = 0;
	for(;i<NHASH;i++)
		symtab[i]=NULL;
}	

int main()
{
return 0;
}