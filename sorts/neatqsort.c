void neatqsort(int l,int u)
{
     int i,m;
     if(l>=u)
             return;
     m=l;
     for(i=l+1;i<=u;i++){
                         if(x[i]<x[l])
                         swap(++m,i);
                         }
     swap(l,m);
     neatqsort(l,m-1);
     neatqsort(m+1,u);    
}
  