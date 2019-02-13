package com.neu.edu.pojo;

public class Order {
    String SalesOrderID;
    String SalesOrderNumber;
    String PurchaseOrderNumber;
    String CustomerID;
    String SalesPersonID;
    String TotalDue;

    public String getSalesOrderID() {
        return SalesOrderID;
    }

    public void setSalesOrderID(String salesOrderID) {
        SalesOrderID = salesOrderID;
    }

    public String getSalesOrderNumber() {
        return SalesOrderNumber;
    }

    public void setSalesOrderNumber(String salesOrderNumber) {
        SalesOrderNumber = salesOrderNumber;
    }

    public String getPurchaseOrderNumber() {
        return PurchaseOrderNumber;
    }

    public void setPurchaseOrderNumber(String purchaseOrderNumber) {
        PurchaseOrderNumber = purchaseOrderNumber;
    }

    public String getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(String customerID) {
        CustomerID = customerID;
    }

    public String getSalesPersonID() {
        return SalesPersonID;
    }

    public void setSalesPersonID(String salesPersonID) {
        SalesPersonID = salesPersonID;
    }

    public String getTotalDue() {
        return TotalDue;
    }

    public void setTotalDue(String totalDue) {
        TotalDue = totalDue;
    }
}
