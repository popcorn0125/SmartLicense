package SmartLicense.smartlicense.InccorectNote.Dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface IncorrectNoteDao {

    List<HashMap<String, Object>> incorrectNoteLoad(HashMap<String, Object> params);

    HashMap<String, Object> getExamRecord(HashMap<String, Object> params);
}
