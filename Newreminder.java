package reminderApp;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.swing.*;
import java.awt.Color;


public class Newreminder extends JFrame {

	private JPanel contentPane;
	private JTextField JT_reminder;
	private JTextField JT_time;
	private JTextField JT_date;
	private JTextField JT_event;

	/**
	 * Launch the application.
	 */
	public void theQuery(String query){
	      Connection con = null;
	      Statement st = null;
	      try{
	          con = DriverManager.getConnection("jdbc:mysql://localhost/event","root","root");
	          st = con.createStatement();
	          st.executeUpdate(query);
	          JOptionPane.showMessageDialog(null,"Reminder Added");
	      }catch(Exception ex){
	          JOptionPane.showMessageDialog(null,ex.getMessage());
	      }
	  }
	 
	 
	    
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Newreminder frame = new Newreminder();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Newreminder() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 666, 414);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(250, 250, 210));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JT_reminder = new JTextField();
		JT_reminder.setBounds(196, 88, 139, 33);
		contentPane.add(JT_reminder);
		JT_reminder.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Date ");
		lblNewLabel.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblNewLabel.setBounds(63, 154, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Time");
		lblNewLabel_1.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(364, 154, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JButton btnSaveButton = new JButton("SAVE");
		btnSaveButton.setHorizontalAlignment(SwingConstants.LEFT);
		btnSaveButton.setIcon(new ImageIcon("C:\\Users\\salma\\Downloads\\icons8-save-64.png"));
		btnSaveButton.setForeground(new Color(0, 102, 102));
		btnSaveButton.setBackground(UIManager.getColor("CheckBox.background"));
    //ADDING AND SAVING REMINDER INTO DATABASE , TABLE NAME :reminders 
		btnSaveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
			         try{
			             theQuery("insert into reminders (R_no,Date,Time,Eventdetails) values('"+JT_reminder.getText()+"','"+JT_date.getText()+"','"+JT_time.getText()+"','"+JT_event.getText()+"')");
			         }
			         catch(Exception ex){}
			         }
			     });
			    
			
		
		btnSaveButton.setFont(new Font("Verdana", Font.BOLD, 15));
		btnSaveButton.setBounds(363, 289, 153, 62);
		contentPane.add(btnSaveButton);
		
		JT_time = new JTextField();
		JT_time.setBounds(420, 147, 96, 33);
		contentPane.add(JT_time);
		JT_time.setColumns(10);
		
		JT_date = new JTextField();
		JT_date.setBounds(196, 149, 139, 33);
		contentPane.add(JT_date);
		JT_date.setColumns(10);
		
		JT_event = new JTextField();
		JT_event.setBounds(196, 212, 320, 33);
		contentPane.add(JT_event);
		JT_event.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Reminder Details");
		lblNewLabel_2.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(63, 219, 145, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Reminder No");
		lblNewLabel_3.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(63, 95, 109, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("ADD NEW REMINDER");
		lblNewLabel_4.setForeground(new Color(0, 102, 102));
		lblNewLabel_4.setFont(new Font("Verdana", Font.BOLD, 20));
		lblNewLabel_4.setBounds(158, 28, 270, 30);
		contentPane.add(lblNewLabel_4);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}

			private void setVisible(boolean b) {
				// TODO Auto-generated method stub
				
			}
		});
		btnBack.setHorizontalAlignment(SwingConstants.LEFT);
		btnBack.setIcon(new ImageIcon("C:\\Users\\salma\\Downloads\\icons8-go-back-64.png"));
		btnBack.setForeground(new Color(0, 102, 102));
		btnBack.setFont(new Font("Verdana", Font.BOLD, 15));
		btnBack.setBackground(UIManager.getColor("CheckBox.background"));
		btnBack.setBounds(196, 289, 157, 62);
		contentPane.add(btnBack);
	}
}
