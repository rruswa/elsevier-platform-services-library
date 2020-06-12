package elsevier.uk.entellect.platform.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@Getter @Setter @Accessors(fluent = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class BitlinkModel {

    @JsonProperty("domain")
    private String domain = "bit.ly";
    @JsonProperty("title")
    private String title;
    @JsonProperty("group_guid")
    private String groupGuid;
    @JsonProperty("long_url")
    private String longUrl;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        BitlinkModel that = (BitlinkModel) o;

        return new EqualsBuilder()
                .append(domain, that.domain)
                .append(title, that.title)
                .append(groupGuid, that.groupGuid)
                .append(longUrl, that.longUrl)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(domain)
                .append(title)
                .append(groupGuid)
                .append(longUrl)
                .toHashCode();
    }

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
