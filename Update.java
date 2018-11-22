package reminderApp;
import java.awt.EventQueue;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.swing.*;
public class Update extends JFrame {

	private JPanel contentPane;
	private JTextField JT_time1;
	private JTextField JT_date1;
	private JTextField JT_event1;
	private JTextField JT_reminder;
	//DATABASE CONNECTION
	public void theQuery(String query){
	      Connection con = null;
	      Statement st = null;
	      try{
	          con = DriverManager.getConnection("jdbc:mysql://localhost/event","root","root");
	          st = con.createStatement();
	          st.executeUpdate(query);
	          JOptionPane.showMessageDialog(null,"Reminder Updated");
	      }catch(Exception ex){
	          JOptionPane.showMessageDialog(null,ex.getMessage());
	      }
	  }
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Update frame = new Update();
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
	public Update() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 664, 434);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(250, 250, 210));
		panel.setLayout(null);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBounds(10, 0, 650, 375);
		contentPane.add(panel);
		
		JLabel label = new JLabel("Date ");
		label.setFont(new Font("Verdana", Font.PLAIN, 14));
		label.setBounds(84, 167, 46, 14);
		panel.add(label);
		
		JLabel label_1 = new JLabel("Time");
		label_1.setFont(new Font("Verdana", Font.PLAIN, 14));
		label_1.setBounds(395, 167, 46, 14);
		panel.add(label_1);
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.setHorizontalAlignment(SwingConstants.TRAILING);
		btnUpdate.setIcon(new ImageIcon("C:\\Users\\salma\\Downloads\\icons8-update-64.png"));
		btnUpdate.setBackground(UIManager.getColor("CheckBox.background"));
		btnUpdate.setForeground(new Color(0, 102, 102));
		//UPDATE ON BUTTON CLICK
		
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Connection con = null;
				Statement st=null;
					try{
					con = DriverManager.getConnection("jdbc:mysql://localhost/event","root","root");
			        st = con.createStatement();
			         theQuery("update reminders set Date = '"+JT_date1.getText()+"',Time = '"+JT_time1.getText()+"', EventDetails = '"+JT_event1.getText()+"' where R_no = " +JT_reminder.getText());
			         }
			         catch(Exception ex){}
			         }

			private void theQuery(String string) {
			
				
			}
			     });
		
		btnUpdate.setFont(new Font("Verdana", Font.BOLD, 15));
		btnUpdate.setBounds(374, 289, 173, 62);
		panel.add(btnUpdate);
		
		JT_time1 = new JTextField();
		JT_time1.setColumns(10);
		JT_time1.setBounds(451, 160, 96, 33);
		panel.add(JT_time1);
		
		JT_date1 = new JTextField();
		JT_date1.setColumns(10);
		JT_date1.setBounds(210, 160, 139, 33);
		panel.add(JT_date1);
		
		JT_event1 = new JTextField();
		JT_event1.setColumns(10);
		JT_event1.setBounds(210, 216, 337, 33);
		panel.add(JT_event1);
		
		JLabel lblReminderDetails = new JLabel("Reminder Details");
		lblReminderDetails.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblReminderDetails.setBounds(84, 223, 139, 14);
		panel.add(lblReminderDetails);
		
		JLabel lblReminders = new JLabel("Reminder No");
		lblReminders.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblReminders.setBounds(84, 113, 109, 14);
		panel.add(lblReminders);
		
		JLabel lblUpdateReminder = new JLabel("UPDATE REMINDER");
		lblUpdateReminder.setForeground(new Color(0, 102, 102));
		lblUpdateReminder.setFont(new Font("Verdana", Font.BOLD, 20));
		lblUpdateReminder.setBounds(158, 28, 270, 30);
		panel.add(lblUpdateReminder);
		
		JT_reminder = new JTextField();
		JT_reminder.setColumns(10);
		JT_reminder.setBounds(210, 106, 139, 33);
		panel.add(JT_reminder);
		
		JButton buttonBack = new JButton("BACK");
		buttonBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				this.setVisible(false);
				new Reminder().setVisible(true);
				
				
			}

			private void setVisible(boolean b) {
				// TODO Auto-generated method stub
				
			}
		});
		buttonBack.setIcon(new ImageIcon("C:\\Users\\salma\\Downloads\\icons8-go-back-64.png"));
		buttonBack.setHorizontalAlignment(SwingConstants.LEFT);
		buttonBack.setForeground(new Color(0, 102, 102));
		buttonBack.setFont(new Font("Verdana", Font.BOLD, 15));
		buttonBack.setBackground(UIManager.getColor("CheckBox.background"));
		buttonBack.setBounds(210, 289, 157, 62);
		panel.add(buttonBack);
	}
}
