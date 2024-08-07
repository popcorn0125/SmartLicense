package SmartLicense.smartlicense.InccorectNote.Service;

import SmartLicense.smartlicense.InccorectNote.Dao.IncorrectNoteDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public Map<String, Object> getExamRecords(String memberId, int page, int itemsPerPage) {
        int offset = (page - 1) * itemsPerPage;
        List<Map<String, Object>> records = incorrectNoteDao.fetchExamRecords(memberId, offset, itemsPerPage);
        int total = incorrectNoteDao.countTotalRecords(memberId);

        Map<String, Object> response = new HashMap<>();
        response.put("records", records);
        response.put("total", total);

        return response;
    }
}
