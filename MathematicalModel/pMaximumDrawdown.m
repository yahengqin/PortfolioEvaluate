function y = pMaximumDrawdown(r)
% 计算最大回撤
% 输入：
% r: 个券日收益率 [m×n],m只券，n日的收益率,n=20,120,250,500
% 输出：
% y：最大回撤值[m×1]

[m,n] = size(r);

% 剔除第一天的收益率
r = r(:,2:end);

% 计算累计收益率
cum_r = cumprod(1 + r, 2) - 1;
% 将收益率转化成价格
price = ones(m,n);
price(:,2:end) = ones(m,n-1).*(1+cum_r);

% 计算最大回撤
x = ones(m,n);
y = ones(m,1);
for i = 1:m
    for j = 1:n
        x(i,j) = price(i,j)/max(price(i,1:j))-1;
    end
    y(i) = min(x(i,:));
end
