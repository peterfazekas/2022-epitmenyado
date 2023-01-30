package hu.construction.tax.model.domain;

public class Site {

    private final String taxId;
    private final String street;
    private final String houseNumber;
    private final Category category;
    private final int area;
    private final int tax;

    public Site(String taxId, String street, String houseNumber, Category category, int area, int tax) {
        this.taxId = taxId;
        this.street = street;
        this.houseNumber = houseNumber;
        this.category = category;
        this.area = area;
        this.tax = tax;
    }

    public boolean isTaxId(String taxId) {
        return this.taxId.equals(taxId);
    }

    public String getTaxId() {
        return taxId;
    }

    public String getStreet() {
        return street;
    }

    public String getAddress() {
        return street + " utca " + houseNumber;
    }

    public boolean isCategory(Category category) {
        return this.category == category;
    }

    public String printCategory() {
        return category.name();
    }

    public int getTax() {
        return tax;
    }
}
