package app.controller;

import app.entity.User;
import app.service.before.DataService;
import app.service.before.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @Description TO-DO
 * @Author DDQ
 * @Date 2020/6/29 23:03
 */
@Controller
@RequestMapping("/api")
public class ApiController {
    @Resource(name = "dataService")
    private DataService dataService;
    @Resource(name = "userService")
    private UserService userService;

    @RequestMapping("/test")
    @ResponseBody
    private User getData(){
        return userService.findUserById("user1");
    }

    @RequestMapping("/data/new")
    @ResponseBody
    private String getNewData(){
        System.out.println("> Data : " + dataService.findNewData("user1", "00000001"));
        return dataService.findNewData("user1", "00000001").getData();
    }
}
