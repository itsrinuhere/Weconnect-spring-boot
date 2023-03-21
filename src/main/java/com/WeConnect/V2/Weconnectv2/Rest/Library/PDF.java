package com.WeConnect.V2.Weconnectv2.Rest.Library;
import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Date;
@Entity
@Table(name= "tbl_library")
public class PDF implements Serializable{
    @Id
    // @GeneratedValue(strategy = GenerationType.UUID)
    String id;
    // @Column(name="file",nullable = false)
    @Column(name="file",columnDefinition ="bytea",nullable = false)
    @Basic(fetch = FetchType.LAZY)
    byte[] file;
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
    public PDF(){

    }
    public PDF(String id, byte[] file, String filetype, Date uploaded_time, String description, String filename, long size) {
        this.id = id;
        this.file = file;
        this.filetype = filetype;
        this.uploaded_time = uploaded_time;
        this.description = description;
        this.filename = filename;
        this.size = size;
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

    public byte[] getFile() {
        return file;
    }

    public void setFile(byte[] file) {
        this.file = file;
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
