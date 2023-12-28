import java.util.List;

public class MemberDTO {
    private Long id;
    private String memberName;
    private String memberMobile;
    private String memberEmail;
    private String memberPass;
    private String memberAddress;
    private String memberNation;
    private int blance;
    private int businessNum;
    private List<ProductDTO> buyList;

    public List<ProductDTO> getBuyList() {
        return buyList;
    }

    public void setBuyList(List<ProductDTO> buyList) {
        this.buyList = buyList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getMemberMobile() {
        return memberMobile;
    }

    public void setMemberMobile(String memberMobile) {
        this.memberMobile = memberMobile;
    }

    public String getMemberEmail() {
        return memberEmail;
    }

    public void setMemberEmail(String memberEmail) {
        this.memberEmail = memberEmail;
    }

    public String getMemberPass() {
        return memberPass;
    }

    public void setMemberPass(String memberPass) {
        this.memberPass = memberPass;
    }

    public String getMemberAddress() {
        return memberAddress;
    }

    public void setMemberAddress(String memberAddress) {
        this.memberAddress = memberAddress;
    }

    public String getMemberNation() {
        return memberNation;
    }

    public void setMemberNation(String memberNation) {
        this.memberNation = memberNation;
    }

    public int getBlance() {
        return blance;
    }

    public void setBlance(int blance) {
        this.blance = blance;
    }

    public int getBusinessNum() {
        return businessNum;
    }

    public void setBusinessNum(int businessNum) {
        this.businessNum = businessNum;
    }
 public  static  Long idValue = 1L;
    public MemberDTO( String memberEmail,String memberPass, String memberName, String memberMobile,   String memberAddress, String memberNation, int businessNum) {
        this.id = idValue ++ ;
        this.memberName = memberName;
        this.memberMobile = memberMobile;
        this.memberEmail = memberEmail;
        this.memberPass = memberPass;
        this.memberAddress = memberAddress;
        this.memberNation = memberNation;
    }

    @Override
    public String toString() {
        return "MemberDTO{" +
                "id=" + id +
                ", memberName='" + memberName + '\'' +
                ", memberMobile='" + memberMobile + '\'' +
                ", memberEmail='" + memberEmail + '\'' +
                ", memberPass='" + memberPass + '\'' +
                ", memberAddress='" + memberAddress + '\'' +
                ", memberNation='" + memberNation + '\'' +
                ", blance=" + blance +
                ", businessNum=" + businessNum +    '\'' +
                '}';
    }
}
