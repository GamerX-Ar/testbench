package com.hubble.data;

public class Person {

    private String name;
    private Byte age;

    public Person(String name, byte age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Byte getAge() {
        return age;
    }

    public void setAge(byte age) {
        this.age = age;
    }
}
