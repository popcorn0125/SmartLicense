package SmartLicense.smartlicense.SignInUp.Dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;

/*******************
 * 날짜 : 2024.07.10
 * 이름 : 김준식
 * 내용 : login Dao
 * *****************/
@Mapper
public interface LoginDao {

    /*******************
     * 날짜 : 2024.07.10
     * 이름 : 김준식
     * 내용 : 아이디 확인
     * *****************/
    int userIdCheck(Object param);

    /*******************
     * 날짜 : 2024.07.10
     * 이름 : 김준식
     * 내용 : 비밀번호 확인
     * *****************/
    String getUserPw(HashMap<String, Object> params);
}
