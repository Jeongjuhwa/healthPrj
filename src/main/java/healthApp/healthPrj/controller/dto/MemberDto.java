package healthApp.healthPrj.controller.dto;

import healthApp.healthPrj.entity.Member;
import lombok.Data;

@Data
public class MemberDto {

    private String name;
    private int age;
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


}
