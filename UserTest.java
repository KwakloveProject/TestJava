package kn.edu.seiralizable;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class UserTest 
{
	public static Scanner sc = new Scanner (System.in);
	public static void main (String [] args) throws ClassNotFoundException, IOException 
	{
		//메뉴선택
	
		boolean initialErrorFlag = false;
		boolean flag = false;
		List<User> list =new ArrayList<User>();		
		//해당된 함수이동	
		while(!flag)
	{
		int number = inputMenu();
		switch(number) 
		{   
			case 1 : list = loading(); break;
			case 2 :  PrintList(list);	break;
			case 3 :rewriteList(list);break;
			case 4 : deleteList(list);break;
			case 5 : sortedList(list);break;
			case 6 : searchList(list);break;
			case 7 : insertList(list);
			break;
			case 8 : initialErrorFlag = Initialization();
         if(initialErrorFlag == false) 
			{
				System.out.println("빨리 복구중입니다");
				System.exit(1);
			}
			flag = true;
			
			break;
			case 9 : flag =true;  break;
			case 10: saveList(list); break;
			default: break;
		}
	
	
	}//end of while
	
	
	
	
	
	}
	private static void searchList(List<User> list) 
	{
		System.out.println("검색하실 List의 이메일을 입력해주세요");
		String email = sc.nextLine();
		boolean falg = false;
		for(User data :list) 
		{
			if(data.getEmail().equals(email)) 
			{
				System.out.println(data);
				falg=true;
			}
		}
		if(falg == false) 
		{
			System.out.println("오류");
		}
	
	}
		
		
	
	private static void sortedList(List<User> list)
	{
				list.sort(null);
	}
	private static void deleteList(List<User> list) 
	{
		System.out.println(" 삭제하실List의 email를 입력하시오");
		String email= sc.nextLine();
		boolean falg = false;
		for(User data :list) 
		{
			if(data.getEmail().equals(email)) 
			{
				list.remove(data);
				falg=true;
				break;
			}
		}
		if(!falg) 
		{
			System.out.println("오류");
		}
	}
	private static void rewriteList(List<User> list) 
	{
		System.out.println("몇번째 List수정하실지 입력하시오");
			int i =sc.nextInt();
			System.out.println("list에 수정하실 정보를 입력하시오");
			list.get(i).setName(sc.next());
			list.get(i).setPassword(sc.next());
			list.get(i).setEmail(sc.next());
			list.get(i).setAge(sc.nextInt());
			
		
		
	}
	private static void saveList(List<User> list) 
	{
		ObjectOutputStream oos =null;
		try 
		{
		 oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(new File("user.dba"))));
		 oos.writeObject(list);
		 System.out.println("직렬화 성공");
		} 
		catch(IOException e) 
		{
			System.out.println("오류가 발생"+ e.toString());
		}
		finally 
		{
		try 
		{
			oos.close();
		}
		catch (IOException e) 
		{
			System.out.println("오류가 발생"+ e.toString());
		}
		
		}
	}
		
	
	private static void insertList(List<User> list) 
	{
		System.out.println("추가 하실 이름과 비밀번호와 이메일과 나이를 입력해주세요");
		list.add(new User(sc.next() , sc .next() , sc.next(),sc.nextInt()));
		
	}
	private static void PrintList(List<User> list )
	{
		for(User data : list) 
		{
			System.out.println(data);
		}
		
	}
	//file에서 가져오기
	private static List<User> loading() throws IOException, ClassNotFoundException 
	{
	try{
			ArrayList <User> list = null;
			File file = new File("user.dba");
			FileInputStream fis = new FileInputStream(file);
			BufferedInputStream bis = new BufferedInputStream(fis);
			ObjectInputStream ois = new ObjectInputStream(bis);
			list =(ArrayList<User>)ois.readObject();
			return list;
		}	 
		catch (Exception e) 
	        {
	        return new ArrayList<User>();
	        }
	    }
	private static boolean Initialization() 
	{
		boolean initialErrorFlag = false;
		
		ArrayList<User> list =new ArrayList<>();
		list.add(new User("kdj", "12345678", "kdj.gmail.com", 20));
		list.add(new User("ldj", "12345679", "ldj.gmail.com", 21));
		list.add(new User("pdj", "12345671", "pdj.gmail.com", 22));
		list.add(new User("odj", "12345672", "odj.gmail.com", 23));
		list.add(new User("udj", "12345673", "udj.gmail.com", 24));
		
	
		ObjectOutputStream oos =null;
		try 
		{
		 oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(new File("user.dba"))));
		 oos.writeObject(list);
		 System.out.println("직렬화 성공");
		 initialErrorFlag = true;
		} 
		catch(IOException e) 
		{
			System.out.println("오류가 발생"+ e.toString());
		}
		finally 
		{
		
		try 
		{
			oos.close();
		}
		catch (IOException e) 
		{
			System.out.println("오류가 발생"+ e.toString());
		}
		
		}
		return initialErrorFlag;
	}
	private static int inputMenu() 
	{
		System.out.println("=====================SIUUUUUUUUUUUUU======================");
		System.out.println("1. 로딩 2.출력 3. 수정 4. 삭제 5.정렬 6.검색 7.추가 8.초기화 9.종료 10 .저장");
		int num = sc.nextInt();
		sc.nextLine();
		return num;
	}
		
}

