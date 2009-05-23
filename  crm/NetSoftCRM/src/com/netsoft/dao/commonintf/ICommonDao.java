package com.netsoft.dao.commonintf;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

public interface ICommonDao {

	/**
	 * 增加对象的公用方法
	 * 这个方法主要用来增加一个持久化对象。并加到数据库中
	 * 要求提供的参数是一个pojo对象。由于采用的是hibernate模板
	 * 所以只能提供由hibernate映射的pojo对象。
	 */
	public abstract boolean add(Object obj);

	/**
	 * 根据持久化对象。从持化化层中删除相应的对象，
	 * 同时将数据库中对应的记录难删掉。
	 * 要求提供的参数是一个pojo对象。由于采用的是hibernate模板
	 * 所以只能提供由hibernate映射的pojo对象。
	 */
	public abstract boolean dele(Object obj);

	/**
	 * 根据提供的HQL语句来动态删除对象，有很大的灵活性，
	 * 提供的语句有一定限制。请参考说明中的语句模板。请使用占位符。HashMap中保存
	 * 的是相对应的占位符的键与值
	 * 下面有示例语句。请参考：
	 * 比如我们要从User对象中删除username=redfox的这个对象。
	 * 请用如下语句：
	 * delete from User as u where u.username=:name
	 * 而对于hashmap中存放的值就要如下申明：
	 *  hm.add("name","redfox")
	 *  多个参数时候。请在HASHMAP中增加多个值即可。 
	 *  调用私有方法excute来执行具体的操作。具体实现就参考excute方法
	 */
	public abstract boolean dele(final String hql, final HashMap hm);

	/**
	 * 根据传过来的对象类型，还有对象的OID来删除对应的持久化对象
	 * 同时将数据库中相对应的记录给删掉。
	 * 参数c1为Class类型的（即对应的要删除的持久化对象的Class）
	 * 参数s为序列化对象。在这里主要是指持化化对象的OID标识。
	 */
	public abstract boolean dele(Class cl, Serializable s);

	/**
	 * 这个方法是用根据传久来的持久化对象的类型。来取得
	 * 所有的这个类型的持化化对象。
	 * 参数cl是要查询的哪一类型。使用时。请您确认。此类型是否
	 * 是持久化对象的类型。否则可能会查询不成功
	 */
	public abstract <cl> List<cl> getObjectAll(Class cl);

	/**
	 * 根据提供的HQL语句来动态查询对象，有很大的灵活性，
	 * 提供的语句有一定限制。请参考说明中的语句模板。请使用占位符。HashMap中保存
	 * 的是相对应的占位符的键与值
	 * 下面有示例语句。请参考：
	 * 比如我们要从User对象中查询username=redfox的这个对象。
	 * 请用如下语句：
	 * from User as u where u.username=:name
	 * 而对于hashmap中存放的值就要如下申明：
	 *  hm.add("name","redfox")
	 *  多个参数时候。请在HASHMAP中增加多个值即可。 
	 *  此方法重写了Spirng中hibernate模板的回调方法来实现。因为hibernate模板提供的方法实现方式有限
	 */
	public abstract List getObjectByHql(final String hql, final HashMap hm);

	/**
	 * 根据传过来的对象类型，还有对象的OID来查找对应的持久化对象
	 * 参数c1为Class类型的（即对应的要查询的持久化对象的Class）
	 * 参数s为序列化对象。在这里主要是指持化化对象的OID标识。
	 */

	public abstract <cl> cl getObjectById(Class cl, Serializable s);

	/**
	 * 根据提供的HQL语句来动态修改对象，有很大的灵活性，
	 * 提供的语句有一定限制。请参考说明中的语句模板。请使用占位符。HashMap中保存
	 * 的是相对应的占位符的键与值
	 * 下面有示例语句。请参考：
	 * 比如我们要把User对象username=redfox的这个对象修改成username=foxconn。
	 * 请用如下语句：
	 * update User set username=:str1 where username=:str2
	 * 而对于hashmap中存放的值就要如下申明：
	 *  hm.add("str1","foxconn")
	 *  hm.add("str2","cdredfox")
	 *  多个参数时候。请在HASHMAP中增加多个值即可。 
	 *  调用私有方法excute来执行具体的操作。具体实现就参考excute方法
	 */
	
	/**
	 *  根据提供的HQL语句来查询对象。重载版本
	 *  这个重载版本不能根参数
	 */
	public abstract List getObjectByHql(String hql);
	public abstract boolean updateObject(final String hql, final HashMap hm);

	/**
	 * 根据持久化对象。从持化化层中修改相应的对象，
	 * 同时将数据库中对应的记录修改掉。
	 * 要求传过来的对象，是已经修改过的对象
	 * 要求提供的参数是一个pojo对象。由于采用的是hibernate模板
	 * 所以只能提供由hibernate映射的pojo对象。
	 */
	public abstract boolean updateObject(Object obj);
	
	/**
	 * 保存持久化对象并返回该对象
	 * @param obj
	 * @return
	 */
	public <cl> cl addreturn(Object obj);
	
	public List currenPage(final int page,final int size,final String hql,final HashMap hm);

}