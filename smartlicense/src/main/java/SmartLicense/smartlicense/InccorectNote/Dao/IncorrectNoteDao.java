package SmartLicense.smartlicense.InccorectNote.Dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Mapper
public interface IncorrectNoteDao {

    List<HashMap<String, Object>> incorrectNoteLoad(HashMap<String, Object> params);

    HashMap<String, Object> getExamRecord(HashMap<String, Object> params);

    @Select("SELECT * FROM exam_record WHERE member_id = #{memberId} ORDER BY start_test_date DESC LIMIT #{offset}, #{limit}")
    List<Map<String, Object>> fetchExamRecords(@Param("memberId") String memberId, @Param("offset") int offset, @Param("limit") int limit);

    @Select("SELECT COUNT(*) FROM exam_record WHERE member_id = #{memberId}")
    int countTotalRecords(@Param("memberId") String memberId);
}
