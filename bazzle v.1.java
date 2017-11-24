package socket;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;


public class sample1 extends JFrame {
   private JFrame rankinput,rank;
   private JTextField nameinput;
   private JTable ranktable;
   private JPanel mainpanel,rankinputpanel;
   private JButton[][] mixbutton;
   private JButton mainbutton,okbutton;
   private JLabel jumsulabel,nameinputlabel;
   private JMenuBar menubar;
   private JMenu menu1,menu2,menu3;
   private JMenuItem item1,item2,item3,item4,item5;
   private ImageIcon[][] subimage,checkimage,tem;
   private ImageIcon temp;
   private Random rand;
   int count=0;
   static int state=0;
   int flag=0,gameflag=0; //flag�� ���ӿϷ�ø��콺 Ŭ���̺�Ʈ�� �������� gameflag�� ù�����ΰ�� �ٷ� ��ŷ�� ����ֱ������̴�. 
   private String[] sum;
   private Object[][] obj;
   private String[] name;
   private String filename;
   int[] jumsu=new int[10];
   int jumsucount=0,rankercount=0;
   String[] ranker=new String[10];
   private BufferedImage bufimage;
   private BufferedImage[] tempbuf;
   private File file;
   private Scanner scan;
   public sample1() {
      setTitle("�׽�Ʈ");
      System.out.println("�����̸��� �Է��ϼ��� (png���ϸ�) ������� 900*600�̿����մϴ�.");
      scan=new Scanner(System.in);
      tempbuf=new BufferedImage[9];
      String filename;
      filename=scan.next();
      file=new File(filename+".png");
      try {
         bufimage=ImageIO.read(file);
      } catch (IOException e1) {
         // TODO Auto-generated catch block
         e1.printStackTrace();
      }
      tempbuf[0]=bufimage.getSubimage(0,0,300, 200); //(x,,y,a,b) x,y �������� ���� a ���� b��ŭ¥���ºκ�
      tempbuf[1]=bufimage.getSubimage(300,0,300, 200);
      tempbuf[2]=bufimage.getSubimage(600,0,300, 200);
      tempbuf[3]=bufimage.getSubimage(0,200,300, 200);
      tempbuf[4]=bufimage.getSubimage(300,200,300, 200);
      tempbuf[5]=bufimage.getSubimage(600,200,300, 200);
      tempbuf[6]=bufimage.getSubimage(0,400,300, 200);
      tempbuf[7]=bufimage.getSubimage(300,400,300, 200);
      tempbuf[8]=bufimage.getSubimage(600,400,300, 200);
      try {
         ImageIO.write(tempbuf[0], "png",new File(filename+"1.png"));
         ImageIO.write(tempbuf[1], "png",new File(filename+"2.png"));
         ImageIO.write(tempbuf[2], "png",new File(filename+"3.png"));
         ImageIO.write(tempbuf[3], "png",new File(filename+"4.png"));
         ImageIO.write(tempbuf[4], "png",new File(filename+"5.png"));
         ImageIO.write(tempbuf[5], "png",new File(filename+"6.png"));
         ImageIO.write(tempbuf[6], "png",new File(filename+"7.png"));
         ImageIO.write(tempbuf[7], "png",new File(filename+"8.png"));
         ImageIO.write(tempbuf[8], "png",new File(filename+"9.png"));
      } catch (IOException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }

      name=new String[10];
      nameinput=new JTextField();
      int randomint1=0,randomint2=0;
      setSize(900,650);
      rand=new Random();
      rankinput=new JFrame();
      nameinputlabel=new JLabel("�̸����Է��ϼ���");
      rankinput.setSize(900,600);
      rankinput.setTitle("��ŷ�Է�");
      rankinputpanel=new JPanel();
      okbutton=new JButton("Ȯ��");
      rank=new JFrame();
      rank.setSize(300,200);
      rank.setTitle("Ranking");
      mainpanel=new JPanel();
      jumsulabel=new JLabel();
      rankinput.add(rankinputpanel);
      rankinputpanel.setLayout(new BoxLayout(rankinputpanel, BoxLayout.Y_AXIS));
      rankinputpanel.add(nameinputlabel);
      rankinputpanel.add(nameinput);
      rankinputpanel.add(jumsulabel);
      rankinputpanel.add(okbutton);
      subimage= new ImageIcon[3][3];
      mixbutton=new JButton[3][3];
      mainbutton=new JButton();
      checkimage=new ImageIcon[3][3];
      tem=new ImageIcon[3][3];
      checkimage[0][0]=new ImageIcon(filename+"1.png");
      checkimage[0][1]=new ImageIcon(filename+"2.png");
      checkimage[0][2]=new ImageIcon(filename+"3.png");
      checkimage[1][0]=new ImageIcon(filename+"4.png");
      checkimage[1][1]=new ImageIcon(filename+"5.png");
      checkimage[1][2]=new ImageIcon(filename+"6.png");
      checkimage[2][0]=new ImageIcon(filename+"7.png");
      checkimage[2][1]=new ImageIcon(filename+"8.png");
      checkimage[2][2]=new ImageIcon(filename+"9.png");
      temp=new ImageIcon();
      for(int i=0; i<10; i++)
      {
         jumsu[i]=10000000;
         ranker[i]="�ӽ�";
      }
      for(int i=0; i<3; i++)
      {
         for(int j=0; j<3; j++)
         {
         //   subimage[i][j]=new ImageIcon(""); 
            tem[i][j]=new ImageIcon();
            tem[i][j]=checkimage[i][j];
            subimage[i][j]=checkimage[i][j];
            subimage[2][2]=null; //�׸����ߴ� ĭ�����ؼ� 2/2 ��ĭ�� �η� �ʱ�ȭ��.            
            mixbutton[i][j]=new JButton();
            mixbutton[i][j].setIcon(subimage[i][j]);
            mixbutton[i][j].setSize(300,200);
            mainpanel.add(mixbutton[i][j]);
         }
      }

      for(int q=0; q<3; q++)
      {         
         for(int w=0; w<3; w++)
         {
            
            randomint1=rand.nextInt(2);
            randomint2=rand.nextInt(2);
            temp=subimage[q][w];
            subimage[q][w]=subimage[randomint1][randomint2];
            subimage[randomint1][randomint2]=temp;
            mixbutton[q][w].setIcon(subimage[q][w]);
            mixbutton[randomint1][randomint2].setIcon(subimage[randomint1][randomint2]);
            // �׸�����.
         }
      }      
   
      okbutton.addMouseListener(new java.awt.event.MouseAdapter()
      {

            public void mousePressed(java.awt.event.MouseEvent evt)
            {
          
               rankinput.setVisible(false);
               if(gameflag==0)
               {
                  jumsu[0]=count;
                  ranker[0]=nameinput.getText();
               }
               else if(gameflag!=0) //�� ù���� ������ �ƴѰ�쿡�� 
               {
                  if(count<jumsu[0]) //�� 1��� ����ī��Ʈ�� Ŭ��� �Ͽ����� (1���̴�)
                  {
                     
                     for(int i=8; i>-1; i--)
                     {

                        jumsu[i+1]=jumsu[i]; //�Ѽ����� �з������Ѵ�.
                        ranker[i+1]=ranker[i]; //�̸��� ������ ���� 
                     }
                     jumsu[0]=count;
                     ranker[0]=nameinput.getText();
                  }
                  else if(count<jumsu[1]) //1��� ����ī��Ʈ�¾ƴϰ� 2��� ����ī��Ʈ�� Ŭ�����Ͽ����� (2����)
                  {
                     for(int i=8; i>-1; i--)
                     {
                        jumsu[i+1]=jumsu[i];
                        ranker[i+1]=ranker[i];
                     }
                     jumsu[1]=count;
                     ranker[1]=nameinput.getText();
                  }
                  else if(count<jumsu[2]) 
                  {
                     for(int i=8; i>0; i--)
                     {
                        jumsu[i+1]=jumsu[i];
                        ranker[i+1]=ranker[i];
                     }
                     jumsu[2]=count;
                     ranker[2]=nameinput.getText();
                  }
                  else if(count<jumsu[3]) 
                  {
                     for(int i=8; i>1; i--)
                     {
                        jumsu[i+1]=jumsu[i];
                        ranker[i+1]=ranker[i];
                     }
                     jumsu[3]=count;
                     ranker[3]=nameinput.getText();
                  }
                  else if(count<jumsu[4]) 
                  {
                     for(int i=8; i>2; i--)
                     {
                        jumsu[i+1]=jumsu[i];
                        ranker[i+1]=ranker[i];
                     }
                     jumsu[4]=count;
                     ranker[4]=nameinput.getText();
                  }
                  else if(count<jumsu[5]) 
                  {
                     for(int i=8; i>3; i--)
                     {
                        jumsu[i+1]=jumsu[i];
                        ranker[i+1]=ranker[i];
                     }
                     jumsu[5]=count;
                     ranker[5]=nameinput.getText();
                  }
                  else if(count<jumsu[6]) 
                  {
                     for(int i=8; i>4; i--)
                     {
                        jumsu[i+1]=jumsu[i];
                        ranker[i+1]=ranker[i];
                     }
                     jumsu[6]=count;
                     ranker[6]=nameinput.getText();
                  }
                  else if(count<jumsu[7]) 
                  {
                     for(int i=8; i>5; i--)
                     {
                        jumsu[i+1]=jumsu[i];
                        ranker[i+1]=ranker[i];
                     }
                     jumsu[7]=count;
                     ranker[7]=nameinput.getText();
                  }
                  else if(count<jumsu[8]) 
                  {
                     for(int i=8; i>6; i--)
                     {
                        jumsu[i+1]=jumsu[i];
                        ranker[i+1]=ranker[i];
                     }
                     jumsu[8]=count;
                     ranker[8]=nameinput.getText();
                  }
                  else if(count<jumsu[9]) 
                  {
                     jumsu[9]=count;
                     ranker[9]=nameinput.getText();
                  }
                  
               }
               nameinput.setText(""); //�̷������� �ʱ�ȭ���������� �ؽ�Ʈ������ ���������� �����ְԵ�.
               }         
        }
      );
      mixbutton[0][0].addMouseListener(new java.awt.event.MouseAdapter()
      {

            public void mousePressed(java.awt.event.MouseEvent evt)
            {   if(flag==0) //flag �� Ŭ����� Ȥ�� ��ü�׸������϶� 1�μ����̵ȴ� . �� Ŭ��� ��ü�׸������϶��� �����ϰ�� ���콺���������۵��Ͽ� �׸��̿�����
            {
               count++;
            if(subimage[0][1]==null)
            {
               temp=subimage[0][0];
               subimage[0][0]=subimage[0][1];
               subimage[0][1]=temp;
               mixbutton[0][0].setIcon(subimage[0][0]);
               mixbutton[0][1].setIcon(subimage[0][1]);
            }
            else if(subimage[1][0]==null)
            {
               temp=subimage[0][0];
               subimage[0][0]=subimage[1][0];
               subimage[1][0]=temp;
               mixbutton[0][0].setIcon(subimage[0][0]);
               mixbutton[1][0].setIcon(subimage[1][0]);
            }
            if(checkimage[0][0]==subimage[0][0] &&checkimage[0][1]==subimage[0][1] &&checkimage[0][2]==subimage[0][2] &&
                  checkimage[1][0]==subimage[1][0] &&checkimage[1][1]==subimage[1][1] &&checkimage[1][2]==subimage[1][2] &&
                        checkimage[2][0]==subimage[2][0] &&checkimage[2][1]==subimage[2][1]  )
            {
               jumsulabel.setText("sucess �̵�Ƚ���� "+count+"���Դϴ�.");
               rankinput.setSize(400,300);rankinput.setVisible(true);
               flag=1; //�ϼ��� flag�� 1�μ��� ���콺���������ȵǵ��ϼ���
            }
            }
         }
            
        }
      );
      
      mixbutton[0][1].addMouseListener(new java.awt.event.MouseAdapter()
      {
            public void mousePressed(java.awt.event.MouseEvent evt)
            {   if(flag==0)
            {
               count++;
            if(subimage[0][0]==null)
            {
               temp=subimage[0][1];
               subimage[0][1]=subimage[0][0];
               subimage[0][0]=temp;
               mixbutton[0][1].setIcon(subimage[0][1]);
               mixbutton[0][0].setIcon(subimage[0][0]);
            }
            else if(subimage[0][2]==null)
            {
               temp=subimage[0][1];
               subimage[0][1]=subimage[0][2];
               subimage[0][2]=temp;
               mixbutton[0][1].setIcon(subimage[0][1]);
               mixbutton[0][2].setIcon(subimage[0][2]);
            }
            else if(subimage[1][1]==null)
            {
               temp=subimage[0][1];
               subimage[0][1]=subimage[1][1];
               subimage[1][1]=temp;
               mixbutton[0][1].setIcon(subimage[0][1]);
               mixbutton[1][1].setIcon(subimage[1][1]);
            }
            if(checkimage[0][0]==subimage[0][0] &&checkimage[0][1]==subimage[0][1] &&checkimage[0][2]==subimage[0][2] &&
                  checkimage[1][0]==subimage[1][0] &&checkimage[1][1]==subimage[1][1] &&checkimage[1][2]==subimage[1][2] &&
                        checkimage[2][0]==subimage[2][0] &&checkimage[2][1]==subimage[2][1]  )
            {
               jumsulabel.setText("sucess �̵�Ƚ���� "+count+"���Դϴ�.");
               rankinput.setSize(400,300);rankinput.setVisible(true);
               flag=1;
   
            }
            }
         }
            
        
      }
      );   
      mixbutton[0][2].addMouseListener(new java.awt.event.MouseAdapter()
      {
            public void mousePressed(java.awt.event.MouseEvent evt)
            {   if(flag==0)
            {
            count++;
            if(subimage[0][1]==null)
            {
               temp=subimage[0][2];
               subimage[0][2]=subimage[0][1];
               subimage[0][1]=temp;
               mixbutton[0][2].setIcon(subimage[0][2]);
               mixbutton[0][1].setIcon(subimage[0][1]);
            }
            else if(subimage[1][2]==null)
            {
               temp=subimage[0][2];
               subimage[0][2]=subimage[1][2];
               subimage[1][2]=temp;
               mixbutton[0][2].setIcon(subimage[0][2]);
               mixbutton[1][2].setIcon(subimage[1][2]);
            }
            if(checkimage[0][0]==subimage[0][0] &&checkimage[0][1]==subimage[0][1] &&checkimage[0][2]==subimage[0][2] &&
                  checkimage[1][0]==subimage[1][0] &&checkimage[1][1]==subimage[1][1] &&checkimage[1][2]==subimage[1][2] &&
                        checkimage[2][0]==subimage[2][0] &&checkimage[2][1]==subimage[2][1]  )
            {
               jumsulabel.setText("sucess �̵�Ƚ���� "+count+"���Դϴ�.");
               rankinput.setSize(400,300);rankinput.setVisible(true);
               flag=1;

            }
            }            
         
            
        }
      }
      );              
      mixbutton[1][0].addMouseListener(new java.awt.event.MouseAdapter()
      {
            public void mousePressed(java.awt.event.MouseEvent evt)
            {   if(flag==0)
            {
              count++;
            if(subimage[0][0]==null)
            {
               temp=subimage[1][0];
               subimage[1][0]=subimage[0][0];
               subimage[0][0]=temp;
               mixbutton[1][0].setIcon(subimage[1][0]);
               mixbutton[0][0].setIcon(subimage[0][0]);
            }
            else if(subimage[1][1]==null)
            {
               temp=subimage[1][0];
               subimage[1][0]=subimage[1][1];
               subimage[1][1]=temp;
               mixbutton[1][0].setIcon(subimage[1][0]);
               mixbutton[1][1].setIcon(subimage[1][1]);
            }
            else if(subimage[2][0]==null)
            {
               temp=subimage[1][0];
               subimage[1][0]=subimage[2][0];
               subimage[2][0]=temp;
               mixbutton[1][0].setIcon(subimage[1][0]);
               mixbutton[2][0].setIcon(subimage[2][0]);
            }
            if(checkimage[0][0]==subimage[0][0] &&checkimage[0][1]==subimage[0][1] &&checkimage[0][2]==subimage[0][2] &&
                  checkimage[1][0]==subimage[1][0] &&checkimage[1][1]==subimage[1][1] &&checkimage[1][2]==subimage[1][2] &&
                        checkimage[2][0]==subimage[2][0] &&checkimage[2][1]==subimage[2][1]  )
            {
               jumsulabel.setText("sucess �̵�Ƚ���� "+count+"���Դϴ�.");
               flag=1;
               rankinput.setSize(400,300);rankinput.setVisible(true);

            }
            }
         }
            
        }
      );
      mixbutton[1][1].addMouseListener(new java.awt.event.MouseAdapter()
      {
            public void mousePressed(java.awt.event.MouseEvent evt)
            {
               if(flag==0)
               {
            count++;
            if(subimage[0][1]==null)
            {
               temp=subimage[1][1];
               subimage[1][1]=subimage[0][1];
               subimage[0][1]=temp;
               mixbutton[1][1].setIcon(subimage[1][1]);
               mixbutton[0][1].setIcon(subimage[0][1]);
            }
            else if(subimage[1][0]==null)
            {
               temp=subimage[1][1];
               subimage[1][1]=subimage[1][0];
               subimage[1][0]=temp;
               mixbutton[1][0].setIcon(subimage[1][0]);
               mixbutton[1][1].setIcon(subimage[1][1]);
            }
            else if(subimage[1][2]==null)
            {
               temp=subimage[1][1];
               subimage[1][1]=subimage[1][2];
               subimage[1][2]=temp;
               mixbutton[1][1].setIcon(subimage[1][1]);
               mixbutton[1][2].setIcon(subimage[1][2]);
            }


            else if(subimage[2][1]==null)
            {
               temp=subimage[1][1];
               subimage[1][1]=subimage[2][1];
               subimage[2][1]=temp;
               mixbutton[1][1].setIcon(subimage[1][1]);
               mixbutton[2][1].setIcon(subimage[2][1]);
            }
            if(checkimage[0][0]==subimage[0][0] &&checkimage[0][1]==subimage[0][1] &&checkimage[0][2]==subimage[0][2] &&
                  checkimage[1][0]==subimage[1][0] &&checkimage[1][1]==subimage[1][1] &&checkimage[1][2]==subimage[1][2] &&
                        checkimage[2][0]==subimage[2][0] &&checkimage[2][1]==subimage[2][1]  )
            {
               jumsulabel.setText("sucess �̵�Ƚ���� "+count+"���Դϴ�.");
               rankinput.setSize(400,300);rankinput.setVisible(true);
               flag=1;

            }
               }
         }
            
        }
      );
      mixbutton[1][2].addMouseListener(new java.awt.event.MouseAdapter()
         {
               public void mousePressed(java.awt.event.MouseEvent evt)
               {
                  if(flag==0)
                  {
               count++;
               if(subimage[2][2]==null)
               {
                  temp=subimage[1][2];
                  subimage[1][2]=subimage[2][2];
                  subimage[2][2]=temp;
                  mixbutton[2][2].setIcon(subimage[2][2]);
                  mixbutton[1][2].setIcon(subimage[1][2]);
               }
               else if(subimage[1][1]==null)
               {
                  temp=subimage[1][2];
                  subimage[1][2]=subimage[1][1];
                  subimage[1][1]=temp;
                  mixbutton[1][2].setIcon(subimage[1][2]);
                  mixbutton[1][1].setIcon(subimage[1][1]);
               }
               else if(subimage[0][2]==null)
               {
                  temp=subimage[1][2];
                  subimage[1][2]=subimage[0][2];
                  subimage[0][2]=temp;
                  mixbutton[1][2].setIcon(subimage[1][2]);
                  mixbutton[0][2].setIcon(subimage[0][2]);
               }
               if(checkimage[0][0]==subimage[0][0] &&checkimage[0][1]==subimage[0][1] &&checkimage[0][2]==subimage[0][2] &&
                     checkimage[1][0]==subimage[1][0] &&checkimage[1][1]==subimage[1][1] &&checkimage[1][2]==subimage[1][2] &&
                           checkimage[2][0]==subimage[2][0] &&checkimage[2][1]==subimage[2][1]  )
               {
                  jumsulabel.setText("sucess �̵�Ƚ���� "+count+"���Դϴ�.");
                  rankinput.setSize(400,300);rankinput.setVisible(true);
                  flag=1;
               }
                  }
            }
               
           }
      );
      mixbutton[2][0].addMouseListener(new java.awt.event.MouseAdapter()
         {
               public void mousePressed(java.awt.event.MouseEvent evt)
               {
                  if(flag==0)
                  {
               count++;
               if(subimage[1][0]==null)
               {
                  temp=subimage[2][0];
                  subimage[2][0]=subimage[1][0];
                  subimage[1][0]=temp;
                  mixbutton[1][0].setIcon(subimage[1][0]);
                  mixbutton[2][0].setIcon(subimage[2][0]);
               }
               else if(subimage[2][1]==null)
               {
                  temp=subimage[2][0];
                  subimage[2][0]=subimage[2][1];
                  subimage[2][1]=temp;
                  mixbutton[2][0].setIcon(subimage[2][0]);
                  mixbutton[2][1].setIcon(subimage[2][1]);
               }
               if(checkimage[0][0]==subimage[0][0] &&checkimage[0][1]==subimage[0][1] &&checkimage[0][2]==subimage[0][2] &&
                     checkimage[1][0]==subimage[1][0] &&checkimage[1][1]==subimage[1][1] &&checkimage[1][2]==subimage[1][2] &&
                           checkimage[2][0]==subimage[2][0] &&checkimage[2][1]==subimage[2][1]  )
               {
                  jumsulabel.setText("sucess �̵�Ƚ���� "+count+"���Դϴ�.");
                  rankinput.setSize(400,300);rankinput.setVisible(true);
                  flag=1;
               }
                  }
            }
               
           }
      );
      mixbutton[2][1].addMouseListener(new java.awt.event.MouseAdapter()
         {
               public void mousePressed(java.awt.event.MouseEvent evt)
               {
                  if(flag==0)
                  {
               count++;
               if(subimage[2][2]==null)
               {
                  temp=subimage[2][1];
                  subimage[2][1]=subimage[2][2];
                  subimage[2][2]=temp;
                  mixbutton[2][2].setIcon(subimage[2][2]);
                  mixbutton[2][1].setIcon(subimage[2][1]);
               }
               else if(subimage[1][1]==null)
               {
                  temp=subimage[2][1];
                  subimage[2][1]=subimage[1][1];
                  subimage[1][1]=temp;
                  mixbutton[2][1].setIcon(subimage[2][1]);
                  mixbutton[1][1].setIcon(subimage[1][1]);
               }
               else if(subimage[2][0]==null)
               {
                  temp=subimage[2][1];
                  subimage[2][1]=subimage[2][0];
                  subimage[2][0]=temp;
                  mixbutton[2][0].setIcon(subimage[2][0]);
                  mixbutton[2][1].setIcon(subimage[2][1]);
               }
               if(checkimage[0][0]==subimage[0][0] &&checkimage[0][1]==subimage[0][1] &&checkimage[0][2]==subimage[0][2] &&
                     checkimage[1][0]==subimage[1][0] &&checkimage[1][1]==subimage[1][1] &&checkimage[1][2]==subimage[1][2] &&
                           checkimage[2][0]==subimage[2][0] &&checkimage[2][1]==subimage[2][1]  )
               {
                  jumsulabel.setText("sucess �̵�Ƚ���� "+count+"���Դϴ�.");
                  rankinput.setSize(400,300);rankinput.setVisible(true);
                  flag=1;
               }
                  }
            }
               
           }
      );
      mixbutton[2][2].addMouseListener(new java.awt.event.MouseAdapter()
         {
            
               public void mousePressed(java.awt.event.MouseEvent evt)
               {
                  if(flag==0)
                  {
               count++;
               if(subimage[1][2]==null)
               {
                  temp=subimage[2][2];
                  subimage[2][2]=subimage[1][2];
                  subimage[1][2]=temp;
                  mixbutton[1][2].setIcon(subimage[1][2]);
                  mixbutton[2][2].setIcon(subimage[2][2]);
               }
               else if(subimage[2][1]==null)
               {
                  temp=subimage[2][2];
                  subimage[2][2]=subimage[2][1];
                  subimage[2][1]=temp;
                  mixbutton[2][1].setIcon(subimage[2][1]);
                  mixbutton[2][2].setIcon(subimage[2][2]);
               }
               if(checkimage[0][0]==subimage[0][0] &&checkimage[0][1]==subimage[0][1] &&checkimage[0][2]==subimage[0][2] &&
                     checkimage[1][0]==subimage[1][0] &&checkimage[1][1]==subimage[1][1] &&checkimage[1][2]==subimage[1][2] &&
                           checkimage[2][0]==subimage[2][0] &&checkimage[2][1]==subimage[2][1]  )
               {
                  
                  jumsulabel.setText("sucess �̵�Ƚ���� "+count+"���Դϴ�.");
                  rankinput.setSize(400,300);rankinput.setVisible(true);
                  flag=1;               
               }
                  }
            }
               
           }
      );

      menubar=new JMenuBar();
      menu1=new JMenu("����");
      menu2=new JMenu("���̵�");
      menu3=new JMenu("����");
      item1=new JMenuItem("������");
      item1.addActionListener(new ActionListener()
      {
         
         public void actionPerformed(ActionEvent e) {
            count=0;
            flag=0; //flag�� �ٽø���� �������� �ϰԵǾ����� �ٽ� ���콺�̺�Ʈ�� �߻��ϵ����ϱ�����.
            gameflag=1; //��ũ���ű涧 ù�������� �ƴ��� Ȯ���ϴ��÷��� ���� ù�����̾ƴ϶�� gameflag�� 1�̵ȴ�.
            for(int q=0; q<3; q++)
            {         
               for(int w=0; w<3; w++)
               {
                  
                  int randomint1=rand.nextInt(2);
                  int randomint2=rand.nextInt(2);
                  temp=subimage[q][w];
                  subimage[q][w]=subimage[randomint1][randomint2];
                  subimage[randomint1][randomint2]=temp;
                  mixbutton[q][w].setIcon(subimage[q][w]);
                  mixbutton[randomint1][randomint2].setIcon(subimage[randomint1][randomint2]);
                  // �׸�����. (�����ӽ�)
               }
            }   
            // TODO Auto-generated method stub
            
         }
            
         });
      item2=new JMenuItem("3*3����");
   /**   item2.addActionListener(new ActionListener()
      {
         

         @Override
         public void actionPerformed(ActionEvent e) {
            
            // TODO Auto-generated method stub
            
         }
            
         });*/
      item3=new JMenuItem("��ũ");
      item3.addActionListener(new ActionListener()
      {

         public void actionPerformed(ActionEvent e) {
            for(int i=0; i<10; i++)
            {
               name[i]=("�ڼ���");
            }
            Object[][] obj={{"�̸�","����"},{ranker[0],jumsu[0]},{ranker[1],jumsu[1]},{ranker[2],jumsu[2]},{ranker[3],jumsu[3]}
            ,{ranker[4],jumsu[4]},{ranker[5],jumsu[5]},{ranker[6],jumsu[6]},{ranker[7],jumsu[7]},{ranker[8],jumsu[8]}
            ,{ranker[9],jumsu[9]}};
            String[] sum={"",""};
            ranktable=new JTable(obj,sum);
            rank.add(ranktable);
            rank.setVisible(true);
            // TODO Auto-generated method stub
            
         }
            
         });
      item4=new JMenuItem("��ü�׸�����");
      item4.addActionListener(new ActionListener()
      {

         public void actionPerformed(ActionEvent e) {

            if(state==0)
            {
               flag=1; //��ü�׸������϶� ���콺�̺�Ʈ�� �߻������ʵ����ϱ�����
               item4.setText("�κб׸�����");
      
               for(int i=0; i<3; i++)
               {
               
                  for(int j=0; j<3; j++)
                  {
   
                     mixbutton[i][j].setIcon(tem[i][j]);
                     
                  }
               }
               state=1;
            }
            else if(state!=0)
            {
               flag=0;
               item4.setText("��ü�׸�����");
               for(int i=0; i<3; i++)
               {
                  for(int j=0; j<3; j++)
                  {
                     mixbutton[i][j].setIcon(subimage[i][j]);         
                  }
               }
               state=0;
            }

         }
         
         });
      item5=new JMenuItem("4*4 ����");
      menubar.add(menu1);
      menubar.add(menu2);
      menubar.add(menu3);
      menu1.add(item1);
      menu2.add(item2);
      menu2.add(item5);
      menu3.add(item3);
      menu3.add(item4);
      add(mainpanel);
      setJMenuBar(menubar);
      mainpanel.setLayout(new GridLayout(3,3));
      this.setVisible(true);

   }
}