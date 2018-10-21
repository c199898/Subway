import java.util.Scanner;

public class Test {
	Read r=new Read();
	public void search() {
		String ss = null;
		Scanner sc=new Scanner(System.in);
		System.out.println("请输入站名：");
		while(sc.hasNext()) {
		ss=sc.nextLine();	
		for(int i=0;i<r.stationList.size();i++) {
			if(ss.equals(r.stationList.get(i).name)) {
				System.out.println(r.stationList.get(i).way);
			}
			else System.out.println("没有该站点");
		}
		}
		

	}
	
	
	
	
	
    public static void main(String[] args) {
          Test t=new Test();
          t.search();
          }
}  
