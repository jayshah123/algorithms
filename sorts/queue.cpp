#include<iostream>
#include<string>
#include<vector>
#define Rep(i,n)  for(int i=0;i<n;i++)
#define MAXQUEUE 100
#define TRUE 1
#define FALSE 0
//saves MAXQUEUE-1 elements.
//hav to comporomise 1 element.
struct qu{
       int items[MAXQUEUE];
       int front,rear;
};
struct qu q;

void qinit(struct qu *q)
{
     q->rear=q->front=MAXQUEUE-1;
}

int empty(struct qu * q)
{
    return ((q->front==q->rear)?TRUE:FALSE);
}

void insert(struct qu * q,int x)
{
     //IOA
     if(q->rear==MAXQUEUE-1)
                            q->rear=0;
     else
                            (q->rear)++;
     if(q->rear==q->front){
                          printf("overflow\n");
                          exit(1);
     }
     q->items[q->rear]=x;
     return ;
}

int remove(struct qu *q)
{
    //OIR
    if(empty(q)){
                printf("underflow\n");
                exit(1);
                }
    if(q->front==MAXQUEUE-1)
                            q->front=0;
    else
                            (q->front)++;
    return q->items[q->front];
}



                
using namespace std;
int main()
{
    qinit(&q);
    insert(&q,3);
    insert(&q,5);
    insert(&q,23);
   system("pause");
    cout<<remove(&q)<<endl;
    system("pause");
    cout<<remove(&q)<<endl;
    system("pause");
    
    cout<<remove(&q)<<endl;
    system("pause");
  //  cout<<remove(&q)<<endl;
    
system("pause");
return 0;
}
