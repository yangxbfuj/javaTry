## 函数式编程

**Java 中的函数，应该理解为是实现了`java.util.fucntion`包中各种函数接口的类以及其对象**

### 5 高阶函数
| “高阶函数只是一个能接受函数作为参数或能把函数当返回值的函数。”
| 1. 作为参数
| 2. 作为返回值

**Function 接口中有一个 andThen的默认方法，专门用来操作函数的。**


### 6 闭包
#### 前提问题
一个`lambda`表达式, 他使用了函数作用域之外的变量。当通过这个`lambada`表达式返回函数对象时，会出现什么呢？比如在函数域中创建了一个对象，将对象的引用传递给了`lambd`表达式, 然后`lambda`表达式返回的值作为函数域的结果返回，即退出函数域，那么之前创建的对象应该出现什么样的行为呢？

实际上可以将`lambada`表达式看作是创建一个`java.util.function`包中接口的匿名内部类；

### 7 函数组合
| 作为函数式编程的一部分，函数组合，将多个函数结合，以创建新的函数
函数组合，将多个函数顺序的组合成了一个函数调用链;

### 8 Currying(柯里化、库里化)和部分求值
| 将一个接受多个参数的函数转变为一系列只接收一个参数的函数