N=input('enter no. of samples');
x = zeros(1,N);
for d = 1:N
    x(d) = input('value no ');
end
x

wn=exp(i*pi)
wn

w = zeros(n);

for a = 1:N
    for j = 1:N
        if a==1 || j==1
            w(a,j)=1;
        else
            w(a,j)=wn^(j*a);
        end
    end
end
w
            