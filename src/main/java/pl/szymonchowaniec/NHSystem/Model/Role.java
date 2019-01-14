package pl.szymonchowaniec.NHSystem.Model;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Role {

    @Id
    private String name;
    @ManyToMany(mappedBy = "roles")
    private List<Member> members;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }

    public Role(String name, List<Member> members) {
        this.name = name;
        this.members = members;
    }

    public Role() {
    }

    public Role(String name) {
        this.name = name;
    }

}