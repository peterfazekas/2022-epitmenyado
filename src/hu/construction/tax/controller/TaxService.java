package hu.construction.tax.controller;

import hu.construction.tax.model.domain.Site;

import java.util.List;

public class TaxService {

    private final List<Site> sites;

    public TaxService(List<Site> sites) {
        this.sites = sites;
    }

}
