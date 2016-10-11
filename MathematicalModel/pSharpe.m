function y = pSharpe(r, rf)
% 计算sharpe比率
% 输入：
% r: 个券日收益率[m×n]，n=20,120,250,500
% rf: 无风险利率[1×1],输入参数为一年期定存利率
% 输出：
% y: Sharpe比率[m×1]

% 将年无风险利率转化成日无风险利率
rf = rf/250;

[m,n]=size(r);
rf=rf*ones(m,n);

y=zeros(m,1);
% 计算个券的波动率
std_r = std(r,0,2);

i=find(std_r==0);
y(i)=NaN;
i=find(std_r~=0);
if ~isempty(i)
  y(i) = (mean(r(i,:) - rf(i,:),2))./std_r(i);
end