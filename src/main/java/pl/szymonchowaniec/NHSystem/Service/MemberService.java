package pl.szymonchowaniec.NHSystem.Service;

import pl.szymonchowaniec.NHSystem.Model.Member;

import java.util.List;
import java.util.Optional;

public interface MemberService {
    Member createMember(Member member);
    Member createAdmin(Member member);
    Optional<Member> findOne(Long id);
    List<Member> findAll();
    void deleteOne(Member member);

}
