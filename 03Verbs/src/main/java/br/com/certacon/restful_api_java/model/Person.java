package br.com.certacon.restful_api_java.model;

import java.io.Serializable;
import java.util.Objects;

public class Person implements Serializable {
    private long id;
    private String firstName;
    private String lastName;
    private String adress;
    private String gender;

    public Person() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public final boolean equals(Object o) {
        if (!(o instanceof Person person)) return false;

        return id == person.id && firstName.equals(person.firstName) && lastName.equals(person.lastName) && adress.equals(person.adress) && gender.equals(person.gender);
    }

    @Override
    public int hashCode() {
        int result = Long.hashCode(id);
        result = 31 * result + firstName.hashCode();
        result = 31 * result + lastName.hashCode();
        result = 31 * result + adress.hashCode();
        result = 31 * result + gender.hashCode();
        return result;
    }
}
