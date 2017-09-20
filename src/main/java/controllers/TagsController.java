package controllers;

import api.TagResponse;
import dao.TagDao;
import generated.tables.records.TagsRecord;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Path("/tags/{tag}")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TagsController {
    final TagDao tags;

    public TagsController(TagDao tags) { this.tags = tags; }

    @DELETE
    public List<TagResponse> getAllTags(){
        List<TagsRecord> tagRecords = tags.getAllTags();
        return tagRecords.stream().map(TagResponse::new).collect(toList());
    }


    @PUT
    public void toggleTag(@PathParam("tag") String tagName, int tag){
        tags.toggleTag(tag, tagName);
    }


    @GET
    public List<TagResponse> getTagsByTagName(@PathParam("tag") String tagName) {
        List<TagsRecord> tagRecords = tags.getTagsByTagName(tagName);
        return tagRecords.stream().map(TagResponse::new).collect(toList());
    }
}
