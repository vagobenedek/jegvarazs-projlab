import java.awt.Component;
import java.awt.Dimension;

import javax.swing.*;

public class ViewMenu extends JComponent {
	private JButton button = new JButton("Uj jatek");
	
	private JLabel label1 = new JLabel("Palya meret");
	private JLabel label2 = new JLabel("Eszkimo");
	private JLabel label3 = new JLabel("Sarkkutato");
	
	private JTextField text1 = new JTextField(5);
	private JTextField text2 = new JTextField(5);
	private JTextField text3 = new JTextField(5);
	
	public ViewMenu(ViewController vc) {
		vc.setSize(new Dimension(400, 400));
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		button.setAlignmentX(Component.CENTER_ALIGNMENT);
		button.setMaximumSize(new Dimension(150, 40));
		add(button);
		add(Box.createRigidArea(new Dimension(0, 30)));
		
		label1.setAlignmentX(Component.CENTER_ALIGNMENT);
		text1.setAlignmentX(Component.CENTER_ALIGNMENT);
		text1.setEditable(false);
		add(label1);
		add(text1);
		text1.setHorizontalAlignment(SwingConstants.CENTER);
		text1.setText(Integer.toString(vc.getMeret()));
		text1.setMaximumSize(new Dimension(150, 40));
		add(Box.createRigidArea(new Dimension(0, 30)));
		
		label2.setAlignmentX(Component.CENTER_ALIGNMENT);
		text2.setAlignmentX(Component.CENTER_ALIGNMENT);
		text2.setEditable(false);
		add(label2);
		add(text2);
		text2.setHorizontalAlignment(SwingConstants.CENTER);
		text2.setText(Integer.toString(vc.getESzam()));
		text2.setMaximumSize(new Dimension(150, 40));
		add(Box.createRigidArea(new Dimension(0, 30)));
		
		label3.setAlignmentX(Component.CENTER_ALIGNMENT);
		text3.setAlignmentX(Component.CENTER_ALIGNMENT);
		text3.setEditable(false);
		add(label3);
		add(text3);
		text3.setHorizontalAlignment(SwingConstants.CENTER);
		text3.setText(Integer.toString(vc.getSSzam()));
		text3.setMaximumSize(new Dimension(150, 40));
		add(Box.createRigidArea(new Dimension(0, 30)));
		
		
	}
}
