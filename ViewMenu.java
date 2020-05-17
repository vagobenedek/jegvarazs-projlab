import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.*;

public class ViewMenu extends JComponent {
	private ViewController view;
	/**
	 * A menu gombjai.
	 */
	private JButton button = new JButton("Uj jatek");
	private JButton meretMinus = new JButton("-");
	private JButton meretPlus = new JButton("+");
	private JButton eszkimoMinus = new JButton("-");
	private JButton eszkimoPlus = new JButton("+");
	private JButton sarkkutatoMinus = new JButton("-");
	private JButton sarkkutatoPlus = new JButton("+");
	/**
	 * A menu labeljei.
	 */
	private JLabel label1 = new JLabel("Palya meret");
	private JLabel label2 = new JLabel("Eszkimo");
	private JLabel label3 = new JLabel("Sarkkutato");
	/**
	 * A menun talalhato TextField-ek.
	 * text1 -> palya merete
	 * text2 -> eszkimok szama
	 * text3 -> sarkkutatok szama
	 */
	private JTextField text1 = new JTextField(15);
	private JTextField text2 = new JTextField(15);
	private JTextField text3 = new JTextField(15);
	
	public ViewMenu(ViewController vc) {
		view = vc;
		view.setSize(new Dimension(400, 400));
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		/**
		 * Az Uj jatek gomb tulajdonsagai, hozzadasa a JComponent-hez.
		 */
		button.setAlignmentX(Component.CENTER_ALIGNMENT);
		button.setMaximumSize(new Dimension(150, 40));
		add(button);
		add(Box.createRigidArea(new Dimension(0, 50)));
		/**
		 * Az Uj jatek gombhoz tartozo command, illetve ActionListener.
		 */
		button.setActionCommand("jatek");
		ActionListener alUjJatek = new UjJatekButtonActionListener();
		button.addActionListener(alUjJatek);
		
		/**
		 * Palya meretet jelzo label JComponent-hez adasa.
		 */
		label1.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(label1);
		
		/**
		 * A palya meretet jelzo TextField es a ket modositogomb JPanel-hez adasa.
		 * Majd a JPanel JComponent-hez rendelese.
		 */
		JPanel meretPanel = new JPanel();
		meretPanel.add(meretMinus);
		meretPanel.add(text1);
		meretPanel.add(meretPlus);
		text1.setEditable(false);
		text1.setHorizontalAlignment(SwingConstants.CENTER);
		text1.setText(Integer.toString(view.getMeret()));
		add(meretPanel);
		add(Box.createRigidArea(new Dimension(0, 30)));
		/**
		 * A meret csokkentese gombhoz tartozo command, illetve ActionListener.
		 */
		meretMinus.setActionCommand("meretMinus");
		ActionListener alMeretMinus = new MeretMinusButtonActionListener();
		meretMinus.addActionListener(alMeretMinus);
		/**
		 * A meret novelese gombhoz tartozo command, illetve ActionListener.
		 */
		meretPlus.setActionCommand("meretPlus");
		ActionListener alMeretPlus = new MeretPlusButtonActionListener();
		meretPlus.addActionListener(alMeretPlus);
		
		/**
		 * Eszkimok darabszamat jelzo label JComponent-hez adasa.
		 */
		label2.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(label2);
		
		/**
		 * Az eszkimok darabszamat jelzo TextField es a ket modositogomb JPanel-hez adasa.
		 * Majd a JPanel JComponent-hez rendelese.
		 */
		JPanel eszkimoPanel = new JPanel();
		eszkimoPanel.add(eszkimoMinus);
		eszkimoPanel.add(text2);
		eszkimoPanel.add(eszkimoPlus);
		text2.setEditable(false);
		text2.setHorizontalAlignment(SwingConstants.CENTER);
		text2.setText(Integer.toString(view.getESzam()));
		add(eszkimoPanel);
		add(Box.createRigidArea(new Dimension(0, 20)));
		/**
		 * Az eszkimok szamanak csokkentese gombhoz tartozo command, illetve ActionListener.
		 */
		eszkimoMinus.setActionCommand("eszkimoMinus");
		ActionListener alEszkimoMinus = new EszkimoMinusButtonActionListener();
		eszkimoMinus.addActionListener(alEszkimoMinus);
		/**
		 * Az eszkimok szamanak novelese gombhoz tartozo command, illetve ActionListener.
		 */
		eszkimoPlus.setActionCommand("eszkimoPlus");
		ActionListener alEszkimoPlus = new EszkimoPlusButtonActionListener();
		eszkimoPlus.addActionListener(alEszkimoPlus);
		
		/**
		 * Sarkkutatok darabszamat jelzo label JComponent-hez adasa.
		 */
		label3.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(label3);
		
		/**
		 * A sarkkutatok darabszamat jelzo TextField es a ket modositogomb JPanel-hez adasa.
		 * Majd a JPanel JComponent-hez rendelese.
		 */
		JPanel sarkkutatoPanel = new JPanel();
		sarkkutatoPanel.add(sarkkutatoMinus);
		sarkkutatoPanel.add(text3);
		sarkkutatoPanel.add(sarkkutatoPlus);
		text3.setEditable(false);
		text3.setHorizontalAlignment(SwingConstants.CENTER);
		text3.setText(Integer.toString(view.getSSzam()));
		add(sarkkutatoPanel);
		add(Box.createRigidArea(new Dimension(0, 20)));
		/**
		 * A sarkkutatok szamanak csokkentese gombhoz tartozo command, illetve ActionListener.
		 */
		sarkkutatoMinus.setActionCommand("sarkkutatoMinus");
		ActionListener alSarkkutatoMinus = new SarkkutatoMinusButtonActionListener();
		sarkkutatoMinus.addActionListener(alSarkkutatoMinus);
		/**
		 * A sarkkutatok szamanak novelese gombhoz tartozo command, illetve ActionListener.
		 */
		sarkkutatoPlus.setActionCommand("sarkkutatoPlus");
		ActionListener alSarkkutatoPlus = new SarkkutatoPlusButtonActionListener();
		sarkkutatoPlus.addActionListener(alSarkkutatoPlus);
	}
	
	/**
	 * 
	 * @author dgurz
	 *
	 */
	final class UjJatekButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent ae) {
			if(ae.getActionCommand().equals("jatek")) {
				try {
					view.CreateUjJatek();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}	
		}
	}
	
	/**
	 * 
	 * @author dgurz
	 *
	 */
	final class MeretMinusButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent ae) {
			if(ae.getActionCommand().equals("meretMinus")) {
				if(view.getMeret()-1 > 4) {
					view.setMeret(view.getMeret() - 1);
					text1.setText(Integer.toString(view.getMeret()));
				}
			}
		}
	}
	
	/**
	 * 
	 * @author dgurz
	 *
	 */
	final class MeretPlusButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent ae) {
			if(ae.getActionCommand().equals("meretPlus")) {
				if(view.getMeret()+1 < 16) {
					view.setMeret(view.getMeret() + 1);
					text1.setText(Integer.toString(view.getMeret()));
				}
			}
		}
	}
	
	/**
	 * 
	 * @author dgurz
	 *
	 */
	final class EszkimoMinusButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent ae) {
			if(ae.getActionCommand().equals("eszkimoMinus")) {
				if(view.getSSzam() + (view.getESzam()-1) > 2 && view.getESzam()-1 >= 0) {
					view.setESzam(view.getESzam() - 1);
					text2.setText(Integer.toString(view.getESzam()));
				}
			}
		}
	}
	
	/**
	 * 
	 * @author dgurz
	 *
	 */
	final class EszkimoPlusButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent ae) {
			if(ae.getActionCommand().equals("eszkimoPlus")) {
				if(view.getSSzam() + (view.getESzam()+1) < 11) {
					view.setESzam(view.getESzam() + 1);
					text2.setText(Integer.toString(view.getESzam()));
				}
			}
		}
	}
	
	/**
	 * 
	 * @author dgurz
	 *
	 */
	final class SarkkutatoMinusButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent ae) {
			if(ae.getActionCommand().equals("sarkkutatoMinus")) {
				if(view.getESzam() + (view.getSSzam()-1) > 2 && view.getSSzam()-1 >= 0) {
					view.setSSzam(view.getSSzam() - 1);
					text3.setText(Integer.toString(view.getSSzam()));
				}
			}
		}
	}
	
	/**
	 * 
	 * @author dgurz
	 *
	 */
	final class SarkkutatoPlusButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent ae) {
			if(ae.getActionCommand().equals("sarkkutatoPlus")) {
				if(view.getESzam() + (view.getSSzam()+1) < 11) {
					view.setSSzam(view.getSSzam() + 1);
					text3.setText(Integer.toString(view.getSSzam()));
				}
			}
		}
	}
}
