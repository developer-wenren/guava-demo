package com.one.guava;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

/*
- 提供强大的基于内存的缓存机制,值在缓存中自动加载
- Coding By One ON 09/02
*/
public class CachingExamples {

    @Test
    public void cacaheTest() {
        LoadingCache<String, String> employyeeCache = CacheBuilder.newBuilder()
                .maximumSize(100)
                .expireAfterAccess(10, TimeUnit.SECONDS).build(new CacheLoader<String, String>() {
                    @Override
                    public String load(String key) throws Exception {
                        return getFromDatabase(key);
                    }
                });

        String s = null;
        try {
            s = employyeeCache.get("100");
//        String s = employyeeCache.getUnchecked("100");
            System.out.println(s);
            // 第二次获取直接从缓存中获取
            s = employyeeCache.getUnchecked("100");
            System.out.println(s);
            Thread.sleep(10000);
            // 缓存失效后再次db里读
            s = employyeeCache.get("100");
            System.out.println(s);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private String getFromDatabase(String key) {
        System.out.println("read from db"); // 只会输出一次
        return key + " employee";
    }
}
