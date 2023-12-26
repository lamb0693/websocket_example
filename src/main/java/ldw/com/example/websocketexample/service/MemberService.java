package ldw.com.example.websocketexample.service;

import ldw.com.example.websocketexample.dto.MemberCreateDTO;
import ldw.com.example.websocketexample.entity.Member;
import ldw.com.example.websocketexample.repository.MemberRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MemberService {
    private MemberRepository memberRepository;

    public void create(MemberCreateDTO memberCreateDTO) throws Exception{
        Member member = new Member();
        member.setUsername(memberCreateDTO.getUsername());
        member.setPassword(memberCreateDTO.getPassword());
        member.setRole(memberCreateDTO.getRole());

        memberRepository.save(member);
    }
}
