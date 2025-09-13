package com.problemsolving.morganstanlry;

public class Employee {

    private Long id;

    private String name;

    public Employee() {
    }

    public Employee(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
       if(!(obj instanceof Employee)){
           return false;
       }

       Employee other = (Employee) obj;

       return (this.id == other.id && this.name == other.name);
    }

//    @Override
//    public int hashCode(){
//
//    }
}
