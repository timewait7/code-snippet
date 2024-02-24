package com.tw.codesnippet.utils;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class StreamUtils {

    /**
     * 根据某个字段去重
     *
     * @param list
     * @param <T>
     * @return
     */
    public <T> List<T> unique(List<T> list) {
        return list.stream().collect(
            Collectors.collectingAndThen(
                Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(T::toString))),
                ArrayList::new
            ));
    }

    /**
     * List<String>转Map<String, List<String>>
     *
     * @param locations
     * @return
     */
    public Map<String, List<String>> list2Map(List<String> locations) {
        return locations.stream()
            .map(s -> s.split(":"))
            .collect(Collectors.groupingBy(a -> a[0],
                Collectors.mapping(a -> a[1], Collectors.toList())));
    }
}
