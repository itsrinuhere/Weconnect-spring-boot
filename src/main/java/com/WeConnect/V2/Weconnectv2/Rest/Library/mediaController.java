package com.WeConnect.V2.Weconnectv2.Rest.Library;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.apache.commons.codec.binary.Base64;
import java.util.Date;
@RestController()
@RequestMapping("media")
public class mediaController {
    protected MediaService service = new MediaService();
    @RequestMapping(value="upload",method = RequestMethod.POST)
    protected ResponseEntity upload(@RequestBody Template pdf){
            PDF object = new PDF();
            object.setFile(new Base64().decode(pdf.getFile()));
            object.setFilename(pdf.getFilename());
            object.setFiletype(pdf.getFiletype());
            object.setUploaded_time(new Date());
            object.setDescription(pdf.getDescription());
            object.setId(pdf.getId());
        return service.service(object);
    }
    @RequestMapping(value="getmedia/{id}", method=RequestMethod.GET)
    protected ResponseEntity update(){
         /*
    update the relational information to the PDF record
     */
        return new ResponseEntity(HttpStatus.OK);
    }
    @RequestMapping(value="getMedias",method=RequestMethod.GET)
    protected ResponseEntity getMedias(){
        return service.GetMedias();
    }
    @RequestMapping(value="getmediafile/{id}",method=RequestMethod.GET)
    protected ResponseEntity GetMediaFile(@PathVariable("id") String id){
        /*
        return the byte[] stream
         */
            System.err.println("Received Id :"+id);
        return new ResponseEntity(new MediaService().getfiledata(id),HttpStatus.OK);
    }
}
