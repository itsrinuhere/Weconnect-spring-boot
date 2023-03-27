package com.WeConnect.V2.Weconnectv2.Rest.Auth;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("auth")
public class Controller {
    Service service = new Service();

    @RequestMapping(value="validate",method=RequestMethod.GET)
    ResponseEntity sign_in( @RequestParam("username") String username ,@RequestParam("password") String password ){
        //return id  else no content
        //backend Completed
        //System.out.println("validate envokes"+username+password);
        return service.validate(username,password);
    }
    @RequestMapping(value = "signup",method = RequestMethod.POST)
    ResponseEntity signup(@RequestBody User user){
        //backend completed
        return service.saveNewUser(user);
    }
    @RequestMapping(value="update",method=RequestMethod.PUT)
    ResponseEntity update(@RequestParam String id,@RequestParam String password){
        //id != null then update only password and profile pic
        return service.update(id,password);
    }
}
