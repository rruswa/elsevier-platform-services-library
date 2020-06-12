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
public class BitlinksModel {

    @JsonProperty("links")
    private List<LinkModel> links;

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("links", links)
                .toString();
    }
}
