package pl.szymonchowaniec.NHSystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.szymonchowaniec.NHSystem.Model.Member;

public interface MemberRepository extends JpaRepository<Member, String> {
}
