##作业变得有意思了起来：  
##用可视化的办法编写JFrame类窗口程序：  
主要借用了ecpliced自带的windowbuilder插件。
1 安装cwindowbuilder插件（可以先尝试下第二步，看是不是已经安装好了）：  在https://www.eclipse.org/windowbuilder/download.php上找到与自己的ecplice版本相符的windowbuilder插件就行。比如1.9.2的插件网址就是http://download.eclipse.org/windowbuilder/1.9.2/
eclipse-->help-->Install New Software-->Add ... 然后上面随便写个名字，下面的location填刚才第一步找到的网址，全选要下载的插件，一路确定下去，最后等待安装就可以了。
2 创建JFrame窗口：
创建一个java工程  
在工程中 File-->New-->Other ...-->WindowBuilder-->Swing Designer-->JFrame   
3 在Design窗口进行可视化编程：
找到刚才创建的JFrame文件，右键-->Open With-->WindowBuilder Editor,点击在打开的java文件下方的Design按钮，就打开了Design视角下的窗口。
4 找到palette ：  
Palette就是有所有按钮类、选择类、文本框类的一个工具栏。一般在Design视角下窗口的左边。可以在Window-->Show View-->Other-->WindowBuilder-->Palette中找到它。  
5 用Palette添加组件到窗体：建议先加入一个JLayeredPane，然后在JLayerPanej上添加其他组件。
