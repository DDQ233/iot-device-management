package app.controller.before;

import app.entity.UserDevice;
import app.service.before.DataService;
import app.service.before.UserDeviceService;
import app.utils.Utils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Description TO-DO
 * @Author DDQ
 * @Date 2020/6/25 23:15
 */
@Controller
@RequestMapping("/custom")
public class UserDeviceController {
    @Resource(name = "dataService")
    private DataService dataService;
    @Resource(name = "userDeviceService")
    private UserDeviceService userDeviceService;

    @RequestMapping("/list")
    public String toUserCustomPage(Model model, HttpSession httpSession) {
        System.out.println("> To user custom page.");
        String userId = httpSession.getAttribute("USER_ID").toString();
        List<UserDevice> userDeviceList = userDeviceService.findAllUserDevice(userId);
        httpSession.setAttribute("USER_DEVICE_LIST", userDeviceList);
        model.addAttribute("currentTime", Utils.getCurrentTime());
        return "before/userDeviceAdmin";
    }

    @RequestMapping("/home")
    public String toIotDeviceAdminPage(Model model, HttpSession httpSession) {
        System.out.println("> To home page.");
        String userId = httpSession.getAttribute("USER_ID").toString();
        model.addAttribute("currentTime", Utils.getCurrentTime());
        model.addAttribute("deviceNum", userDeviceService.countDevice(userId));
        model.addAttribute("dataNum", dataService.count(userId));
        model.addAttribute("deviceOnlineNum", userDeviceService.countOnlineDevice(userId));
        return "before/home";
    }

    @RequestMapping("/addDevice")
    public String toAddDevicePage() {
        System.out.println("> To add user device page.");
        return "before/addUserDevice";
    }

    @RequestMapping("/add")
    public String addUserDevice(@ModelAttribute("userDevice") UserDevice userDevice) {
        System.out.println("> Add user device.");
        userDeviceService.addUserDevice(userDevice);
        return "forward:/custom/list";
    }

    @RequestMapping("/delete/{userDeviceAuth}")
    public String deleteUserDeviceById(@PathVariable String userDeviceAuth, HttpSession httpSession) {
        System.out.println("> Delete user device.");
        userDeviceService.deleteUserDeviceByAuth(userDeviceAuth);
        return "forward:/custom/list";
    }

    @RequestMapping("/userDeviceInfo/{deviceAuth}")
    public String toUserDeviceInfoPage(@PathVariable String deviceAuth, Model model) {
        System.out.println("> To user device information page.");
        UserDevice userDevice = userDeviceService.findUserDeviceByAuth(deviceAuth);
        model.addAttribute(userDevice);
        return "before/userDeviceInfo";
    }

    @RequestMapping("/searchUserDevice")
    public String toSearchUserDevicePage(HttpSession httpSession) {
        System.out.println("> To search user device page.");
        httpSession.removeAttribute("SEARCH_USER_DEVICE_LIST");
        return "before/searchUserDevice";
    }

    @RequestMapping("/search")
    public String searchUserDevice(
            @RequestParam String deviceId,
            @RequestParam String deviceStatus,
            @RequestParam String deviceAuth,
            @RequestParam String addr,
            HttpSession httpSession
    ) {
        System.out.println("> Search user device.");
        String userId = httpSession.getAttribute("USER_ID").toString();
        UserDevice userDevice = new UserDevice();
        userDevice.setUser_id(userId);
        userDevice.setDevice_id(deviceId);
        userDevice.setDevice_status(deviceStatus);
        userDevice.setDevice_auth(deviceAuth);
        userDevice.setDevice_addr(addr);
        List<UserDevice> userDeviceList = userDeviceService.findUserDevice(userDevice);
        httpSession.removeAttribute("SEARCH_USER_DEVICE_LIST");
        httpSession.setAttribute("SEARCH_USER_DEVICE_LIST", userDeviceList);
        return "before/searchUserDevice";
    }
}
