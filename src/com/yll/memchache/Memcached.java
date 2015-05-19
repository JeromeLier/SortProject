package com.yll.memchache;

import net.spy.memcached.MemcachedClient;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public final class Memcached implements Cache{

	private static final Log log = LogFactory.getLog(Memcached.class);
	private MemcachedClient memcachedClient;
	
	
	private int expiredTime = 60 * 120;
    public Object get(String key) {
        Object result = null;
        try {
            result = memcachedClient.get(key);
        } catch (Exception e) {
            log.error("Failed to get '" + key + "' from cache.", e);
        }
        return result;
    }

    public void put(String key, Object value) {
        put(key, value, expiredTime);
    }

    public void put(String key, Object value, int expiredTime) {
        try {
            memcachedClient.set(key, expiredTime, value);
        } catch (Exception e) {
            log.error("Failed to put '" + key + "' into cache.", e);
        }
    }

    public void remove(String key) {
        try {
            memcachedClient.delete(key);
        } catch (Exception e) {
            log.error("Failed to remove cache '" + key + "'.", e);
        }
    }

    public void setExpiredTime(int expiredTime) {
        this.expiredTime = expiredTime;
    }

    public void setMemcachedClient(MemcachedClient memcachedClient) {
        this.memcachedClient = memcachedClient;
    }


}