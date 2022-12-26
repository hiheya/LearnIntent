# Intent
## 一. 概念
   Intent 的中文名是意图，意思是我想让你干什么，简单地说， 就是传递消息。Intent 是各 个组件之间信息沟通的桥梁，既能在Activity 之间沟通，又能在Activity 与Service 之间沟通， 
   也能在Activity 与Broadcast 之间沟通。总而言之， Intent 用于处理Android 各组件之间的通信， 完成的工作主要有3 部分：
   1. Intent 需标明本次通信请求从哪里来、到哪里去、要怎么走。
   2. 发起方携带本次通信需要的数据内容，接收方对收到的Intent 数据进行解包。
   3. 如果发起方要求判断接收方的处理结果， Intent 就要负责让接收方传回应答的数据内容。
Intent的组成部分如下表所示：

| 元素名称  |   设置方法   |                  说明与用途                   |
| :-------: | :----------: | :-------------------------------------------: |
| Component | setComponent |       组件，用于指定Intent 的来源与目的       |
|  Action   |  setAction   |        动作，用于指定Intent 的操作行为        |
|   Data    |   setData    |     即Uri ，用于指定动作要操纵的数据路径      |
| Category  | addCategory  |       类别， 用于指定Intent 的操作类别        |
|   Type    |   setType    |       数据类型，用于指定Data 类型的定义       |
|  Extras   |   putExtra   |       扩展信息，用于指定装载的参数信息        |
|   Flags   |   setFlags   | 标志位，用于指定Intent 的运行模式（启动标志） |
表达 Intent 的来往路径有两种方式： 一种是显式Intent，另一种是隐式Intent
## 二. 显式Intent 与 隐式Intent
1. 显式Intent
   在声明一个Intent 对象时，需要指定两个参数，第一个参数表示跳转的来源页面，第二个 参数表示接下来要跳转到的页面类。具体的声明方式有如下3 种：
（1）.在构造函数中指定， 示例代码如下：
   ```java
      Intent intent= new Intent(this, ActResponseActivity.class);
   ```
（2）.调用setClass 方法指定， 示例代码如下：
   ```java
      Intent intent = new Intent();
      intent.setClass( this, ActResponseActivity.class );
   ```
（3）.调用setComponent 方法指定，示例代码如下：
   ```java
      Intent intent = new Intent();
      ComponentName component= new ComponentName(this, ActResponseActivity.class);
      intent.setComponent( component);
   ```
2. 隐式Inte nt，没有明确指定要跳转的类名， 只给出一个动作让系统匹配拥有相同字串定义的目标，属于模糊匹配。
   因为我们常常不希望直接暴露源码的类名，只给出一个事先定义好的名称，这样大家约定俗成、按图索骥就好，所以隐式Intent 起到了过滤作用。
   这个定义好的动作名称是一个字符串，可以是自己定义的动作，也可以是己有的系统动作。系统动作的取值说明如下表所示：
   | Intent 类的系统动作常量名 |       系统动作的常量值       |             说明              |
   | :-----------------------: | :--------------------------: | :---------------------------: |
   |        ACTION_MAIN        |  android.intent.action.MAIN  |       App 启动时的入口        |
   |        ACTION_VIEW        |  android.intent.action.VIEW  |        显示数据给用户         |
   |        ACTION_EDIT        |  android.intent.action.EDIT  |       显示可编辑的数据        |
   |        ACTION_CALL        |  android.intent.action.CALL  |             拨号              |
   |        ACTION_DIAL        |  android.intent.action.DIAL  |            打电话             |
   |        ACTION_SEND        |  android.intent.action.SEND  |            发短信             |
   |       ACTION_ANSWER       | android.intent.action.ANSWER |            接电话             |
   |       ACTION_SEARCH       | android.intent.action.SEARCH | 导航栏上SearchView 的搜索动作 |
      
   这个动作名称通过setAction 方法指定，也可以通过构造函数Ir出nt(String action ）直接生成 Intent 对象。当然，由于动作是模糊匹配，因此有时需要更详细的路径，比如知道某人住在天
   通苑小区，并不能直接找到他家，还得说明他住在天通苑的哪一期、哪号楼、哪一层、哪一个 单元。Uri 和Category 便是这样的路径与门类信息， Uri 数据可通过构造函数Intent(String action,
   Uri uri ）在生成对象时一起指定，也可通过setData 方法指定Cse tData 这个名字有歧义，实际就是setUri) ; Category 可通过addCategory 方法指定，之所以用add 而不用set 方法，是因为一
   个Intent 可同时设置多个Category ， 一起进行过滤。

   隐式Intent 还用到了过滤器的概念，即把不符合匹配条件的过滤掉，剩下符合条件的按照优先顺序调用。创建一个Android 工程， AndroidManifest.xml 里的intent“filter 就是XML 中的
   过滤器。比如下面这个最常见的主页面MainAcitivity, activity 节点下面便设置了action 和category 的过滤条件。其中， android .intent.action.MAIN 表示App 的入口动作，
   android. intent.category .LA UN CHER 表示在App 启动时调用。

