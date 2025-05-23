package Lab308.model;

import jakarta.persistence.*;
import java.util.List;

import java.util.ArrayList;

@Entity
public class Chapter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;  //there will be 7 chapter therefore 0-6
    private String name;   // Chapter's name
    private String district;

    @OneToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "president_id")
    private Member president; //1 president to 1 chapter

    @OneToMany(mappedBy = "chapter", cascade = CascadeType.ALL)
    private List<Member> memberList = new ArrayList<>();    //importar java.util.list;


    //     ///    ////
    // Add this field and annotation




    //setters Getters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public Member getPresident() {
        return president;
    }

    public void setPresident(Member president) {
        this.president = president;
    }

    //setters and getters memberList


    public List<Member> getMemberList() {
        return memberList;
    }

    public void setMemberList(List<Member> memberList) {
        this.memberList = memberList;
    }


    public Chapter(Integer id, String name, String district, Member president) {
        this.id = id;
        this.name = name;
        this.district = district;
        this.president = president;
    }


    public Chapter() {
    }


    public void addMember(Member member) {
        memberList.add(member);
        member.setChapter(this);
    }


    @Override
    public String toString() {
        return "Chapter{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", district='" + district + '\'' +
                ", president=" + president +
                ", memberList=" + memberList +
                '}';
    }
}
