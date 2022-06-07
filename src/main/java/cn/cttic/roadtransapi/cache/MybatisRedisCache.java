package cn.cttic.roadtransapi.cache;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import org.apache.ibatis.cache.Cache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import cn.cttic.roadtransapi.common.SerializeUtil;


/**
 * 
* @ClassName: RedisCache
* @Description: TODO(使用第三方缓存服务器redis，处理二级缓存)
* @author likai
* @date 2015年6月2日 
*
 */
public class MybatisRedisCache  implements Cache  {

	private static Logger logger = LoggerFactory.getLogger(MybatisRedisCache.class);
	 
	private Jedis redisClient=createReids();  
	 
	protected  static Jedis createReids(){  
	        JedisPool pool = RedisAPI.getPool();  
	        return pool.getResource();  
	    }  
	 
	 /** The ReadWriteLock. */    
    private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    
    private String id;  
    
    public MybatisRedisCache(final String id) {    
        if (id == null) {  
            throw new IllegalArgumentException("Cache instances require an ID");  
        }  
        logger.debug(">>>>>>>>>>>>>>>>>>>>>>>>MybatisRedisCache:id="+id);  
        this.id = id;  
    }    
    
    
	@Override
	public void clear() {
		redisClient.flushDB();
	}

	@Override
	public String getId() {
		 return this.id; 
	}

	@Override
	public Object getObject(Object arg0) {
		Object value = SerializeUtil.unserialize(redisClient.get(SerializeUtil.serialize(arg0.toString())));  
        logger.debug(">>>>>>>>>>>>>>>>>>>>>>>>getObject:"+arg0+"="+value);  
        return value; 	
	}

	@Override
	public ReadWriteLock getReadWriteLock() {
		return readWriteLock;
	}

	@Override
	public int getSize() {
		return Integer.valueOf(redisClient.dbSize().toString());
	}

	@Override
	public void putObject(Object arg0, Object arg1) {
		logger.debug(">>>>>>>>>>>>>>>>>>>>>>>>putObject:"+arg0+"="+arg1);  
        redisClient.set(SerializeUtil.serialize(arg0.toString()), SerializeUtil.serialize(arg1));  
	}

	@Override
	public Object removeObject(Object arg0) {
		return redisClient.expire(SerializeUtil.serialize(arg0.toString()),0);
	}

}
