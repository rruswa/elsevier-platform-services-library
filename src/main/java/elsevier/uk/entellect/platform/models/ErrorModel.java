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
public class ErrorModel {

    @JsonProperty("message")
    private String message;
    @JsonProperty("resource")
    private String resource;
    @JsonProperty("description")
    private String description;

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("message", message)
                .append("resource", resource)
                .append("description", description)
                .toString();
    }
    
}
