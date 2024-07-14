package SmartLicense.smartlicense.SignInUp.Service;

import SmartLicense.smartlicense.SignInUp.DTO.MemberDTO;
import SmartLicense.smartlicense.SignInUp.Dao.MemberDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class MemberService {
    @Autowired
    MemberDao memberDao;

    public HashMap<String, Object> memberRegister(MemberDTO params) {
        HashMap<String, Object> result = new HashMap<>();

        return result;
    }

}
