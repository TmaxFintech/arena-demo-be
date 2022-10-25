package kr.co.tmax.arenademobe.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Member {

    @Id
    private Long id;
    private String name;
    private String preferred1st;
    private String preferred2nd;
    private String preferred3rd;
}
