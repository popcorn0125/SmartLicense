package SmartLicense.smartlicense.SolveProblem.Dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface CategoryChoiceDao {
    List<HashMap<String, Object>> loadLicense();

    List<HashMap<String, Object>> loadDetailLicense(@Param("licenseName") String licenseName);

    List<HashMap<String, Object>> loadSessionQuestion(@Param("examDate") String examDate);

    List<HashMap<String, Object>> loadSubjects(HashMap<String, Object> params);
}
