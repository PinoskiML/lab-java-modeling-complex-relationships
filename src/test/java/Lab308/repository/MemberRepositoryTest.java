package Lab308.repository;


import Lab308.model.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class MemberRepositoryTest {
    @Autowired
    MemberRepository memberRepository;

    Member member; //varios metodos

/*    @Test
    public void createMember_member_newMember(){
        member = new Member ("JimmyJ",  44)
    }*/



    @Test
    public void findAll_members_memberList(){
        List<Member> memberList = memberRepository.findAll();
        System.out.println(memberList);
        assertEquals(0,memberList.size(), "Expected 0"); //message is only displayed when test fails
    }

    @Test
    public void findByID_invalidId_memberNotPresent(){
        Optional<Member> memberOptional = memberRepository.findById(999);
        assertTrue(memberOptional.isEmpty(), "woa this should be empty");
    }

}