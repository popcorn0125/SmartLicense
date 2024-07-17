package SmartLicense.smartlicense.SignInUp.Service;

import SmartLicense.smartlicense.SignInUp.Dao.LoginDao;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
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

    @Autowired
    PasswordEncoder passwordEncoder;

    // RSA 키 생성
//    private final KeyPair keyPair;
//
//    public LoginService() throws NoSuchAlgorithmException {
//        this.keyPair = KeyGeneratorUtils.generateRSAKeyPair();
//    }

    /*******************
     * 날짜 : 2024.07.10
     * 이름 : 김준식
     * 내용 : 로그인(아이디, 비밀번호 검사)
     * *****************/
    public HashMap<String, Object> smartLicenselogin(HashMap<String, Object> params, HttpServletRequest request, HttpServletResponse response) {
        // 0 : 로그인 실패, 1 : 로그인 성공
        HashMap<String, Object> result = new HashMap<>();
        result.put("result",0);
        try {
            // 아이디 검증
            int count = loginDao.userIdCheck(params.get("userId").toString());
            if(count == 0) {
                result.put("message", "존재하지 않는 아이디입니다.");
                return result;
            }

            // 비밀번호 검증
            String password = params.get("userPw").toString();
            String encodePassword = loginDao.getUserPw(params);
            // 비밀번호가 일치하지 않을 경우
            if( !(passwordEncoder.matches(password, encodePassword)) ) {
                result.put("message", "비밀번호가 일치하지 않습니다.");
                return result;
            }

            // 토큰 추가
//            String token = makeAccessJWTToken(params.get("userId").toString());
//            System.out.println("token : "+ token);
            HttpSession session = request.getSession();
            session.setAttribute("loginUser", params.get("userId").toString());
            session.setMaxInactiveInterval(30*60); // 30분
            System.out.println("세션 생성 성공");
            cookieCreate(response, "USER_ID", params.get("userId").toString());

            result.put("result", 1);
            System.out.println("로그인 성공");
        } catch (Exception e){
            result.put("message", "오류가 발생하였습니다.");
            e.printStackTrace();
        }

        return result;
    }

    /*******************
     * 날짜 : 2024.07.17
     * 이름 : 김준식
     * 내용 : 쿠키 생성
     * *****************/
    public void cookieCreate(HttpServletResponse response, String cookieName, String cookieValue ) {
        Cookie cookie = new Cookie(cookieName, cookieValue);
        cookie.setMaxAge(30*60);
        response.addCookie(cookie);
        System.out.println("쿠키 생성 성공");
    }

    /*******************
     * 날짜 : 2024.07.17
     * 이름 : 김준식
     * 내용 : 로그아웃
     * *****************/
    public int logout(HttpServletRequest request, HttpServletResponse response) {
        int result = 0;

        HttpSession session = request.getSession(false);
        if (session != null) {
            // 세션 무효화
            session.invalidate();
            // 쿠키 삭제
            cookieDelete(request, response);
            result = 1;
        }
        return result;
    }

    /*******************
     * 날짜 : 2024.07.10
     * 이름 : 김준식
     * 내용 : 쿠키 삭제
     * *****************/
    public void cookieDelete(HttpServletRequest request, HttpServletResponse response) {
        Cookie[] cookies = request.getCookies();
        if(cookies != null) {
            for( Cookie cookie : cookies) {
                if(cookie.getName().equals("USER_ID")){
                    // 쿠키에 USER_ID가 있을 경우
                    cookie.setMaxAge(0);
                    response.addCookie(cookie);
                    break;
                }
            }
        }
    }

    /*******************
     * 날짜 : 2024.07.10
     * 이름 : 김준식
     * 내용 : access 토큰 생성
     * *****************/
//    public String makeAccessJWTToken(String param) {
//        Date current_date = new Date();
//
//        return Jwts.builder()
//                .setHeaderParam(Header.TYPE, Header.JWT_TYPE)
//                .setIssuer("access")
//                .setIssuedAt(current_date)
//                .setExpiration(new Date(current_date.getTime() + Duration.ofMinutes(30).toMillis()))
//                .claim("id", param)
//                .signWith(SignatureAlgorithm.RS256, keyPair.getPrivate())
//                .compact();
//    }
    /*******************
     * 날짜 : 2024.07.10
     * 이름 : 김준식
     * 내용 : refresh 토큰 생성
     * *****************/
//    public String makeRefreshJWTToken(String param) {
//        Date current_date = new Date();
//
//        return Jwts.builder()
//                .setHeaderParam(Header.TYPE, Header.JWT_TYPE)
//                .setIssuer("refresh")
//                .setIssuedAt(current_date)
//                .setExpiration(new Date(current_date.getTime() + Duration.ofMinutes(60).toMillis()))
//                .claim("nickname", param)
//                .signWith(SignatureAlgorithm.HS256, "secret")
//                .compact();
//    }
}
