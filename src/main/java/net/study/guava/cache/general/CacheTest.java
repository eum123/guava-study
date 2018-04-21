package net.study.guava.cache.general;

import com.google.common.base.Stopwatch;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class CacheTest {

    private final int COUNT = 1000000;
    private Map<String, String> map = new HashMap();
    private Cache<String, String> cache = CacheBuilder.newBuilder().build();

    public void mapInit() {
        map.clear();
        cache.cleanUp();

        for(int i=0 ;i<COUNT ;i++) {
            map.put(String.valueOf(i), String.valueOf(i));
        }

        cache.putAll(map);
    }

    public void putTestForMap() {
        Stopwatch stopwatch = Stopwatch.createStarted();
        for(int i=0 ;i<COUNT ;i++) {
            map.put(String.valueOf(i), String.valueOf(i));
        }
        System.out.println("map put elapse time : " + stopwatch.elapsed(TimeUnit.MILLISECONDS));
        stopwatch.stop();
    }

    public void putTestForCache() {
        Stopwatch stopwatch = Stopwatch.createStarted();
        for(int i=0 ;i<COUNT ;i++) {
            cache.put(String.valueOf(i), String.valueOf(i));
        }
        System.out.println("cache put elapse time : " + stopwatch.elapsed(TimeUnit.MILLISECONDS));
        stopwatch.stop();
    }

    public void getTestForMap() {
        Stopwatch stopwatch = Stopwatch.createStarted();
        for(int i=0 ;i<COUNT ;i++) {
            map.get(String.valueOf(1));
        }
        System.out.println("map get elapse time : " + stopwatch.elapsed(TimeUnit.MILLISECONDS));
        stopwatch.stop();
    }

    public void getTestForCache() {
        Stopwatch stopwatch = Stopwatch.createStarted();
        for(int i=0 ;i<COUNT ;i++) {
            cache.getIfPresent(String.valueOf(1));
        }
        System.out.println("cache get elapse time : " + stopwatch.elapsed(TimeUnit.MILLISECONDS));
        stopwatch.stop();
    }


    public static void main(String ... strings) {
        CacheTest t = new CacheTest();
        t.putTestForMap();
        t.putTestForCache();

        t.getTestForMap();
        t.getTestForCache();

    }
}
