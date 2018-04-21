package net.study.guava.cache.general;

import com.google.common.base.Stopwatch;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class CacheSample {

    private Cache<String, String> cache = null;

    public void init() {
        cache = CacheBuilder.newBuilder().build(new CacheLoader<String, String>(){

            public String load(String s) throws Exception {
                return cache.getIfPresent(s);
            }

        });

        Map<String, String> data = new HashMap();
        data.put("name", "홍길동");
        data.put("age", "30");
        cache.putAll(data);
    }



    public void test() {
        System.out.println("name:" + cache.getIfPresent("name"));

        cache.put("name", "고양이");

        System.out.println("changed name:" + cache.getIfPresent("name"));

    }

    public void getTimeCheck() {
        Stopwatch stopwatch = Stopwatch.createStarted();
        for(int i=0 ;i<1000000 ;i++) {
            cache.getIfPresent("name");
        }
        System.out.println("elapse time : " + stopwatch.elapsed(TimeUnit.MILLISECONDS));
        stopwatch.stop();
    }

    public void getTimeCheckMap() {
        Map<String, String> data = new HashMap();
        data.put("name", "홍길동");
        data.put("age", "30");

        Stopwatch stopwatch = Stopwatch.createStarted();
        for(int i=0 ;i<1000000 ;i++) {
            data.get("name");
        }
        System.out.println("elapse time : " + stopwatch.elapsed(TimeUnit.MILLISECONDS));
        stopwatch.stop();
    }


    public static void main(String ... strs) {
        CacheSample sample = new CacheSample();
        sample.init();


        sample.test();

        sample.getTimeCheck();

        sample.getTimeCheckMap();
    }
}
