package fr.eolya.dropwizard.bs.services.hello;

import org.hibernate.validator.constraints.Length;
import com.fasterxml.jackson.annotation.JsonProperty;

public class HelloSaying {
    private long id;

    @Length(max = 3)
    private String content;

    public HelloSaying() {
        // Jackson deserialization
    }

    public HelloSaying(long id, String content) {
        this.id = id;
        this.content = content;
    }

    @JsonProperty
    public long getId() {
        return id;
    }

    @JsonProperty
    public String getContent() {
        return content;
    }
}
