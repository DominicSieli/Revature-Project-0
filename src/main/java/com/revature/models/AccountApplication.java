package com.revature.models;

import java.sql.Date;

public class AccountApplication {
    private int customerID;
    private Person customer;
    private boolean approved;
    private Date approvalDate;
    private Date applicationDate;
    private int applicationNumber;

    public AccountApplication() {
    }

    public AccountApplication(int customerID, Person customer, boolean approved, Date approvalDate, Date applicationDate, int applicationNumber) {
        this.customerID = customerID;
        this.customer = customer;
        this.approved = approved;
        this.approvalDate = approvalDate;
        this.applicationDate = applicationDate;
        this.applicationNumber = applicationNumber;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public Person getCustomer() {
        return customer;
    }

    public void setCustomer(Person customer) {
        this.customer = customer;
    }

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    public Date getApprovalDate() {
        return approvalDate;
    }

    public void setApprovalDate(Date approvalDate) {
        this.approvalDate = approvalDate;
    }

    public Date getApplicationDate() {
        return applicationDate;
    }

    public void setApplicationDate(Date applicationDate) {
        this.applicationDate = applicationDate;
    }

    public int getApplicationNumber() {
        return applicationNumber;
    }

    public void setApplicationNumber(int applicationNumber) {
        this.applicationNumber = applicationNumber;
    }

    @Override
    public String toString() {
        return "AccountApplication{" +
                "customerID=" + customerID +
                ", customer=" + customer +
                ", approved=" + approved +
                ", approvalDate=" + approvalDate +
                ", applicationDate=" + applicationDate +
                ", applicationNumber=" + applicationNumber +
                '}';
    }
}