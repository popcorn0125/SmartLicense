package SmartLicense.smartlicense.SolveProblem.Dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.parsing.Problem;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Mapper
public interface ModeDao {

    List<Map<String, Object>> testModeLoadExam(HashMap<String, Object> params);

    int getExamDuration(HashMap<String, Object> params);

    int userSelectAnswer(HashMap<String, Object> params);

    int storeExamRecord(HashMap<String, Object> params);

    List<HashMap<String, Object>> getSubjectName(HashMap<String, Object> params);

    int loadTestScore(HashMap<String, Object> Params);

    String getRemainingTime(HashMap<String, Object> params);

    int isPassUpdate(HashMap<String, Object> params);

    // 연습 모드 문제 로드
    List<Map<String, Object>> practiceModeLoadExam(Map<String, Object> params);

}
