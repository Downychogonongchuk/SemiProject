import java.util.Scanner;

public class ShoppingMain {
    public static void main(String[] args) {
    ShoppingService shoppingService = new ShoppingService();
    ProductService productService = new ProductService();
        Scanner sc =new Scanner(System.in);

        while (true){
            System.out.println("-----------------------------------------------------------------");
            System.out.println("1. 회원가입 | 2. 로그인 | 3. 상품 검색 | 4. 상품 구매 | 5.마이페이지 | 6. 종료 | 7. 종료");
            System.out.println("-----------------------------------------------------------------");
            int sel = sc.nextInt();
            if (sel==1){
            shoppingService.registerUser(); // 회원가입
        }else if(sel==2){
            shoppingService.login();  // 로그인
        }else if(sel==3){
            productService.searchProduct(); // 상품 검색
        }else if (sel==4){
            shoppingService.buyProduct(); // 상품구매
        }else if (sel==5){
            shoppingService.myPage(); // 마이페이지
        } else if (sel==6) {
         break;
        }else if (sel==7){
            break;
        }
        }
    }
}
