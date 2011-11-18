m=100;
sigma=15;
xmin=70;
xmax=130;
n=100;
k=10000;

x=linspace(xmin,xmax,n);
p=csnormp(x,mu,sigma);

figure(1);
clf;

subplot(1,3,1);
plot(x,p,'k-');
xlabel('x');
ylabel('pdf');
title('pdf');
