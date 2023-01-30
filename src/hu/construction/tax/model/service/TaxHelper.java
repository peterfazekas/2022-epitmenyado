package hu.construction.tax.model.service;

import hu.construction.tax.model.domain.Category;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TaxHelper {

    private static final int LIMIT = 10_000;
    private static final Map<Category, Integer> CATEGORY_MAP = new HashMap<>();

    public static void setCategories(List<Integer> values) {
        Arrays.stream(Category.values())
                .forEach(cat -> CATEGORY_MAP.put(cat, values.get(cat.ordinal())));
    }

    public static int taxValue(Category category, int area) {
        return ado(category, area);
    }

    private static int ado(Category category, int area) {
        int ado = CATEGORY_MAP.getOrDefault(category, 0) * area;
        return ado < LIMIT ? 0 : ado;
    }
}
