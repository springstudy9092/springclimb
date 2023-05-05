package spring.study.user.domain;
import lombok.Getter;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Getter
public class User {
    @Id
    private String email;
    private String password;
    private String name;
//    private float height;
//    private float weight;
//    private String experience;
//    private String area;
//    private String idPhoto;
//    private Date birthDt;
//    private Date modrDt;
//    private String field;

}
