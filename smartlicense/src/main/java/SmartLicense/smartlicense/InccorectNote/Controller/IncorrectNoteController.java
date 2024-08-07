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

}
