package hello.core.order;

import hello.core.AppConfig;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class OrderServiceTest2 {

    @Autowired
    MemberService memberService;
    @Autowired
    OrderService orderService;

    @Test
    void createOrder() {
        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Long memberId2 = 2L;
        Member member2 = new Member(memberId2, "memberB", Grade.VIP);
        memberService.join(member2);

        Order order1 = orderService.createOrder(memberId, "itemA", 10000);
        Order order2 = orderService.createOrder(memberId, "itemA", 20000);
        Assertions.assertThat(order1.getDiscountPrice()).isEqualTo(1000);
        Assertions.assertThat(order2.getDiscountPrice()).isEqualTo(2000);
    }

}
