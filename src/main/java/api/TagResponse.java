package api;

import com.fasterxml.jackson.annotation.JsonProperty;
import generated.tables.records.TagsRecord;

public class TagResponse {
    @JsonProperty
    int receiptId;

    @JsonProperty
    String tagName;

    public TagResponse(TagsRecord dbRecord) {
        this.tagName = dbRecord.getTag();
        this.receiptId = dbRecord.getId();
    }
}
