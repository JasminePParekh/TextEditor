import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.Random;
import javax.swing.border.*;
import javax.swing.BorderFactory;
public class MenuThing extends JPanel implements ActionListener
{
	JFrame frame;
	JMenuBar menuBar = new JMenuBar();
	JMenu fontMenu, sizeMenu, colorTextMenu, colorBackMenu, outlineColorMenu;
	JButton [] buttons = new JButton[4];
	JButton reset;
	JMenuItem [] fontItem = new JMenuItem [3];
	JMenuItem [] sizeItem = new JMenuItem [3];
	JMenuItem [] colorTextItem = new JMenuItem [3];
	JMenuItem [] colorBackItem = new JMenuItem [3];
	JMenuItem [] outlineColorItem = new JMenuItem[4];
	JPanel panel;
	JTextArea area = new JTextArea();
	Font newFont;
	int fontSize;
	String fontName;
	Random rand = new Random();
	Border empty;


	public MenuThing()
	{
		frame=new JFrame();
		frame.add(this);
		panel = new JPanel(new GridLayout(1,6));

		buttons[0] = new JButton("North");
		buttons[1] = new JButton("South");
		buttons[2] = new JButton("East");
		buttons[3] = new JButton("West");

		for(int j=0;j<4;j++){
			buttons[j].addActionListener(this);
			panel.add(buttons[j]);
		}
		empty = BorderFactory.createEmptyBorder();
		fontName = "Arial";
		fontSize = 40;
		newFont = new Font(fontName,Font.PLAIN,fontSize);
		fontMenu = new JMenu("Font");
		sizeMenu = new JMenu("Font Size");
		colorTextMenu = new JMenu("Text Color");
		colorBackMenu = new JMenu("Background Color");
		outlineColorMenu = new JMenu("Outline Button Color");

		fontItem[0] = new JMenuItem("Times New Roman");
		fontItem[1] = new JMenuItem("Arial");
		fontItem[2] = new JMenuItem("Monospaced");

		sizeItem[0] = new JMenuItem("10");
		sizeItem[1] = new JMenuItem("40");
		sizeItem[2] = new JMenuItem("100");

		colorTextItem[0] = new JMenuItem("Black");
		colorTextItem[1] = new JMenuItem("Magenta");
		colorTextItem[2] = new JMenuItem("Random");

		colorBackItem[0] = new JMenuItem("Red");
		colorBackItem[1] = new JMenuItem("Yellow");
		colorBackItem[2] = new JMenuItem("Random");

		outlineColorItem[0] = new JMenuItem("None");
		outlineColorItem[1] = new JMenuItem("Red");
		outlineColorItem[2] = new JMenuItem("Blue");
		outlineColorItem[3] = new JMenuItem("Random");

		area.setFont(newFont);



		for(int i=0;i<3;i++){
			fontItem[i].addActionListener(this);
			sizeItem[i].addActionListener(this);
			colorTextItem[i].addActionListener(this);
			colorBackItem[i].addActionListener(this);
			fontMenu.add(fontItem[i]);
			sizeMenu.add(sizeItem[i]);
			colorTextMenu.add(colorTextItem[i]);
			colorBackMenu.add(colorBackItem[i]);
		}
		for(int i=0;i<4;i++){
			outlineColorItem[i].addActionListener(this);
			outlineColorMenu.add(outlineColorItem[i]);
		}
		menuBar.setLayout(new GridLayout(5,1));
		menuBar.add(fontMenu);
		menuBar.add(sizeMenu);
		menuBar.add(colorTextMenu);
		menuBar.add(colorBackMenu);
		menuBar.add(outlineColorMenu);
		panel.add(menuBar);

		reset = new JButton("Reset");
		reset.addActionListener(this);
		panel.add(reset);
		for(JButton b : buttons){
				b.setBorder(empty);
			}
			reset.setBorder(empty);

		frame.add(panel, BorderLayout.NORTH);
		frame.add(area, BorderLayout.CENTER);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1000,600);
		frame.setVisible(true);
	}

	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == buttons[0]){
			frame.remove(panel);
			frame.remove(menuBar);
			frame.remove(reset);
			panel.setLayout(new GridLayout(1,6));
			menuBar.setLayout(new GridLayout(5,1));
			panel.add(menuBar);
			panel.add(reset);
			frame.add(panel, BorderLayout.NORTH);
		}
		if(e.getSource() == buttons[1]){
			frame.remove(panel);
			frame.remove(menuBar);
			frame.remove(reset);
			panel.setLayout(new GridLayout(1,6));
			menuBar.setLayout(new GridLayout(5,1));
			panel.add(menuBar);
			panel.add(reset);
			frame.add(panel, BorderLayout.SOUTH);
		}
		if(e.getSource() == buttons[2]){
			frame.remove(panel);
			frame.remove(menuBar);
			frame.remove(reset);
			panel.setLayout(new GridLayout(6,1));
			menuBar.setLayout(new GridLayout(5,1));
			panel.add(menuBar);
			panel.add(reset);
			frame.add(panel, BorderLayout.EAST);
		}
		if(e.getSource() == buttons[3]){
			frame.remove(panel);
			frame.remove(menuBar);
			frame.remove(reset);
			panel.setLayout(new GridLayout(6,1));
			menuBar.setLayout(new GridLayout(5,1));
			panel.add(menuBar);
			panel.add(reset);
			frame.add(panel, BorderLayout.WEST);
		}
		if(e.getSource() == reset){
			frame.remove(panel);
			frame.remove(menuBar);
			frame.remove(reset);
			for(int j=0;j<4;j++){
				panel.remove(buttons[j]);
			}
			buttons = new JButton[4];
			buttons[0] = new JButton("North");
			buttons[1] = new JButton("South");
			buttons[2] = new JButton("East");
			buttons[3] = new JButton("West");

			for(int j=0;j<4;j++){
				buttons[j].addActionListener(this);
				panel.add(buttons[j]);
			}
			panel.setLayout(new GridLayout(1,6));
			menuBar.setLayout(new GridLayout(5,1));
			reset.setBorder(empty);
			reset.setForeground(Color.BLACK);
			fontName = "Arial";
			fontSize = 40;
			newFont = new Font(fontName,Font.PLAIN,fontSize);
			area.setFont(newFont);
			area.setForeground(Color.BLACK);
			area.setBackground(Color.WHITE);
			area.setText(null);
			buttons[0].setBorder(empty);
			buttons[1].setBorder(empty);
			buttons[2].setBorder(empty);
			buttons[3].setBorder(empty);
			panel.add(menuBar);
			panel.add(reset);
			frame.add(panel, BorderLayout.NORTH);
		}
		for(JMenuItem j: fontItem){
			if(e.getSource() == j){
				if(j.getText() == "Times New Roman"){
					fontName = "Times New Roman";
				}
				else if(j.getText() == "Arial"){
					fontName = "Arial";
				}
				else if(j.getText() == "Monospaced"){
					fontName = "Monospaced";
				}
				newFont = new Font(fontName,Font.PLAIN,fontSize);
					area.setFont(newFont);
			}
		}
		for(JMenuItem j: sizeItem){
			if(e.getSource() == j){
				if(j.getText() == "10"){
					fontSize = 10;
				}
				else if(j.getText() == "40"){
					fontSize = 40;
				}
				else if(j.getText() == "100"){
					fontSize = 100;
				}
				newFont = new Font(fontName,Font.PLAIN,fontSize);
					area.setFont(newFont);
			}
		}
		for(JMenuItem j: colorTextItem){
			if(e.getSource() == j){
				if(j.getText() == "Black"){
					for(int i=0;i<4;i++){
						buttons[i].setForeground(Color.BLACK);
					}
					reset.setForeground(Color.BLACK);
					area.setForeground(Color.BLACK);
				}
				else if(j.getText() == "Magenta"){
					for(int i=0;i<4;i++){
						buttons[i].setForeground(Color.MAGENTA);
					}
					reset.setForeground(Color.MAGENTA);
					area.setForeground(Color.MAGENTA);
				}
				else if(j.getText() == "Random"){
					for(int i=0;i<4;i++){
						buttons[i].setForeground(randColor());
					}
					reset.setForeground(randColor());
					area.setForeground(randColor());
				}
			}
		}
		for(JMenuItem j: colorBackItem){
			if(e.getSource() == j){
				if(j.getText() == "Red"){
					area.setBackground(Color.RED);
				}
				else if(j.getText() == "Yellow"){
					area.setBackground(Color.YELLOW);
				}
				else if(j.getText() == "Random"){
					area.setBackground(randColor());
				}
			}
		}
		for(JMenuItem j: outlineColorItem){
			if(e.getSource() == j){
				if(j.getText() == "None"){
					for(JButton b : buttons){
						b.setBorder(empty);
					}
					reset.setBorder(empty);
				}
				else if(j.getText() == "Red"){
					for(JButton b : buttons){
						b.setBorder(new LineBorder(Color.RED));
					}
					reset.setBorder(new LineBorder(Color.RED));
				}
				else if(j.getText() == "Blue"){
					for(JButton b : buttons){
						b.setBorder(new LineBorder(Color.BLUE));
					}
					reset.setBorder(new LineBorder(Color.BLUE));
				}
				else if(j.getText() == "Random"){
					for(JButton b : buttons){
						b.setBorder(new LineBorder(randColor()));
					}
					reset.setBorder(new LineBorder(randColor()));
				}
			}
		}


		frame.revalidate();

	}
	public Color randColor(){
		float r = rand.nextFloat();
		float g = rand.nextFloat();
		float b = rand.nextFloat();

		Color randomColor = new Color(r, g, b);

		return randomColor;
	}



	public static void main(String[] args)
	{
		MenuThing app=new MenuThing();
	}

}