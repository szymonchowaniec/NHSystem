package pl.szymonchowaniec.NHSystem.Controler;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.szymonchowaniec.NHSystem.Model.Member;
import pl.szymonchowaniec.NHSystem.Service.MemberService;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class MemberController {

    @Autowired
    private MemberService memberService;


    @PostMapping
    public Member createMember(@RequestParam String email, @RequestParam String name, @RequestParam String password){
        Member member = new Member(email, name,password);
        return memberService.createMember(member);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Member> getMembers(){
        return memberService.findAll();
    }



    @GetMapping(value = "{email}", produces = MediaType.APPLICATION_JSON_VALUE )
    private Member getMember (@PathVariable("email") String email){
        return memberService.findOne(email);
    }
    @DeleteMapping()
    private void dropMember(){
        memberService.deleteOne(new Member());
    }


}
