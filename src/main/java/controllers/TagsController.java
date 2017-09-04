package controllers;

import api.TagResponse;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import dao.TagDao;
import generated.tables.records.TagsRecord;

import javax.jws.WebParam;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.xml.ws.RequestWrapper;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Path("/tags/{tag}")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TagsController {
    final TagDao tags;

    public TagsController(TagDao tags) { this.tags = tags; }

    @PUT
    public void toggleTag(@PathParam("tag") String tagName, int tag){
        tags.toggleTag(tag, tagName);
    }

    @GET
    public List<TagResponse> getTagsByTagName(@PathParam("tag") String tagName) {
        List<TagsRecord> tagRecords = tags.getTags(tagName);
        return tagRecords.stream().map(TagResponse::new).collect(toList());
    }
}
