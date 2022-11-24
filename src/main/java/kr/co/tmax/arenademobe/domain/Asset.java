package kr.co.tmax.arenademobe.domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Asset")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Asset {

    @Id
    private Long assetCode;

    @Column(name = "ASSET_NAME")
    private String assetName;

    @Column(name = "ASSET_ENGNAME")
    private String assetEngName;
}
