package cuk.mvc.domain.member;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class MemberRepositoryTest {

    MemberRepository memberRepository = MemberRepository.getInstance();

    @AfterEach
    void afterEach() {
        memberRepository.clearStore();
    }

    @Test
    void save() {
        //given
        Member member = new Member("memberA", 20);
        
        //when
        memberRepository.save(member);

        //then
        Member savedMember = memberRepository.findById(member.getId());
        System.out.println("member = " + savedMember.getId());
        assertThat(member).isEqualTo(savedMember);
    }
    
    @Test
    void findAll() {
        //given
        Member member1 = new Member("memberA", 20);
        Member member2 = new Member("memberB", 25);

        memberRepository.save(member1);
        memberRepository.save(member2);
        
        //when
        List<Member> result = memberRepository.findAll();
        
        //then
        assertThat(result.size()).isEqualTo(2);
        assertThat(result).contains(member1, member2);
    }
    

}