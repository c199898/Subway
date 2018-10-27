import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class Read {
    public ArrayList <Raw> rawList;
    public ArrayList <Station> stationList;
    public HashSet <String> stationName;
    public ArrayList <String> nameList;
    public Read() {
    	this.rawList=new ArrayList <Raw> ();
    	this.stationList=new ArrayList <Station> ();
    	this.nameList=new ArrayList <String> ();  //存放唯一站点名
    	this.stationName=new HashSet<>();    //去除站点名中的重复元素
    	String str ="1号线";
	try {
	File file = new File("subway.txt");
	BufferedReader br = new BufferedReader(new FileReader(file));
	String line=null;
	while((line=br.readLine())!=null) {     //判断是几号线
        if(line.equals("1号线站点间距")) str="1号线";
        else if(line.equals("2号线站点间距")) str="2号线";
        else if(line.equals("3号线站点间距")) str="3号线";
        else if(line.equals("4号线站点间距")) str="4号线";
        else if(line.equals("6号线站点间距")) str="6号线";
        else if(line.equals("7号线站点间距")) str="7号线";
        else if(line.equals("8号线站点间距")) str="8号线";
        else if(line.equals("阳逻线站点间距")) str="阳逻线";
        else if(line.equals("11号线东段站点间距")) str="11号线东段";
        else{
        String[] temp = line.split("\t");     //按tab分割
		rawList.add(new Raw(str,temp[0],temp[1],temp[2]));   //创捷原始类对象，存入动态数组
		}
		
	}
	br.close();
	}
	catch(Exception e) {
		 System.err.println("read errors :" + e);
	}
	
	
	for(int j=0;j<rawList.size();j++) {
		stationList.add(new Station(rawList.get(j).way,rawList.get(j).thisStation,Double.parseDouble(rawList.get(j).distance)) );
	} 
	
	for(int i=0;i<=185;i++) {
		stationName.add(stationList.get(i).name);
	}
	
	
	Iterator <String> it=stationName.iterator();
	while(it.hasNext()) {
		nameList.add(it.next());
	}
	
    
    }
    

}