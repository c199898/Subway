import java.util.Scanner;
import java.util.ArrayList;

public class Function {
     Read r=new Read();
     
     
	public void search() {
		int flag=0;
		String ss = null;
		Scanner sc=new Scanner(System.in);
		System.out.println("请输入站名：");
		while(sc.hasNext()) {
		ss=sc.nextLine();	
		for(int i=0;i<r.stationList.size();i++) {
			if(ss.equals(r.stationList.get(i).name)) {
				flag=1;
				System.out.println(r.stationList.get(i).way);
			}
		}
		if(flag==0) System.out.println("没有该站点");
		}
		
	}
	
	
	public String[] toEnd(String way,String endStation) {
		int start=0;
		int end=0;
		ArrayList <String> List= new ArrayList <String> ();
		if(way.equals("1号线")) {start=0;end=31;}
	    else if(way.equals("2号线")) {start=32;end=59;}
		else if(way.equals("3号线")) {start=60;end=83;}
		else if(way.equals("4号线")) {start=84;end=111;}
		else if(way.equals("6号线")) {start=112;end=138;}
		else if(way.equals("7号线")) {start=139;end=157;}
		else if(way.equals("8号线")) {start=158;end=168;}
		else if(way.equals("阳逻线")) {start=169;end=184;}
		else if(way.equals("11号线东段")) {start=185;end=197;}
		if(endStation.equals(r.stationList.get(end).name)) {
			for(int i=start;i<=end;i++) {
				List.add(r.stationList.get(i).name);
			}
			}
			else if(endStation.equals(r.stationList.get(start).name)) {
				for(int i=end;i>=start;i--) {
					List.add(r.stationList.get(i).name);
				}
			}
		String[] result = (String[])List.toArray((new String[0]));
		return result;
		}
}
