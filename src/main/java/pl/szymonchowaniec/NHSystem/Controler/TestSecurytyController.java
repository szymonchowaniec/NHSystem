package pl.szymonchowaniec.NHSystem.Controler;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestSecurytyController {

    @RequestMapping("/")
    public String Hello(){
        return"Hello world!";
    }

    @RequestMapping("/notprotected")
    public String HelloAgain(){
        return"Hello from non protected page!";
    }

    @RequestMapping("/protectedByUserRole")
    public String HelloUser(){
        return"Hello from user protected page!";
    }

    @RequestMapping("/protectedByAdminRole")
    public String HelloAdmin(){
        return"Hello from admin protected page!";
    }


}
