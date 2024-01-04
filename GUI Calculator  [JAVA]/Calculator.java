import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame implements ActionListener{
   
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JTextField textfield;
    JLabel numLabel;
    JPanel panel1,panel2;
    JButton num[] = new JButton[10];
    JButton functionButtons[] = new JButton[9];
    JButton add,mul,sub,div,equal,clr,del,dec,sign;
    Font myfont = new Font("Monospace",Font.BOLD,24);
    char operator=' ';
    int ind ;;
    double num1,num2,ans;
    
    Calculator() {
        
        this.setLocation(600,150);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 560);

        this.getContentPane().setBackground(new Color(255, 134, 27));
        this.setTitle("GUI Calculator By Subham");
        
        addTextfield();

        numLabel = new JLabel("");
        numLabel.setFont(new Font("sans serif",Font.BOLD,20));
        numLabel.setBounds(0,-12,350,40);
        textfield.add(numLabel);

        addNumButtons();
        addFuncButtons();
        addPanels();
        
        this.setLayout(null);
        this.setResizable(false);
        this.setVisible(true);
    }
    void addTextfield(){
        
        textfield = new JTextField();
        textfield.setEditable(false);
        textfield.setFocusable(false);
        textfield.setBounds(20, 15, 350, 70);
        textfield.setBackground(new Color(38, 231, 146));
        textfield.setHorizontalAlignment(SwingConstants.RIGHT);
        //textfield.setBackground(Color.WHITE);
        textfield.setBorder(null);
        textfield.setFont(myfont);
        this.add(textfield);

    }

    void addPanels(){

        panel2 = new JPanel();
        panel2.setBounds(30, 110, 330, 75);
        panel2.setBackground(new Color(0 , 0, 0, 150));
        panel2.setLayout(new FlowLayout(FlowLayout.LEADING));
        this.add(panel2);
        
        panel2.add(functionButtons[6]);
        panel2.add(functionButtons[8]);
        panel2.add(functionButtons[7]);


        panel1 = new JPanel();
        panel1.setBounds(30, 190, 330, 330);
        panel1.setBackground(new Color(0,0,0, 150));
        panel1.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.add(panel1);

        panel1.add(num[7]);
        panel1.add(num[8]);
        panel1.add(num[9]);
        panel1.add(functionButtons[0]);
        panel1.add(num[4]);
        panel1.add(num[5]);
        panel1.add(num[6]);
        panel1.add(functionButtons[1]);
        panel1.add(num[1]);
        panel1.add(num[2]);
        panel1.add(num[3]);
        panel1.add(functionButtons[2]);
        panel1.add(functionButtons[5]);
        panel1.add(num[0]);
        panel1.add(functionButtons[4]);
        panel1.add(div);

    }

    void addNumButtons(){
        for(int i=0;i<10;i++){
            num[i] = new JButton(i+"");
            num[i].setFont(myfont);
            num[i].setFocusable(false);
            num[i].setPreferredSize(new Dimension(75 ,75));
            num[i].addActionListener(this);
            num[i].setBackground(new Color(16, 23, 20));
            num[i].setForeground(Color.white);
        }

    }

    void addFuncButtons(){
        add = new JButton("+");
        sub = new JButton("-");
        mul = new JButton("*");
        div = new JButton("/");
        equal = new JButton("=");
        clr = new JButton("Clr");
        del = new JButton("\uF0E7");
        dec = new JButton(".");
        sign = new JButton("+/-");
    
        functionButtons[0] = add;
        functionButtons[1] = sub;
        functionButtons[2] = mul;
        functionButtons[3] = div;
        functionButtons[4] = equal;
        functionButtons[5] = del;
        functionButtons[6] = clr;
        functionButtons[7] = dec;
        functionButtons[8] = sign;
        
        for(int i=0;i<9;i++){
            functionButtons[i].setBackground(new Color(245, 233, 51));
            functionButtons[i].setFont(myfont); //Change
            functionButtons[i].setFocusable(false);
            functionButtons[i].setPreferredSize(new Dimension(75 ,75));
            functionButtons[i].addActionListener(this);
        }
        functionButtons[6].setPreferredSize(new Dimension(104 ,65));
        functionButtons[7].setPreferredSize(new Dimension(104 ,65));
        functionButtons[8].setPreferredSize(new Dimension(104 ,65));
    }

    public void actionPerformed(ActionEvent ae){
        
        String string = textfield.getText();
        
        for(int i=0;i<10;i++){
            if(ae.getSource() == num[i]) {
                textfield.setText(textfield.getText()+i+"");
            }
        }

        if(ae.getSource() == clr){
            textfield.setText(null);
            numLabel.setText(null);
        }

        if(ae.getSource() == del){
            textfield.setText("");
            for(int i=0;i<string.length()-1;i++) {
                textfield.setText(textfield.getText()+string.charAt(i));
            }
        }

        if(ae.getSource() == dec){
            if(textfield.getText().compareTo("")>0){
                if(textfield.getText().contains(".")){
                return;
                }
                else{
                    textfield.setText(textfield.getText()+".");
                }
            }
        }
        
        if(ae.getSource() == add){
            operator='+';
            numLabel.setText(textfield.getText()+"+");
            num1=Double.parseDouble(textfield.getText());
            textfield.setText("");
        }
        if(ae.getSource() == sub){
            operator='-';
            numLabel.setText(textfield.getText()+"-");
            num1=Double.parseDouble(textfield.getText());
            textfield.setText("");
        }
        if(ae.getSource() == mul){
            operator='*';
            numLabel.setText(textfield.getText()+"*");
            num1=Double.parseDouble(textfield.getText());
            textfield.setText("");
        }
        if(ae.getSource() == div){
            operator='/';
            numLabel.setText(textfield.getText()+"/");
            num1=Double.parseDouble(textfield.getText());
            textfield.setText("");
        }
    
        try{
            if(ae.getSource()==functionButtons[4]){
                numLabel.setText(numLabel.getText()+textfield.getText());
                num2 = Double.parseDouble(textfield.getText());
                switch(operator){
                    case '+':   ans=num1+num2;
                        textfield.setText(Double.toString(ans));
                        System.out.println(num1+"+"+num2+"="+ans);
                        break;
                    case '-':   ans=num1-num2;
                        textfield.setText(Double.toString(ans));
                        break;
                    case '*':   ans=num1*num2;
                        textfield.setText(Double.toString(ans));
                        break;
                    case '/':   

                        try{
                            ans=num1/num2;
                            textfield.setText(Double.toString(ans));
                            break;
                        } catch(ArithmeticException are){
                            System.err.println(are);
                        }
                    default:
                        dispose();

                }
            }
        } catch(Exception e){
            System.err.println(e);
            //e.printStackTrace();
        }

        if(ae.getSource() == sign){
            double temp = Double.parseDouble(textfield.getText());
            temp *=-1;
            textfield.setText(Double.toString(temp));
        }
    }


    public static void main(String[] args) {
        new Calculator();
    }
}