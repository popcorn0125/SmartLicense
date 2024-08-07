package SmartLicense.smartlicense.InccorectNote.Controller;

import SmartLicense.smartlicense.InccorectNote.Service.IncorrectNoteSerive;
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
 * 날짜 : 2024.08.06
 * 이름 : 김준식
 * 내용 : 오답노트 Controller
 * *****************/
@RestController
@RequestMapping("/incorrectNote")
public class IncorrectNoteController {

    @Autowired
    IncorrectNoteSerive incorrectNoteSerive;

    /*******************
     * 날짜 : 2024.08.06
     * 이름 : 김준식
     * 내용 : 문제풀이에서 사용자가 응시한 문제 로드
     * *****************/
    @PostMapping("/incorrectNoteLoad")
    public ResponseEntity<HashMap<String, Object>> incorrectNoteLoad(@RequestBody HashMap<String, Object> params) {
        System.out.println("incorrectNoteLoad 실행");
        return ResponseEntity.ok(incorrectNoteSerive.incorrectNoteLoad(params));
    }

    @PostMapping("/loadExamRecord")
    public Map<String, Object> loadExamRecord(@RequestBody Map<String, Object> request) {
        String memberId = (String) request.get("memberId");
        int page = (int) request.get("page");
        int itemsPerPage = (int) request.get("itemsPerPage");

        return incorrectNoteSerive.getExamRecords(memberId, page, itemsPerPage);
    }

    @PostMapping("/deleteExamRecord")
    public void deleteExamRecord(@RequestBody Map<String, Object> params){
        String memberId = (String) params.get("memberId");
        int idx = (int) params.get("examRecordIdx");

        incorrectNoteSerive.passiveExamRecord(memberId, idx);
    }

    @PostMapping("/searchRecord")
    public Map<String, Object> searchRecord(@RequestBody Map<String, Object> params){
        String memberId = (String) params.get("memberId");
        String searchQuery = (String) params.get("searchQuery");
        int page = (int) params.get("page");
        int itemsPerPage = (int) params.get("itemsPerPage");

        return incorrectNoteSerive.searchExamRecords(memberId, searchQuery, page, itemsPerPage);
    }
}
