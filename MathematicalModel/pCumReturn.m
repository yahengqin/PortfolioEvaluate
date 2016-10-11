function y = pCumReturn(r)
% 计算一段时间的累积收益率
% 输入：
% r: 个券日收益率 [m×n],m只券，n日的收益率，n=20,120,250,500
% 输出：
% y: 所有证券一段时间内的累积收益率[m×1]

cum_r = cumprod(1 + r, 2) - 1;
y = cum_r(:,end);
