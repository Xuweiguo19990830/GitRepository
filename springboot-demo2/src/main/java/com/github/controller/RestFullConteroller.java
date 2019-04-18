package com.github.controller;


import com.github.pojo.ItripUser;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestFullConteroller {

    @RequestMapping(value = "/getuser/{id}/{userName}/{userCode}",method = RequestMethod.GET)
    public ItripUser getItripUser(@PathVariable Integer id,
                                  @PathVariable String userName,
                                  @PathVariable String userCode){
        ItripUser itripUser = null;
        if (id != null && userName != null && userCode != null){
             itripUser = new ItripUser();
            itripUser.setUserCode(userCode);
            itripUser.setId(Long.valueOf(id));
            itripUser.setUserName(userName);
            itripUser.setUserType(1);
            itripUser.setUserPassword("123232112321");
        }
        return itripUser;
    }
}
