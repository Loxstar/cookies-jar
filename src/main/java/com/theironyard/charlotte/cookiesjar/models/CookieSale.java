package com.theironyard.charlotte.cookiesjar.models;

import javax.persistence.*;
import java.util.Date;

@Entity
public class CookieSale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private Cookie cookie;

    @Column
    private double cost;

    @Column
    private Date day;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cookie getCookie() {
        return cookie;
    }

    public void setCookie(Cookie cookie) {
        this.cookie = cookie;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public Date getDay() {
        return day;
    }

    public void setDay(Date day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return "CookieSale{" +
                "id=" + id +
                ", cookie=" + cookie +
                ", cost=" + cost +
                ", day=" + day +
                '}';
    }
}
