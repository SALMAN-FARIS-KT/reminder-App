package reminderApp;
import java.awt.EventQueue;
import javax.swing.border.EmptyBorder;
import net.proteanit.sql.DbUtils;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.*;
import java.awt.Font;
import java.awt.Color;
public class view extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JButton btnAddNew;
	private JScrollPane scrollPane;
	public void theQuery(String query){
	      Connection con = null;
	      Statement st = null;
	      try{
	          con = DriverManager.getConnection("jdbc:mysql://localhost/event","root","root");
	          st = con.createStatement();
	          st.executeUpdate(query);
	          JOptionPane.showMessageDialog(null,"loaded");
	      }catch(Exception ex){
	          JOptionPane.showMessageDialog(null,ex.getMessage());
	      }
	  }
	 
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					view frame = new view();
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
	public view() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 698, 432);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(250, 250, 210));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("REMINDERS");
		lblNewLabel.setForeground(new Color(0, 102, 102));
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 20));
		lblNewLabel.setBounds(117, 49, 171, 22);
		contentPane.add(lblNewLabel);
		
		JButton btnReload = new JButton("RELOAD");
		btnReload.setFont(new Font("Verdana", Font.BOLD, 13));
		btnReload.setBackground(UIManager.getColor("CheckBox.background"));
		btnReload.setForeground(new Color(0, 102, 102));
		
		//code to view the reminders from database,
		
		btnReload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				Connection con = null;
				Statement st=null;
					try{
					con = DriverManager.getConnection("jdbc:mysql://localhost/event","root","root");
			        st = con.createStatement();
			        ResultSet rs=st.executeQuery("select R_no,Date,Time,Eventdetails from reminders");
				table.setModel(DbUtils.resultSetToTableModel(rs));
        //rs2xml.jar file is added to the external library to display the data in table format 
				
			}
				catch(Exception ex){
					System.out.print(ex);
				}
			}
			});
		btnReload.setBounds(391, 45, 103, 34);
		contentPane.add(btnReload);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(49, 96, 572, 258);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		btnAddNew = new JButton("ADD NEW");
		btnAddNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				this.setVisible(false);
		        new Newreminder().setVisible(true);//this redirect to  newremider frame
				
			}

			
			private void setVisible(boolean b) {
				// TODO Auto-generated method stub
				
			}
		});
		btnAddNew.setForeground(new Color(0, 128, 128));
		btnAddNew.setFont(new Font("Verdana", Font.BOLD, 13));
		btnAddNew.setBounds(508, 45, 103, 34);
		contentPane.add(btnAddNew);
	}
}

