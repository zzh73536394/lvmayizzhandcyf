package com.jk.bean;




public class Commpany {
    private Integer id;//主键
    private String companyName;//公司名称
    private String companyInfo;//公司简称
    private String companyPhone;//接单电话
    private String relationName;//联系人
    private String station;//官方网站
    private String companyLogo;//公司标志
    private String serviceAim;//服务宗旨
    private String introduction;//公司简介
    private String industry;//优势服务行业
    private String account;//账号
    private String password;//密码
      private  String chufadi;
      private  String mudidi;
      private String companyProvince;//公司地址
    private Integer yunShuType;

    public Integer getId() {
        return id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getCompanyInfo() {
        return companyInfo;
    }

    public String getCompanyPhone() {
        return companyPhone;
    }

    public String getRelationName() {
        return relationName;
    }

    public String getStation() {
        return station;
    }

    public String getCompanyLogo() {
        return companyLogo;
    }

    public String getServiceAim() {
        return serviceAim;
    }

    public String getIntroduction() {
        return introduction;
    }

    public String getIndustry() {
        return industry;
    }

    public String getAccount() {
        return account;
    }

    public String getPassword() {
        return password;
    }

    public String getChufadi() {
        return chufadi;
    }

    public String getMudidi() {
        return mudidi;
    }

    public String getCompanyProvince() {
        return companyProvince;
    }

    public Integer getYunShuType() {
        return yunShuType;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setCompanyInfo(String companyInfo) {
        this.companyInfo = companyInfo;
    }

    public void setCompanyPhone(String companyPhone) {
        this.companyPhone = companyPhone;
    }

    public void setRelationName(String relationName) {
        this.relationName = relationName;
    }

    public void setStation(String station) {
        this.station = station;
    }

    public void setCompanyLogo(String companyLogo) {
        this.companyLogo = companyLogo;
    }

    public void setServiceAim(String serviceAim) {
        this.serviceAim = serviceAim;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setChufadi(String chufadi) {
        this.chufadi = chufadi;
    }

    public void setMudidi(String mudidi) {
        this.mudidi = mudidi;
    }

    public void setCompanyProvince(String companyProvince) {
        this.companyProvince = companyProvince;
    }

    public void setYunShuType(Integer yunShuType) {
        this.yunShuType = yunShuType;
    }

    @Override
    public String toString() {
        return "Commpany{" +
                "id=" + id +
                ", companyName='" + companyName + '\'' +
                ", companyInfo='" + companyInfo + '\'' +
                ", companyPhone='" + companyPhone + '\'' +
                ", relationName='" + relationName + '\'' +
                ", station='" + station + '\'' +
                ", companyLogo='" + companyLogo + '\'' +
                ", serviceAim='" + serviceAim + '\'' +
                ", introduction='" + introduction + '\'' +
                ", industry='" + industry + '\'' +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", chufadi='" + chufadi + '\'' +
                ", mudidi='" + mudidi + '\'' +
                ", companyProvince='" + companyProvince + '\'' +
                ", yunShuType=" + yunShuType +
                '}';
    }
}
