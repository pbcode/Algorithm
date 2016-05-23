# Algorithm

#锻炼硬本领（算法）

##一、组合算法

```
类名：AlgorithmForAssemble.java
```
```
说明：整体思想如下，首先依次将数组每一个元素放置第一位，其他位元素仍按原始顺序。
      在过程中，再依次将最后一位往前移位，直至回到原始状态。
```
```
举例：abcd进行组合
      第一组：
      第一步：创建abcd
      第二步：对d进行移位，abcd->abdc->adbc
      第三步：对c进行移位，adbc->adcb->acdb
      第四步：对b进行移位：acdb->acbd
      结果：abcd , abdc , adbc , adcb , acdb , acbd
      依次类推最后得到
      abcd , abdc , adbc , adcb , acdb , acbd
      bacd , badc , bdac , bdca , bcda , bcad
      cabd , cadb , cdab , cdba , cbda , cbad
      dabc , dacb , dcab , dcba , dbca , dbac
```
