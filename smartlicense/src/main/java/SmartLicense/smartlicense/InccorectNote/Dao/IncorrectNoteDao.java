package SmartLicense.smartlicense.InccorectNote.Dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*******************
 * 날짜 : 2024.08.06
 * 이름 : 김준식
 * 내용 : 오답노트 DAO
 * *****************/
@Mapper
public interface IncorrectNoteDao {

    /*******************
     * 날짜 : 2024.08.06
     * 이름 : 김준식
     * 내용 :  과목명, 회차별(ex 2022년 3월 5일), 세부자격명(ex 정보처리기사),
     *           문제, 보기1, 보기2, 보기3, 보기4,
     *           문제 정답, 문제가 이미지였을 때의 경로
     *           사용자가 선택한 답, 정답여부 가져오기
     * *****************/
    List<HashMap<String, Object>> incorrectNoteLoad(HashMap<String, Object> params);

    /*******************
     * 날짜 : 2024.08.06
     * 이름 : 김준식
     * 내용 : 총 문제 수, 남은 시간 가져오기
     * *****************/
    HashMap<String, Object> getExamRecord(HashMap<String, Object> params);

    @Select("SELECT * FROM exam_record WHERE member_id = #{memberId} ORDER BY start_test_date DESC LIMIT #{offset}, #{limit}")
    List<Map<String, Object>> fetchExamRecords(@Param("memberId") String memberId, @Param("offset") int offset, @Param("limit") int limit);

    @Select("SELECT COUNT(*) FROM exam_record WHERE member_id = #{memberId}")
    int countTotalRecords(@Param("memberId") String memberId);
}
