package SmartLicense.smartlicense.SignInUp.Service;

import SmartLicense.smartlicense.SignInUp.Dao.LoginDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
/*******************
 * 날짜 : 2024.07.10
 * 이름 : 김준식
 * 내용 : login Service
 * *****************/
@Service
public class LoginService {

    @Autowired
    LoginDao loginDao;

    /*******************
     * 날짜 : 2024.07.10
     * 이름 : 김준식
     * 내용 : 로그인(아이디, 비밀번호 검사)
     * *****************/
    public HashMap<String, Object> smartLicenselogin(HashMap<String, Object> params) {
        // 0 : 로그인 실패, 1 : 로그인 성공
        HashMap<String, Object> result = new HashMap<>();
        result.put("result",0);
        try {
            // 아이디 검증
            int count = loginDao.userIdCheck(params.get("userId"));
            if(count == 0) {
                return result;
            }

            // 비밀번호 검증
            String pw = loginDao.getUserPw(params);
        } catch (Exception e){
            e.printStackTrace();
        }

        return result;
    }
}
