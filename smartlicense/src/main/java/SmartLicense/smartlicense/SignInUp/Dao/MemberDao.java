package SmartLicense.smartlicense.SignInUp.Dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;

@Mapper
public interface MemberDao {

    void memberRegister(HashMap<String, Object> params);
}
