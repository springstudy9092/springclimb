package spring.study.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import javax.persistence.*;
import java.util.Objects;
@Entity
@Getter
@ToString
@Table(indexes = {
        @Index(columnList = "email", unique = true)
})
@NoArgsConstructor
public class User {
    @Id
    @Column(nullable = false, length = 100)
    private String email;

    @Setter
    @Column(nullable = false)
    private String password;
    @Setter
    @Column(nullable = false)
    private String name;


//    private float height;
//    private float weight;
//    private String experience;
//    private String area;
//    private String idPhoto;
//    private Date birthDt;
//    private Date modrDt;


    // 생성시 직접 new 하지 않고 static 메서드 사용
    private User(String email, String password, String name) {
        this.email = email;
        this.password = password;
        this.name = name;
    }

    public static User of(String email, String password, String name) {
        return new User( email, password, name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User that = (User) o;
        return this.getEmail() != null && this.getEmail().equals(that.getEmail());
    }
    @Override
    public int hashCode() {
        return Objects.hash(this.getEmail());
    }
}
