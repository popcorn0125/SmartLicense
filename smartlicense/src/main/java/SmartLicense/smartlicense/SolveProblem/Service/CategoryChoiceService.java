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
}
