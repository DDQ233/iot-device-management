package app.controller.admin;

import app.entity.Admin;
import app.entity.Password;
import app.service.admin.AdminService;
import app.service.admin.DeviceService;
import app.service.admin.PriClassifyService;
import app.service.admin.ProtocolService;
import app.utils.Utils;
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
    @Resource(name = "deviceService")
    private DeviceService deviceService;
    @Resource(name = "protocolService")
    private ProtocolService protocolService;
    @Resource(name = "priClassifyService")
    private PriClassifyService priClassifyService;

    @RequestMapping("/toLogin")
    public String toAdminLoginPage(
            @ModelAttribute("admin") Admin admin,
            Model model,
            HttpSession httpSession) {
        System.out.println("> To admin login page.");
        Object id = httpSession.getAttribute("ADMIN_ID");
        if (id != null) {
            if (adminService.findAdminById(id.toString()) != null) {
                return "redirect:/admin/list";
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
            return "redirect:/admin/list";
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

    @RequestMapping("/list")
    public String toAdminHomePage(Model model, HttpSession httpSession) {
        System.out.println("> To admin page.");
        model.addAttribute("userName", httpSession.getAttribute("USER_NAME"));
        return "admin/adminMain";
    }

    @RequestMapping("/home")
    public String toHomePage(Model model, HttpSession httpSession) {
        System.out.println("> To admin home page.");
        Object adminId = httpSession.getAttribute("ADMIN_ID");
        if (adminId != null) {
            model.addAttribute("currentTime", Utils.getCurrentTime());
            model.addAttribute("deviceNum", deviceService.count());
            model.addAttribute("protocolNum", protocolService.count());
            model.addAttribute("admin", adminId.toString());
            return "admin/home";
        } else {
            return "redirect:/admin/toLogin";
        }
    }

    @RequestMapping("/deviceAdmin")
    public String toDeviceAdminPage() {
        System.out.println("> To device admin page.");
        return "admin/deviceAdmin";
    }

    @RequestMapping("/adminInfo")
    public String toAdminInfoPage(Model model, HttpSession httpSession) {
        System.out.println("> To admin information page.");
        String adminId = httpSession.getAttribute("ADMIN_ID").toString();
        httpSession.setAttribute("ADMIN_INFO", adminService.findAdminById(adminId));
        Admin admin = adminService.findAdminById(adminId);
        model.addAttribute(admin);
        return "admin/adminInfo";
    }

    @RequestMapping("/update/info")
    public String updateAdminInfo(@ModelAttribute("admin") Admin admin, Model model, HttpSession httpSession) {
        System.out.println("> Admin update.");
        String adminId = httpSession.getAttribute("ADMIN_ID").toString();
        admin.setAdmin_id(adminId);
        if (adminService.updateAdmin(admin) > 0) {
            model.addAttribute("msg", "保存成功");
        } else {
            model.addAttribute("msg", "保存失败");
        }
        httpSession.removeAttribute("USER_INFO");
        return "admin/adminInfo";
    }

    @RequestMapping("/passwordModify")
    public String toUpdateUserPasswordPage(Model model, HttpSession httpSession) {
        System.out.println("> To update admin password page.");
        model.addAttribute("password", new Password());
        return "admin/adminPasswordInfo";
    }

    @RequestMapping("/update/password")
    public String updatePassword(
            @ModelAttribute("password") Password password,
            Model model,
            HttpSession httpSession) {
        System.out.println("> Update user password.");
        String oldPassword = password.getOldPassword();
        String newPassword = password.getNewPassword();
        String repetition = password.getRepetition();
        if (oldPassword != null && newPassword != null && repetition != null) {
            if (oldPassword.equals(newPassword)) {
                model.addAttribute("msg", "新密码与旧密码不能一致");
                return "admin/adminPasswordInfo";
            } else if (!newPassword.equals(repetition)) {
                model.addAttribute("msg", "两次输入的新密码不一致");
                return "admin/adminPasswordInfo";
            }
            Admin admin = new Admin();
            String adminId = httpSession.getAttribute("ADMIN_ID").toString();
            admin.setAdmin_id(adminId);
            admin.setAdmin_pwd(oldPassword);
            if (adminService.findAdmin(admin) != null) {
                adminService.updatePassword(adminId, newPassword);
                httpSession.invalidate();
            } else {
                model.addAttribute("msg", "原密码错误");
                return "admin/adminPasswordInfo";
            }
        } else {
            model.addAttribute("msg", "请输入正确的信息");
            return "admin/adminPasswordInfo";
        }
        model.addAttribute("msg", "修改成功");
        return "admin/adminPasswordInfo";
    }
}
