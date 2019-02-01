package pl.szymonchowaniec.NHSystem.Controler;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import pl.szymonchowaniec.NHSystem.Model.Member;
import pl.szymonchowaniec.NHSystem.Service.MemberService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.security.Principal;
import java.time.ZoneId;
import java.util.List;
import java.util.Locale;
import java.util.Map;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class MemberController {

    @Autowired
    private MemberService memberService;


    @RequestMapping(value = "/user/", method = RequestMethod.GET)
    public ResponseEntity<List<Member>> listAllUsers() {
        List<Member> users = memberService.findAll();
        if(users.isEmpty()){
            return new ResponseEntity<List<Member>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Member>>(users, HttpStatus.OK);
    }

    @RequestMapping(value = "/user/", method = RequestMethod.POST)
    public ResponseEntity<Void> createUser(@Valid @RequestBody Member member, UriComponentsBuilder ucBuilder) {
        System.out.println("Creating User " + member.getName());


        memberService.createMember(member);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(member.getEmail()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }


    @GetMapping
    List<Member> findAll(
            Principal principal,
            Locale locale,
            ZoneId zoneId,
            @CookieValue("my_cookie") String my_cookie,
            @RequestHeader Map<String,String> headers,
            HttpServletRequest request

    ){
        Principal principal1 = request.getUserPrincipal();
 return  memberService.findAll();
    }





    @GetMapping(value = "user/{id}", produces = MediaType.APPLICATION_JSON_VALUE )
    private ResponseEntity getMember (@PathVariable("id") Long id){
        if(memberService.findOne(id).isPresent())
            return new ResponseEntity<>(memberService.findOne(id), HttpStatus.OK);
        else
            return new ResponseEntity<java.util.Optional<Member>>(HttpStatus.NOT_FOUND);
    }


    @DeleteMapping()
    private void dropMember(){
        memberService.deleteOne(new Member());
    }




}
