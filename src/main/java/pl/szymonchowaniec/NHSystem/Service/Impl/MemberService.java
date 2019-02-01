package pl.szymonchowaniec.NHSystem.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pl.szymonchowaniec.NHSystem.Model.Member;
import pl.szymonchowaniec.NHSystem.Model.Role;
import pl.szymonchowaniec.NHSystem.Repository.MemberRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MemberService implements pl.szymonchowaniec.NHSystem.Service.MemberService {

    @Autowired
    private MemberRepository memberRepository;

    public Member createMember(Member member){
        return getMember(member, "MEMBER");
    }

    private Member getMember(Member member, String member2) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        member.setPassword(encoder.encode(member.getPassword()));
        Role memberRole = new Role(member2);
        List<Role> roleList = new ArrayList<>();
        roleList.add(memberRole);
        member.setRoles(roleList);
        return memberRepository.save(member);
    }

    public Member createAdmin(Member member){
        return getMember(member, "ADMIN");
    }



    public Optional<Member> findOne  (Long id){
        return  memberRepository.findById(id);

    }


    public List<Member> findAll(){
        return memberRepository.findAll();
    }

    public void deleteOne(Member member) {
        memberRepository.delete(member);
    }




}
