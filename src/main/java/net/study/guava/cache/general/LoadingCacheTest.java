package net.study.guava.cache.general;


import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

public class LoadingCacheTest {

    private LoadingCache<String, String> cache = null;

    public void init() {
        cache = CacheBuilder.newBuilder().build(new CacheLoader<String, String>() {
            @Override
            public String load(String s) throws Exception {
                System.out.println("load......" + s);
                return "hi";
            }
        });
    }

    public void test() {
        System.out.println("size:" + cache.size());

        System.out.println(cache.getIfPresent("name"));

        System.out.println(cache.getUnchecked("name"));

        System.out.println(cache.getIfPresent("name"));
    }

    public static void main(String ... args) {
        LoadingCacheTest t = new LoadingCacheTest();
        t.init();
        t.test();
    }
}
