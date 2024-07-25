package SmartLicense.smartlicense.SolveProblem.Controller;

import SmartLicense.smartlicense.SolveProblem.Service.ModeService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.parsing.Problem;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/mode")
public class ModeController {

    @Autowired
    ModeService modeService;

    @PostMapping("/testModeLoadExam")
    public ResponseEntity<List<Map<String, Object>>> testModeLoadExam(@RequestBody HashMap<String, Object> params) throws JsonProcessingException {
        System.out.println("testModeLoadExam 실행");
        return ResponseEntity.ok(modeService.testModeLoadExam(params));
    }

    @PostMapping("/userSelectAnswer")
    public ResponseEntity<HashMap<String, Object>> usreSelectAnswer(@RequestBody HashMap<String, Object> params) {
        System.out.println("userChoiceAnswer 실행");
        return ResponseEntity.ok(modeService.userSelectAnswer(params));
    }

    // 연습 모드 문제 로드
    @PostMapping("/practiceModeLoadExam")
    public ResponseEntity<List<Map<String, Object>>> practiceModeLoadExam(@RequestBody Map<String, Object> params) {
        System.out.println("practiceModeLoadExam 실행");
        System.out.println("params : " + params);
        return ResponseEntity.ok(modeService.practiceModeLoadExam(params));
    }
}
