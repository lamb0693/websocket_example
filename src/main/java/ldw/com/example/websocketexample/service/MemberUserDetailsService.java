package ldw.com.example.websocketexample.service;

import ldw.com.example.websocketexample.dto.MemberUserDetails;
import ldw.com.example.websocketexample.entity.Member;
import ldw.com.example.websocketexample.repository.MemberRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MemberUserDetailsService implements UserDetailsService {
    private MemberRepository memberRepository;

    @Override
    public MemberUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Member member = memberRepository.findById(username).orElseThrow( ()-> new UsernameNotFoundException("no such user name"));

        return new MemberUserDetails(username, member.getPassword(), member.getRole());
    }
}
