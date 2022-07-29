package hello.core.member;

import hello.core.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {

    MemberService memberService;

    @BeforeEach // 테스트 실행하기 전 실행
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }

    @Test
    void join() {
        //given
        Member member = new Member(1L, "memberA", Grade.VIP);

        //when
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        //then
        Assertions.assertThat(member).isEqualTo(findMember);
    }

    @Test
    @DisplayName("회원정보수정")
    void update() {
        // given
        Member member = new Member(1L, "David", Grade.VIP);

        // when
        memberService.join(member);
        member.setName("Lisandro");
        member.setGrade(Grade.BASIC);
        memberService.updateMember(member);

        Member findMember = memberService.findMember(1L);

        // then
        Assertions.assertThat(member).isEqualTo(findMember);
        Assertions.assertThat(member.getGrade()).isEqualTo(findMember.getGrade());
        Assertions.assertThat(member.getName()).isEqualTo(findMember.getName());

    }

    @Test
    @DisplayName("회원 삭제")
    void delete() {
        // given
        Member member = new Member(1L, "David", Grade.VIP);

        // when
        memberService.join(member);
        memberService.deleteMember(member);

        Member findMember = memberService.findMember(1L);
        System.out.println(findMember);
        // then
        Assertions.assertThat(member).isNotSameAs(findMember);
    }
}
