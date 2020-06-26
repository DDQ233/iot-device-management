package app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * @Description TO-DO
 * @Author DDQ
 * @Date 2020/6/26 17:28
 */
@Controller
public class PageJumpController {
    @RequestMapping("/IotDeviceAdmin.")
    public String toIotDeviceAdminPage(HttpSession httpSession) {
        System.out.println("> To iot device administration page.");

        return "iotDeviceAdmin";
    }

    @RequestMapping("/IotDevice")
    public String toIotDevicePage() {
        return "iotDevice";
    }
}
