
public class Station {
      String way;
      String name;
      double disToNext;
      public Station(String way,String name,double disToNext) {
    	 this.way=way;
    	 this.name=name;
    	 this.disToNext=disToNext;
      }
      
      public String returnWay(String aname) {
    	  if(aname.equals(this.name)) {
    		  return this.way;
    	  }
    	  else return null;
    		 
      }
}
