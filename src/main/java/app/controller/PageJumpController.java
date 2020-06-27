package app.controller;

import app.entity.User;
import app.service.before.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * @Description TO-DO
 * @Author DDQ
 * @Date 2020/6/26 17:28
 */
@Controller
public class PageJumpController {
    @Resource(name = "userService")
    private UserService userService;

    @RequestMapping("/")
    public String toUserLoginPage(
            @ModelAttribute("user") User user,
            Model model,
            HttpSession httpSession) {
        System.out.println("> To root page.");
        Object id = httpSession.getAttribute("USER_ID");
        if (id != null) {
            if (userService.findUserById(id.toString()) != null) {
                return "redirect:/custom/list";
            }
        }
        model.addAttribute(user);
        return "redirect:/user/toLogin";
    }

    @RequestMapping("/404")
    public String toErrorPage(){
        System.out.println("> To error page.");
        return "common/error";
    }

    @RequestMapping("/IotDevice")
    public String toIotDevicePage() {
        return "iotDevice";
    }
}
