package elsevier.uk.entellect.platform.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@Getter @Setter @Accessors(fluent = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class BitlinkModel {

    @JsonProperty("domain")
    private String domain;
    @JsonProperty("title")
    private String title;
    @JsonProperty("group_guid")
    private String groupGuid;
    @JsonProperty("long_url")
    private String longUrl;

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("domain", domain)
                .append("title", title)
                .append("group_guid", groupGuid)
                .append("long_url", longUrl)
                .toString();
    }
}
