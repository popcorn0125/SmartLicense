package SmartLicense.smartlicense.InccorectNote.Service;

import SmartLicense.smartlicense.InccorectNote.Dao.IncorrectNoteDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class IncorrectNoteSerive {

    @Autowired
    IncorrectNoteDao incorrectNoteDao;

    public HashMap<String, Object> incorrectNoteLoad(HashMap<String, Object> params) {
        HashMap<String, Object> result = new HashMap<>();
        result.put("exam_record", incorrectNoteDao.getExamRecord(params));
        result.put("question", incorrectNoteDao.incorrectNoteLoad(params));
        return result;
    }
}
