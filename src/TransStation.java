import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class TransStation {
       Read r=new Read();
       public HashSet <String> transSet;
       public ArrayList <String> transList;
       public TransStation() {
    	   this.transSet=new HashSet <String> ();
    	   this.transList=new ArrayList <String> ();
    	   for(int i=0;i<r.stationList.size();i++) {
    		   for(int j=0;j<r.stationList.size();j++) {
    			   if(i!=j&&r.stationList.get(i).name.equals(r.stationList.get(j).name)) {  //如果在stationList中出现两次，则为换乘站
    				   transSet.add(r.stationList.get(i).name);
    			   }
    		   }
    	   }
    	   Iterator <String> it=transSet.iterator();
    		while(it.hasNext()) {
    			transList.add(it.next());
    		}
    	   
       }
}
