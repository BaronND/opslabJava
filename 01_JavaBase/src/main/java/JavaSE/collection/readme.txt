类集

	类集就是实现对现有数据结构的封装以动态数组的方式提供了方便的操作接口
	
java中常用的类集有：
	常用的接口有:
	Collection				存放单值的最大接口
	List					是Collection接口的子接口，对其进行大量的扩充，里面运行存放重复值
	Set						是Collection接口的子接口，没有对其进行扩充，里面不运行存放重复值 (确定重复值利用equals和hashCode 排序用比较器)
	Map						是存放键值对的最大接口
	Iterator				是集合输出接口
	ListIterator			是List的输出接口
	Enumernation			最早的输出接口
	SortedSet				单值排序接口   使用比较器进行排序
	SortedMap				键值对排序接口 使用比较器进行排序
	Queue					队列接口
	Map.Entry				Map接口里保存的内容，其实例代表一个键值对 key-value
	
其继承关系
 	Collection
 	   |
 List  Set Queue StroedSet
 
 	Map
 	|
 StroedMap
 
 
 常用的Map子类
 	HashMap					无序存放，Key不可以重复
 	HashTable				无序存放，key不可以重复
 	TreeMap					有序存放，key可以重复
 	IdentiyMap				key可以重复的Map集合  (只要key1 != key2 即俩个对象地址不同就表示key不同)