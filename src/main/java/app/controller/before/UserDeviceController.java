package app.controller.before;

import app.entity.Device;
import app.entity.UserDevice;
import app.service.admin.DeviceService;
import app.service.before.DataService;
import app.service.before.UserDeviceService;
import app.utils.Utils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    @Resource(name = "deviceService")
    private DeviceService deviceService;

    @RequestMapping("/list")
    public String toUserCustomPage(Model model, HttpSession httpSession) {
        System.out.println("> To user custom page.");
        model.addAttribute("USER_NAME", httpSession.getAttribute("USER_ID"));
        return "before/userDeviceAdmin";
    }

    @RequestMapping("/userDeviceList")
    public String toUserDeviceListPage(Model model, HttpSession httpSession) {
        System.out.println("> To user device list page.");
        String userId = httpSession.getAttribute("USER_ID").toString();
        List<UserDevice> userDeviceList = userDeviceService.findAllUserDevice(userId);
        model.addAttribute("userDeviceList", userDeviceList);
        return "before/userDeviceList";
    }

    @RequestMapping("/home")
    public String toHomePage(Model model, HttpSession httpSession) {
        System.out.println("> To home page.");
        String userId = httpSession.getAttribute("USER_ID").toString();
        model.addAttribute("currentTime", Utils.getCurrentTime());
        model.addAttribute("deviceNum", userDeviceService.countDevice(userId));
        model.addAttribute("dataNum", dataService.count(userId));
        model.addAttribute("deviceOnlineNum", userDeviceService.countOnlineDevice(userId));
        return "before/home";
    }

    @RequestMapping("/addDevice")
    public String toAddDevicePage(@ModelAttribute("userDevice") UserDevice userDevice, HttpSession httpSession, Model model) {
        System.out.println("> To add user device page.");
        // String userId = httpSession.getAttribute("USER_ID").toString();
        // userDevice.setUser_id(userId);
        List<Device> deviceList = deviceService.findAllDevice();
        for (Device device : deviceList) {
            System.out.println(device.toString());
        }
        model.addAttribute("userDevice", userDevice);
        model.addAttribute("deviceList", deviceList);
        return "before/addUserDevice";
    }

    @RequestMapping("/add")
    public String addUserDevice(@ModelAttribute("userDevice") UserDevice userDevice, Model model, HttpSession httpSession) {
        System.out.println("> Add user device.");
        String userId = httpSession.getAttribute("USER_ID").toString();
        String deviceAuth = userDevice.getDevice_auth();
        userDevice.setUser_id(userId);
        userDevice.setDevice_status("OFF");
        if (userDeviceService.findUserDeviceByAuth(userId, deviceAuth) == null) {
            if (userDeviceService.addUserDevice(userDevice) > 0) {
                model.addAttribute("msg", "添加成功");
            } else {
                model.addAttribute("msg", "添加失败");
            }
        } else {
            model.addAttribute("msg", "已有相同的设备认证码");
        }
        return "before/addUserDevice";
    }

    @RequestMapping("/delete")
    public String deleteUserDeviceById(String deviceAuth, HttpSession httpSession) {
        System.out.println("> Delete user device.");
        userDeviceService.deleteUserDeviceByAuth(deviceAuth);
        return "forward:/custom/userDeviceList";
    }

    @RequestMapping("/userDeviceInfo")
    public String toUserDeviceInfoPage(String deviceAuth, Model model, HttpSession httpSession) {
        System.out.println("> To user device information page.");
        System.out.println("> Device auth : " + deviceAuth);
        String userId = httpSession.getAttribute("USER_ID").toString();
        System.out.println("> User id : " + userId);
        UserDevice userDevice = userDeviceService.findUserDeviceByAuth(userId, deviceAuth);
        System.out.println("> Auth : " + userDevice.getDevice_auth());
        // System.out.println("> UserDevice : " + userDevice.toString());
        System.out.println("> UserDevice name : " + userDevice.getDevice().getDevice_name());
        System.out.println("> UserDevice name : " + userDevice.getProtocol().getProtocol_name());
        System.out.println("> UserDevice name : " + userDevice.getPriClassify().getPri_classify_name());
        model.addAttribute(userDevice);
        // return "before/userDeviceInfo";
        return "before/userDeviceInfo";
    }

    @RequestMapping("/update/userDevice")
    public String updateUserDeviceInfo(@ModelAttribute("userDevice") UserDevice userDevice, Model model) {
        System.out.println("> Update user device");
        if (userDeviceService.updateUserDevice(userDevice) > 0) {
            model.addAttribute("msg", "保存成功");
        } else {
            model.addAttribute("msg", "保存失败");
        }
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
