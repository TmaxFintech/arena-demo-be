package kr.co.tmax.arenademobe.domain;

import kr.co.tmax.arenademobe.config.BaseEntity;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@ToString
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "USER_ACCOUNT", uniqueConstraints = {@UniqueConstraint(name = "NAME_EMAIL_UNIQUE",  columnNames = {"USERNAME", "EMAIL"})})
public class UserAccount extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty
    @Length(min = 4)
    private String username;

    @NotEmpty
    @Length(min = 4)
    private String password;

    @NotEmpty
    @Email
    private String email;

    private String role;

    private String preferred1st;
    private String preferred2nd;
    private String preferred3rd;
}