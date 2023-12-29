import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ProductRepository {
    public static List<ProductDTO> productDTOList= new ArrayList<>();

    public   ProductDTO searchProductId(Long productId) {
        ProductDTO productDTO = null;
        for (int i = 0; i < productDTOList.size(); i++) {
            if (productId.equals(productDTOList.get(i).getProductId())){
                 productDTO = productDTOList.get(i);
            }
        }return productDTO;
    }

    public   List<ProductDTO> searchProduct(String search) {
        List<ProductDTO> searchList =new ArrayList<>();
        for (int i = 0; i < productDTOList.size(); i++) {
            if (productDTOList.get(i).getProductName().contains(search)) {
                searchList.add(productDTOList.get(i));
            }
        }
        List<ProductDTO> sortedList = searchList.stream()
                .sorted(Comparator.comparing(ProductDTO::getProductPrice))
                .collect(Collectors.toList());
        return sortedList;
    }

    public void registerProduct(ProductDTO productDTO) {
        productDTOList.add(productDTO);
    }

    public void deleteProduct(int businessNum, Long productId) {
        for (int i = 0; i <productDTOList.size() ; i++) {
            if (businessNum==productDTOList.get(i).getBusinessNum() && productId.equals(productDTOList.get(i).getProductId())){
                productDTOList.remove(i);
            }
        }
    }

    }



