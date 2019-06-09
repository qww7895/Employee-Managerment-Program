import java.util.Scanner;
import java.util.Vector;

public class DataBase {
   private Vector<User> dbList;
   DataBase(){
      dbList= new Vector<User>(10,90);
      dbList.add(new User("매니저","manager","machine",true,25,4,0));
      //기본 생성자 입력 순서
      //name ID PW isManager age level index 
      //name : none age : 25 ID : manager PW : machine level : 4
      //isManager : true index : 1000
      
      //생성자 기본 관리자 1인
      //기본 10칸, 확장시 최대 10+90칸의 공간을 차지함
   }
   // 전체 사원 보기 메소드
   public void ShowAllDB(User test/*사용자 정보*/) {
      //모든 DB내용을 보는 매소드
      //객체의 권한을 확인
      if(test.isManager()==true){
         //권한이 있을떄
         for(int count=0;count<dbList.size();count++) {
               //전체 데이터 출력
               //사원 클래스 생성후 세부내용 제작***********
               //예시 System.out.println(dbList.elementAt(count).name);
               
               
               
               
            }
         }else{
         //권한 없음
         System.out.println("권한 없음");
         }
   }
   //개인 사원 보기 메소드
   public void ShowMyDB(int index/*찾을 사원번호*/) {
      //자기 사원이름을 입력하면 자기 데이터만 보는 메소드
      //중복된이름이 있을수 있으므로 번호로 검색
      for(int count=0;count<dbList.size();count++) {
         if(dbList.elementAt(count).getIndex()==index) {
            //사원번호가 일치하는 데이터가 존재함
            //사원 데이터 출력
            //예시 System.out.println(dbList.elementAt(count).name);
            
            
            
            
            
         }
      }
         
   }
   
   
   //사원 데이터 추가
   public void setDB(User test/*사용자 정보*/,User addData/*추가할 데이터*/) {
      //DB 데이터 입력.
      //매니저만 가능
      if(test.isManager()==true) {
         //권한이 있을떄
         dbList.add(addData);
         System.out.println("데이터 입력 완료");
      }else{
         //권한 없음
         System.out.println("권한 없음");
      }
   }
   
   //사원 데이터 삭제
   public void removeDB(User test/*사용자 정보*/,int index) {
      //DB번호를 기반으로 DB데이터 삭제. 매니저만 가능
      //이름으로 접근시 중복되는 이름이 존재할수 있으므로 번호로 접근
      //DB번호에 해당하는 정보를 출력한뒤 정말로 지울건지 재확인후 삭제
      int count;
      if(test.isManager()==true) {
         Scanner scann = new Scanner(System.in);
         for(count=0;count<dbList.size();count++) {
            if(dbList.elementAt(count).getIndex()==index){
               //DB번호에 해당하는 정보 출력 위치
               
               
               
               
               System.out.print("정말로 지우실건가요? Y/N : ");
               String isTrue=scann.nextLine();
               if(isTrue.equals("Y")) {
                  //정보를 삭제함
                  dbList.remove(count);
                  System.out.println("삭제하였습니다");
                  }else {
                  //정보를 삭제하지 않음
                  System.out.println("삭제하지 않고 돌아갑니다");
               }   
               break;
            }else if(count==(dbList.size()-1)) {
               //마지막 루프까지 사원을 발견하지 못함
               System.out.println("해당 번호를 가진사원이 존재하지 않습니다");
            }
         }
      }else {
         //권한없음
         System.out.println("권한없음");
      }   
   }
   //사원내용 변겅
   public void updateDB(User test/*사용자 정보*/,int index/*사원 번호*/,User updateData/*업데이트할 내용*/) {
      //사원 정보 변경 중복된 이름이 있을수 있으므로 번호로 접근
      //매니저만 접근 가능
         if(test.isManager()==true) {
         for(int count=0;count<dbList.size();count++) {
               if(dbList.elementAt(count).getIndex()==index){
                  dbList.setElementAt(updateData, index);
                  System.out.println("사원정보 변경 완료");
               }else if(count==(dbList.size()-1)) {
                  //마지막 루프까지 사원을 발견하지 못함
                  System.out.println("해당 번호를 가진사원이 존재하지 않습니다");
               }
               
            }
         }else {
            System.out.println("권한 없음");
         }
   }
   
   
   //ID PW Index로 사원정보 찾기
   public boolean isExist(int index,String ID,String PW) {
      //ID PW Index로 사원정보 찾기
      //true false 반환
      for(int count=0;count<dbList.size();count++) {      
         if((dbList.elementAt(count).getIndex()==index)&&(dbList.elementAt(count).getID()==ID)&&(dbList.elementAt(count).getPW()==PW)){
            return true;//사원정보 찾음
         }
      }
      return false;//사원정보 찾지못함
   }


   
   
   
}