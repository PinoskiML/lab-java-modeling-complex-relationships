package Lab308.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Member {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;


    private String name;

    @Enumerated(EnumType.STRING)
    private MemberStatus memberStatus;

    private Date renewalDate;

    // /MAnytoOne
    @ManyToOne
    @JoinColumn(name = "chapter_id")
    private Chapter chapter;

    @OneToOne(mappedBy = "president")
    private Chapter presidingChapter;


    public void setChapter(Chapter chapter) {
        this.chapter = chapter;
    }

    public Chapter getChapter() {
        return chapter;
    }

   ///
    private Date renewalStatus;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public MemberStatus getMemberStatus() {
        return memberStatus;
    }

    public void setMemberStatus(MemberStatus memberStatus) {
        this.memberStatus = memberStatus;
    }

    public Date getRenewalStatus() {
        return renewalStatus;
    }

    public void setRenewalStatus(Date renewalStatus) {
        this.renewalStatus = renewalStatus;
    }

    public Member(Date renewalStatus) {
        this.renewalStatus = renewalStatus;
    }

    public Member(String name) {
        this.name = name;
    }


    //constructor con chapter


    public Member(String name, MemberStatus memberStatus, Chapter chapter, Date renewalStatus) {
        this.name = name;
        this.memberStatus = memberStatus;
        this.chapter = chapter;
        this.renewalStatus = renewalStatus;
    }

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", memberStatus=" + memberStatus +
                ", chapter=" + chapter +
                ", renewalStatus=" + renewalStatus +
                '}';
    }

    public Member() {
    }
}
