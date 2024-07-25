package SmartLicense.smartlicense.SolveProblem.Service;

import SmartLicense.smartlicense.SolveProblem.Dao.ModeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.parsing.Problem;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ModeService {

    @Autowired
    ModeDao modeDao;

    public List<Map<String, Object>> testModeLoadExam(HashMap<String, Object> params) {
        return modeDao.testModeLoadExam(params);
    }

    public int userSelectAnswer(HashMap<String, Object> params) {
        return modeDao.userSelectAnswer(params);
    }

    // 연습 모드 문제 로드
    public List<Map<String, Object>> practiceModeLoadExam(Map<String, Object> params) {
        return modeDao.practiceModeLoadExam(params);
    }
}
