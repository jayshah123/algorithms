arr = [1,2,3,4,5,6,7,8];
x=zeros(8,8);
k=0;
for i=1:8
    for j = 0:7
       x(i,j+1)=arr(mod(j+k,8)+1);
    end
   k=k+1;
end
x