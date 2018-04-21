package net.study.guava.cache.general;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

public class WaitingCache extends CacheLoader<String, String> {


    private LoadingCache<String, String> cache = null;

    public WaitingCache() {
        cache = CacheBuilder.newBuilder().build(this);
    }

    public LoadingCache getCache() {
        return cache;
    }

    @Override
    public String load(String key) throws Exception {
        return null;
    }
}
