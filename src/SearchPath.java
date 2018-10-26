public class SearchPath {
       double[][] s=new double[160][160];
       double[] dis=new double[160];
       double[] book=new double[160];
       int inf=99999;
       int x,y;
       Read r=new Read();
       
       
       
       public void init() {
           for(int i=0;i<160;i++) {
        		 for(int j=0;j<160;j++) {
        			 if(i==j)  s[i][j]=0;
        			 else s[i][j]=inf;
        	 }
        	 }   //初始化
       
          for(int i=0;i<185;i++) {     //遍历原始数据类数组
        	  String Tstation=r.rawList.get(i).thisStation;    
        	  String Nstation=r.rawList.get(i).nextStation;   //读出每一条之间的两个站
        	  x=r.nameList.indexOf(Tstation);
        	  y=r.nameList.indexOf(Nstation);   //获得两站在nameList中的索引位置
        	  s[x][y]=Double.valueOf(r.rawList.get(i).distance);
        	  s[y][x]=Double.valueOf(r.rawList.get(i).distance);
          }
      
           
           
           
           
           
           
           }
       
       

        
     
     
}
