import java.util.ArrayList;
import java.util.List;

public class ShoppingRepository {
    public static List<MemberDTO> memberDTOList = new ArrayList<>();
    public static List<ProductDTO> productDTOList = new ArrayList<>();
    public static List<ProductListDTO>productListDTOList =new ArrayList<>();


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

    public List<ProductListDTO> payment(ProductDTO productDTO, int total) { // 결제
        for (int i = 0; i < memberDTOList.size(); i++) {
            if (Common.loginEmail.equals(memberDTOList.get(i).getMemberEmail())) {
                int blance = memberDTOList.get(i).getBlance();
                if (blance > total) {
                    blance -= total;
                    memberDTOList.get(i).setBlance(blance);
                    ProductListDTO productListDTO = new ProductListDTO(productDTO);
                    productListDTOList.add(productListDTO);

                }
            }
        }
        return productListDTOList;
    }

    public int businessCheck() {  // 사업자 회원 체크
        int businessNum = 0;
        for (int i = 0; i < memberDTOList.size(); i++) {
            if (Common.loginEmail.equals(memberDTOList.get(i).getMemberEmail())) {
                if (memberDTOList.get(i).getBusinessNum() != 0) {
                    businessNum = memberDTOList.get(i).getBusinessNum();
                }
            }
        }
        return businessNum;
    }

    public void rechargePay(int pay) {
        for (int i = 0; i < memberDTOList.size(); i++) {
            if (Common.loginEmail.equals(memberDTOList.get(i).getMemberEmail())) {
                int blance = memberDTOList.get(i).getBlance();
                blance += pay;
                memberDTOList.get(i).setBlance(blance);
            }
        }
    }

    public List<ProductDTO> buyHistory() {
        for (int i = 0; i < memberDTOList.size(); i++) {
            if (Common.loginEmail.equals(memberDTOList.get(i).getMemberEmail())) {
                List<ProductDTO> productDTOList = memberDTOList.get(i).getBuyList();
            }
        }
        return productDTOList;
    }
}







