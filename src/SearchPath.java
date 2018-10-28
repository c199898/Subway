import java.util.ArrayList;

public class SearchPath {
       double[][] dis=new double[160][160];
       int[][] path=new int[160][160];
       int inf=100;
       int x;
       int y;
       int next;
       int normalPrice;
       String Way;
       String Way2;
       public ArrayList <String> pathList;
       Read r=new Read();
       TransStation t=new TransStation();
       
       public SearchPath() {
    	   this.pathList=new ArrayList <String>();
       }
       
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
       
       public void floyd(int x,int y) {   //x和y为站点名在nameList中的索引位置  x=r.nameList.indexOf("站名")
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
    		        pathList.add(r.nameList.get(x));
    		        while(next!=y)
    		        {
    		          pathList.add(r.nameList.get(next));
    		          System.out.println("——>"+r.nameList.get(next));  //打印后继点
    		          next=path[next][y];        //继续找下一个后继点
    		         }
    		           pathList.add(r.nameList.get(y));
    		           System.out.println("——>"+r.nameList.get(y));       //打印终点
    		        }
    		      }
    		     
       

       
    		}
       
       public void finalPrint() {
    	   for(int i=0;i<r.rawList.size();i++) {
    	  if(r.rawList.get(i).thisStation.equals(pathList.get(0))&&r.rawList.get(i).nextStation.equals(pathList.get(1))){
             Way=r.rawList.get(i).way;
           }
    	  else if(r.rawList.get(i).thisStation.equals(pathList.get(1))&&r.rawList.get(i).nextStation.equals(pathList.get(0))) {
    		 Way=r.rawList.get(i).way;
    	  }
       }
    	   System.out.println("乘坐"+Way);
           for(int i=2;i<pathList.size();i++){
        	   for(int j=0;j<r.rawList.size();j++){
        		   if(t.transList.indexOf(pathList.get(i))!=-1) {  //pathList[i]为换乘站
        			   if(r.rawList.get(j).thisStation.equals(pathList.get(i))&&r.rawList.get(j).nextStation.equals(pathList.get(i+1))){
        		             Way2=r.rawList.get(j).way;
        		           }    
        		    	  else if(r.rawList.get(j).thisStation.equals(pathList.get(i+1))&&r.rawList.get(j).nextStation.equals(pathList.get(i))) {
        		     		 Way2=r.rawList.get(j).way;
        		     	  } 

        	  	   }


        		}
        		    if(Way.equals(Way2)==false&&Way2!=null) {
        			System.out.println("在"+pathList.get(i)+"换乘"+Way2);
        			Way=Way2;
        		  }  
        	  }

        		  
           
           
           
           
           
        			  
        	  }

          
          
          
          
       
       
       
       
}

       



       


    	   
    	   
    	
    		    
    		    
    		    
    		    
    		    
    	   
       

        
     
     

