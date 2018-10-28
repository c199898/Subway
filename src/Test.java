


public class Test {
	
    public static void main(String[] args) {
    	Read r=new Read();
        SearchPath sp=new SearchPath();
           int x=r.nameList.indexOf("武汉火车站");
           int y=r.nameList.indexOf("光谷广场");
           sp.floyd(x, y);
           sp.finalPrint();
        
}  
    
    
    
    
    
}
    

