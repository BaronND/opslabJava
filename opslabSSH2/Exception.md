Java项目中的异常
-----
Java异常处理不就是try….catch…finally这简单？
java语言中，Exception是所有异常的父类。任何异常都扩展于Exception类。Exception就相当于一个错误类型。
如果要定义一个新的错误类型就扩展一个新的Exception子类。采用异常的好处还在于可以精确的定位到导致程序
出错的源代码位置,并获得详细的错误信息。

Java异常处理通过五个关键字来实现，try,catch,throw ,throws, finally。具体的异常处理结构由
try….catch….finally块来实现。try块存放可能出现异常的java语句，catch用来捕获发生的异常，并对异常进行
处理。Finally块用来清除程序中未释放的资源。不管理try块的代码如何返回，finally块都总是被执行。

给错误进行了统一的分类，通过扩展Exception类或其子类来实现。从而避免了相同的错误可能在不同的方法中具有
不同的错误信息。在不同的方法中出现相同的错误时，只需要throw 相同的异常对象即可。

    Throwable(必须检查) 
        Error（非必须检查） 
        Exception（必须检查） 
            RuntimeException（非必须检查）
            
#关于Check和UnCheck异常的使用
    如果一个异常是致命的，不可恢复的。或者调用者去捕获它没有任何益处，使用unChecked异常。
    如果一个异常是可以恢复的，可以被调用者正确处理的，使用checked异常。

    
#关于异常的记录
    1.异常应该在最初产生的位置记录！
    2.如果必须捕获一个无法正确处理的异常，仅仅是把它封装成另外一种异常往上抛出。不必再次把已经被记录过的异常再次记录。
    3.如果捕获到一个异常，但是这个异常是可以处理的。则无需要记录异常
    
#J2EE项目中异常的处理
    现在软件，尤其是J2EE开发的软件一版都会遵循层次进行设计。其中中著名且最通用的设计当然是三层模型
        数据表现层
        数据业务层
        数据持久化层
        
    例如在SSH项目中shuu表现层就是struts层，业务层就是具体的service层数据持久化层就是Dao层。例如想本
    项目的代码一样。具体的包结构如下
        ├─dao                           dao层的接口（Spring的@Repository层）ModelDao命名
        │  └─impl                       DAO实现层ModelDaoImpl命名
        ├─model                         业务Model类的定义（Model命名首字母大写）
        ├─service                       Service层的接口(Spring的@Service层) ModelService命名
        │  ├─impl                       Service层的实现ModelServiceImple
        │  └─interceptor                Service的Filter(Spring的AOP)operationInterceptor命名
        ├─struts                        控制层的接口(Spring的@Controller) 
        │  ├─Action                     控制层是实现及action实现operationAction命名
        │  └─interceptor                控制层的Filter（Struts2的拦截器）operationInterceptor命名
##J2EE项目中异常的分层分类        
按照分层的设计里面每层都自己的相关职权，本着这个原则可以对异常也进行相应的分层分类。
    
     * 数据持久化层因处理数据持久化相关的异常外，其余所有异常都因自我消化，及本身需要处理。
     * 数据业务层的职责就是业务相关的操作因处理业务相关异常，其余所有外都因自我消化
     * 数据表现层的职责就是展现和控制业务数据，同时也是程序行为的始发处，因此需要同时处理用户操作引起的异常
       和程序内部抛出的异常。
     
###数据持久化层的异常
    
    数据持久化层的任务就是处理数据相关的操作，如读写增删改查。
    这些操作报考但不限于 数据库的读写，文件的读写，socked的读写，SOAP等远程消息的读写等等因此数据持久化层需要
    包装并记录的这些异常，这些异常报考IOException，SQLException,RemoteException等等。出上述所述的这些影响数据
    持久化的异常需要包装并抛像业务层外，其他的所有的异常都因自我消化
    
    对于IOException,SQLException,RemoteException等checked异常是必须要进行相应的处理，如果将这些异常全部封装
    成checked异常，那么意味着所有的数据持久化层的接口方法的签名中都会携带一个Exception，意味着数据持久化层的
    接口方法会验证的收感染。同时意味着所有调用这些方法的地方都会出现try-catch处理块
    
###数据持久化层的异常类
可以将数据持久化层的所有数据持久化相关的异常封装成一个Uncheck的异常类例如：
    
    /**
     * <h6>Description:<h6>
     * <p>
     *     数据持久话层的异常实体类，数据持久化层的方法因将所有数据持久化相关的所有异常包装成该类型的异常
     *     并抛像上层调用。除此之外的所有异常都因在数据持久化层进行自我消化
     * </p>
     *
     * @date 2015-07-08.
     */
    public class DataAccessException extends RuntimeException {
    
        public DataAccessException(String msg){
            super(msg);
        }
    
        public DataAccessException(String msg,Throwable cause){
            super(msg,cause);
        }
    }
    
因此可以像如下一样定义数据持久化层的接口

    public interface SupportDao<T> {
    	
    	//保存实体
    	public void saveEntry(T t) throws DataAccessException;
    	
    	//更新实体
    	public void updateEntry(T t) throws DataAccessException;
    	
    	//保存或更新
    	public void saveOrUpdateEntry(T t) throws DataAccessException;
    	
    	//删除实体
    	public void deleteEntryById(T t) throws DataAccessException;
    	
    	//加载实体
    	public T loadEntry(Integer id) throws DataAccessException;
    	
    	//加载实体
    	public T getEntry(Integer id) throws DataAccessException;
    	
    	//通过HQL查询单个实体
    	public T queryEntry(String hql) throws DataAccessException;
    	
    	//以HQL方式批量操作
    	public int batchEntryByHQL(String hql,Object ...objects) throws DataAccessException;
    	
    	//通过HQL获得实体列表
    	public List<T> getEntryListByHQL(String hql,Object ...objects) throws DataAccessException;
    	
    	//通过SQL获得提示列表
    	public List<T> getEntryListBySQL(String sql,Object ...objects) throws DataAccessException;
    
    	//通过HQL获取实例列表
    	public List<T> findEntityByHQL(String hql, Object[] objects) throws DataAccessException;
    	
    	//以分页的方式获得实体
    	public EntryPage query(final String hql, int page, final int size) throws DataAccessException;
    	
    }
    
###数据业务层的异常处理
    
    业务层处理业务相关的异常以外所有其他异常都应该自我消化，另外因为所有的DAO层的方法都有可能会抛出
    DataAccessException异常，然后Service层是不所有方法都需要处理改异常，因此可以让DataAccessException
    异常集成ServicesException，这样不是所有的业务层方法都需要处理DAO抛出的异常，只需在action层统一处理即可
    ，另外这样也更加符合逻辑，及DataAccessException异常本来就是一种特殊的ServicesException异常

    另外Service层发生异常意味着客户通过Action进行的操作发生错误，需要为用户返回一个异常信息。比如因记录已经
    存在引起的Hibernate保存异常等。所以Services需要将想要的异常进行包装成通俗易懂的异常抛到Action层。

###Action层的异常处理
    Action是整个软件行为控制的始发处，用户通过页面操作进行相应的业务操作，同事也是整个软件的展现层因此在
    这层面需要同时处理俩方面的错误，用户操作引起的异常（调用业务层前的发生的异常）以及程序内部抛出的异常
    即（调用业务层方法的过程中发生的错误）
     
  