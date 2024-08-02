package SmartLicense.smartlicense.SignInUp.Controller;

import SmartLicense.smartlicense.SignInUp.DTO.MemberDTO;
import SmartLicense.smartlicense.SignInUp.Service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Objects;

/*******************
 * 날짜 : 2024.07.15
 * 이름 : 김준식
 * 내용 : 회원 컨트롤러
 * *****************/

@RestController
@RequestMapping("/api")
public class MemberController {
    @Autowired
    MemberService memberService;

    @Value("${phonenumber.erificationCode}")
    private Integer erificationCode;

    /*******************
     * 날짜 : 2024.07.15
     * 이름 : 김준식
     * 내용 : 회원가입
     * *****************/
    @PostMapping("/signup")
    public ResponseEntity<HashMap<String, Object>> memberRegister(@RequestBody HashMap<String, String> params) {
        System.out.println("memberRegister 실행");
        MemberDTO memberDTO = new MemberDTO(
                params.get("userid"),
                params.get("pw"),
                params.get("name"),
                params.get("phonenumber"),
                params.get("nickname"),
                params.get("gender").charAt(0)
        );
        return ResponseEntity.ok(memberService.memberRegister(memberDTO));
    }

    /*******************
     * 날짜 : 2024.07.16
     * 이름 : 김준식
     * 내용 : 아이디 중복 확인
     * *****************/
    @PostMapping("/isDuplicateId")
    public ResponseEntity<Integer> isDuplcateId(@RequestBody HashMap<String, Object> params) {
        System.out.println("isDuplicateId 실행");
        return ResponseEntity.ok(memberService.isDuplicateId(params));
    }

    /*******************
     * 날짜 : 2024.07.16
     * 이름 : 김준식
     * 내용 : 닉네임 중복 확인
     * *****************/
    @PostMapping("/isDuplicateNickName")
    public ResponseEntity<Integer> isDuplicateNickName(@RequestBody HashMap<String, Object> params) {
        System.out.println("isDuplicateNickName 실행");
        return ResponseEntity.ok(memberService.isDuplicateNickName(params));
    }

    /*******************
     * 날짜 : 2024.07.16
     * 이름 : 김준식
     * 내용 : 전화번호 입력후 인증번호 전송
     * *****************/
    @PostMapping("/sendSMS")
    public ResponseEntity<Integer> sendSMS() {
        System.out.println("sendSMS 실행");
        return ResponseEntity.ok(erificationCode);
    }

    /*******************
     * 날짜 : 2024.07.16
     * 이름 : 김준식
     * 내용 : 인증번호 확인
     * *****************/
    @PostMapping("/isNumberCheck")
    public ResponseEntity<Integer> numberCheck(@RequestBody HashMap<String, Integer> params) {
        System.out.println("numberCheck 실행");
        int result = 0;
        if(Objects.equals(params.get("checknumber"), erificationCode)) {
            result = 1;
        }
        return ResponseEntity.ok(result);
    }

    /*******************
     * 날짜 : 2024.07.29
     * 이름 : 김준식
     * 내용 : 마이페이지에서 회원 정보 불러오기
     * *****************/
    @PostMapping("/loadUserInfo")
    public ResponseEntity<HashMap<String, Object>> loadUserInfo(@RequestBody HashMap<String, Object> params) throws SQLException {
        System.out.println("loadUserInfo 실행");
        return ResponseEntity.ok(memberService.loadUserInfo(params));
    }

    /*******************
     * 날짜 : 2024.08.01
     * 이름 : 김준식
     * 내용 : 정보수정에서 회원 정보 불러오기
     * *****************/
    @PostMapping("/getUserInfo")
    public ResponseEntity<HashMap<String, Object>> getUserInfo(@RequestBody HashMap<String, Object> params) throws SQLException {
        System.out.println("getUserInfo 실행");
        return ResponseEntity.ok(memberService.getUserInfo(params));
    }

    /*******************
     * 날짜 : 2024.08.02
     * 이름 : 김준식
     * 내용 : 정보수정에서 회원정보 수정하기
     * *****************/
    @PostMapping("/updateUserInfo")
    public ResponseEntity<Integer> updateUserInfo(@RequestBody HashMap<String, Object> params) throws SQLException {
        System.out.println("updateUserInfo 실행");
        return ResponseEntity.ok(memberService.updateUserInfo(params));
    }

    /*******************
     * 날짜 : 2024.08.01
     * 이름 : 김준식
     * 내용 : 회원탈퇴
     * *****************/
    @PostMapping("/deleteAccount")
    public ResponseEntity<Integer> deleteAccount(@RequestBody HashMap<String, Object> params) throws SQLException {
        System.out.println("deleteAccount 실행");
        return ResponseEntity.ok(memberService.deleteAccount(params));
    }
}
