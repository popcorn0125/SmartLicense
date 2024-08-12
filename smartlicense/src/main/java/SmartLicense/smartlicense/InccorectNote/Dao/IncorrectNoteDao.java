package SmartLicense.smartlicense.InccorectNote.Dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.security.core.parameters.P;

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

    @Select("SELECT * FROM exam_record WHERE member_id = #{memberId} AND is_active = 1 ORDER BY exam_record_idx DESC LIMIT #{offset}, #{limit}")
    List<Map<String, Object>> fetchExamRecords(@Param("memberId") String memberId, @Param("offset") int offset, @Param("limit") int limit);

    @Select("SELECT COUNT(*) FROM exam_record WHERE member_id = #{memberId} AND is_active = 1")
    int countTotalRecords(@Param("memberId") String memberId);

    @Update("update exam_record set is_active = 0 where member_id =#{memberId} and exam_record_idx = #{idx}")
    int updateExamRecord(@Param("memberId") String memberId, @Param("idx") int idx);

    @Select("SELECT * FROM exam_record WHERE member_id = #{memberId} AND (detail_license_name LIKE (CONCAT('%', #{searchQuery}, '%')) OR (exam_date LIKE CONCAT('%', #{searchQuery}, '%'))) AND is_active = 1 ORDER BY exam_record_idx DESC LIMIT #{offset}, #{limit}")
    List<Map<String, Object>> searchExamRecords(@Param("memberId") String memberId, @Param("searchQuery") String searchQuery, @Param("offset") int offset, @Param("limit") int limit);

    @Select("SELECT COUNT(*) FROM exam_record WHERE member_id = #{memberId} AND detail_license_name LIKE (CONCAT('%', #{searchQuery}, '%')) OR (exam_date LIKE CONCAT('%', #{searchQuery}, '%')) AND is_active = 1")
    int countTotalRecord(@Param("memberId") String memberId, @Param("searchQuery") String searchQuery);
}
