package pl.szymonchowaniec.NHSystem.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pl.szymonchowaniec.NHSystem.Model.Member;
import pl.szymonchowaniec.NHSystem.Model.Role;
import pl.szymonchowaniec.NHSystem.Repository.MemberRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class MemberService {
    @Autowired
    private MemberRepository memberRepository;

    public Member createMember(Member member){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        member.setPassword(encoder.encode(member.getPassword()));
        Role memberRole = new Role("MEMBER");
        List<Role> roleList = new ArrayList<>();
        roleList.add(memberRole);
        member.setRoles(roleList);
        return memberRepository.save(member);
    }

    public void createAdmin(Member member){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        member.setPassword(encoder.encode(member.getPassword()));
        Role memberRole = new Role("ADMIN");
        List<Role> roleList = new ArrayList<>();
        roleList.add(memberRole);
        member.setRoles(roleList);
        memberRepository.save(member);
    }

    public Member findOne(String email){
       return memberRepository.getOne(email);
    }

    public Page<Member> findAll(Pageable pageable){
        return memberRepository.findAll(pageable);
    }

    public List<Member> findAll(){
        return memberRepository.findAll();
    }

    public void deleteOne(Member member) {
        memberRepository.delete(member);
    }
}
