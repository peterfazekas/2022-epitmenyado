package hu.construction.tax.model.service;

import hu.construction.tax.model.domain.Category;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class TaxHelper {

    private static final Map<Category, Integer> categoryMap = new HashMap<>();

    public static void setCategories(List<Integer> values) {
        Arrays.stream(Category.values())
                .forEach(cat -> categoryMap.put(cat, values.get(cat.ordinal())));
    }
}
