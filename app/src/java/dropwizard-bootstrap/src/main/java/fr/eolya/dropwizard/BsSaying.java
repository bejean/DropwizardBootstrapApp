package fr.eolya.dropwizard;

import org.hibernate.validator.constraints.Length;
import com.fasterxml.jackson.annotation.JsonProperty;

public class BsSaying {
    private long id;

    @Length(max = 3)
    private String content;

    public BsSaying() {
        // Jackson deserialization
    }

    public BsSaying(long id, String content) {
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
