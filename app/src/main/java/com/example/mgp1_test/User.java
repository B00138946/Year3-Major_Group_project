package com.example.mgp1_test;

public class User {

    public String age,weight, goals;

    public User() {

    }

    public User(String age, String weight, String goals) {

        this.age = age;
        this.weight = weight ;
        this.goals = goals ;

    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getGoals() {
        return goals;
    }

    public void setGoals(String goals) {
        this.goals = goals;
    }
}