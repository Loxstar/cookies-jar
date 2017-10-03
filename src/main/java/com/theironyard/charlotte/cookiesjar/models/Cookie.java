package com.theironyard.charlotte.cookiesjar.models;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "cookies")
public class Cookie {
    @Id // this is a primary key column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private int diameter;

    @Column
    private boolean containsNuts;

    @Column
    private boolean isChocolateChip;

    @Column
    private boolean glutenFree;

    @OneToOne
    private CookieSalesData salesData;

    @ManyToMany
    private List<Ingredient> ingredients;

    public Cookie() {
    }

    public Cookie(int diameter, boolean containsNuts, boolean isChocolateChip, boolean glutenFree) {
        this.diameter = diameter;
        this.containsNuts = containsNuts;
        this.isChocolateChip = isChocolateChip;
        this.glutenFree = glutenFree;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getDiameter() {
        return diameter;
    }

    public void setDiameter(int diameter) {
        this.diameter = diameter;
    }

    public boolean isContainsNuts() {
        return containsNuts;
    }

    public void setContainsNuts(boolean containsNuts) {
        this.containsNuts = containsNuts;
    }

    public boolean isChocolateChip() {
        return isChocolateChip;
    }

    public void setChocolateChip(boolean chocolateChip) {
        isChocolateChip = chocolateChip;
    }

    public boolean isGlutenFree() {
        return glutenFree;
    }

    public void setGlutenFree(boolean glutenFree) {
        this.glutenFree = glutenFree;
    }

    public CookieSalesData getSalesData() {
        return salesData;
    }

    public void setSalesData(CookieSalesData salesData) {
        this.salesData = salesData;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Cookie{" +
                "id=" + id +
                ", diameter=" + diameter +
                ", containsNuts=" + containsNuts +
                ", isChocolateChip=" + isChocolateChip +
                ", glutenFree=" + glutenFree +
                ", salesData=" + salesData +
                '}';
    }
}
