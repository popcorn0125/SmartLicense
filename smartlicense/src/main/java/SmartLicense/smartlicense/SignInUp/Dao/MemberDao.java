package SmartLicense.smartlicense.SignInUp.Dao;

import SmartLicense.smartlicense.SignInUp.DTO.MemberDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;

/*******************
 * 날짜 : 2024.07.15
 * 이름 : 김준식
 * 내용 : 회원 DAO
 * *****************/
@Mapper
public interface MemberDao {

    /*******************
     * 날짜 : 2024.07.15
     * 이름 : 김준식
     * 내용 : 회원 등록( DB에 데이터 저장)
     * *****************/
    int memberRegister(MemberDTO params);

    /*******************
     * 날짜 : 2024.07.16
     * 이름 : 김준식
     * 내용 : 아이디 중복이 있는지 확인 ( 아이디 중복 확인 )
     * *****************/
    int isDuplicateId(HashMap<String, Object> params);

    /*******************
     * 날짜 : 2024.07.16
     * 이름 : 김준식
     * 내용 : 닉네임 중복이 있는지 확인 ( 닉네임 중복 확인 )
     * *****************/
    int isDuplicateNickName(HashMap<String, Object> params);
}
