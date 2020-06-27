package app.controller.before;

import app.dao.before.UserDeviceDao;
import app.entity.UserDevice;
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
    @Resource(name = "userDeviceDao")
    private UserDeviceDao userDeviceDao;

    @RequestMapping("/list")
    public String toUserCustomPage(HttpSession httpSession) {
        System.out.println("> To user custom page.");
        String userId = httpSession.getAttribute("USER_ID").toString();
        List<UserDevice> userDeviceList = userDeviceDao.findAllUserDevice(userId);
        httpSession.setAttribute("USER_DEVICE_LIST", userDeviceList);
        return "userDeviceAdmin";
    }

    @RequestMapping("/addDevice")
    public String toAddDevicePage() {
        System.out.println("> To add user device page.");
        return "addUserDevice";
    }

    @RequestMapping("/add")
    public String addUserDevice(@ModelAttribute("userDevice") UserDevice userDevice) {
        System.out.println("> Add user device.");
        userDeviceDao.addUserDevice(userDevice);
        return "forward:/custom/list";
    }

    @RequestMapping("/delete/{userDeviceAuth}")
    public String deleteUserDeviceById(@PathVariable String userDeviceAuth, HttpSession httpSession) {
        System.out.println("> Delete user device.");
        userDeviceDao.deleteUserDeviceByAuth(userDeviceAuth);
        return "forward:/custom/list";
    }

    @RequestMapping("/userDeviceInfo/{deviceAuth}")
    public String toUserDeviceInfoPage(@PathVariable String deviceAuth, Model model) {
        System.out.println("> To user device information page.");
        UserDevice userDevice = userDeviceDao.findUserDeviceByAuth(deviceAuth);
        model.addAttribute(userDevice);
        return "userDeviceInfo";
    }

    @RequestMapping("/searchUserDevice")
    public String toSearchUserDevicePage(HttpSession httpSession) {
        System.out.println("> To search user device page.");
        httpSession.removeAttribute("SEARCH_USER_DEVICE_LIST");
        return "searchUserDevice";
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
        List<UserDevice> userDeviceList = userDeviceDao.findUserDevice(userDevice);
        httpSession.removeAttribute("SEARCH_USER_DEVICE_LIST");
        httpSession.setAttribute("SEARCH_USER_DEVICE_LIST", userDeviceList);
        return "searchUserDevice";
    }
}
