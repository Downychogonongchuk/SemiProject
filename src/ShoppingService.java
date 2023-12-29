import java.sql.SQLOutput;
import java.util.List;
import java.util.Scanner;

public class ShoppingService {
    ShoppingRepository shoppingRepository = new ShoppingRepository();
    ProductRepository productRepository = new ProductRepository();
    ProductService productService = new ProductService();
    Scanner sc = new Scanner(System.in);

    public void registerUser() {
        boolean result = false;
        int sel = sc.nextInt();
        do {
            System.out.println("가입하실 이메일을 입력하세요");
            String email = sc.next();
            result = shoppingRepository.emailCheck(email);
            if (result) {
                System.out.println("이미 사용 중인 이메일입니다.");
            } else {
                System.out.println("사용가능한 이메일 입니다");
                System.out.println("비밀번호: ");
                String pass = sc.next();
                System.out.println("이름: ");
                String name = sc.next();
                System.out.println("전화번호: ");
                String mobile = sc.next();
                System.out.println("주소지 : ");
                String address = sc.next();
                System.out.println("국가: ");
                String nation = sc.next();
                System.out.println("사업자 회원이십니까?");
                System.out.println("1. yes | 2. no");
                if (sel == 1) {
                    System.out.println("사업자번호를 입력하세요");
                    int businessNum = sc.nextInt();
                    MemberDTO memberDTO = new MemberDTO(email, pass, name, mobile, address, nation, businessNum);
                    shoppingRepository.registerUser(memberDTO);
                } else if (sel == 2) {
                    int businessNum = 0;
                    MemberDTO memberDTO = new MemberDTO(email, pass, name, mobile, address, nation, businessNum);
                    shoppingRepository.registerUser(memberDTO);
                }
            }
        } while (result);
    }

    public void login() {
        System.out.println("로그인 하실 이메일을 입력해주세요 ");
        String email = sc.next();
        System.out.println("비밀번호를 입력해주세요");
        String pass = sc.next();
        shoppingRepository.login(email, pass);
        if (Common.loginEmail != null) {
            System.out.println("로그인 되었습니다.");
        }
    }

    public void buyProduct() {
        if (Common.loginEmail == null) {
            System.out.println("로그인이 필요한 서비스 입니다.");
        } else {
            System.out.println("상품의 ID 를 입력해주세요");
            Long ProductId = sc.nextLong();
            ProductDTO productDTO = productRepository.searchProductId(ProductId); // 제품id 검색
            int fee = deliveryFee(productDTO);// 제품 정보
            int price = productDTO.getProductPrice();
            int total = fee + price;
            System.out.println("상품명: " + productDTO.getProductName() + "\t" + "상품 가격: " + productDTO.getProductPrice() + "\t" + "배송료 : " + fee + "총 가격: " + total);
            MemberDTO memberDTO = shoppingRepository.payment(productDTO, total); // 제품 결제
            memberDTO.getBuyList().add(productDTO); // 구매정보 저장
        }
    }

    private int deliveryFee(ProductDTO productDTO) {
        int productWeight = productDTO.getProductWeight();
        int deliveryFee = 0;
        if (productWeight > 30) {
            deliveryFee = 100000;
        } else if (productWeight > 10) {
            deliveryFee = 50000;
        } else if (productWeight > 5) {
            deliveryFee = 20000;
        } else if (productWeight > 2) {
            deliveryFee = 2500;
        }
        return deliveryFee;
    }

    public void myPage() {
        if (Common.loginEmail == null) {
            System.out.println("로그인이 필요한 서비스 입니다.");
        } else {
            while (true) {
                int sel = sc.nextInt();
                System.out.println("----------------------------------------------------");
                System.out.println("1. 상품 등록 | 2. 등록 상품 취소 | 3. 페이 충전 | 4.구매한 상품 리스트 | 5. 종료");
                System.out.println("----------------------------------------------------");
                if (sel == 1) {
                    int businessNum = shoppingRepository.businessCheck();
                    if (businessNum ==0){
                        System.out.println("사업자 회원이 아닙니다.");
                        break;
                    }
                    productService.registerProduct(businessNum);
                }

            if (sel == 2) {
                int businessNum = shoppingRepository.businessCheck();
                if (businessNum ==0){
                    System.out.println("사업자 회원이 아닙니다.");
                    break;
                }
                System.out.println("등록 제거 하실 상품의 Id 를 입력해주세요");
                Long productId = sc.nextLong();
                productRepository.deleteProduct(businessNum , productId);
            }
            if (sel == 3) {
                System.out.println("충전하실 금액을 입력해주세요");
                int pay = sc.nextInt();
                shoppingRepository.rechargePay(pay);
            }
            if (sel == 4) {
              List<ProductDTO>productDTOList = shoppingRepository.buyHistory();
                for (ProductDTO productDTO:productDTOList) {
                    System.out.println("제품ID:  " + productDTO.getProductId() + "\t" + "제품명:  " + productDTO.getProductName() + "\t" + "가격: " + productDTO.getProductPrice() + "\t");
                }
            }
            if (sel == 5) {
                break;
            }
        }
    }
}


}
