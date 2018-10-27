public class SearchPath {
       double[][] dis=new double[160][160];
       int[][] path=new int[160][160];
       int inf=100;
       int x,y,next;
       int normalPrice;
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
      
          for(int i=0;i<160;i++)//设置A和path的初值
        	     {
        	      for(int j=0;j<160;j++)
        	      {
        	       if(dis[i][j]!=inf)
        	        path[i][j]=j;   //j是i的后继
        	       else
        	        path[i][j]=0;
        	      }
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
    	   
    	      //判断价格
    	       if(dis[x][y]<=9) normalPrice=2;
    	       else if(dis[x][y]>9&&dis[x][y]<=14) normalPrice=3;
    	       else if(dis[x][y]>14&&dis[x][y]<=21) normalPrice=4;
    	       else if(dis[x][y]>21&&dis[x][y]<=30) normalPrice=5;
    	       else if(dis[x][y]>30&&dis[x][y]<=41) normalPrice=6;
    	       else if(dis[x][y]>41&&dis[x][y]<=54) normalPrice=7;
    	     //输出距离和价格
              System.out.println("距离为："+dis[x][y]);
              System.out.println("普通票价格为："+normalPrice);
              System.out.println("武汉通价格为："+normalPrice*0.9);
              System.out.println("日票价格为：0");
    	    //打印路径
    		       if(x!=y)
    		       {
    		        next=path[x][y];        //next为起点i的后继顶点
    		       System.out.println("输出路径");
    		       if(next==0)
    		       System.out.println("不可达");
    		       else//Pij存在
    		       {
    		        System.out.println(r.nameList.get(x));
    		        while(next!=y)
    		        {
    		          System.out.println("——>"+r.nameList.get(next));  //打印后继点
    		          next=path[next][y];        //继续找下一个后继点
    		         }
    		            System.out.println("——>"+r.nameList.get(y));       //打印终点
    		        }
    		      }
    		     
       

       
    		}
       
       
}

    	   
    	   
    	
    		    
    		    
    		    
    		    
    		    
    	   
       

        
     
     

