坦克大战游戏:
设计的技术
1. Java面向对象编程
2. 界面编程
3. 绘图技术
4. 多线程
5. 文件I/O操作
6. 数据库

绘图原理:
1. Component类提供了两个绘图相关最重要的方法:
      Paint(Graphics g)绘制组件的外观
      repaint()函数刷新组件外观
2. 在以下情况下paint将会被调用
    窗口最小化，再最大化
    窗口大小发生变化
    repaint函数被调用

Graphics类: 为我们提供了各种绘制图形的方法
  画直线 drawLine(int x1, int y1, int x2, int y2)
  画矩形边框 drawRect(int x, int y, int width, int height)
  画椭圆 drawOval(int x, int y, int width, int height)
  填充矩形 fillRect(int x, int y, int width, int height)
  填充椭圆 fillOval(int x, int y, int width, int height)
  画图片 drawImage(Image img, int x, int y, ...)
  画字符串 drawString(String str, int x, int y)
  设置画笔字体 setFont(Font font)
  设置画笔颜色 setColor(Color c)


Event类型