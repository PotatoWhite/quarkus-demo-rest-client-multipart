package me.potato.model.resource;

import me.potato.model.MultipartBody;
import me.potato.model.client.MultipartService;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;

@Path("/client")
public class MultipartClientResource {
  @Inject
  @RestClient
  MultipartService service;

  @POST
  @Path("/multipart")
  @Produces(MediaType.TEXT_PLAIN)
  public String sendFile() throws Exception {
    var body=new MultipartBody();
    body.setFileName("greeting.txt");
    body.setFile(new ByteArrayInputStream("Hello World".getBytes(StandardCharsets.UTF_8)));
    return service.sendMultipartData(body);
  }

}
