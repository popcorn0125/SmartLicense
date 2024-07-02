package SmartLicense.smartlicense.Controller;


import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/api")
public class testController {
    @GetMapping("/test")
    public void test() {
        System.out.println("heeeeeeeellooooworldlesdklfj1!");
    }

    @PostMapping("/test2")
    public void test2(@RequestBody HashMap<String, Object> params) {
        System.out.println("body : " + params.get("data"));
    }
}
