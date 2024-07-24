package SmartLicense.smartlicense.SolveProblem.Service;

import SmartLicense.smartlicense.SolveProblem.Dao.CategoryChoiceDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class CategoryChoiceService {
    @Autowired
    CategoryChoiceDao categoryChoiceDao;

    public List<HashMap<String, Object>> loadLicense(){
        return categoryChoiceDao.loadLicense();
    }

    public List<HashMap<String, Object>> loadDetailLicense(String licenseName){
        return categoryChoiceDao.loadDetailLicense(licenseName);
    }

    public List<HashMap<String, Object>> loadSessionQuestion(String examDate){
        System.out.println("서비스실행완");
        System.out.println(categoryChoiceDao.loadSessionQuestion(examDate));
        return categoryChoiceDao.loadSessionQuestion(examDate);
    }

    public List<HashMap<String, Object>> loadSubjects(HashMap<String, Object> params){
        System.out.println(params);
        return categoryChoiceDao.loadSubjects(params);
    }
}
