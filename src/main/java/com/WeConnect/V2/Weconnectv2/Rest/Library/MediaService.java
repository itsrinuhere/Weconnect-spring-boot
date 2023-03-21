package com.WeConnect.V2.Weconnectv2.Rest.Library;
import org.apache.commons.codec.binary.Base64;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;
public class MediaService {
   protected Session  session ;
  protected  Transaction transaction ;
  MediaService(){
      session = MediaHibernateUtility.getsessionfactory().openSession();
      transaction =  session.beginTransaction();
  }
    ResponseEntity service(PDF object){
        try{
            session = MediaHibernateUtility.getsessionfactory().openSession();
            transaction =  session.beginTransaction();
            session.persist(object);
            transaction.commit();
           System.err.println(transaction.getStatus());
           System.err.println(transaction.getTimeout());
           System.err.println(session.getTransaction());

        }catch(Exception e){
            System.err.println(e.toString());
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        finally{
            session.clear();
        }
        return new ResponseEntity(HttpStatus.OK);
    }
    protected  ResponseEntity GetMedias(){
        try{
            System.err.println("GET all media data link envoked");
            session = MediaHibernateUtility.getsessionfactory().openSession();
            transaction =  session.beginTransaction();
            Query<PDF> query = session.createQuery("FROM com.WeConnect.V2.Weconnectv2.Rest.Library.PDF ",PDF.class);
            List<PDF> data = query.getResultList();
            if(data!=null){
                int i=0;
                while(i<data.size()){
                    data.get(i++).setFile(null);
                }
               return new ResponseEntity(data,HttpStatus.OK);
            }
            return new ResponseEntity(HttpStatus.NO_CONTENT);

        }catch(Exception ex){
            System.err.println(ex.toString());
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        finally{
            if(session.isOpen())
            session.close();
        }
    }
    ResponseEntity getmediainfo(String id){
        try{
            Query<PDF> query = session.createQuery("FROM com.WeConnect.V2.Weconnectv2.Rest.Library.PDF object WHERE object.id : =id",PDF.class);
            query.setParameter("id",id);
            List<PDF> data = query.getResultList();
            if(data!=null && data.get(0) != null) {
                System.err.println(transaction.getStatus());
                return new ResponseEntity(data.get(0), HttpStatus.OK);
            }
        }catch(Exception ex){
            System.err.println(ex.toString());
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        finally{
            if(session.isOpen())
                session.close();
        }
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
    PDF Query(String q){
        try{
            Query<PDF> query = session.createQuery(q,PDF.class);
            List<PDF> data = query.getResultList();
            if(data!=null && data.get(0) != null) {
                System.err.println(transaction.getStatus());
               return data.get(0);
            } return null;
        }catch(Exception ex){
            System.err.println(ex.toString());
            ex.printStackTrace();
            return null;
        }finally {
            if(session.isOpen())
                session.close();
        }
    }
    Template getfiledata(String id){
      Template data=new Template();
      try{
          Query query = session.createQuery("SELECT o.file ,o.filetype FROM com.WeConnect.V2.Weconnectv2.Rest.Library.PDF o WHERE o.id ='"+id+"'");
          List<Object[]> ls = query.getResultList();
          for(Object[] o : ls){
              byte[] d =(byte[] )o[0];
              data.setFile(new Base64().encodeToString(d));
              data.setFiletype((String)o[1]);
          }
         // data = query.getParameter("o.file");
      }catch(Exception ex){
        System.out.println(ex);
      }finally {
          if(session.isOpen())
              session.close();
      }

      return  data;
    }
}
