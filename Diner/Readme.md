### 订餐程序
设计编写一个**订餐程序**，*显示菜品清单，完成点餐（加份、减份），算卡路里，结算，快递*等功能。
[需求](https://www.cnblogs.com/haoxz258988/p/12932815.htm)
1. 实现菜品meal管理。增删改查-操作
2. 实现饮料drinking管理。增删改查-操作
3. 实现顾客client管理。增删改查-操作
4. 实现订单项lineitem。增删改查-操作
5. 实现订单order管理。增删改查-操作
7. 实现点餐Ordering功能。
8. 实现卡路里计算Calculate功能
9. 实现结算Checkout功能
10. 实现快递Post功能

#### 程序分析(Java程序设计就是：给不同的类安排任务（职责）)
1. 程序结构设计：分层 Layering设计： MVC模型
   1. M-Model 层
      1. 数据、实体层（菜品Meal、Client等）
   2. V-View 层
      1. 显示交互（点餐功能）
   3. C-Control 层
      1. 控制层（菜单）[主类]
2. 如何管理Model层数据？
   1. 每一种菜品是一个管理的单元
      1. class Meal
      2. 写成一个pojo类,构造方法、访问器（getter/setter）
   2. 将菜品放入一个数组（对象[容器]）
      1. class Meals
      2. 用数组组织多个菜品对象
      3. 完成管理：CRUD：增、删、改、查
3. 如何管理View层-交互
   1. 选餐Ordering
      1. 显示菜品列表
      2. 选择、+、-
      3. 形成订单Order
   2. 订单Order管理
      1. 显示
      2. 增删改查
      3. 形成订单（饭袋）
4. 如何管理Control层
   1. 显示菜单Menu
   2. 调用功能方法

### Model类，数据类，实体类Entity,POJO类
1. 对基本数据的封装，基础的不变化的数据
2. 写Model类的要求：
   1. 单一数据
   2. 简单的操作
      1. 构造方法（缺省）
      2. toString
      3. getter（）/Setter（）
### 分析阶段
1. class Meal