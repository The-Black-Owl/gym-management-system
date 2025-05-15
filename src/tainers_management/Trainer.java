package tainers_management;

import members_management.Member;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Trainer {
    private String id;
    private String name;
    private String contact;
    private boolean isActive;
    private List<Member> members=new ArrayList<>();

    public Trainer(String id, String name, String contact) {
        this.id = id;
        this.name = name;
        this.contact=contact;
        this.isActive=true;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }
    public void addMember(Member member) {
        if (members == null) {
            members = new ArrayList<>();
        }
        members.add(member);
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String trainerReport() {
        return "Trainer{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", members=" + members +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Trainer trainer = (Trainer) o;
        return Objects.equals(id, trainer.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
