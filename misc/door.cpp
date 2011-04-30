#include<iostream>
#include<cstdlib>
using namespace std;

void usedoor(int ar[],int choice){
    int k=1;
     while(choice*k<=10){
                           ar[choice*k-1]++;
                           ar[choice*k-1]=ar[choice*k-1]%2;
                           k++;
                           }
         }
    

int main()
{
    int choice;
    int k=1;
    int door[10];
    for(int i=0;i<10;i++)
            door[i]=0;
    
  while(1){
    printf("enter your choice \n");
    scanf("%d",&choice);
    if(choice==99)        //press 99 to exit
                      exit(0);
    usedoor(door,choice);
    
  
    //while(choice*k<=10){
      //                     (door[choice*k-1]++)%2;
        //                   k++;
          //                 }
   cout<<endl;
    for(int i=0;i<10;i++)
            cout<<door[i]<<endl;
}
    system("pause");
    return 0;
}
