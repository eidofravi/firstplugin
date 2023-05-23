package com.com.rest;

public class Terraform {
    private String feature;
    private String oss;
    private String cloudFree;
    private String cloudTeamGovernance;
    private String cloudBusiness;
    private String enterprise;

    public Terraform(String feature, String oss, String cloudFree, String cloudTeamGovernance, String cloudBusiness, String enterprise) {
        this.feature = feature;
        this.oss = oss;
        this.cloudFree = cloudFree;
        this.cloudTeamGovernance = cloudTeamGovernance;
        this.cloudBusiness = cloudBusiness;
        this.enterprise = enterprise;
    }

    public String getFeature() {
        return feature;
    }

    @Override
    public String toString() {
        return "oss='" + oss + '\'' +
                ", cloudFree='" + cloudFree + '\'' +
                ", cloudTeamGovernance='" + cloudTeamGovernance + '\'' +
                ", cloudBusiness='" + cloudBusiness + '\'' +
                ", enterprise='" + enterprise + '\'';
    }
}