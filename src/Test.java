


public class Test {
	
    public static void test() {
    	Read r=new Read();
        SearchPath sp=new SearchPath();
           int x=r.nameList.indexOf("光谷广场");
           int y=r.nameList.indexOf("武昌火车站");
           if(x!=-1&&y!=-1) {
           sp.floyd(x,y);
           sp.finalPrint();
           }
           else {
        	   System.out.println("输入错误");
           }

        
}  
    
    
    
    
    
}
    

