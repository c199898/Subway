import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class Read {
    private ArrayList <Raw> rawList;
    public ArrayList <Station> stationList;
    public Read() {
    	this.rawList=new ArrayList <Raw> ();
    	this.stationList=new ArrayList <Station> ();
    	String str ="1号线";
	try {
	File file = new File("subway.txt");
	BufferedReader br = new BufferedReader(new FileReader(file));
	String line=null;
	while((line=br.readLine())!=null) {
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
        String[] temp = line.split("\t");
		rawList.add(new Raw(str,temp[0],temp[1],temp[2]));
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
    }
    
    
    public  void print() {
    	for (int i=0;i<rawList.size();i++) {
    		System.out.println(stationList.get(i).way+":"+stationList.get(i).name+stationList.get(i).disToNext);
    	}
    }
    

    

}