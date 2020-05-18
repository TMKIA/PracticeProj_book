package org.example.entity;

import org.springframework.stereotype.Component;

import javax.servlet.Servlet;

/**
 * UserTable entity. @author MyEclipse Persistence Tools
 */

@Component
public class Login {
    // Fields
    private Integer id;
    private String name;
    private String password;
    private boolean role;
    private String telephone;


    /**
     * default constructor
     */
    public Login() {
    }

    // Constructors

    /**
     * full constructor
     */
    public Login(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public Login(String name, String password, String telephone) {
        super();
        this.name = name;
        this.password = password;
        this.telephone = telephone;
    }

    public Login(Integer id, String name, String password, boolean role, String telephone) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.role = role;
        this.telephone = telephone;
    }

    // Property accessors
    /**
     * @return the Role
     */
    public boolean isRole() {
        return role;
    }

    public void setRole(boolean role) {
        this.role = role;
    }

    public Integer getId() {
        return this.id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    public String getPassword() {
        return this.password;
    }

    /**
     * @return the telephone
     */
    public String getTelephone() {
        return telephone;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @param telephone the telephone to set
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Override
    public String toString() {
        return "Login{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                ", telephone='" + telephone + '\'' +
                '}';
    }
}