package com.pujariz.RestUserProject.DTO;

import com.pujariz.RestUserProject.Entity.Company;

public class CompanyDTO {

    private long id;
    private String name;
    private String catchPhrase;
    private String bs;

    public CompanyDTO(Company company) {
        this.id = company.getId();
        this.name = company.getName();
        this.catchPhrase = company.getCatchPhrase();
        this.bs = company.getBs();
    }

//Getters and Setters

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCatchPhrase() {
        return catchPhrase;
    }

    public void setCatchPhrase(String catchPhrase) {
        this.catchPhrase = catchPhrase;
    }

    public String getBs() {
        return bs;
    }

    public void setBs(String bs) {
        this.bs = bs;
    }
}
