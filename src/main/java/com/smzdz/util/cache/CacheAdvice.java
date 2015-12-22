package com.smzdz.util.cache;

import org.springframework.stereotype.Service;

@Service
@SuppressWarnings("unused")
public class CacheAdvice {
    
    private void flushAllCache(){
        RedisUtils.clearCache();
    }
}
