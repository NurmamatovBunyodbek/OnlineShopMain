package uz.bunyodbek.onlineshopmain.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.bunyodbek.onlineshopmain.model.User;
import uz.bunyodbek.onlineshopmain.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN' ,'USER')")
    public List<User> userList(){
        List<User> list = userService.getALlUsers();
        return list;
    }



}
