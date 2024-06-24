package vn.edu.likelion.library.model;

import vn.edu.likelion.library.service.AbstractEntity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class User extends AbstractEntity {
    private String name;
    private int age;
    private List<Rental> rentals;

    public User() {
        this.rentals = new ArrayList<>();
    }

    // getters, setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Rental> getRentals() {
        return rentals;
    }

    public void setRentals(List<Rental> rentals) {
        this.rentals = rentals;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", rentals=" + rentals +
                "}" ;
    }

    public void display() {
        String temp = "";
        for (Rental rental : rentals) {
            temp += rental.getBook() + ", countHired:" + rental.getQuantity() + "}, ";
        }
        System.out.println(toString() + ", listHiredBooks =[{" + temp + "]");
    }
}

