function y = pVaR(r)
% 计算VaR值函数
% 输入：
% r: 个券日收益率 [m×n],m只券，n日的收益率
% 输出：
% y: 所有证券的历史VaR列向量[m×1]

m=size(r,1);

iLen = size(r, 2);
if iLen <= 1 
  y = 0;
else
  r = sort(r, 2);
  %计算当前分位数vCon对应的位置（靠下的一个）
  iForePos = 1 + floor(0.05 * (iLen - 1));
  %计算当前分位数距离靠下位置的位移
  vMultiNum = 0.05 * (iLen - 1) - floor(0.05 * (iLen - 1));
  %通过位移给上下两个点的收益率加权
  y = r(:, iForePos) + vMultiNum * (r(:, iForePos + 1) - r(:, iForePos));
end;