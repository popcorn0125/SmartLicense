package SmartLicense.smartlicense.SolveProblem.Controller;

import SmartLicense.smartlicense.SolveProblem.Service.CategoryChoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/solveProblem")
public class CategoryChoiceController {
    @Autowired
    CategoryChoiceService categoryChoiceService;

    @PostMapping("/loadLicense")
    public List<HashMap<String, Object>> loadLicense(){
        System.out.println("잘 됐나요?");
        return categoryChoiceService.loadLicense();
    }

    @PostMapping("/loadDetailLicense")
    public List<HashMap<String, Object>> loadDetailLicense(@RequestBody HashMap<String, Object> params){
        String licenseName = params.get("license").toString();
        return categoryChoiceService.loadDetailLicense(licenseName);
    }
}
