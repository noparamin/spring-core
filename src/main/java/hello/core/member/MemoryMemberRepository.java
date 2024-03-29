package hello.core.member;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component // memoryMemberRepository
public class MemoryMemberRepository implements MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();

    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
    }

    @Override
    public void update(Member member) {
        store.put(member.getId(), member);
    }

    @Override
    public void delete(Member member) {
        store.remove(member.getId());
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }

    public void clearStore() {
        store.clear();
    }
}
