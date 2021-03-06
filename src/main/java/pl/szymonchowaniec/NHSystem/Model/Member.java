package pl.szymonchowaniec.NHSystem.Model;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Member {

    @Id
    @GeneratedValue
    Long id;
    @Email
    @NotEmpty
    @Column(unique = true)
    private String email;
    @NotEmpty
    private String name;
    @Size(min = 4)
    private String password;
    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Task> tasks;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "MEMBER_ROLES", joinColumns={
            @JoinColumn(name = "MEMBER_ID", referencedColumnName = "id") }, inverseJoinColumns = {
            @JoinColumn(name = "ROLE_NAME", referencedColumnName = "name") })
    private List<Role> roles;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Task> gettasks() {
        return tasks;
    }

    public void settasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public Member(String email, String name, String password) {
        this.email = email;
        this.name = name;
        this.password = password;
    }

    public Member() {

    }

}