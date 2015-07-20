Java代码规范
=======

## 0. 规范的规范
1. 本规范的每一条目必须无二义性，并且可执行。否则作废
2. 本规范的条目分为两个级别:
> - 规则 - R
> - 建议 - S
3. 本规范所有的“规则”条目必须被遵守

## 1. 代码格式
1. R-使用《开发环境和工具使用手册.md》所定义的eclipse设置
2. S-非 Eclipse用户参考上述设置

## 2. 命名

### 2.1 包
1. R-包名必须全部小写，2个以内单词。
1. S-最好为 1 个单数名词。
1. R-所有项目的包要以“com.xinhuanet”为父包。

### 2.2 类和接口
1. S-最好为名词
1. R-命名类和接口时，需要将所有单词的首字母大写。
1. R-接口的命名不采用首字母为 I 或加上 IF 后缀的命名方式 。例 如 ：IBookDao 、 BookDaoIF 等 。
1. R-抽象类必须使用 Abstract 作为类名的前缀，而接口建议使用 Interface 作为 接口名后缀。
1. R-异常类应该使用 Exception 做为 名称 后缀。
1. R-如果是运行一次就抛弃的类，以 ing 结尾，比如Rendering
1. R-类名尽量短，但是最好不要缩写，如果缩写，必须为特别常用的类，比如 Lang.java
> 因为调用者书写你的类名太长，他(她)的IDE会自动替他(她)换行，他会觉得有点不爽
1. R-不要和 Java 的标准库中的类名冲突，比如 Class, Object, String 等
> 如果冲突，就表示你极其藐视 Java 标准库中的那个的设计
> 调用者需要花更多的时间和代码来明确他使用的是你的类, 而不是标准库中的那个
1. S-以下情况可以允许写奇怪类名 -- 名称简短，让人一眼不知道什么意思，用了以后一眼就能知道什么意思
> - 类特别常用
> - 类非常特殊，难以归类
> - 私有类或内部类
> - 不推荐其他人调用的 公有、保护、默认类
> - 起个奇怪的名字，就是不想让你关心这个类的代码
1. R-缺省接口实现应该使用 Default 名称 前缀。
> - 例 如 ： DefaultEntityMaker。也可以采用 Impl 作为后缀，表示这个实现为此接口的最优实现或者唯一实现
1. R-接口使用简写的方式。例如：

```java
interface A{
	  public static final String str = "Hello"; //定义常量
	  public abstract viod print(); //定义抽象方法
	  public abatract String getInfo(); //定义抽象方法
   }
```
简写成：
```java
   interface A{
	  String str = "Hello"; //定义常量
	  viod print(); //定义抽象方法
	  String getInfo(); //定义抽象方法
   }
```

### 2.3 成员变量
1. S-命名采用驼峰规则
1. S-最好为单数名词
1. R-能 private 就不要 default，能 default 就不要 protected，最好不要 public
1. R-如果是集合或数组，用复数名词
* Map pets， 比 Map petMap 要好 *
1. R-不要用一个字母，尤其是 i，你可以用 index 或者 cursor 来代替

### 2.4 常量
R-命名常量（带有 final 修饰符的域）时需分隔。如 ： public final int MAX_VALUE = 30 。
R-常量不要用权限开放的调用权限严谨的。因为Java初始化顺序是先public后private。例如：
     尽量避免下面的情况：用public调用private
```java
    private static final String PROJECT_CACHE_PREFIX = "xhuc:";
    public static final String USER = PROJECT_CACHE_PREFIX + "user";
```

### 2.5 局部变量
1. S-命名采用驼峰规则
1. R-局域变量名要尽量短，推荐用缩写，比如 StringBuilder sb
1. R-总的来说局部变量请随意命名，越短越好
*比如这个就不好：*

```java
 public String abc(String str){
	AbcObjectSet abcObjectSet = new AbcObjectSet();
	abcObjectSet.setName(str);
	return abcObjectSet.getBrief();
 }
```

*而这个就很容易阅读了：*

```java
 public String abc(String str){
	AbcObjectSet aos = new AbcObjectSet();
	aos.setName(str);
	return aos.getBrief();
 }
```

### 2.6 成员函数和静态函数
1. S-命名采用驼峰规则
1. R-除了 setter / getter，其他的函数采用动词或者动名短语
1. S-以下情况可以允许写奇怪函数 -- 名称简短，让人一眼不知道什么意思，用了以后一眼就能知道什么意思
> - 函数特别常用
> - 函数非常特殊
> - 私有函数或默认函数
1. S-支持链式赋值的 setter 允许写成 ，并且也可以支持同名 getter

```java
// Setter
public Pet name(String name){
	this.name = name;
	return this;
}

// Getter
public String name(){
	return this.name;
}
```

## 3. 注释
1. R-注释必须和代码保持同步。
1. R-注释中的第一个句子要以（英文）句号、问号或者感叹号结束。
> Javadoc生成工具会将注释中的第一个句子放在方法汇总表和索引中。
1. R-如果注释中有超过一个段落，用 ```<P>``` 标签 分隔。
1. R-如果注释中有多个章节，用 ```<H2>``` 标签声明每个章节的标题。
1. R-如果注释需要换行，用 ```<BR>``` 标签。
1. R-示例代码以 ```<PRE></PRE>``` 包裹。

### 3.1 类 Java Doc
1. R-要著名作者，格式为 @author XiaoMing(xm@gmail.com)
1. R-继承的方法可以省略注释，但是被继承方法必须有注释。

### 3.2 函数 Java Doc
1. R-简单的 get/set 方法可以省略注释。
1. R-继承的方法可以省略注释，但是被继承方法必须有注释。

### 3.3 字段 Java Doc
1. R-没有更多说明了
### 3.4 函数内部注释
1. R-行注释和块注释都是可以被接受的
1. R-不要写 JAVA DOC，没意义
1. R-代码质量不好但能正常运行，或者还没有实现的代码用 “ //TODO: ”
1. R-在 if ... else .. 分支上做注释格式应该如下：

```java
// comments for case A
if(xxxx){
	//TODO you code here
}
/*
 * Multipline comments for case B
 */
else if(xxxxx){
	//TODO you code here
}
// comments for default case
else{
	//TODO you code here
}
```

## 4. 编程
1. R-你的每一次提交，必须都是编译通过的
1. R-你的每一次提交，最好都是通过 JUnit 测试的
1. 除非有特别的情况 -- 比如你要和其他人分享的修改
1. R-无论任何时候，同样的功能，一段更短的代码，总比更长的代码要好
* 这里的“短”，主要指的是“逻辑”短，而不是“字符长度”短 *
1. R-删掉一段代码的贡献，比增加一段代码的贡献要大，至少不比它小
1. R-避免过度设计
> - 先让代码能工作，然后重构成为优美的代码
> - 你需要知道，“接口”固定了架构，“类” 不是，当它进化为接口的时候就固定了

## 5. 单元测试
1. R-用例名请用 "长名" - 一句话，用下划线_代替空白
> 通过这个名字，基本可以了解测试是干什么的
1. R-主要接口和实现类的所有代码栈要尽可能多的被用例覆盖
1. R-测试用例中必须包含至少一个assertXX方法
