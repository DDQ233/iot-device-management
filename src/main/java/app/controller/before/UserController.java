package app.controller.before;

import app.entity.User;
import app.service.before.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * @Description TO-DO
 * @Author DDQ
 * @Date 2020/6/25 21:05
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Resource(name = "userService")
    private UserService userService;

    @RequestMapping("/toLogin")
    public String toUserLoginPage(
            @ModelAttribute("user") User user,
            Model model,
            HttpSession httpSession) {
        System.out.println("> To user login page.");
        Object id = httpSession.getAttribute("USER_ID");
        if (id != null) {
            if (userService.findUserById(id.toString()) != null) {
                return "redirect:/custom/list";
            }
        }
        model.addAttribute(user);
        return "before/userLogin";
    }

    @RequestMapping("/login")
    public String userLogin(
            @ModelAttribute("user") User user,
            Model model,
            HttpSession httpSession) {
        System.out.println("> User login");
        System.out.println("> User id : " + user.getUser_id());
        System.out.println("> User pwd : " + user.getUser_pwd());
        if (userService.checkLogin(user) != null) {
            httpSession.setAttribute("USER_ID", user.getUser_id());
            return "redirect:/custom/list";
        } else {
            model.addAttribute("errorMsg", "用户名或密码错误");
            return "before/userLogin";
        }
    }

    @RequestMapping("/logout")
    public String logout(HttpSession httpSession) {
        System.out.println("> User logout.");
        httpSession.invalidate();
        return "redirect:/user/toLogin";
    }

    @RequestMapping("/toRegister")
    public String toUserRegisterPage() {
        System.out.println("> To user register page.");
        return "before/userRegister";
    }

    @RequestMapping("/register")
    public String register(@ModelAttribute("user") User user, Model model) {
        System.out.println("> Admin register.");
        if (userService.findUserById(user.getUser_id()) != null) {
            model.addAttribute("errorMsg", "该账号已经存在");
            return "before/userRegister";
        }
        userService.register(user);
        return "redirect:/user/toLogin";
    }

    @RequestMapping("/delete/user")
    public String cancelUserAccount(HttpSession httpSession) {
        System.out.println("> Close user account.");
        String userId = httpSession.getAttribute("USER_ID").toString();
        userService.cancelAccount(userId);
        httpSession.invalidate();
        return "redirect:/user/toLogin";
    }

    @RequestMapping("/userInfo")
    public String toAdminInfoPage(Model model, HttpSession httpSession) {
        System.out.println("> To user information page.");
        String userId = httpSession.getAttribute("USER_ID").toString();
        httpSession.setAttribute("USER_INFO", userService.findUserById(userId));
        User user = userService.findUserById(userId);
        System.out.println(user.toString());
        model.addAttribute(user);
        return "before/userInfo";
    }

    @RequestMapping("/update")
    public String updateUserInfo(@ModelAttribute("user") User user, Model model, HttpSession httpSession) {
        System.out.println("> Update user.");
        String userId = httpSession.getAttribute("USER_ID").toString();
        user.setUser_id(userId);
        System.out.println(user.toString());
        if(userService.updateUser(user) > 0){
            model.addAttribute("msg", "保存成功");
        } else {
            model.addAttribute("msg", "保存失败");
        }
        httpSession.removeAttribute("USER_INFO");
        return "before/userInfo";
    }

    @RequestMapping("/passwordModify")
    public String toUpdateUserPasswordPage(HttpSession httpSession) {
        System.out.println("> To update user password page.");
        return "before/updateUserPassword";
    }

    @RequestMapping("/update/password")
    public String updatePassword(
            @RequestParam String oldPassword,
            @RequestParam String newPassword,
            Model model,
            HttpSession httpSession) {
        System.out.println("> Update user password.");
        User user = new User();
        String userId = httpSession.getAttribute("USER_ID").toString();
        user.setUser_id(userId);
        user.setUser_pwd(oldPassword);
        if (userService.findUser(user) != null) {
            userService.updatePassword(userId, newPassword);
            httpSession.invalidate();
            return "redirect:/user/login";
        } else {
            model.addAttribute("errorMsg", "原密码错误");
            return "before/updateUserPassword";
        }
    }
}
