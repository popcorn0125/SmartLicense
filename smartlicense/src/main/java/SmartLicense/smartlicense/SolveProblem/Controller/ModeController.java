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

/*******************
 * 날짜 : 2024.07.26
 * 이름 : 김준식
 * 내용 : Mode Controller
 * *****************/
@RestController
@RequestMapping("/mode")
public class ModeController {

    @Autowired
    ModeService modeService;

    /*******************
     * 날짜 : 2024.07.25
     * 이름 : 김준식
     * 내용 : 사용자가 선택한 과목에 따른 문제 로드
     * *****************/
    @PostMapping("/testModeLoadExam")
    public ResponseEntity<HashMap<String, Object>> testModeLoadExam(@RequestBody HashMap<String, Object> params) throws JsonProcessingException {
        System.out.println("testModeLoadExam 실행");
        return ResponseEntity.ok(modeService.testModeLoadExam(params));
    }

    /*******************
     * 날짜 : 2024.07.25
     * 이름 : 김준식
     * 내용 : 사용자가 선택한 답을 저장
     * *****************/
    @PostMapping("/userSelectAnswer")
    public ResponseEntity<HashMap<String, Object>> usreSelectAnswer(@RequestBody HashMap<String, Object> params) {
        System.out.println("userChoiceAnswer 실행");
        return ResponseEntity.ok(modeService.userSelectAnswer(params));
    }

    /*******************
     * 날짜 : 2024.07.25
     * 이름 : 김준식
     * 내용 : 사용자가 응시 기록을 저장
     * *****************/
    @PostMapping("/storeExamRecord")
    public ResponseEntity<Integer> storeExamRecord(@RequestBody HashMap<String, Object> params) {
        System.out.println("storeExamRecord 실행");
        return ResponseEntity.ok(modeService.storeExamRecord(params));
    }

    /*******************
     * 날짜 : 2024.07.25
     * 이름 : 김준식
     * 내용 : 시험 모드 결과(점수) 반환
     * *****************/
    @PostMapping("/loadTestScore")
    public ResponseEntity<HashMap<String, Object>> loadTestScore(@RequestBody HashMap<String, Object> params) throws JsonProcessingException {
        System.out.println("loadTestScore 실행");
        System.out.println("params : " + params);
        return ResponseEntity.ok(modeService.loadTestScore(params));
    }

    // 연습 모드 문제 로드
    @PostMapping("/practiceModeLoadExam")
    public ResponseEntity<List<Map<String, Object>>> practiceModeLoadExam(@RequestBody Map<String, Object> params) {
        System.out.println("practiceModeLoadExam 실행");
        System.out.println("params : " + params);
        return ResponseEntity.ok(modeService.practiceModeLoadExam(params));
    }
}
