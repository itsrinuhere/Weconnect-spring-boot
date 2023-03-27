package com.WeConnect.V2.Weconnectv2.Rest.Auth;

import com.WeConnect.V2.Weconnectv2.Rest.HibernateUtility;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.engine.jdbc.spi.SqlExceptionHelper;
import org.hibernate.query.Query;
import org.hibernate.sql.exec.ExecutionException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class Service {
    Transaction transaction;
    Session session;
    Service() {
        //session= HibernateUtility.getUsersessionfactory().openSession();
       // transaction = session.beginTransaction();
    }
    ResponseEntity res = new ResponseEntity(HttpStatus.OK);
    ResponseEntity saveNewUser(User user){
        try{
            session  = HibernateUtility.getUsersessionfactory().openSession();
            transaction = session.beginTransaction();
            session.persist(user);
            transaction.commit();
            res = new ResponseEntity(HttpStatus.OK);
        }
        catch(Exception ex){
            //if(ex.getMessage())
            System.out.println(ex.getMessage());
            res = new ResponseEntity(ex.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }finally{
            if(session!=null)
            if(session.isOpen()){
                session.close();
            }
        }
        return res;
    }

    public ResponseEntity validate(String username, String password) {
      try {
          session = HibernateUtility.getUsersessionfactory().openSession();

          transaction = session.beginTransaction();
          Query q = session.createQuery("SELECT object.id FROM com.WeConnect.V2.Weconnectv2.Rest.Auth.User object WHERE object.username ='" + username + "' OR object.email_id = '"+username+"' AND object.password  ='" + password + "'");
          List<Object[]> ls = q.getResultList();
          if (ls == null) {
              return new ResponseEntity(HttpStatus.NO_CONTENT);
          }
          String id = ls.get(0) + "";
          res = new ResponseEntity(id, HttpStatus.ACCEPTED);
      }catch(Exception ex){
          return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
      }finally{
          if(session.isOpen())session.close();
      }
        return res;
    }
    protected ResponseEntity update(String id,String password){
       ResponseEntity res = new ResponseEntity(HttpStatus.CREATED);
       try {
           session = HibernateUtility.getUsersessionfactory().openSession();
           transaction = session.beginTransaction();
           String q = "UPDATE com.WeConnect.V2.Weconnectv2.Rest.Auth.User o SET ";
           q+="o.password ='"+password+"'";
           q+="WHERE o.id = '"+id+"'";
           Query query = session.createQuery(q);
          int result = query.executeUpdate();
            transaction.commit();
            System.out.println(transaction.getStatus()+" result is :"+result);
       }catch(Exception ex){
        res = new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
       }finally{
           if(session.isOpen())session.close();
       }
       return res;
    }
}
