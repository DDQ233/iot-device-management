package app.controller.admin;

import app.entity.Admin;
import app.entity.Device;
import app.service.admin.AdminService;
import app.service.admin.DeviceService;
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
 * @Date 2020/6/25 23:14
 */
@Controller
@RequestMapping("/device")
public class DeviceController {
    @Resource(name = "deviceService")
    private DeviceService deviceService;

    @Resource(name = "adminService")
    private AdminService adminService;

    // @RequestMapping("/deviceAdmin")
    // public String toDeviceAdminPage(HttpSession httpSession){
    //     System.out.println("> To device admin page.");
    //     String id = httpSession.getAttribute("ADMIN_ID").toString();
    //     if (id != null && adminService.findAdminById(id) != null) {
    //         return "redirect:/iot-admin";
    //     }else {
    //         return "adminLogin";
    //     }
    // }

    @RequestMapping("/list")
    public String toDeviceAdminPage(HttpSession httpSession) {
        System.out.println("> To device administration page.");
        List<Device> deviceList = deviceService.findAllDevice();
        httpSession.setAttribute("DEVICE_LIST", deviceList);
        return "deviceAdminList";
    }

    @RequestMapping("/addDevice")
    public String toAddDevicePage() {
        System.out.println("> To add device page.");
        return "addDevice";
    }

    @RequestMapping("/add")
    public String addDevice(@ModelAttribute("device") Device device) {
        System.out.println("> Add device.");
        deviceService.addDevice(device);
        return "redirect:/device/addDevice";
    }

    @RequestMapping("/delete/{deviceId}")
    public String deleteDeviceById(@PathVariable String deviceId) {
        System.out.println("> Delete device.");
        deviceService.deleteDeviceById(deviceId);
        return "forward:/device/list";
    }

    @RequestMapping("/deviceInfo/{deviceId}")
    public String toUpdateDevicePage(@PathVariable String deviceId, Model model) {
        System.out.println("> To device information page.");
        Device device = deviceService.findDeviceById(deviceId);
        model.addAttribute(device);
        return "deviceInfo";
    }

    @RequestMapping("/update")
    public String updateDevice(@ModelAttribute("device") Device device, HttpSession httpSession) {
        System.out.println("> Update device.");
        deviceService.updateDevice(device);
        httpSession.removeAttribute("DEVICE_LIST");
        return "forward:/device/list";
    }

    @RequestMapping("/searchDevice")
    public String toSearchDevicePage(HttpSession httpSession) {
        System.out.println("> To search device page.");
        httpSession.removeAttribute("SEARCH_DEVICE_LIST");
        return "searchDevice";
    }

    @RequestMapping("/search")
    public String searchDevice(
            @RequestParam String deviceId,
            @RequestParam String name,
            @RequestParam String protocolId,
            @RequestParam String priClassifyId,
            @RequestParam String usage,
            HttpSession httpSession
    ) {
        System.out.println("> Search device.");
        Device device = new Device();
        device.setDevice_id(deviceId);
        device.setDevice_name(name);
        device.setDevice_protocol_id(protocolId);
        device.setDevice_pri_classify_id(priClassifyId);
        device.setDevice_usage(usage);
        List<Device> deviceList = deviceService.findDevice(device);
        httpSession.removeAttribute("SEARCH_DEVICE_LIST");
        httpSession.setAttribute("SEARCH_DEVICE_LIST", deviceList);
        return "searchDevice";
    }
}
