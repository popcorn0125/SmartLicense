package SmartLicense.smartlicense.SignInUp.Service;

import SmartLicense.smartlicense.SignInUp.Dao.LoginDao;
import io.jsonwebtoken.Header;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.Date;
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
            // 비밀번호가 일치하지 않을 경우
            if( !(params.get("userPw").toString().equals(pw)) ) {
                return result;
            }

            // 토큰 추가
            String token = makeAccessJWTToken(params.get("userId").toString());
            System.out.println("token : "+ token);
            result.put("result", token);
        } catch (Exception e){
            e.printStackTrace();
        }

        return result;
    }

    /*******************
     * 날짜 : 2024.07.10
     * 이름 : 김준식
     * 내용 : access 토큰 생성
     * *****************/
    public String makeAccessJWTToken(String param) {
        Date current_date = new Date();

        return Jwts.builder()
                .setHeaderParam(Header.TYPE, Header.JWT_TYPE)
                .setIssuer("access")
                .setIssuedAt(current_date)
                .setExpiration(new Date(current_date.getTime() + Duration.ofMinutes(30).toMillis()))
                .claim("id", param)
                .signWith(SignatureAlgorithm.RS256, "secret")
                .compact();
    }
    /*******************
     * 날짜 : 2024.07.10
     * 이름 : 김준식
     * 내용 : refresh 토큰 생성
     * *****************/
    public String makeRefreshJWTToken(String param) {
        Date current_date = new Date();

        return Jwts.builder()
                .setHeaderParam(Header.TYPE, Header.JWT_TYPE)
                .setIssuer("refresh")
                .setIssuedAt(current_date)
                .setExpiration(new Date(current_date.getTime() + Duration.ofMinutes(60).toMillis()))
                .claim("nickname", param)
                .signWith(SignatureAlgorithm.HS256, "secret")
                .compact();
    }
}
