package com.bell.thyme.model;

//import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "PersonInBlackList")
public class Person implements Serializable {

    @XmlElement(name="FullName")
    private String fullName;
    @XmlElement(name="ListOfAddress")
    private List listOfAddress;
    @XmlElement(name="DULSeries")
    private String DULSeries;
    @XmlElement(name="DULNumber")
    private int DULNumber;

    boolean inBlackList;

    public Person(String fullName, List listOfAddress, String DULSeries, int DULNumber, boolean inBlackList){
        this.fullName = fullName;
        this.listOfAddress = listOfAddress;
        this.DULSeries = DULSeries;
        this.DULNumber = DULNumber;
        this.inBlackList = inBlackList;
    }

    public Person(){

    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getDULSeries() {
        return DULSeries;
    }

    public void setDULSeries(String DULSeries) {
        this.DULSeries = DULSeries;
    }

    public int getDULNumber() {
        return DULNumber;
    }

    public void setDULNumber(int DULNumber) {
        this.DULNumber = DULNumber;
    }

    public boolean getInBlackList() {
        return inBlackList;
    }

    public void setInBlackList(boolean inBlackList) {
        this.inBlackList = inBlackList;
    }

    public List getListOfAddress() {
        return listOfAddress;
    }

    public void setListOfAddress(List listOfAddress) {
        this.listOfAddress = listOfAddress;
    }
}
