package SmartLicense.smartlicense.SolveProblem.Controller;

import SmartLicense.smartlicense.SolveProblem.Service.ModeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*******************
 * 날짜 : 2024.07.23
 * 이름 : 김준식
 * 내용 : 모드 컨트롤러
 * *****************/
@RestController
@RequestMapping("/mode")
public class ModeController {

    @Autowired
    ModeService modeService;

    /*******************
     * 날짜 : 2024.07.10
     * 이름 : 김준식
     * 내용 : 시험모드 문제 데이터 반환
     * *****************/
    @PostMapping("/testModeLoadExam")
    public ResponseEntity<List<Map<String, Object>>> testModeLoadExam(@RequestBody HashMap<String, Object> params) {
        System.out.println("testModeLoadExam 실행");
        return ResponseEntity.ok(modeService.testModeLoadExam(params));
    }
}
