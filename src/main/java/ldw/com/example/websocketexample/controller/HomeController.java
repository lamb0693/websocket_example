package ldw.com.example.websocketexample.controller;

import ldw.com.example.websocketexample.dto.MemberCreateDTO;
import ldw.com.example.websocketexample.dto.MemberUserDetails;
import ldw.com.example.websocketexample.service.MemberService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@AllArgsConstructor
public class HomeController {
    PasswordEncoder passwordEncoder;
    MemberService memberService;

    @GetMapping("/")
    @ResponseBody
    public String home(){
        return "Hello";
    }

    @GetMapping("/testMember")
    @ResponseBody
    public String testMember(){
        MemberCreateDTO memberCreateDTO;
        try{
            memberCreateDTO = new MemberCreateDTO("ldw", passwordEncoder.encode("00000000"), "USER");
            memberService.create(memberCreateDTO);
            return "created : " + memberCreateDTO.toString();
        } catch (Exception e){
            return "failed : " + e.getMessage();
        }
    }

    @GetMapping("/member")
    @ResponseBody
    public String member(@AuthenticationPrincipal MemberUserDetails memberUserDetails){
        return "Secured Page :" + memberUserDetails.getUsername() + " " + memberUserDetails.getAuthorities();
    }

}
