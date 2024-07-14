package SmartLicense.smartlicense.SignInUp.Controller;

import SmartLicense.smartlicense.SignInUp.DTO.MemberDTO;
import SmartLicense.smartlicense.SignInUp.Service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/api")
public class MemberController {
    @Autowired
    MemberService memberService;

    @PostMapping("/signup")
    public ResponseEntity<HashMap<String, Object>> memberRegister(@RequestBody MemberDTO params) {
        System.out.println("memberRegister 실행");
        return ResponseEntity.ok(memberService.memberRegister(params));
    }
}
