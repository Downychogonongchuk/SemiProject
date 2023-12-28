import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class ProductService {
    ProductRepository productRepository = new ProductRepository();
    Scanner sc = new Scanner(System.in);

    public void searchProduct() {
        System.out.println("검색어를 입력하세요");
        String search = sc.next();
      List<ProductDTO>searchList  = productRepository.searchProduct(search);
        System.out.println("검색하신" + search + "제품에 대한 결과 입니다.");
        System.out.println("productId\t" + "productName\t" + "productPrice\t");
        for (ProductDTO productDTO : searchList) {
            System.out.println("제품ID:  " + productDTO.getProductId() + "\t" + "제품명:  " + productDTO.getProductName() + "\t" + "가격: " + productDTO.getProductPrice() + "\t");
        }
    }
        public void registerProduct(int businessNum) { // 상품 등록
            System.out.println("상품명: ");
            String productName = sc.next();
            System.out.println("상품금액: ");
            int productPrice = sc.nextInt();
            System.out.println("상품무게는 kg 단위로 작성해주세요");
            int productWeight = sc.nextInt();
            System.out.println("상품 상세 설명");
            String productDescription = sc.next();
            ProductDTO productDTO = new ProductDTO(productName, productPrice, productWeight, productDescription, businessNum);
            productRepository.registerProduct(productDTO);
        }

    public void deleteProduct() {
    }

    public void rechargePay() {
    }

    public void buyHistory() {
    }


    }

