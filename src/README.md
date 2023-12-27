// memberDTO : Long Id (자동증가), member name, member mobile, member email , member pass, member Address , member nation , blance , business num , List<ProductDTO>buyList
// productDTO :  Long product Id(자동증가) , product name , int product price , Int product weight , product description , business num
// Common : public static String loginEmail = null; (로그인 성공 여부)

1. 회원가입 : 국가 , 이름 , 전화번호 , 주소 , 이메일 , 비밀번호    
   사업자 회원가입 + 사업자 번호     // 매개변수 ( business num : 0 ) 
  
2.  로그인 : 이메일 , 비밀번호  // 로그인 확인 loginCheck();

3. 페이 충전 : loginCheck();  pay + blance 

4.(사업자) 상품 등록시 : 상품명, 가격, 무게, 상품 설명  // 로그인 확인 loginCheck(); 사업자 확인 business num != 0   BusinessCheck (); 
        

5. (상품 검색) 최저가 비교 
  상품명 검색 : 가격 비교 후 가장 낮은 금액의 물건 상위 노출
 // 입력 받은 상품명 .contents 포함하는 물건 리스트를
 // 가격 비교 가장 낮은 금액부터  리스트의 0번인덱스부터 저장 (담아서 보여줄 새로운 리스트 생성)
   

ex) 1. 제품ID : 1 | 상품명 : 민트껌 | 가격 : 500원 | 판매자 : 고구마맛탕 | 
    2. 제품ID : 4 | 상품명 : 민트껌 | 가격 : 600원 | 판매자 : 노란병아리 |
  

6. 해외배송 상품 배송료 측정
   판매 국가와 구매 국가의 가격이 일치하지 않을 시 무게에 따른 배송료 부가  // 무게에 따른 배송료 측정 메서드 // 기본 배송료 0;

7. 물건 구매  
   제품 id로 구매 // if (blance > pay) 구매한 목록 

##############################################
* 가능하면
  7. 물건 구매 시 장바구니의 물건을 모두 구매
   검색 메서드 or 베스트 셀러 메서드 에서 "장바구니에 담으시겠습니까?" - >1 - "제품 ID" - sc.nextLong -  장바구니( shoppingBasket(); ) [List or Map] 에 저장

  8. 베스트 셀러 물건 보기
     구매 완료 시 count += 1; 가장 많이 구매한 물건 5개 보여주기 + 장바구니

  9. 마이페이지
      로그인 한 아이디의 구매한 목록 + 잔액 
