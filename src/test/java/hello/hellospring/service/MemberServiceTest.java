package hello.hellospring.service;


import hello.hellospring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {


    MemberService memberService = new MemberService();
    @Test
    void 회원가입() { // Test Case 작성 시엔 한글로 메서드명을 지어도 상관없다.
        //given
        Member member1 = new Member();
        member1.setName("song");

        //when
        Long saveId = memberService.join(member1);

        //then
        Member result = memberService.findOne(saveId).get();
        assertThat(member1.getName()).isEqualTo(result.getName());
    }

    @Test
    public void 중복_회원_예외(){
        //given
        Member member1 = new Member();
        member1.setName("song");

        Member member2 = new Member();
        member2.setName("song");

        //when
        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");

//        try{
//            memberService.join(member2);
//            fail();
//        }catch(IllegalStateException e){
//            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
//        }

        //then

    }


    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}