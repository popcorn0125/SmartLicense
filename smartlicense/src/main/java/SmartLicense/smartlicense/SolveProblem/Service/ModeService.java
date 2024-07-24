package SmartLicense.smartlicense.SolveProblem.Service;

import SmartLicense.smartlicense.SolveProblem.Dao.ModeDao;
import org.springframework.beans.factory.annotation.Autowired;
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
}
