package me.potato.model;

import lombok.Getter;
import lombok.Setter;
import org.jboss.resteasy.annotations.providers.multipart.PartType;

import javax.ws.rs.FormParam;
import javax.ws.rs.core.MediaType;
import java.io.InputStream;

@Getter
@Setter
public class MultipartBody {
  @FormParam("file")
  @PartType(MediaType.APPLICATION_OCTET_STREAM)
  private InputStream file;

  @FormParam("fileName")
  @PartType(MediaType.TEXT_PLAIN)
  private String fileName;
}
