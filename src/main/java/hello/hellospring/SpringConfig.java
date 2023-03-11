package hello.hellospring;

import hello.hellospring.aop.TimeTraceAop;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig
{
    //JdbcTemplate
//    private DataSource dataSource;
//
//    @Autowired
//    public SpringConfig(DataSource dataSource) {
//        this.dataSource = dataSource;
//    }

    //JPA
//    private EntityManager em;
//
//    @Autowired
//    public SpringConfig(EntityManager em) {
//        this.em = em;
//    }

    private final MemberRepository memberRepository;

    @Autowired
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    //MemberService 를 여기서 생성한뒤에 MemberController 생성자에서 @AutoWired 를 사용하면 생성자의 인자로 인스턴스가 들어온다
    @Bean
    public MemberService memberService()
    {
        return new MemberService(memberRepository);
    }

//    @Bean
//    public TimeTraceAop TimeTraceAop()
//    {
//        return new TimeTraceAop();
//    }

    //@Bean
    //public MemberRepository memberRepository()
    //{
     //   return new JpaMemberRepository(em);

        //return new MemoryMemberRepository();
        //return new JdbcTemplateMemberRepository(dataSource);
    //}
}
