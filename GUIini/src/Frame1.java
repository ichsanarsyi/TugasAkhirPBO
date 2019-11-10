import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Window.Type;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JProgressBar;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSpinner;
import javax.swing.JToggleButton;
import javax.swing.JScrollBar;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.SpinnerNumberModel;

public class Frame1 {

	private JFrame Frame;
	private JTextField textField1;
	private JTextField textField2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame1 window = new Frame1();
					window.Frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Frame1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Frame = new JFrame();
		Frame.setResizable(false);
		Frame.setTitle("Males Ngitung");
		Frame.setBounds(100, 100, 300, 300);
		Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Frame.getContentPane().setLayout(null);
		
		textField1 = new JTextField();
		textField1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField1.setBounds(22, 36, 159, 45);
		Frame.getContentPane().add(textField1);
		textField1.setColumns(10);
		
		textField2 = new JTextField();
		textField2.setEditable(false);
		textField2.setBounds(122, 204, 103, 37);
		Frame.getContentPane().add(textField2);
		textField2.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Kelajuan");
		lblNewLabel.setBounds(22, 11, 110, 14);
		Frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Jarak Tempuh");
		lblNewLabel_1.setBounds(22, 215, 90, 14);
		Frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_3 = new JLabel("KM");
		lblNewLabel_3.setBounds(235, 215, 19, 14);
		Frame.getContentPane().add(lblNewLabel_3);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Hour", "Sec"}));
		comboBox_1.setBounds(196, 125, 58, 20);
		Frame.getContentPane().add(comboBox_1);
		
		JLabel lblWaktuTempuh = new JLabel("Waktu Tempuh");
		lblWaktuTempuh.setBounds(22, 92, 110, 14);
		Frame.getContentPane().add(lblWaktuTempuh);
		
		JRadioButton kmh = new JRadioButton("KM/H");
		kmh.setBounds(187, 36, 92, 20);
		Frame.getContentPane().add(kmh);
		
		JRadioButton ms = new JRadioButton("M/S");
		ms.setToolTipText("");
		ms.setBounds(187, 59, 67, 22);
		Frame.getContentPane().add(ms);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(kmh);
		bg.add(ms);
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(new Integer(0), null, null, new Integer(1)));
		spinner.setBounds(22, 125, 159, 20);
		Frame.getContentPane().add(spinner);
		
		JButton btnNewButton = new JButton("Itung!");
		btnNewButton.setBackground(Color.GREEN);
		btnNewButton.setForeground(Color.RED);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent act) {
				int kelajuan;
				int waktu;
				int idx;
				float jarakf;
				try {
					kelajuan = Integer.parseInt(textField1.getText());
					waktu = (int) spinner.getValue();
					idx = comboBox_1.getSelectedIndex();
					if ((kmh.isSelected())&&(idx==0)) {
						jarakf=kelajuan*waktu;
						textField2.setText(""+jarakf);
					}
					else if ((kmh.isSelected())&&(idx==1)) {
						jarakf=kelajuan*waktu/3600;
						textField2.setText(""+jarakf);
					}
					else if ((ms.isSelected())&&(idx==0)) {
						jarakf=kelajuan*waktu*3600/1000;
						textField2.setText(""+jarakf);
					}
					else if ((ms.isSelected())&&(idx==1)) {
						jarakf=kelajuan*waktu/1000;
						textField2.setText(""+jarakf);
					}
				}
				catch(Exception e){
					JOptionPane.showMessageDialog(null, "Masukkan angka yang valid");
				}
				
			}
		});
		btnNewButton.setBounds(108, 165, 73, 28);
		Frame.getContentPane().add(btnNewButton);
		

	}
}
