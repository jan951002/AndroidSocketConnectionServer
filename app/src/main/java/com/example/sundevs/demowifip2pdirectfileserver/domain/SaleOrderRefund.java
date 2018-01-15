package com.example.sundevs.demowifip2pdirectfileserver.domain;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by SunDevs on 15/01/2018.
 */

public class SaleOrderRefund {
    private String _id;
    private Employee employee;
    private String reason;
    private Double total;
    private ArrayList<SaleOrderLineRefund> saleOrderLineRefunds;
    private Date createdAt;

    public SaleOrderRefund() {
    }

    public String getId() {
        return _id;
    }

    public void setId(String _id) {
        this._id = _id;
    }


    public ArrayList<SaleOrderLineRefund> getSaleOrderLineRefunds() {
        return saleOrderLineRefunds;
    }

    public void setSaleOrderLineRefunds(ArrayList<SaleOrderLineRefund> saleOrderLineRefunds) {
        this.saleOrderLineRefunds = saleOrderLineRefunds;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
