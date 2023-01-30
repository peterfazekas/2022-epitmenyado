package hu.construction.tax.controller;

import hu.construction.tax.model.domain.Category;
import hu.construction.tax.model.domain.Site;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TaxService {

    private final List<Site> sites;

    public TaxService(List<Site> sites) {
        this.sites = sites;
    }

    /**
     * 2. feladat
     */
    public int getSiteCount() {
        return sites.size();
    }

    /**
     * 3.deladat
     */
    public String printSiteAddressesByTaxId(String taxId) {
        String addresses = getSiteAddressesByTaxId(taxId);
        return addresses.isBlank()
                ? "Nem szerepel az adatállományban."
                : addresses;
    }

    private String getSiteAddressesByTaxId(String taxId) {
        return getSitesByTaxId(taxId).stream()
                .map(Site::getAddress)
                .collect(Collectors.joining("\r\n"));
    }

    private List<Site> getSitesByTaxId(String taxId) {
        return sites.stream()
                .filter(i -> i.isTaxId(taxId))
                .collect(Collectors.toList());
    }

    /**
     * 5. feladat
     */
    public String getCategoryStatistic() {
        return Arrays.stream(Category.values())
                .map(this::getSitesByCategory)
                .map(this::getCategoryDetails)
                .collect(Collectors.joining("\r\n"));
    }

    private List<Site> getSitesByCategory(Category category) {
        return sites.stream()
                .filter(i -> i.isCategory(category))
                .collect(Collectors.toList());
    }

    private String getCategoryDetails(List<Site> siteList) {
        String cat = siteList.get(0).printCategory();
        int count = siteList.size();
        int taxAmount = calculateTaxAmount(siteList);
        return String.format("%s sávba %d telek esik, az adó %d Ft.",
                cat, count, taxAmount);
    }

    private int calculateTaxAmount(List<Site> siteList) {
        return siteList.stream()
                .mapToInt(Site::getTax)
                .sum();
    }

    /**
     * 7. feladat
     */
    public List<String> calculateTaxAmountByTaxId() {
        return  getTaxIds().stream()
                .map(i -> getSitesByTaxId(i))
                .map(i -> printDetails(i))
                .collect(Collectors.toList());
    }

    private List<String> getTaxIds() {
        return sites.stream()
                .map(Site::getTaxId)
                .distinct()
                .collect(Collectors.toList());
    }

    private String printDetails(List<Site> siteList) {
        String taxId = siteList.get(0).getTaxId();
        int taxAmount = calculateTaxAmount(siteList);
        return String.format("%s %d", taxId, taxAmount);
    }

}
