# 数据范围与时间复杂度

<img src="photos\01.png"/>

# Useful Link
- 贪心算法总结
    - https://leetcode.cn/discuss/post/3091107/fen-xiang-gun-ti-dan-tan-xin-ji-ben-tan-k58yb/
- DP 模版
    - https://gitee.com/zhihongshuo/zhs_algorithm1000/tree/master/%E5%8A%A8%E6%80%81%E8%A7%84%E5%88%92%E8%A7%A3%E9%A2%98%E6%A8%A1%E6%9D%BF

# Habbit
## Java
### Common
1. 面试之前，可以问面试官能否改变输出结构
### Variable
#### Example1
Bad
```java
int m = matrix.length;
int n = matrix[0].length;
```

Good
```java
int m = matrix.length, n = matrix[0].length;
```

#### Example2
Bad
```Java
arr[cnt] = 0;
cnt++;
```

Good
```Java
arr[cnt++] = 0;
```

### String
Good
```Java
s == null || s
```