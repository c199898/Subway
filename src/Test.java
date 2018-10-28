


public class Test {
	
    public static void main(String[] args) {
    	Read r=new Read();
        SearchPath sp=new SearchPath();
           int x=r.nameList.indexOf("天河机场");
           int y=r.nameList.indexOf("友谊路");
           if(x!=-1&&y!=-1) {
           sp.floyd(x,y);
           sp.finalPrint();
           }
           else {
        	   System.out.println("输入错误");
           }

        
}  
    
    
    
    
    
}
    

