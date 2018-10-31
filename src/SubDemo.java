import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class SubDemo extends JFrame implements ActionListener  {
	Read r=new Read();

    Function f=new Function();
    JTextField messageText1;
    JTextField messageText2;
    JTextField messageText3;
    JTextField messageText4;
    JTextField messageText5;
    JButton Button1;  //确认1
    JButton Button2;  //确认2
    JButton Button3;  //确认3
    JTextArea resultText;
    
    public SubDemo() {
    	super("地铁模拟系统");
    	
    	Container c=this.getContentPane();
    	c.setLayout(new GridLayout(4,1));
    	JPanel Panel1=new JPanel(new FlowLayout());  //功能1
    	JPanel Panel2=new JPanel(new FlowLayout());  //功能2
    	JPanel Panel3=new JPanel(new FlowLayout());  //功能3
    	JPanel Panel4=new JPanel(new FlowLayout());  //输出框
    	messageText1=new JTextField(6);    //功能1 站点名
    	messageText2=new JTextField(6);    //功能2 线路名   
    	messageText3=new JTextField(6);    //功能2 终点站
    	messageText4=new JTextField(6);    //功能3 起点站
    	messageText5=new JTextField(6);     //功能3 终点站
    	JLabel messageLabel1=new JLabel("请输入站点名：");
    	JLabel messageLabel2=new JLabel("请输入线路名：");
    	JLabel messageLabel3=new JLabel("请输入终点方向：");
    	JLabel messageLabel4=new JLabel("请输入起点站：");
    	JLabel messageLabel5=new JLabel("请输入终点站：");
    	Button1=new JButton("确认");
    	Button2=new JButton("确认");
    	Button3=new JButton("确认");
    	resultText=new JTextArea("结果：",10,60);
    	JScrollPane js=new JScrollPane (resultText);
    	Panel1.add(messageLabel1);
    	Panel1.add(messageText1);
    	Panel1.add(Button1);
    	Panel2.add(messageLabel2);
    	Panel2.add(messageText2);
    	Panel2.add(messageLabel3);
    	Panel2.add(messageText3);
    	Panel2.add(Button2);
    	Panel3.add(messageLabel4);
    	Panel3.add(messageText4);
    	Panel3.add(messageLabel5);
    	Panel3.add(messageText5);
    	Panel3.add(Button3);
    	Panel4.add(js);
    	c.add(Panel1);
    	c.add(Panel2);
    	c.add(Panel3);
    	c.add(Panel4);
    	
    	Button1.addActionListener(this);
    	Button2.addActionListener(this);
    	Button3.addActionListener(this);
    	
    	js.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS); 
    	js.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    	
    	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	this.setSize(660,580);
    	this.setVisible(true);
    		
    }
    
    
    public static void main(String[] args) {
    	SubDemo s=new SubDemo();
    }
    
    public void actionPerformed(ActionEvent e) {
    	if(e.getSource()==Button1) {
         String s=messageText1.getText();
         resultText.setText("结果：\n");
         f.search(s);
         for(int i=0;i<f.result1.size();i++) {
        	 resultText.append(f.result1.get(i)+"\n");
         }
    	}
    	if(e.getSource()==Button2) {
    		resultText.setText("结果:");
    		resultText.append("\n");
    		String way=messageText2.getText();
    		String end=messageText3.getText();
    		for(int i=0;i<f.toEnd(way, end).length;i++) {
    			resultText.append(f.toEnd(way, end)[i]+"\n");
    		}
    	}
    	if(e.getSource()==Button3) {
    	    SearchPath sp=new SearchPath();
    		resultText.setText("结果:");
    		resultText.append("\n");
    		String begin=messageText4.getText();
    		String end=messageText5.getText();
    		int x=r.nameList.indexOf(begin);
            int y=r.nameList.indexOf(end);
            if(x!=-1&&y!=-1) {
                sp.floyd(x,y);
                sp.finalPrint();
                for(int i=0;i<sp.result1.size();i++) {
                	resultText.append(sp.result1.get(i)+"\n");
                }
                for(int i=0;i<sp.result2.size();i++) {
                	resultText.append(sp.result2.get(i)+"\n");
                }
                }
                else {
             	   resultText.append("输入错误");
                }
    	}
    }
    
    
    
    
    

}
