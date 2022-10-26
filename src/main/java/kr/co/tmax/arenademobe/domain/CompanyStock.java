package kr.co.tmax.arenademobe.domain;

import lombok.*;
import javax.persistence.*;

@Entity
@Table(name = "CompanyStock")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CompanyStock {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String assetName;
    private String assetCode;
    private String title;
    private String media;
    private String time;
    private String img;

    @Column(length = 30000)
    private String content;
}
