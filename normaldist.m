mu=100;
sigma=15;
xmin=70;
xmax=130;
n=100; %no of points on pdf and cdf plot
k=10000;

%create a set of values ranging from xmin to xmax

x=linspace(xmin,xmax,n);
p=normpdf(x,mu,sigma);

figure(1);
clf;

subplot(1,3,1);
plot(x,p,'k-');
xlabel('x');
ylabel('pdf');
title('Probability density function');
