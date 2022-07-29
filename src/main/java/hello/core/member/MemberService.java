package hello.core.member;

public interface MemberService {

    void join(Member member);

    Member findMember(Long memberId);

    void updateMember(Member member);

    void deleteMember(Member member);
}
