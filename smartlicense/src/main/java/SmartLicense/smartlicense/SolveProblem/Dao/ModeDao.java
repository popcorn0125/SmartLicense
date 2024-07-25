package SmartLicense.smartlicense.SolveProblem.Dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.parsing.Problem;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Mapper
public interface ModeDao {

    List<Map<String, Object>> testModeLoadExam(HashMap<String, Object> params);

    int userSelectAnswer(HashMap<String, Object> params);

    // 연습 모드 문제 로드
    List<Map<String, Object>> practiceModeLoadExam(Map<String, Object> params);

}
