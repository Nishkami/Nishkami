// Demonstrate GridLayout 
import java.awt.*;
import java.applet.*; 
import java.awt.event.*;
import javax.swing.*;


class Error extends Exception
{
	
	Error(String msg)
	{
		super(msg);
	}
	
}
public class NA11 extends JFrame implements MouseListener,MouseMotionListener
{ 
	static final int n = 8;
	int X1,Y1,select,X2,Y2,flag,nishu=0;
	boolean b=true,p=true;
	JPanel jp1,jp2,jp21,jp22,jp23;
	TextArea text;
	String str[]={ "g_rook_w.jpg",   "g_knight_b.jpg",   "g_bishop_w.jpg",   "g_queen_b.jpg",
		    "g_king_w.jpg",  "g_bishop_b.jpg",   "g_knight_w.jpg",   "g_rook_b.jpg",
		    "g_pawn_b.jpg",   "g_pawn_w.jpg",    
		    "s_rook_b.jpg",   "s_knight_w.jpg",   "s_bishop_b.jpg",    "s_queen_w.jpg",
		    "s_king_b.jpg",   "s_bishop_w.jpg",   "s_knight_b.jpg",     "s_rook_w.jpg",
		    "s_pawn_w.jpg",  "s_pawn_b.jpg",
		    "Black.jpg",        "White.jpg",
		    "g_king_b.jpg",    "g_queen_w.jpg",   "s_queen_b.jpg",     "s_king_w.jpg"}; 

	ImageIcon icon[][]=new ImageIcon[8][8];
	ImageIcon cut1 = new ImageIcon();
	JLabel l[][] = new JLabel[8][8];
	JLabel cut=new JLabel();
	int a[][]={{1,2,3,4,5,6,7,8},
		{9,9,9,9,9,9,9,9},
		{10,11,10,11,10,11,10,11},
		{11,10,11,10,11,10,11,10},		
		{10,11,10,11,10,11,10,11},
		{11,10,11,10,11,10,11,10},
		{-9,-9,-9,-9,-9,-9,-9,-9},
		{-1,-2,-3,-4,-5,-6,-7,-8}};
	int def[]=new int[64];

	public NA11()
	{
		jp1 = new JPanel();
		jp2 = new JPanel();
		jp21 = new JPanel();
		//jp22 = new JPanel();
		jp23 = new JPanel();
		jp1.setLayout(new GridLayout(n, n));
		jp1.setSize(640,640);
		jp1.setVisible(true);
		add(jp1);
		jp2.setLayout(new GridLayout(3,1));
		jp2.setSize(640,640);
		jp2.setVisible(true);
		jp2.add(jp21);
		//jp2.add(jp22);
		text =new TextArea(" \t\t\t***********GAME DESCRIPTION ***********\n\nIts White's Turn:\n\n",20,20);
		jp2.add(text);
		jp2.add(jp23);
		jp21.add(new JLabel ("BLACK : "));
		
		jp23.add(new JLabel ("WHITE : "));
		//text.setSize(200,200);
		//jp22.add(text);
		add(jp2);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		for(int i=0;i<8;i++)
		{
			for(int j=0;j<8;j++)
			{	
				if(i==0)
				{
					setdata(i,j,str[j]);	
				}
				else if(j%2==1&& i==1)
				{
					setdata(i,j,str[9]);
				}
				else if(j%2==0&& i==1)
				{
					setdata(i,j,str[8]);
				}
				else if(i==7)
				{
					setdata(i,j,str[j+10]);
				}
				else if(j%2==1&&i==6)
				{
					setdata(i,j,str[19]);
				}
				else if(j%2==0&&i==6)
				{
					setdata(i,j,str[18]);
				}			
				else if((i+j)%2==1)
				{
					def[i]=10;
					setdata(i,j,str[20]);
				}
				else
				{
					def[i]=11;
					setdata(i,j,str[21]);
				}				
			}			
		}
					
		addMouseListener(this);
		addMouseMotionListener(this);		
	}
	
	public void setdata(int i,int j,String s)
	{
		icon[i][j]=new ImageIcon(s);
		l[i][j]=new JLabel(icon[i][j]);
		jp1.add(l[i][j]);	
	}
	public void removedata(int i,int j)
	{
			
		if(a[i][j]>0)
		{
			if(a[i][j]==9)
				cut1=new ImageIcon(str[8]);
			else if(a[i][j]==8 || a[i][j]==1)
				cut1=new ImageIcon(str[7]);			
			else if(a[i][j]==7 || a[i][j]==2)
				cut1=new ImageIcon(str[1]);
			else if(a[i][j]==6 || a[i][j]==3)
				cut1=new ImageIcon(str[5]);
			else if(a[i][j]==4)
				cut1=new ImageIcon(str[3]);
			else if(a[i][j]==5)
				cut1=new ImageIcon(str[22]);
			cut=new JLabel(cut1);
			jp21.add(cut);
		}
		else
		{
			if(a[i][j]==-9)
				cut1=new ImageIcon(str[18]);
			else if(a[i][j]==-8 || a[i][j]==-1)
				cut1=new ImageIcon(str[17]);	
			else if(a[i][j]==-7 || a[i][j]==-2)
				cut1=new ImageIcon(str[11]);
			else if(a[i][j]==-6 || a[i][j]==-3)
				cut1=new ImageIcon(str[15]);
			else if(a[i][j]==-4)
				cut1=new ImageIcon(str[24]);
			else if(a[i][j]==-5)
				cut1=new ImageIcon(str[14]);
			cut=new JLabel(cut1);
			jp23.add(cut);
		}					
	}	

/*	public Insets getBorderInsets(Component c)
	{
		return jp1;
	}
	boolean isBorderOpaque()
	{
	}
	public void paintBorder(Component c,Graphics g,int x, int y, int width,int height)
	{
	}
*/
	public void mouseClicked(MouseEvent e)
	{
		if(b)
		{
			X1=e.getX();
			Y1=e.getY();
			int t1 = X1/80;
			int t2 = Y1/80;
			if(t1<8 && t2<8)
			{
			select = a[t2][t1];
			System.out.println("mouse clicked"+t1+"   "+t2+"   "+select);
			text.append("\nMouse Clicked"+t1+"   "+t2+"   "+select);
			if(select==10 || select==11)
				b=true;
			else
				b = false;	
			}
		}
		else if(select != 10 && select != 11)
		{
			X2 = e.getX();
			Y2 = e.getY();
			try
			{
				if((nishu==0 && select>0) || (nishu==1 && select<0) )
					throw new Error("\n ****** Invalid Move... Not Your Turn......*******");
			}
			catch(Error m)
			{	
				text.append("\n****** Invalid Move ... Not Your Turn......*******");
				System.out.println(m.getMessage());
			}				
			if(nishu == 1)
			{
				
				if(select == 9)
					move_pawn();
				else if(select ==1||select==8)
					move_rook();
				else if(select ==2||select==7)
					move_knight();
				else if(select ==3||select==6)
					move_bishop();
				else if(select ==5)
					move_king();
				else if(select==4)
					move_queen();

				//nishu=1;
			}
			else
			{
				
				if(select == -9)
					move_pawn();
				else if(select ==-1||select==-8)
					move_rook();
				else if(select ==-2||select==-7)
					move_knight();
				else if(select ==-3||select==-6)
					move_bishop();
				else if(select==-5)
					move_king();
				else if(select ==-4)
					move_queen();

			//	nishu=0;
			}
			b=true;
		
		}
		//else
		//{
		//	b=true;
		//}
			
	}
	public void mousePressed(MouseEvent e){}
	public void mouseReleased(MouseEvent e){}
	public void mouseEntered(MouseEvent e){}

	public void mouseExited(MouseEvent e)
	{
	}

	public void mouseDragged(MouseEvent e)
	{
	}
	public void mouseMoved(MouseEvent e){}
	void move_pawn()
	{
		int t1 = X1/80;
		int t2 = Y1/80;
		int t3 = X2/80;
		int t4 = Y2/80;
		System.out.println("move pawn : "+t2+"   "+t1+"   "+t4+"   "+t3);	
		text.append("\nMove Pawn : "+t2+"   "+t1+"   "+t4+"   "+t3);
		if(select==9)
		{
			try
			{
			if(((t4-t2==1)&&(t3-t1==1)&&(a[t4][t3] != 10 && a[t4][t3]!=11 )&& a[t4][t3]<0)
		    	     ||((t4-t2==1)&&(t3-t1==-1)&&(a[t4][t3] != 10 && a[t4][t3]!=11))
			     ||(t2==1&&(t4-t2==2)&&(t3-t1==0)&&(a[t2+1][t1] == 10||a[t2+1][t1]==11)&&(a[t2+2][t1]==10 || a[t2+2][t1]==11))
			     ||((t4-t2==1)&&(t3-t1==0)&&(a[t2+1][t1]==10 || a[t2+1][t1]==11)))
			{
				
				if(a[t4][t3]!=10 && a[t4][t3]!=11)
				{
					removedata(t4,t3);
				}

				if((t1+t2)%2==0)
				{
					l[t2][t1].setIcon(new ImageIcon(str[21]));
					a[t2][t1]=10;
				}
				else				
				{
					l[t2][t1].setIcon(new ImageIcon(str[20]));
					a[t2][t1]=11;
				}
				if((t4+t3)%2==0)
				{
					//removedata(t4,t3);
					l[t4][t3].setIcon(new ImageIcon(str[9]));	
					a[t4][t3]=9;
				}
				else
				{
					//removedata(t4,t3);
					l[t4][t3].setIcon(new ImageIcon(str[8]));	
					a[t4][t3]=9;
				}	
				nishu=0;
		
			}
			else
				throw new Error("Invalid move...");
			}
			catch(Error e)
			{
				text.append("\n****** Invalid Move ...*******");
				//addLable(e.getMessage());
				System.out.println(e.getMessage());
			}
		}			
		if(select==-9)
		{
			try
			{
			if(((t4-t2==-1)&&(t3-t1==1)&&(a[t4][t3] != 10 && a[t4][t3]!=11) && a[t4][t3]>0)
	   	     	||((t4-t2==-1)&&(t3-t1==-1)&&(a[t4][t3] != 10 && a[t4][t3]!=11))
		     	||(t2==6&&(t4-t2==-2)&&(t3-t1==0)&&(a[t2-1][t1] == 10||a[t2-1][t1]==11)&&(a[t2-2][t1]==10 || a[t2-2][t1]==11))
		     	||((t4-t2==-1)&&(t3-t1==0)&&(a[t2-1][t1]==10 || a[t2-1][t1]==11)))
			{

				if(a[t4][t3]!=10 && a[t4][t3]!=11)
				{
					removedata(t4,t3);
				}

				if((t1+t2)%2==0)
				{
					l[t2][t1].setIcon(new ImageIcon(str[21]));
					a[t2][t1]=10;
				}
				else				
				{
					l[t2][t1].setIcon(new ImageIcon(str[20]));
					a[t2][t1]=11;
				}
				if((t4+t3)%2==0)
				{
					
					l[t4][t3].setIcon(new ImageIcon(str[18]));	
					a[t4][t3]=-9;
				}
				else
				{
					l[t4][t3].setIcon(new ImageIcon(str[19]));	
					a[t4][t3]=-9;
	             		}
				nishu=1;
			
			}
			
			else
				throw new Error("Invalid move...");
			}
			catch(Error e)
			{
				text.append("\n****** Invalid Move ...*******");
				//addLable(e.getMessage());
				System.out.println(e.getMessage());
			}
		}	
	}
	void move_king()
	{
		int t1 = X1/80;
		int t2 = Y1/80;
		int t3 = X2/80;
		int t4 = Y2/80;
		System.out.println("move king : "+t2+"   "+t1+"   "+t4+"   "+t3);
		text.append("\nMove King : "+t2+"   "+t1+"   "+t4+"   "+t3);
		try
		{	
	
		if((((Math.abs(t4-t2)==1 || Math.abs(t3-t1)==1)&&(t4-t2==0 || t3-t1==0))||(Math.abs(t4-t2)==1 && Math.abs(t3-t1)==1))&&((select==5 		&& (a[t4][t3]<0 || a[t4][t3] == 10 || a[t4][t3] == 11))||(select==-5 && a[t4][t3]>0 )))
		{	
			if(a[t4][t3]!=10 && a[t4][t3]!=11)
			{
				removedata(t4,t3);
			}
		
			if((t1+t2)%2==0)
			{
				l[t2][t1].setIcon(new ImageIcon(str[21]));
				a[t2][t1]=10;
			}
			else				
			{
				l[t2][t1].setIcon(new ImageIcon(str[20]));
				a[t2][t1]=11;
			}
			if(select==5 )
			{	
				

				if((t4+t3)%2==0)
				{
					l[t4][t3].setIcon(new ImageIcon(str[4]));	
					a[t4][t3]=5;
				}
				else
				{
					l[t4][t3].setIcon(new ImageIcon(str[22]));	
					a[t4][t3]=5;
				}
				nishu=0;
			
			}
			else if(select==-5 )		
			{
				if((t4+t3)%2==0)
				{
					l[t4][t3].setIcon(new ImageIcon(str[25]));	
					a[t4][t3]=-5;
				}
				else
				{
					l[t4][t3].setIcon(new ImageIcon(str[14]));	
					a[t4][t3]=-5;
				}
				nishu=1;
			
			}
		}	
		
		else
			throw new Error("\n******Invalid move...******");
		}
		catch(Error e)
		{
			text.append("\n****** Invalid Move ...*******");
			//addLable(e.getMessage());
			System.out.println(e.getMessage());
		}
	}
	void move_queen()
	{
		int t1 = X1/80;
		int t2 = Y1/80;
		int t3 = X2/80;
		int t4 = Y2/80;
		flag=0;
		System.out.println("move queen : "+t2+"   "+t1+"   "+t4+"   "+t3);	
		text.append("\nMove Queen : "+t2+"   "+t1+"   "+t4+"   "+t3);
		if(t3-t1==0)
		{
			if(t4>t2)
			{
				for(int i=t2+1;i<t4;i++)
				{
					if(a[i][t1]==10 || a[i][t1]==11 )				
					{
						System.out.println("flag=0");
						flag = 0;
					}
					else
					{
						System.out.println("flag=1");
						flag = 1;
						break;
					}
				}
			}
			else
			{
				for(int i=t4;i<t2;i++)
				{
					if(a[i][t1]==10 || a[i][t1]==11)
					{
						System.out.println("flag=0");
						flag = 0;
					}
					else
					{
						System.out.println("flag=1");
						flag = 1;
					}
				}			
			}
		}
		else if(t4-t2==0)
		{
			if(t3>t1)
			{
				for(int i=t1+1;i<t3;i++)
				{
					if(a[t2][i]==10 || a[t2][i]==11 )
					{
						flag = 0;
					}
					else
					{
						flag = 1;
						break;
					}
				}
			}
			else
			{
				for(int i=t3+1;i<t1;i++)
				{
					if(a[t2][i]==10 || a[t2][i]==11)
					{
						flag = 0;
					}
					else
					{
						flag = 1;
						break;
					}
				}
			}
		}
		else if(Math.abs(t4-t2)==Math.abs(t3-t1))
		{
			
			if(t4>t2 && t3>t1)
			{	
				for(int i=1;i<(t4-t2);i++)
				{
					if(a[t2+i][t1+i]==10 || a[t2+i][t1+i]==11)
					{
						flag=0;
					}
					else
					{
						flag=1;
						break;
					}
				}
			}
			
			else if(t4>t2 && t3<t1)
			{
				for(int i=1;i<(t4-t2);i++)
				{
					if(a[t2+i][t1-i]==10 || a[t2+i][t1-i]==11 )
					{
						flag=0;
					}
					else
					{
						flag=1;
						break;
					}
				}
			}
			else if(t4<t2 && t3>t1)
			{
				for(int i=1;i<(t2-t4);i++)
				{
					if(a[t2-i][t1+i]==10 || a[t2-i][t1+i]==11 )
					{
						flag=0;
					}
					else
					{
						flag=1;
						break;
					}
				}
			}
			else if(t4<t2 && t3<t1)
			{
				for(int i=1;i<(t4-t2);i++)
				{
					if(a[t2-i][t1-i]==10 || a[t2-i][t1-i]==11 )
					{
						flag=0;
					}
					else
					{
						flag=1;
						break;
					}
				}
			}	
		}
		else
		{
			flag=1;
		}
		try
		{
		if(flag==0 && ((select==4 &&(a[t4][t3]<0 || a[t4][t3]==10 || a[t4][t3]==11)) || (select == -4 &&(a[t4][t3]>0))))
		{
			if(a[t4][t3]!=10 && a[t4][t3]!=11)
			{
				removedata(t4,t3);
			}

			if((t1+t2)%2==0)
			{
				l[t2][t1].setIcon(new ImageIcon(str[21]));
				a[t2][t1]=10;
			}
			else				
			{
				l[t2][t1].setIcon(new ImageIcon(str[20]));
				a[t2][t1]=11;
			}
			if(select==4)
			{
				if((t4+t3)%2==0)
				{
					l[t4][t3].setIcon(new ImageIcon(str[23]));	
					a[t4][t3]=4;
				}
				else
				{
					l[t4][t3].setIcon(new ImageIcon(str[3]));	
					a[t4][t3]=4;
				}
				nishu=0;
				
			}
			else if(select == -4)
			{
				if((t4+t3)%2==0)
				{
					l[t4][t3].setIcon(new ImageIcon(str[13]));	
					a[t4][t3]=-4;
				}
				else
				{
					l[t4][t3].setIcon(new ImageIcon(str[24]));	
					a[t4][t3]=-4;
				}
				nishu=1;
	
			}
		}
		else
			throw new Error("Invalid move...");
		}
		catch(Error e)
		{
			text.append("\n****** Invalid Move ...*******");
			//addLable(e.getMessage());
			System.out.println(e.getMessage());
		}
		
		
	}
 	void move_rook()
	{
		int t1 = X1/80;
		int t2 = Y1/80;
		int t3 = X2/80;
		int t4 = Y2/80;
		flag=0;
		System.out.println("move Rook : "+t2+"   "+t1+"   "+t4+"   "+t3);	
		text.append("\nMove Rook : "+t2+"   "+t1+"   "+t4+"   "+t3);
		if(select==1 || select == 8) 
		{
			//System.out.println("inside 1.....");
			if(t3-t1==0)
			{
				if(t4>t2)
				{
					for(int i=t2+1;i<t4;i++)
					{
						if(a[i][t1]==10 || a[i][t1]==11)
						{
							flag = 0;
						}
						else
						{
							
							flag = 1;
							break;
						}
					}
								
				}
				else
				{
					for(int i=t4+1;i<t2;i++)
					{
						if(a[i][t1]==10 || a[i][t1]==11)
						{
							flag = 0;
						}
						else
						{
							//System.out.println("flag=1");
							flag = 1;
							break;
						}
					}
				}
				
		
			}
			else if(t4-t2==0)
			{
				if(t3>t1)
				{
					for(int i=t1+1;i<t3;i++)
					{
						if(a[t2][i]==10 || a[t2][i]==11)
						{
							flag = 0;
						}
						
						else
						{
							flag = 1;
							break;
						}
					}
				}
				else
				{
					for(int i=t3+1;i<t1;i++)
					{
						if(a[t2][i]==10 || a[t2][i]==11)
						{
							flag = 0;
						}
						else
						{
							flag = 1;
							break;
						}
					}
				}
				
			}
		}
		else if(select==-1 || select == -8) 
		{
			if(t3-t1==0)
			{
				if(t4>t2)
				{
					for(int i=t2+1;i<t4;i++)
					{
						if(a[i][t1]==10 || a[i][t1]==11)
						{
							flag = 0;
						}
						else
						{
							flag = 1;
							break;
						}
					}
				}
				else
				{
					for(int i=t4+1;i<t2;i++)
					{
						if(a[i][t1]==10 || a[i][t1]==11)
						{
							flag = 0;
						}
						else
						{	
							flag = 1;
							break;
						}
					}
				}
			

			}
			else if(t4-t2==0)
			{
				if(t1>t3)
				{
					for(int i=t1-1;i>t3;i--)
					{
						if(a[t2][i]==10 || a[t2][i]==11)
						{
							flag = 0;
						}
						else
						{
							flag = 1;
							break;
						}
					}
				}
				else
				{
					for(int i=t3-1;i>t1;i--)
					{
						if(a[t2][i]==10 || a[t2][i]==11)
						{
							flag = 0;
						}
						else
						{
							flag = 1;
							break;
						}
					}	
				}
				
			}
		}
		try
		{
			if(flag==0 && (((select==1 || select==8) &&(a[t4][t3]<0 || a[t4][t3]==10 || a[t4][t3]==11)) || ((select == -1 || select == 				-8) &&(a[t4][t3]>0))))
			{
		
				if(a[t4][t3]!=10 && a[t4][t3]!=11)
				{
					removedata(t4,t3);
				}
	
				if((t1+t2)%2==0)
				{
					l[t2][t1].setIcon(new ImageIcon(str[21]));
					a[t2][t1]=10;
				}
				else				
				{
					l[t2][t1].setIcon(new ImageIcon(str[20]));
					a[t2][t1]=11;
				}
				if(select==1 || select==8)
				{
					if((t4+t3)%2==0)
					{
						l[t4][t3].setIcon(new ImageIcon(str[0]));	
						a[t4][t3]=1;
					}
					else
					{
						l[t4][t3].setIcon(new ImageIcon(str[7]));	
						a[t4][t3]=8;
					}
					nishu=0;
				}
				else if(select==-1 || select==-8)
				{
					if((t4+t3)%2==0)
					{
				
						l[t4][t3].setIcon(new ImageIcon(str[17]));	
						a[t4][t3]=-8;
					}
					else
					{
						l[t4][t3].setIcon(new ImageIcon(str[10]));	
						a[t4][t3]=-1;
					}
					nishu=1;	
				}
			}
			else
			throw new Error("Invalid move...");
		}
		catch(Error e)
		{
			text.append("\n****** Invalid Move ...*******");
			//addLable(e.getMessage());
			System.out.println(e.getMessage());
		}
	}
	void move_bishop()
	{
		int t1 = X1/80;
		int t2 = Y1/80;
		int t3 = X2/80;
		int t4 = Y2/80;
		flag=0;
		System.out.println("move Bishop : "+t2+"   "+t1+"   "+t4+"   "+t3);	
		text.append("\nMove Bishop  : "+t2+"   "+t1+"   "+t4+"   "+t3);
		if(Math.abs(t4-t2)==Math.abs(t3-t1))
		{
			
			if(t4>t2 && t3>t1)
			{	
				for(int i=1;i<(t4-t2);i++)
				{
					if(a[t2+i][t1+i]==10 || a[t2+i][t1+i]==11)
					{
						flag=0;
					}
					else
					{
						flag=1;
						break;
					}
				}
			}
			
			else if(t4>t2 && t3<t1)
			{
				for(int i=1;i<(t4-t2);i++)
				{
					if(a[t2+i][t1-i]==10 || a[t2+i][t1-i]==11 )
					{
						flag=0;
					}
					else
					{
						flag=1;
						break;
					}
				}
			}
			else if(t4<t2 && t3>t1)
			{
				for(int i=1;i<(t2-t4);i++)
				{
					if(a[t2-i][t1+i]==10 || a[t2-i][t1+i]==11 )
					{
						flag=0;
					}
					else
					{
						flag=1;
						break;
					}
				}
			}
			else if(t4<t2 && t3<t1)
			{
				for(int i=1;i<(t4-t2);i++)
				{
					if(a[t2-i][t1-i]==10 || a[t2-i][t1-i]==11)
					{
						flag=0;
					}
					else
					{
						flag=1;
						break;
					}
				}
			}
			try
			{
			if(flag==0 && (((select==3 || select==6) &&(a[t4][t3]<0 || a[t4][t3]==10 || a[t4][t3]==11)) || ((select == -3 || select == 				-6) &&(a[t4][t3]>0))))
			{
				if(a[t4][t3]!=10 && a[t4][t3]!=11)
				{
					removedata(t4,t3);
				}

				if((t1+t2)%2==0)
				{
					l[t2][t1].setIcon(new ImageIcon(str[21]));
					a[t2][t1]=10;
				}
				else				
				{
					l[t2][t1].setIcon(new ImageIcon(str[20]));
					a[t2][t1]=11;
				}
				if(select==3 || select==6)
				{
				if((t4+t3)%2==0)
				{
				
					l[t4][t3].setIcon(new ImageIcon(str[2]));	
					a[t4][t3]=3;
				}
				else
				{
					l[t4][t3].setIcon(new ImageIcon(str[5]));	
					a[t4][t3]=6;
				}
				nishu=0;

				}
				else if(select==-3 || select==-6)
				{
				if((t4+t3)%2==0)
				{
				
					l[t4][t3].setIcon(new ImageIcon(str[15]));	
					a[t4][t3]=-6;
				}
				else
				{
					l[t4][t3].setIcon(new ImageIcon(str[12]));	
					a[t4][t3]=-3;
				}
				nishu=1;

				}
				
			}	
			else
			throw new Error("Invalid move...");
		}
		catch(Error e)
		{
			text.append("\n****** Invalid Move ...*******");
			//addLable(e.getMessage());
			System.out.println(e.getMessage());
		}							
		}
	}
	void move_knight()
	{
		int t1 = X1/80;
		int t2 = Y1/80;
		int t3 = X2/80;
		int t4 = Y2/80;
		flag=1;
		System.out.println("move knight  : "+t2+"   "+t1+"   "+t4+"   "+t3);	
		text.append("\nMove knight  : "+t2+"   "+t1+"   "+t4+"   "+t3);
		if(((Math.abs(t4-t2))==2 && (Math.abs(t3-t1))==1) || ((Math.abs(t4-t2))==1 && (Math.abs(t3-t1))==2))
		{
			if(select>0 && (a[t4][t3]==10 || a[t4][t3]==11 || a[t4][t3]<0))
			{
				flag=0;		
			}
			else if(select<0 && (a[t4][t3]==10 || a[t4][t3]==11 || a[t4][t3]>0))
			{
				flag=0;

			}
			else
				flag=1;	
		}
		try
		{
			if(flag==0 && (((select>0) &&(a[t4][t3]<0 || a[t4][t3]==10 || a[t4][t3]==11)) || ((select<0) &&(a[t4][t3]>0))))
			{
				if(a[t4][t3]!=10 && a[t4][t3]!=11)
				{
					removedata(t4,t3);
				}

				if((t1+t2)%2==0)
				{
					l[t2][t1].setIcon(new ImageIcon(str[21]));
					a[t2][t1]=10;
				}
				else				
				{
					l[t2][t1].setIcon(new ImageIcon(str[20]));
					a[t2][t1]=11;
				}
				if(select>0)
				{
					if((t4+t3)%2==0)
					{
				
						l[t4][t3].setIcon(new ImageIcon(str[6]));	
						a[t4][t3]=2;
					}
					else
					{
						l[t4][t3].setIcon(new ImageIcon(str[1]));	
						a[t4][t3]=7;
					}
					nishu=0;

				}
				else if(select<0)
				{
					if((t4+t3)%2==0)
					{
				
						l[t4][t3].setIcon(new ImageIcon(str[11]));	
						a[t4][t3]=-2;
					}
					else
					{
						l[t4][t3].setIcon(new ImageIcon(str[16]));	
						a[t4][t3]=-7;
					}
					nishu=1;

				}
				
			}	
			else
			throw new Error("Invalid move...");
		}
		catch(Error e)
		{
			text.append("\n****** Invalid Move ...*******");
			//addLable(e.getMessage());
			System.out.println(e.getMessage());
		}							
		
	}
												
}	
class Demo
{
	public static void main(String a[]) 		
	{
	//	Graphics g;
		NA11 kp=new NA11();
		kp.setBounds(0,0,1280,640);
		//kp.setLayout(new FlowLayout());
		kp.setLayout(new GridLayout(1,2));
		//g.drawLine(645,0,645,640);
		kp.setVisible(true);
		kp.setTitle("chess_AN");	
	}
}