import java.util.Scanner;
import java.util.Vector;

public class DataBase {
   private Vector<User> dbList;
   DataBase(){
      dbList= new Vector<User>(10,90);
      dbList.add(new User("�Ŵ���","manager","machine",true,25,4,0));
      //�⺻ ������ �Է� ����
      //name ID PW isManager age level index 
      //name : none age : 25 ID : manager PW : machine level : 4
      //isManager : true index : 1000
      
      //������ �⺻ ������ 1��
      //�⺻ 10ĭ, Ȯ��� �ִ� 10+90ĭ�� ������ ������
   }
   // ��ü ��� ���� �޼ҵ�
   public void ShowAllDB(User test/*����� ����*/) {
      //��� DB������ ���� �żҵ�
      //��ü�� ������ Ȯ��
      if(test.isManager()==true){
         //������ ������
         for(int count=0;count<dbList.size();count++) {
               //��ü ������ ���
               //��� Ŭ���� ������ ���γ��� ����***********
               //���� System.out.println(dbList.elementAt(count).name);
               
               
               
               
            }
         }else{
         //���� ����
         System.out.println("���� ����");
         }
   }
   //���� ��� ���� �޼ҵ�
   public void ShowMyDB(int index/*ã�� �����ȣ*/) {
      //�ڱ� ����̸��� �Է��ϸ� �ڱ� �����͸� ���� �޼ҵ�
      //�ߺ����̸��� ������ �����Ƿ� ��ȣ�� �˻�
      for(int count=0;count<dbList.size();count++) {
         if(dbList.elementAt(count).getIndex()==index) {
            //�����ȣ�� ��ġ�ϴ� �����Ͱ� ������
            //��� ������ ���
            //���� System.out.println(dbList.elementAt(count).name);
            
            
            
            
            
         }
      }
         
   }
   
   
   //��� ������ �߰�
   public void setDB(User test/*����� ����*/,User addData/*�߰��� ������*/) {
      //DB ������ �Է�.
      //�Ŵ����� ����
      if(test.isManager()==true) {
         //������ ������
         dbList.add(addData);
         System.out.println("������ �Է� �Ϸ�");
      }else{
         //���� ����
         System.out.println("���� ����");
      }
   }
   
   //��� ������ ����
   public void removeDB(User test/*����� ����*/,int index) {
      //DB��ȣ�� ������� DB������ ����. �Ŵ����� ����
      //�̸����� ���ٽ� �ߺ��Ǵ� �̸��� �����Ҽ� �����Ƿ� ��ȣ�� ����
      //DB��ȣ�� �ش��ϴ� ������ ����ѵ� ������ ������� ��Ȯ���� ����
      int count;
      if(test.isManager()==true) {
         Scanner scann = new Scanner(System.in);
         for(count=0;count<dbList.size();count++) {
            if(dbList.elementAt(count).getIndex()==index){
               //DB��ȣ�� �ش��ϴ� ���� ��� ��ġ
               
               
               
               
               System.out.print("������ ����ǰǰ���? Y/N : ");
               String isTrue=scann.nextLine();
               if(isTrue.equals("Y")) {
                  //������ ������
                  dbList.remove(count);
                  System.out.println("�����Ͽ����ϴ�");
                  }else {
                  //������ �������� ����
                  System.out.println("�������� �ʰ� ���ư��ϴ�");
               }   
               break;
            }else if(count==(dbList.size()-1)) {
               //������ �������� ����� �߰����� ����
               System.out.println("�ش� ��ȣ�� ��������� �������� �ʽ��ϴ�");
            }
         }
      }else {
         //���Ѿ���
         System.out.println("���Ѿ���");
      }   
   }
   //������� ����
   public void updateDB(User test/*����� ����*/,int index/*��� ��ȣ*/,User updateData/*������Ʈ�� ����*/) {
      //��� ���� ���� �ߺ��� �̸��� ������ �����Ƿ� ��ȣ�� ����
      //�Ŵ����� ���� ����
         if(test.isManager()==true) {
         for(int count=0;count<dbList.size();count++) {
               if(dbList.elementAt(count).getIndex()==index){
                  dbList.setElementAt(updateData, index);
                  System.out.println("������� ���� �Ϸ�");
               }else if(count==(dbList.size()-1)) {
                  //������ �������� ����� �߰����� ����
                  System.out.println("�ش� ��ȣ�� ��������� �������� �ʽ��ϴ�");
               }
               
            }
         }else {
            System.out.println("���� ����");
         }
   }
   
   
   //ID PW Index�� ������� ã��
   public boolean isExist(int index,String ID,String PW) {
      //ID PW Index�� ������� ã��
      //true false ��ȯ
      for(int count=0;count<dbList.size();count++) {      
         if((dbList.elementAt(count).getIndex()==index)&&(dbList.elementAt(count).getID()==ID)&&(dbList.elementAt(count).getPW()==PW)){
            return true;//������� ã��
         }
      }
      return false;//������� ã������
   }


   
   
   
}