
https://leetcode.cn/problems/regular-expression-matching/solutions/763744/zheng-ze-biao-da-shi-pi-pei-dong-tai-gui-c4iv/

公式推导 refer 完全背包

部分Copy自link

<img src="https://raw.githubusercontent.com/maomaomqiu/Images/main/01.png" />

# 注
$S,P$的有效字符串下标从1开始

# 情况1
$P[j]$为`.`或字母，则 $f[i][j] \leftarrow f[i-1][j-1]$

# 情况2
$P[j]$为`*`

$P[j]$影响$P[j-1]$,使得$P[j-1]$匹配$n==0$次
- $f[i][j] \leftarrow f[i][j-2]$
<img src="https://raw.githubusercontent.com/maomaomqiu/Images/main/Weixin%20Image_20251207071205_19_8.jpg" alt="image" style="width:30%;"/>

$P[j]$影响 $P[j-1]$,使得 $P[j-1]$ 匹配 $n==1$ 次
- $P[j-1]==S[i]$
TBD
- $$

<script src="https://cdn.jsdelivr.net/npm/mathjax@3/es5/tex-mml-chtml.js"></script>