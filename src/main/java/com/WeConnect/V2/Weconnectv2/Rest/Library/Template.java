package com.WeConnect.V2.Weconnectv2.Rest.Library;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;
@Entity

public class Template implements Serializable {
    @Id
    // @GeneratedValue(strategy = GenerationType.UUID)
    String id;
    @Column(name="file")
    String file;
    @Column(name="uploaded_by")
    String uploaded_by;
    //feature update to redirect uploaded by user Id to view user Info
    @Column(name="filetype")
    String filetype;
    @Column(name="uploaded_time")
    Date uploaded_time;
    @Column(name="description")
    String description;
    @Column(name="filename")
    String filename;
    @Column(name="size")
    long size;


    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }



    public String getFiletype() {
        return filetype;
    }

    public void setFiletype(String filetype) {
        this.filetype = filetype;
    }

    public Date getUploaded_time() {
        return uploaded_time;
    }

    public void setUploaded_time(Date uploaded_time) {
        this.uploaded_time = uploaded_time;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }
}
