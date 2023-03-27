package com.WeConnect.V2.Weconnectv2.Rest;

import com.WeConnect.V2.Weconnectv2.Rest.Auth.User;
import com.WeConnect.V2.Weconnectv2.Rest.Library.PDF;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;

public class HibernateUtility {
    static String sqlDriver="org.postgresql.Driver";
    static String dbusername="postgres";
    static String dbPassword="root";
    static String url= "jdbc:postgresql://localhost:5432/Spring?createDatabaseIfNotExist=true&&autoReconnect=true";
    static String dielect="org.hibernate.dialect.PostgreSQLDialect";
    public static SessionFactory usersessionfact,librarysessionfact,authsessionfact;

    public static SessionFactory getUsersessionfactory() {
        if(usersessionfact == null) {
            try {
                Configuration configuration= new Configuration();
                Properties settings = new Properties();
                settings.put(Environment.DRIVER, sqlDriver);//?autoReconnect=true
                settings.put(Environment.URL,url);
                settings.put(Environment.USER, dbusername);
                settings.put(Environment.PASS, dbPassword);
                settings.put(Environment.DIALECT, dielect);
                settings.put(Environment.SHOW_SQL, "true");
                settings.put(Environment.FORMAT_SQL,true);
                settings.put(Environment.USE_SQL_COMMENTS,true);
                settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
                settings.put(Environment.HBM2DDL_AUTO, "validate");
                // settings.put(Environment.HBM2DDL_AUTO, "create");
                configuration.setProperties(settings);
                configuration.addAnnotatedClass(User.class);
                ServiceRegistry serviceregistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
                usersessionfact = configuration.buildSessionFactory(serviceregistry);
            }catch(Exception e) {
                e.printStackTrace();
            }
        }
        return usersessionfact;
    }
    public static SessionFactory getLibrarysessionfactory() {
        if(librarysessionfact == null) {
            try {
                Configuration configuration= new Configuration();
                Properties settings = new Properties();
                settings.put(Environment.DRIVER, sqlDriver);//?autoReconnect=true
                settings.put(Environment.URL, url);
                settings.put(Environment.USER, dbusername);
                settings.put(Environment.PASS, dbPassword);
                settings.put(Environment.DIALECT,dielect);
                settings.put(Environment.SHOW_SQL, "true");
                settings.put(Environment.FORMAT_SQL,true);
                settings.put(Environment.USE_SQL_COMMENTS,true);
                settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
                settings.put(Environment.HBM2DDL_AUTO, "validate");
                // settings.put(Environment.HBM2DDL_AUTO, "create");
                configuration.setProperties(settings);
                configuration.addAnnotatedClass(PDF.class);
                ServiceRegistry serviceregistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
                librarysessionfact = configuration.buildSessionFactory(serviceregistry);
            }catch(Exception e) {
                e.printStackTrace();
            }
        }
        return librarysessionfact;
    }
    public static SessionFactory getPostsessionfactory() {
        if(authsessionfact == null) {
            try {
                Configuration configuration= new Configuration();
                Properties settings = new Properties();
                settings.put(Environment.DRIVER, sqlDriver);//?autoReconnect=true
                settings.put(Environment.URL, url);
                settings.put(Environment.USER, dbusername);
                settings.put(Environment.PASS, dbPassword);
                settings.put(Environment.DIALECT,dielect);
                settings.put(Environment.SHOW_SQL, "true");
                settings.put(Environment.FORMAT_SQL,true);
                settings.put(Environment.USE_SQL_COMMENTS,true);
                settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
                settings.put(Environment.HBM2DDL_AUTO, "validate");
                //settings.put(Environment.HBM2DDL_AUTO, "create");
                configuration.setProperties(settings);
                configuration.addAnnotatedClass(User.class);
                ServiceRegistry serviceregistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
                authsessionfact = configuration.buildSessionFactory(serviceregistry);
            }catch(Exception e) {
                e.printStackTrace();
            }
        }
        return authsessionfact;
    }
}
