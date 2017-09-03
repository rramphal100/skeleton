package controllers;

import api.CreateTagRequest;
import api.TagResponse;
import dao.TagDao;
import generated.tables.records.TagsRecord;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
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

    @PUT
    public void toggleTag(@PathParam("tag") String tagName, @Valid @NotNull CreateTagRequest tag){
        tags.toggleTag(tag.id, tagName);
    }

    @GET
    public List<TagResponse> getTags(@PathParam("tag") String tagName) {
        List<TagsRecord> tagRecords = tags.getTags(tagName);
        return tagRecords.stream().map(TagResponse::new).collect(toList());
    }
}
