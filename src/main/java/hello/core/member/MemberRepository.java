package hello.core.member;

public interface MemberRepository {

    void save(Member member);

    void update(Member member);

    void delete(Member member);

    Member findById(Long memberId);
}
