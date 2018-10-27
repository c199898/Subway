public class SearchPath {
       double[][] dis=new double[160][160];
       int[][] path=new int[160][160];
       int inf=100;
       int x,y;
       Read r=new Read();
       
       
       
       public void init() {
    	   
           for(int i=0;i<160;i++) {
        		 for(int j=0;j<160;j++) {
        			 if(i==j)  dis[i][j]=0;
        			 else dis[i][j]=inf;
        	 }
        	 }   //初始化
       
          for(int i=0;i<185;i++) {     //遍历原始数据类数组
        	  String Tstation=r.rawList.get(i).thisStation;    
        	  String Nstation=r.rawList.get(i).nextStation;   //读出每一条之间的两个站
        	  x=r.nameList.indexOf(Tstation);
        	  y=r.nameList.indexOf(Nstation);   //获得两站在nameList中的索引位置
        	  dis[x][y]=Double.valueOf(r.rawList.get(i).distance);
        	  dis[y][x]=Double.valueOf(r.rawList.get(i).distance);
          }
      
           
           }
       
       
       public void floyd(int x,int y) {
    	   init();
    	   for(int k=0;k<160;k++)
    		    //做n次迭代，每次均试图将顶点k扩充到当前求得的从i到j的最短路径pij上
    		     {
    		      for(int i=0;i<160;i++)
    		      {
    		       for(int j=0;j<160;j++)
    		       {
    		        if(dis[i][j]>(dis[i][k]+dis[k][j]))
    		        {
    		         dis[i][j]=dis[i][k]+dis[k][j];  //修改长度
    		         path[i][j]=path[i][k];    //修改路径
    		        }
    		       }
    		     }
    		    }
    	   System.out.println(dis[x][y]);
    	   

       }

        
     
     
}
