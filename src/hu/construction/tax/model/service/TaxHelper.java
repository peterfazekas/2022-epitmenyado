package hu.construction.tax.model.service;

import hu.construction.tax.model.domain.Category;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TaxHelper {

    private static final Map<Category, Integer> categoryMap = new HashMap<>();

    public static void setCategories(List<Integer> values) {
        categoryMap.put(Category.A, values.get(0));
        categoryMap.put(Category.B, values.get(1));
        categoryMap.put(Category.C, values.get(2));
    }

}
