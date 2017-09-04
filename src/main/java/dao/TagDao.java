package dao;

import generated.tables.records.TagsRecord;
import org.jooq.Configuration;
import org.jooq.DSLContext;
import org.jooq.impl.DSL;

import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Preconditions.checkState;
import static generated.Tables.TAGS;

public class TagDao {
    DSLContext dsl;

    public TagDao(Configuration jooqConfig) {
        this.dsl = DSL.using(jooqConfig);
    }

    public int checkRecord(int tagID, String tagName){
        return dsl.selectFrom(TAGS).where(TAGS.ID.eq(tagID)).fetch().getValues(TAGS.TAG).indexOf(tagName);
    }

    public void deleteRecord(int tagID, String tagName){
        dsl.deleteFrom(TAGS).where(TAGS.ID.eq(tagID).and(TAGS.TAG.eq(tagName))).execute();
    }

    public void toggleTag(int receiptId, String tagName){


        if(checkRecord(receiptId, tagName) != -1){
            deleteRecord(receiptId, tagName);
        }
        else{
            dsl.insertInto(TAGS, TAGS.ID, TAGS.TAG)
                    .values(receiptId, tagName).execute();
        }


    }

    public List<TagsRecord> getTags(String tagName) {
        return dsl.selectFrom(TAGS).where(TAGS.TAG.eq(tagName)).fetch();
    }
}

