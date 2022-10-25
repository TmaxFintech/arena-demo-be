package kr.co.tmax.arenademobe.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Document(collection = "finance")
public class Finance {

    @Id
    private String id;

    @Field(name = "title")
    private String title;

    @Field(name = "section")
    private String section;

    @Field(name = "media")
    private String media;

    @Field(name = "date")
    private String date;

    @Field(name = "url")
    private String url;

    @Field(name = "content")
    private String content;
}
