N=input('enter no. of samples');
x = zeros(1,N);
for d = 1:N
    x(d) = input('value no ');
end
x

wn=exp(i*pi*(-2)/N)
wn

w = zeros(N);

for a = 0:N-1
    for j = 0:N-1
            w(a+1,j+1)=wn^(j*a);
    end
end
w

w*x'
