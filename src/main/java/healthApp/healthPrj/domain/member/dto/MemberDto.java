package healthApp.healthPrj.domain.member.dto;

import healthApp.healthPrj.domain.member.model.Member;
import lombok.Data;

@Data
public class MemberDto {

    private String name;
    private Integer age;
    private String sex;
    private String city;
    private String street;
    private String zipcode;

    public MemberDto(Member m){
        this.name = m.getMemberName();
        this.age = m.getMemberAge();
        this.sex = m.getMemberSex();
        this.city = m.getAddress().getCity();
        this.street =m.getAddress().getStreet();
        this.zipcode = m.getAddress().getZipcode();
    }

    public MemberDto(String name, Integer age, String sex, String city, String street, String zipcode) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
    }
}
