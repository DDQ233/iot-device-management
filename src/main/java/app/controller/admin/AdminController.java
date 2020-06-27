package app.controller.admin;

import app.entity.Admin;
import app.service.admin.AdminService;
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
@RequestMapping("/admin")
public class AdminController {
    @Resource(name = "adminService")
    private AdminService adminService;

    @RequestMapping("/toLogin")
    public String toAdminLoginPage(
            @ModelAttribute("admin") Admin admin,
            Model model,
            HttpSession httpSession) {
        System.out.println("> To admin login page.");
        Object id = httpSession.getAttribute("ADMIN_ID");
        if (id != null) {
            if (adminService.findAdminById(id.toString()) != null) {
                return "redirect:/iotDeviceAdmin";
            }
        }
        model.addAttribute(admin);
        return "admin/adminLogin";
    }

    // 这里AdminController涉及到不同权限的不同操作，需要改进
    @RequestMapping("/login")
    public String adminLogin(
            @ModelAttribute("admin") Admin admin,
            Model model,
            HttpSession httpSession) {
        System.out.println("> Admin login.");
        System.out.println("> Admin id : " + admin.getAdmin_id());
        System.out.println("> Admin pwd : " + admin.getAdmin_pwd());
        if (adminService.checkLogin(admin) != null) {
            httpSession.setAttribute("ADMIN_ID", admin.getAdmin_id());
            httpSession.setAttribute("ADMIN_ROLE_ID", adminService.findAdminById(admin.getAdmin_id()).getAdmin_role_id());
            return "redirect:/iotDeviceAdmin";
        } else {
            model.addAttribute("errorMsg", "用户名或密码错误");
            return "admin/adminLogin";
        }
    }

    @RequestMapping("/logout")
    public String logout(HttpSession httpSession) {
        System.out.println("> Admin logout.");
        httpSession.invalidate();
        return "redirect:/admin/toLogin";
    }

    @RequestMapping("/toRegister")
    public String toAdminRegisterPage() {
        System.out.println("> To admin register page.");
        return "admin/adminRegister";
    }

    @RequestMapping("/register")
    public String register(@ModelAttribute("admin") Admin admin, Model model) {
        System.out.println("> Admin register.");
        if (adminService.findAdminById(admin.getAdmin_id()) != null) {
            model.addAttribute("errorMsg", "该账号已经存在");
            return "admin/adminRegister";
        }
        adminService.register(admin);
        return "redirect:/admin/toLogin";
    }

    @RequestMapping("/deviceAdmin")
    public String toDeviceAdminPage() {
        System.out.println("> To device admin page.");
        return "admin/deviceAdmin";
    }

    @RequestMapping("/adminInfo")
    public String toAdminInfoPage(HttpSession httpSession) {
        System.out.println("> To admin information page.");
        String adminId = httpSession.getAttribute("ADMIN_ID").toString();
        httpSession.setAttribute("ADMIN_INFO", adminService.findAdminById(adminId));
        return "admin/adminInfo";
    }

    @RequestMapping("/update/admin")
    public String updateAdminInfo(@ModelAttribute("admin") Admin admin, HttpSession httpSession) {
        System.out.println("> Admin update.");
        adminService.updateAdmin(admin);
        httpSession.removeAttribute("ADMIN_INFO");
        return "forward:/admin/adminInfo";
    }

    @RequestMapping("/passwordModify")
    public String toUpdateUserPasswordPage(HttpSession httpSession) {
        System.out.println("> To update admin password page.");
        return "admin/updateAdminPassword";
    }

    @RequestMapping("/update/password")
    public String updatePassword(
            @RequestParam String oldPassword,
            @RequestParam String newPassword,
            Model model,
            HttpSession httpSession) {
        System.out.println("> Update admin password.");
        Admin admin = new Admin();
        String adminId = httpSession.getAttribute("ADMIN_ID").toString();
        admin.setAdmin_id(adminId);
        admin.setAdmin_pwd(oldPassword);
        if (adminService.findAdmin(admin) != null) {
            adminService.updatePassword(adminId, newPassword);
            httpSession.invalidate();
            return "redirect:/admin/toLogin";
        } else {
            model.addAttribute("errorMsg", "原密码错误");
            return "admin/updateAdminPassword";
        }
    }
}
