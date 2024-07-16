package SmartLicense.smartlicense.SignInUp.Service;

import SmartLicense.smartlicense.SignInUp.DTO.MemberDTO;
import SmartLicense.smartlicense.SignInUp.Dao.MemberDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
/*******************
 * 날짜 : 2024.07.15
 * 이름 : 김준식
 * 내용 : 회원 서비스
 * *****************/
@Service
public class MemberService {
    @Autowired
    MemberDao memberDao;

    @Autowired
    PasswordEncoder passwordEncoder;

    /*******************
     * 날짜 : 2024.07.15
     * 이름 : 김준식
     * 내용 : 회원가입 ( 비밀번호 암호화 후 저장)
     * *****************/
    public HashMap<String, Object> memberRegister(MemberDTO params) {
        HashMap<String, Object> result = new HashMap<>();
        result.put("result", "0");
        try {
            String pw = passwordEncoder.encode(params.getPw());
            params.setPw(pw);
            int isSuccess = memberDao.memberRegister(params);
            if (isSuccess != 0) result.put("result", "1");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /*******************
     * 날짜 : 2024.07.16
     * 이름 : 김준식
     * 내용 : 아이디 중복 확인
     * *****************/
    public int isDuplicateId(HashMap<String, Object> params) {
        int result = 0;
        try{
            result = memberDao.isDuplicateId(params);
        } catch (Exception e){
            e.printStackTrace();
        }

        return result;
    }

    /*******************
     * 날짜 : 2024.07.15
     * 이름 : 김준식
     * 내용 : 닉네임 중복 확인
     * *****************/
    public int isDuplicateNickName(HashMap<String, Object> params) {
        int result = 0;
        try{
            result = memberDao.isDuplicateNickName(params);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

}
