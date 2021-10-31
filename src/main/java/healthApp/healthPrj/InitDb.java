package healthApp.healthPrj;

import healthApp.healthPrj.common.object.Address;
import healthApp.healthPrj.domain.member.model.Gym;
import healthApp.healthPrj.domain.member.model.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;

@Component
@RequiredArgsConstructor
public class InitDb {

    private final InitService initService;

    @PostConstruct
    public void init(){
        initService.dbInit1();
        initService.dbInit2();
    }



    @Component
    @RequiredArgsConstructor
    static class InitService{

        private final EntityManager em;
        private final PasswordEncoder passwordEncoder;

        @Transactional
        public void dbInit1(){

            Gym gym1 = Gym.builder()
                    .gymName("spoAny")
                    .emailId("spoAny@naver.com")
                    .password(passwordEncoder.encode("spozzang"))
                    .gymNumber("2233344444")
                    .address(new Address("서울시","공항대로34","12115"))
                    .build();
            Gym gym2 = Gym.builder()
                    .gymName("헬스장")
                    .emailId("health@naver.com")
                    .password(passwordEncoder.encode("healthzzang"))
                    .gymNumber("1122233333")
                    .address(new Address("서울시","공항대로376","53215"))
                    .build();
            Gym gym3 = Gym.builder()
                    .gymName("주화헬스")
                    .emailId("juhwa@naver.com")
                    .password(passwordEncoder.encode("juhwazzang"))
                    .gymNumber("7788899999")
                    .address(new Address("서울시","공항대로285","21833"))
                    .build();
            em.persist(gym1);
            em.persist(gym2);
            em.persist(gym3);


        }
        @Transactional
        public void dbInit2(){
            Member member1 = Member.builder()
                    .emailId("qwe199942@naver.com")
                    .password(passwordEncoder.encode("963."))
                    .memberName("정주화")
                    .memberAge(26)
                    .memberSex("남")
                    .address(new Address("서울시","화곡로350","07953"))
                    .build();
            Member member2 = Member.builder()
                    .emailId("gwangtae@naver.com")
                    .password(passwordEncoder.encode("234."))
                    .memberName("이태광")
                    .memberAge(27)
                    .memberSex("남")
                    .address(new Address("부산시","수영로345","43654"))
                    .build();
            Member member3 = Member.builder()
                    .emailId("ohno@naver.com")
                    .password(passwordEncoder.encode("dkssud"))
                    .memberName("조현호")
                    .memberAge(27)
                    .memberSex("남")
                    .address(new Address("부산시","수영로350","12345"))
                    .build();
            Member member4 = Member.builder()
                    .emailId("kojeong@naver.com")
                    .password(passwordEncoder.encode("koko"))
                    .memberName("고정민")
                    .memberAge(27)
                    .memberSex("남")
                    .address(new Address("부산시","남천동로12","44003"))
                    .build();
            Member member5 = Member.builder()
                    .emailId("yuntae@naver.com")
                    .password(passwordEncoder.encode("tkfkd"))
                    .memberName("박윤태")
                    .memberAge(27)
                    .memberSex("남")
                    .address(new Address("부산시","남천동로235","34503"))
                    .build();
            Member member6 = Member.builder()
                    .emailId("moi@naver.com")
                    .password(passwordEncoder.encode("tkfkd"))
                    .memberName("박뫼름")
                    .memberAge(27)
                    .memberSex("여")
                    .address(new Address("홍천시","시골로111","12565"))
                    .build();
            Member member7 = Member.builder()
                    .emailId("jeyoung@naver.com")
                    .password(passwordEncoder.encode("tkfkd"))
                    .memberName("윤제영")
                    .memberAge(27)
                    .memberSex("여")
                    .address(new Address("부산시","수영로257","64783"))
                    .build();
            Member member8 = Member.builder()
                    .emailId("hyukjin@naver.com")
                    .password(passwordEncoder.encode("okgolife"))
                    .memberName("손혁진")
                    .memberAge(27)
                    .memberSex("남")
                    .address(new Address("부산시","남천동로21","43211"))
                    .build();
            Member member9 = Member.builder()
                    .emailId("jjongwu@naver.com")
                    .password(passwordEncoder.encode("busanuniv"))
                    .memberName("김종우")
                    .memberAge(27)
                    .memberSex("남")
                    .address(new Address("부산시","남천동로26","34112"))
                    .build();
            Member member10 = Member.builder()
                    .emailId("qkyeongja@naver.com")
                    .password(passwordEncoder.encode("taekwon"))
                    .memberName("이경준")
                    .memberAge(27)
                    .memberSex("남")
                    .address(new Address("부산시","수영로876","96734"))
                    .build();

            em.persist(member1);
            em.persist(member2);
            em.persist(member3);
            em.persist(member4);
            em.persist(member5);
            em.persist(member6);
            em.persist(member7);
            em.persist(member8);
            em.persist(member9);
            em.persist(member10);


        }


    }

}
