
https://leetcode.cn/problems/regular-expression-matching/solutions/763744/zheng-ze-biao-da-shi-pi-pei-dong-tai-gui-c4iv/

公式推导 refer 完全背包(TBD, add link from 完全背包)

部分Copy自link

<img src="https://raw.githubusercontent.com/maomaomqiu/Images/main/01.png" />

# 注
$S,P$的有效字符串下标从1开始
根据 $P[j]$ 为`.` 或者字母或者`*`，可以有两种情况

# 情况1
$P[j]$为`.`或字母，则 $f[i][j] \leftarrow f[i-1][j-1] \ and \ (P[j-1] == S[i] \ or \ P[j-1] == ''.'')$


# 情况2
$P[j]$为`*`, `*`代表可以匹配 $P[j-1]$ 0, 1, ..k次，记为 $m(0), m(1), ..., m(k)$

$f[i][j] \leftarrow m(0) \ or \ m(1) \ or \ ... \ or \ m(k)$

## 公式推导
### 匹配0次 m(0)
$P[j]$影响 $P[j-1]$ ,使得 $P[j-1]$ 匹配 $n==0$ 次

<img src="https://raw.githubusercontent.com/maomaomqiu/Images/main/d770d90aea6b6c7cdb6545e28e38005e.jpg" alt="image" style="width:30%;"/>

<img src="https://raw.githubusercontent.com/maomaomqiu/Images/main/c6c03dcf704210b018323cfa2d2aaf28.jpg" alt="image" style="width:30%;"/>



- $m(0) \leftarrow f[i][j-2]$

### 匹配1次 m(1)
$P[j]$影响 $P[j-1]$,使得 $P[j-1]$ 匹配 $n==1$ 次
- $P[j-1]==S[i]$
- $P[j-1]==''.''$

<img src="https://raw.githubusercontent.com/maomaomqiu/Images/main/4611104719c1f1058767fc1ddb94c79e.jpg" alt="image" style="width:30%;"/>

- $m(1) \leftarrow f[i-1][j-2] \ and \ (P[j-1] == S[i] \ or \ P[j-1] == ''.'')$



### 匹配2次 m(2)
$P[j]$影响 $P[j-1]$,使得 $P[j-1]$ 匹配 $n==2$ 次
- $P[j-1]==S[i] \ and \ S[i] == S[i-1]$
- $P[j-1]==''.'' \ and \ S[i]==S[i-1]$

<img src="https://raw.githubusercontent.com/maomaomqiu/Images/main/24d4818951992fcadaec45e47aa4992f.jpg" alt="image" style="width:30%;"/>

- $m(2) \leftarrow f[i-2][j-2] \ and \ (P[j-1] == S[i] \ or \ P[j-1] == ''.'') \ and \ S[i] == S[i-1]$



### 匹配k次 m(k)
由此可以推得
$P[j]$影响 $P[j-1]$,使得 $P[j-1]$ 匹配 $n==k$ 次

- $m(k) \leftarrow f[i-k][j-2] \ and \ (P[j-1] == S[i] \ or \ P[j-1] == ''.'') \ and \ S[i] == S[i-1] \ and \ S[i]==S[i-2] .. \ and \ S[i] == S[i - (k-1)]$ 




## 优化公式

假设S,P长度均为N,k在极端情况下可以接近N,所以计算 $f[i][j]$ 的时间复杂度 接近 $O(N^3)$，可以进一步优化

记S中 $S[i]$ 和 $P[j-1]$ match为 $S_i$

- $m(1) \leftarrow f[i-1][j-2] \ and \ S_i$

记S中 $S[i-1]$ 和 $P[j-1]$ match为 $S_{i-1}$

- $m(2) \leftarrow f[i-2][j-2] \ and \ S_i \ and \ S_{i-1}$

记S中 $S[i-(k-1)]$ 和 $P[j-1]$ match为 $S_{i-(k-1)}$

- $m(k) \leftarrow f[i-k][j-2] \ and \ S_i \ and \ S_{i-1} ... \ and \ S_{i-(k-1)}$

由此

$f[i][j] \leftarrow f[i][j-2] \ \ or \ \ (f[i-1][j-2] \ and \ S_i) \ \ or \ \ (f[i-1][j-2] \ and \ S_i \ and \ S_{i-1}) \ \ or \ ...$

$f[i-1][j] \leftarrow f[i-1][j-2] \ \ or \ \ (f[i-2][j-2] \ and \ S_{i-1}) \ \ or \ \ (f[i-3][j-2] \ and \ S_{i-1} \ and \ S_{i-2}) \ \ or \ ...$

$f[i][j] \leftarrow f[i-1][j] \ and \ S_i$

$f[i][j] \leftarrow f[i-1][j] \ and \ (P[j-1] == S[i] \ or  P[j-1] == ''.'')$

此时，计算 $f[i][j]$ 的时间复杂度 优化为 $O(N^2)$

# 汇总
对于$S[i]$, $P[j]$ 为`.`或字母
- $f[i][j] \leftarrow f[i-1][j-1] \ and \ (P[j-1] == S[i] \ or \ P[j-1] == ''.'')$

$P[j]$为`*`
- $f[i][j] \leftarrow f[i-1][j] \ and \ (P[j-1] == S[i] \ or \ P[j-1] == ''.'')$

# 初始情况

$f[0][0]$ is true

$f[1][0], f[2][0], ... f[n][0]$ is false, 因为S只要有长度，P无法匹配

$f[0][n], n \ge 1$, S长度为0可以匹配

- "*" → **Note** 这种串是不合法的
- "***" → **Note** 这种串是不合法的
- ".\*" or "a\*"
- ".\*a\*" 

所以初始化规则
- 当 $p[j] == ''*''$ :
    - $f[0][j] = f[0][j-2]$
- 否则:
    - $f[0][j] = false$

# Hint
- 题目中的提示很重要，特别是**保证**


