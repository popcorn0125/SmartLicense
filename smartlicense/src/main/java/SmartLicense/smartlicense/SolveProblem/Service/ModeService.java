package SmartLicense.smartlicense.SolveProblem.Service;

import SmartLicense.smartlicense.SolveProblem.Dao.ModeDao;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ModeService {

    @Autowired
    ModeDao modeDao;

    public List<Map<String, Object>> testModeLoadExam(HashMap<String, Object> params) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        params.put("subject", objectMapper.readValue(params.get("subject").toString(), List.class));
        return modeDao.testModeLoadExam(params);
    }

    public HashMap<String, Object> userSelectAnswer(HashMap<String, Object> params) {
        HashMap<String, Object> result = new HashMap<>();
        result.put("result", 0);
        try{
            int isSuccess = modeDao.userSelectAnswer(params);
            result.put("result", isSuccess);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }
}
