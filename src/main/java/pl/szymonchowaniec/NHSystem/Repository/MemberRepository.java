package pl.szymonchowaniec.NHSystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.szymonchowaniec.NHSystem.Model.Member;

import java.util.List;
import java.util.Optional;


public interface MemberRepository extends JpaRepository<Member, String> {
    @Override
    List<Member> findAll();

    Optional<Member> findById(Long id);
}
