
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
/**
 *
 * @author zafer
 */
public class color extends JFrame {

    public static int num = 1;
    ImageIcon bckg = new ImageIcon("image/bckg.jpg");
    

    public static int[][] a=new int[5][5];
    int sayac = 1;
    
    //Game Board background pic.
    public void paint(Graphics g) 
      { 
          g.drawImage(bckg.getImage(), 0, 7, getWidth(), getHeight(), null); 
          
      } 
       
    // This is check matris from console.
    public void yazdir(){ 
        
        for (int i = 0; i < 4; i++) 
            {
                for (int j = 0; j < 4; j++) { 
			System.out.print(a[i][j] + "  ");
		}
			System.out.println();
            }
        System.out.println("-------");
    }
    
    public color(int x){ 
        
        
        JPanel p = new JPanel();
        //p.add(bckg);
     setLayout(null);
     setSize(600, 650);
     setDefaultCloseOperation(EXIT_ON_CLOSE);
     Font org = new Font("MonoSpaced", (Font.BOLD), 40);
     
     //Homescreen Settings
     JLabel sudoku = new JLabel("COLOR");
     JLabel sudoku2 = new JLabel("SUDOKU");
     JButton ngame = new JButton("New Game");
     sudoku.setFont(org);
     sudoku2.setFont(org);
     sudoku2.setBounds(150,70,200,80);
     sudoku.setBounds(100,0,200,80);
     ngame.setBounds(150,350,300,50);
     ngame.addActionListener(new ActionListener(){
         @Override
         public void actionPerformed(ActionEvent e) {
             
             if(e.getSource()==ngame){
                 
                 int rand = (int) (Math.random()*4)+1;
                 
                 switch(rand) { //Template game coordinate
                    case 1:
                        a[0][2] = 4; 
                        a[1][2] = 1; a[3][1] = 1;//yellow
                        a[2][1] = 3;//blue
                        
                        break;
                    case 2:
                        a[0][1] = 1;//yellow
                        a[1][1] = 2; a[3][2] = 2;//green
                        a[2][2] = 3;//blue
                        break;
                    case 3:
                        a[0][1] = 2;//green
                        a[2][0] = 4; a[3][2] = 4;//red
                        a[1][3] = 3;//blue
                        break;
                    case 4:
                        a[1][2] = 4;//red
                        a[1][3] = 3; a[2][1] = 3;//blue
                        a[2][0] = 1;//yellow
                        break;
                     default:
                        // code block
                    }
                 
                new color();
                setVisible(false);
                  
             }
         }
     });
     //initialize homescreen
     add(sudoku);
     add(sudoku2);
     add(ngame);
     setVisible(true);
        
    }
    
    public color(){
        
     
     Container pane = this.getContentPane();
     pane.setLayout(null);
     JPanel p1=new JPanel();
     //JPanel p2=new JPanel();
     //JPanel p3=new JPanel();
     JButton check = new JButton("Check");
     Font org = new Font("MonoSpaced", (Font.BOLD), 40);
     
     
     //Table Creating

     for(int i = 0;i<4;i++){
         
         for(int p = 0 ; p<4 ; p++){
             
            final JButton btn_ij = new JButton(Integer.toString(sayac)); //Create cell
            if(sayac%10  ==  4  ){sayac+=7;}else sayac++;  
                                                                                    
            btn_ij.setBounds((p+1)*100, (i+1)*100, 94, 94);                                   
            btn_ij.setName(Integer.toString(i) + Integer.toString(p));  
            btn_ij.setOpaque(true);
            btn_ij.setBorderPainted(false);
            
            
            switch(a[i][p]) {   //Template game painting
                         
                        case 0 :
                             btn_ij.setBackground(Color.white); 
                             btn_ij.setForeground(Color.white);
                          break;    
                        case 1 :
                             btn_ij.setBackground(Color.yellow);
                             btn_ij.setForeground(Color.yellow);
                             btn_ij.setEnabled(false);
                             btn_ij.setText("");
                          break;
                        case 2 :
                           btn_ij.setBackground(Color.green);
                           btn_ij.setForeground(Color.green);
                           btn_ij.setEnabled(false);
                             btn_ij.setText("");
                        break;
                        case 3 :
                             btn_ij.setBackground(Color.blue);
                             btn_ij.setForeground(Color.blue);
                             btn_ij.setEnabled(false);
                             btn_ij.setText("");
                         break;
                        case 4:
                             btn_ij.setBackground(Color.red);
                             //btn_ij.setForeground(Color.red);
                             btn_ij.setEnabled(false);
                             btn_ij.setText("");
                         }
            
            
            pane.add(btn_ij);
            
            btn_ij.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent c) {
                    
                    if(c.getSource()==btn_ij)
                    {
                        
                        int k,l;
                        int b = (int) Integer.parseInt(btn_ij.getText()); // get button name and information
                        k = b%10; //k is matrix first box value
                        l = b/10; // l is matrix second box value
                        
                        
                        switch(num) {
                         case 1 :
                             btn_ij.setBackground(Color.YELLOW);
                             btn_ij.setForeground(Color.YELLOW);
                             a[l][k-1] = num;
                             num=2;
                          break;
                        case 2 :
                           btn_ij.setBackground(Color.green);
                           btn_ij.setForeground(Color.green);
                           a[l][k-1] = num;
                            num=3; 
                        break;
                        case 3 :
                             btn_ij.setBackground(Color.blue);
                             btn_ij.setForeground(Color.blue);
                             a[l][k-1] = num;
                             num=4;
                         break;
                        case 4:
                             btn_ij.setBackground(Color.red);
                             btn_ij.setForeground(Color.red);
                             a[l][k-1] = num;
                             num=1;
                         break;
                       
                         }   
                    }
                }
            });
         }
         
     }

     check.addActionListener(new ActionListener(){
         @Override
            public void actionPerformed(ActionEvent e) {
                check.setBorderPainted(true);
              if(e.getSource()==check){
                  int x = 0;
                   yazdir();
                       
                        //row control
                     
                      for(int col = 0; col < 4; col++)
                        for(int row = 0; row < 3; row++)
                           for(int row2 = row + 1; row2 < 4; row2++)
                              if(a[col][row]==a[col][row2])
                              x=1;
                       
                       //column control
                      
                       for(int row = 0; row < 4; row++)
                        for(int col = 0; col < 3; col++)
                           for(int col2 = col + 1; col2 < 4; col2++)
                              if(a[col][row]==a[col2][row])
                                 x=1;
                   
                   
                   //Box control 2x2
                 
                   
                   for(int row = 0;row<4;row+=2)
                        for(int col = 0;col<3;col+=2){
                       
                            if(a[row][col] != a[row][col+1] && a[row][col+1] != a[row+1][col] && a[row+1][col] != a[row+1][col+1]&&
                               a[row][col] != a[row+1][col] && a[row][col] != a[row+1][col+1] && a[row][col+1] != a[row+1][col+1])

                                  System.out.println("Box Check is Correct!");
                               else {x = 1;System.out.println("Box Check is InCorrect!");} 

                         }
                   
                   if(x == 1) JOptionPane.showMessageDialog(rootPane, "Something Is Wrong! Change Some Box And Be Careful ", "Fault!", JOptionPane.PLAIN_MESSAGE);
                   else JOptionPane.showMessageDialog(rootPane, "Congralations! You Done! ", "Bravo!", JOptionPane.PLAIN_MESSAGE); 
                   
              }
            }

        });
     //Table Background
     //p1.setBackground(Color.black);
    // p1.setBounds(90, 90 , 414, 414);
     //pane.add(p1);
     
     //Check Button Loc.
     check.setBounds(250,515,100,75);
     pane.add(check);
     
     //Frame Settings
     this.setTitle("Color Sudoku 4x4");     
     this.setSize(600,650);
     this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     this.setVisible(true);
     
    }
    
  public static void main(String[] args) {
      
      new color(0);
      
  }
}

