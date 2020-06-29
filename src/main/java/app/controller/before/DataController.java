package app.controller.before;

import app.entity.UserDevice;
import app.service.before.DataService;
import app.service.before.UserDeviceService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Description TO-DO
 * @Author DDQ
 * @Date 2020/6/25 23:15
 */
@Controller
@RequestMapping("/data")
public class DataController {
    @Resource(name = "dataService")
    private DataService dataService;
    @Resource(name = "userDeviceService")
    private UserDeviceService userDeviceService;

    @RequestMapping("/display")
    public String toDataDisplayPage(Model model, HttpSession httpSession) {
        System.out.println("> To data display page.");
        String userId = httpSession.getAttribute("USER_ID").toString();
        List<UserDevice> userDeviceList = userDeviceService.findAllUserDevice(userId);
        model.addAttribute("userDeviceList", userDeviceList);
        return "before/dataDisplay";
    }
}
