Java反射

	所谓反射通俗的说就是通过对象实例获取类相关信息.
	主要的操作包有：
		java.lang.reflect包中


Java中的反射主要靠Class类来完成.
	在java.lang.reflect包中常用的类有
		Constructor		表示类中的构造方法
		Filed			表示类中的属性
		method			表示类中的方法


【实例化对象】
	- 通过无参构造实例化对象
		需要调用Class类的newInstance方法.必须保证类有无参构造
		demo 实例化对象.newInstance
	- 通过有参构造实例化对象
		· 通过Class类的getConstructors方法取得全部的构造方法
		· 想构造方法传递参数，以数组的形式
		· 通过构造方法实例创建对象实例

【调用实例的方法】
	如果想要通过反射调用那个对象的方法。
		· 首先要通过Class的getMethods方法获取对象的方法的实例Method
		· 设置参数
		· 通过Method类的invoke方法调用


JavaIO
	主要的操作包：java.io
	JavaIO操作主要直输入和输出。在java的IO操作中主要有5个类和一个接口：

		类：
			File				主要用于文件的操作
			InputStream         字节输入操作的抽象类
			OutputStream        字节输出操作的抽象类
			Reader              字符输出操作的抽象类
			Writer              字符输入操作的抽象类
		接口：
			Serializable        对象序列化功能接口

【File类】
	主要完成文件的管理创建删除等操作。
【RandomAccessFile】
	主要用于完成文件的随机读取。注意要实现随机读取，则必须要保证给你数据的长度都想相同
	例如
		以一个人的姓名和年龄为一个数据项：
			name = "chanshi"  age = 20
			name = "nigu"     age = 20
		要实现随机方法的文件则必须按如下方式存储
			name = "chanshi" age = 20
			name = "nigu   " age = 20
【字节流和字符流】
	不论是字节流和字符流都分为输入流和输出流。
	程序中所有的数据都是以流的方式传递或保存。要想使用数据就需要使用输入流读入数据，要想保存数据就要使用输出流保存数据

	字节流主要以操作byte类型的数据，以byte[]为主。主要的操作类有InputStream和OutputStream类为主

	字符流主要以操作字符类型的数据（java中一个字符是俩个字节）。主要的操作类有Writer和Reader

	字节流和字符在使用的几乎相同。但字符在操作时使用了缓冲区，而字节流没有使用缓存区


【转换流】

	在整个IO包中除了字节流和字符流外，还存在一组字节流-字符流的转类。

		OutputStreamWriter: 是Writer的子类，将输出的字符流变为字节流。即将一个字符的输出对象转变为字节流输出对象
		InputStreamReader： 是Reader的子类，将输入的字节流变为字符流。即将一个字节流的输入对象变为字符流的输入对象。

		以文件操作为列，则内存中的字符数据需要通过OutputStreamWriter变为字节流才能保存在文件中，读取时需要将读入的字节流通过InputStreamReader变为
		字符流。
【内存操作流】
	输入输出的位置不光是文件，还可以是内存。要想使用内存输入输出特性，则需要使用ByteArrayInputStream和ByteArrayOutputStream类
		ByteArrayInputStream   用于向内存写入数据
		ByteArrayOutputStream	用于将内存数据输出


【管道流】
	管道流主要用于俩个线程之间通信。管道流分为PipedOutputStream 管道输出流，PipedInputStream 管道输入流。
	管道输出流要想输出怎必须联到管道输入流上。
	因此PipedOutputStream提供了如下方法
		public void connect(PipedInputStream snk);
【打印流】
	打印流是整个IO包中输出信息最方便的类。主要包含字节打印流（PrintStream）和字符打印流（PrintWriter）。

【BufferedReader】
	BufferedReader用于从缓冲区读取数据，所有输入的字节数据都先缓存到缓冲区中，再一次读出。
	BufferedReader的构造函数直结束字符流输入，所以要将字节输入转换为字符输入


【Scanner】
	JDK1.5之后提供了专门用于输入的类java.util.Scanner该类不单提供了输入功能还提供了输入验证


【数据操作流】
	在java IO中提供俩个与平台无关的数据操作类，DataInputStream和DataOutputStream。通常将数据按照一定的格式
	输出，按一定的个数读书


【压缩流】
	Zip压缩是常用文件压缩形式。在java中要使用zip压缩时要导入java.util.zip包。
	利用该包中的ZipFile ZipInputStream ZipOutputStream ZipEntry就能完成文件的压缩

【对象序列化】
	要想实现对象序列化就必须实现Serializable接口。该接口只标识一个功能，并没有方法。要想序列化和发序列还需要同
	ObjectInputStream和ObjectOutputStream类完成。

	若要指定序列化的内容可以采用Externalizable接口
	该接口中定义如下俩个方法：
		writeExternal(ObjectOutput Out)			在此方法中写入要保存的属性，对象序列化时调用
		readExternal(ObjectInput in)			在此方法中读取写入的信息，对象反序列化时使用

	当然也可以直接在Serilizable接口子类中使用transient关键字指定不序列化某一属性








