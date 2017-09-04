package api;

import com.fasterxml.jackson.annotation.JsonProperty;
import generated.tables.records.TagsRecord;

public class TagResponse {
    @JsonProperty
    int id;

    @JsonProperty
    String tagName;

    public TagResponse(TagsRecord dbRecord) {
        this.tagName = dbRecord.getTag();
        this.id = dbRecord.getId();
    }
}
