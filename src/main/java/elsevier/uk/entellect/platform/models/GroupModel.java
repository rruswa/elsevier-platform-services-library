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
public class GroupModel {

    // TODO: Change class type of created and modified to LocalDateTime after implementing custom serialisation
    @JsonProperty("created")
    private String created;
    @JsonProperty("modified")
    private String modified;
    @JsonProperty("bsds")
    private List<String> bsds;
    @JsonProperty("guid")
    private String guid;
    @JsonProperty("organization_guid")
    private String organizationGuid;
    @JsonProperty("name")
    private String name;
    @JsonProperty("is_active")
    private boolean isActive;
    @JsonProperty("role")
    private String role;
    @JsonProperty("references")
    private ReferenceModel references;

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("created", created)
                .append("modified", modified)
                .append("bsds", bsds)
                .append("guid", guid)
                .append("organization_guid", organizationGuid)
                .append("name", name)
                .append("is_active", isActive)
                .append("role", role)
                .append("references", references)
                .toString();
    }

}
