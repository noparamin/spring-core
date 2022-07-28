package hello.core.member;

public interface MemberRepository {

    void save(Member member);

    void update(Member member);

    Member findById(Long memberId);
}
