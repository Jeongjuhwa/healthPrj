package healthApp.healthPrj.etc;

import healthApp.healthPrj.entity.Address;
import healthApp.healthPrj.entity.Gym;
import healthApp.healthPrj.entity.Member;
import lombok.RequiredArgsConstructor;
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
    }



    @Component
    @Transactional
    @RequiredArgsConstructor
    static class InitService{

        public final EntityManager em;

        public void dbInit1(){

            Gym gym1 = new Gym("spoAny","2233344444",new Address("서울시","공항대로34","12115"));
            Gym gym2 = new Gym("헬스장","1122233333",new Address("서울시","공항대로376","53215"));
            Gym gym3 = new Gym("주화헬스","7788899999",new Address("서울시","공항대로285","21833"));
            em.persist(gym1);
            em.persist(gym2);
            em.persist(gym3);

            Member member1 = new Member("qwe199942@naver.com","963.","정주화",26,"남",new Address("서울시","화곡로350","07953"));
            Member member2 = new Member("yuntae@naver.com","123.","박윤태",27,"남",new Address("부산시","수영로234","12312"));
            Member member3 = new Member("gwangtae@naver.com","234.","이태광",27,"남",new Address("부산시","수영로345","43654"));
            Member member4 = new Member("ohno@naver.com","555.","조현호",27,"남",new Address("부산시","수영로456","51236"));
            Member member5 = new Member("kojeong@naver.com","666.","고정민",27,"남",new Address("부산시","수영로567","86435"));
            Member member6 = new Member("moi@naver.com","2134234.","박뫼름",27,"여",new Address("홍천시","시골로111","12565"));
            Member member7 = new Member("jeyoung@naver.com","34652.","윤제영",27,"여",new Address("부산시","수영로333","12368"));
            Member member8 = new Member("hyukjin@naver.com","32415235.","손혁진",27,"남",new Address("부산시","수영로666","54543"));
            Member member9 = new Member("kyeongja@naver.com","32454325.","이경준",27,"남",new Address("부산시","수영로777","23475"));
            Member member10 = new Member("jjongwu@naver.com","32454325.","김종우",27,"남",new Address("부산시","수영로888","43257"));


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

            member1.setGym(gym1);
            member2.setGym(gym2);
            member3.setGym(gym3);
            member4.setGym(gym1);
            member5.setGym(gym2);
            member6.setGym(gym3);
            member7.setGym(gym1);
            member8.setGym(gym2);
            member9.setGym(gym3);
            member10.setGym(gym1);

        }


    }

}
