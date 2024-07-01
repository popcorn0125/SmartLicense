package SmartLicense.smartlicense.Controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class testController {
    @GetMapping("/test")
    public void test() {
        System.out.println("heeeeeeeellooooworldlesdklfj1!");
    }
}
