public class ProductListDTO {
//    private Long productId;
//    private String productName;
//    private int productPrice;
//    private int productWeight;
//    private String productDescription;
//    private int businessNum;
//
//    public Long getProductId() {
//        return productId;
//    }
//
//    public void setProductId(Long productId) {
//        this.productId = productId;
//    }
//
//    public String getProductName() {
//        return productName;
//    }
//
//    public void setProductName(String productName) {
//        this.productName = productName;
//    }
//
//    public int getProductPrice() {
//        return productPrice;
//    }
//
//    public void setProductPrice(int productPrice) {
//        this.productPrice = productPrice;
//    }
//
//    public int getProductWeight() {
//        return productWeight;
//    }
//
//    public void setProductWeight(int productWeight) {
//        this.productWeight = productWeight;
//    }
//
//    public String getProductDescription() {
//        return productDescription;
//    }
//
//    public void setProductDescription(String productDescription) {
//        this.productDescription = productDescription;
//    }
//
//    public int getBusinessNum() {
//        return businessNum;
//    }
//
//    public void setBusinessNum(int businessNum) {
//        this.businessNum = businessNum;
//    }
//
//    private   static Long idValue = 1L;
//    public ProductListDTO(String productName, int productPrice, int productWeight, String productDescription, int businessNum) {
//        this.productId = idValue++;
//        this.productName = productName;
//        this.productPrice = productPrice;
//        this.productWeight = productWeight;
//        this.productDescription = productDescription;
//        this.businessNum = businessNum;
//    }
//
//    @Override
//    public String toString() {
//        return "ProductListDTO{" +
//                "productName='" + productName + '\'' +
//                ", productPrice=" + productPrice +
//                ", productWeight=" + productWeight +
//                ", productDescription='" + productDescription + '\'' +
//                ", businessNum=" + businessNum +
//                '}';
//    }
    private ProductDTO productDTO;

    private Long id;

    public ProductDTO getProductDTO() {
        return productDTO;
    }

    public void setProductDTO(ProductDTO productDTO) {
        this.productDTO = productDTO;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
 private static Long idValue = 1L;
    public ProductListDTO(ProductDTO productDTO) {
        this.id = idValue++;
        this.productDTO = productDTO;
    }

    @Override
    public String toString() {
        return "ProductListDTO{" +
                "productDTO=" + productDTO +
                ", id=" + id +
                '}';
    }
}


