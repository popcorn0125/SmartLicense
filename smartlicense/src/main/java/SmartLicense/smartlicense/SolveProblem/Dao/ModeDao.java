package SmartLicense.smartlicense.SolveProblem.Dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Mapper
public interface ModeDao {

    List<Map<String, Object>> testModeLoadExam(HashMap<String, Object> params);
}
