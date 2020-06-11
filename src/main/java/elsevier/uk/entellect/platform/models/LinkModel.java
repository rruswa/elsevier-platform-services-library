package elsevier.uk.entellect.platform.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.List;

@Getter @Setter @Accessors(fluent = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class LinkModel {

    @JsonProperty("created_at")
    private String createdAt;
    @JsonProperty("id")
    private String id;
    @JsonProperty("link")
    private String link;
    @JsonProperty("long_url")
    private String longUrl;
    @JsonProperty("archived")
    private boolean archived;
    @JsonProperty("tags")
    private List<String> tags;
    @JsonProperty("references")
    private ReferencesModel references;

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("created_at", createdAt)
                .append("id", id)
                .append("link", link)
                .append("long_url", longUrl)
                .append("archived", archived)
                .append("tags", tags)
                .append("references", references)
                .toString();
    }
}
