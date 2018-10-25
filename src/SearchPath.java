
public class SearchPath {
       int[][] s=new int[185][185];
       int[] dis=new int[185];
       int[] book=new int[185];
       int inf=99999999;
       Read r=new Read();
       double count=0;
       
       public double calculateDistance(int i1,int i2) {//i1,i2为车站在动态数组中的索引位置
    	   for(int x=i1;x<i2;x++) {
    		   count=count+r.stationList.get(x).disToNext;
    	   }
    	   return count;
       }
       
       
       
       
       
       
     public void Path() {
    	 for(int i=0;i<185;i++) {
    		 for(int j=0;j<185;j++) {
    			 if(i==j)  s[i][j]=0;
    			 else s[i][j]=inf;
    		 }
    	 }
     }                                       //初始化
         
     
     
}
