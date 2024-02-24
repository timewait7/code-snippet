package utils;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
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
}
