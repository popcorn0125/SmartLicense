package SmartLicense.smartlicense.InccorectNote.Service;

import SmartLicense.smartlicense.InccorectNote.Dao.IncorrectNoteDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*******************
 * 날짜 : 2024.08.06
 * 이름 : 김준식
 * 내용 : 오답노트 Service
 * *****************/
@Service
public class IncorrectNoteSerive {

    @Autowired
    IncorrectNoteDao incorrectNoteDao;

    /*******************
     * 날짜 : 2024.08.06
     * 이름 : 김준식
     * 내용 : 문제풀이에서 사용자가 응시한 문제 로드
     *          exam_record : 총 문제 수, 남은 시간
     *          question :  과목명, 회차별(ex 2022년 3월 5일), 세부자격명(ex 정보처리기사),
     *                 문제, 보기1, 보기2, 보기3, 보기4,
     *                 문제 정답, 문제가 이미지였을 때의 경로
     *                 사용자가 선택한 답, 정답여부
     * *****************/
    public HashMap<String, Object> incorrectNoteLoad(HashMap<String, Object> params) {
        HashMap<String, Object> result = new HashMap<>();
        result.put("exam_record", incorrectNoteDao.getExamRecord(params));
        result.put("question", incorrectNoteDao.incorrectNoteLoad(params));
        return result;
    }
}
