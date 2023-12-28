import java.util.ArrayList;
import java.util.List;

public class ShoppingRepository {
    List<MemberDTO> memberDTOList = new ArrayList<>();
    List<ProductDTO> productDTOList = new ArrayList<>();


    public boolean emailCheck(String email) { // 이메일 중복체크
        for (int i = 0; i < memberDTOList.size(); i++) {
            if (email.equals(memberDTOList.get(i).getMemberEmail())) {
                return true;
            }
        }
        return false;
    }

    public void registerUser(MemberDTO memberDTO) {
        memberDTOList.add(memberDTO);
    }

    public void login(String email, String pass) {
        for (int i = 0; i < memberDTOList.size(); i++) {
            if (email.equals(memberDTOList.get(i).getMemberEmail()) && pass.equals(memberDTOList.get(i).getMemberPass())) {
                Common.loginEmail = email;
            }
        }
    }

    public MemberDTO payment(ProductDTO productDTO , int total) { // 결제
        MemberDTO memberDTO = null;
        for (int i = 0; i < memberDTOList.size(); i++) {
            if (Common.loginEmail.equals(memberDTOList.get(i).getMemberEmail())){
                int blance = memberDTOList.get(i).getBlance();
                if (blance >total){
                    blance -= total;
                    memberDTOList.get(i).setBlance(blance);
                      memberDTO=memberDTOList.get(i);
                }else {
                    System.out.println("잔액이 부족합니다.");
                }
            }
        }return memberDTO;
    }
}



