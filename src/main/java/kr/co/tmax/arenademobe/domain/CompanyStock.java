package kr.co.tmax.arenademobe.domain;

import lombok.Getter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@ToString
@Document(collection = "company_stock")
public class CompanyStock {

    @Id
    private String id;

    @Field(name = "asset_name")
    private String assetName;

    @Field(name = "asset_code")
    private String assetCode;

    private String title;
    private String media;
    private String time;
    private String content;
    private String img;

    @Field(name = "naver_url")
    private String naverUrl;

    @Field(name = "origin_url")
    private String originUrl;
}
