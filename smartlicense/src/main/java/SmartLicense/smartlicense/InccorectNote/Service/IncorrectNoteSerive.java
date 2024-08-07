package SmartLicense.smartlicense.InccorectNote.Service;

import SmartLicense.smartlicense.InccorectNote.Dao.IncorrectNoteDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        HashMap<String, Object> param = incorrectNoteDao.getExamRecord(params);
        result.put("exam_record", param);
        result.put("question", incorrectNoteDao.incorrectNoteLoad(param));
        return result;
    }

    public Map<String, Object> getExamRecords(String memberId, int page, int itemsPerPage) {
        int offset = (page - 1) * itemsPerPage;
        List<Map<String, Object>> records = incorrectNoteDao.fetchExamRecords(memberId, offset, itemsPerPage);
        int total = incorrectNoteDao.countTotalRecords(memberId);

        Map<String, Object> response = new HashMap<>();
        response.put("records", records);
        response.put("total", total);

        return response;
    }
}
