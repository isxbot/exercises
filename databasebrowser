import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Assignment_02Source extends JFrame {
	private JButton buttonPrev = new JButton("Prev");
	private JButton buttonReset = new JButton("Reset");
	private JButton buttonNext = new JButton("Next");

	private JLabel labelHeader = new JLabel("Database Browser", JLabel.CENTER);
	private JLabel labelName = new JLabel("Name");
	private JLabel labelAddress = new JLabel("Address");
	private JLabel labelCity = new JLabel("City");
	private JLabel labelState = new JLabel("State");
	private JLabel labelZip = new JLabel("Zip");

	private JTextField textFieldName = new JTextField();
	private JTextField textFieldAddress = new JTextField();
	private JTextField textFieldCity = new JTextField();
	private JTextField textFieldState = new JTextField();
	private JTextField textFieldZip = new JTextField();

	// Database variables.
	String jdbcURL = "jdbc:oracle:thin:@localhost:1521:XE";
	Connection conn = null;
	Statement statement = null;
	ResultSet resultSet = null;
	String user = "student1";
	String passwd = "pass";

	public Assignment_02Source(String title) {

		super(title);

		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

		JPanel cp = (JPanel) getContentPane();

		labelHeader.setFont(new Font("TimesRoman", Font.BOLD, 24));
		labelHeader.setBounds(40, 10, 300, 50);

		buttonPrev.setBounds(30, 250, 80, 25);
		buttonReset.setBounds(150, 250, 80, 25);
		buttonNext.setBounds(270, 250, 80, 25);

		labelName.setBounds(10, 80, 80, 25);
		labelAddress.setBounds(10, 110, 80, 25);
		labelCity.setBounds(10, 140, 80, 25);
		labelState.setBounds(10, 170, 80, 25);
		labelZip.setBounds(10, 200, 80, 25);

		textFieldName.setBounds(120, 80, 250, 25);
		textFieldAddress.setBounds(120, 110, 250, 25);
		textFieldCity.setBounds(120, 140, 250, 25);
		textFieldState.setBounds(120, 170, 250, 25);
		textFieldZip.setBounds(120, 200, 250, 25);

		cp.setLayout(null);
		cp.add(labelHeader);
		cp.add(buttonPrev);
		cp.add(buttonReset);
		cp.add(buttonNext);
		cp.add(labelName);
		cp.add(textFieldName);
		cp.add(labelAddress);
		cp.add(textFieldAddress);
		cp.add(labelCity);
		cp.add(textFieldCity);
		cp.add(labelState);
		cp.add(textFieldState);
		cp.add(labelZip);
		cp.add(textFieldZip);

		try {
			// Load database driver.
			Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
			// Get a connection to the database.
			conn = DriverManager.getConnection(jdbcURL, user, passwd);
			// Create a statement.
			statement = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

			// Store the statement information.
			resultSet = statement
					.executeQuery("SELECT concat(firstname,lastname) as name, street, state, city, zip FROM address");
			// Create a DataClass object to store the result data.

			// Populate the text fields at startup.
			resultSet.next();
			nameChange(resultSet.getString("Name"));
			addressChange(resultSet.getString("Street"));
			cityChange(resultSet.getString("City"));
			stateChange(resultSet.getString("State"));
			zipChange(resultSet.getString("Zip"));

		} catch (Exception e) {
			e.printStackTrace();
		}

		addWindowListener(new java.awt.event.WindowAdapter() {

			public void windowClosing(java.awt.event.WindowEvent evt) {

				shutDown();
			}
		});

		// Implement the 'Previous' button functionality.
		buttonPrev.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {

				try {
					// Move to the previous row.
					if (resultSet.previous()) {
						nameChange(resultSet.getString("name"));
						addressChange(resultSet.getString("street"));
						cityChange(resultSet.getString("city"));
						stateChange(resultSet.getString("state"));
						zipChange(resultSet.getString("zip"));
					}
					// If the cursor is before the first row, go to the last row.
					if (resultSet.isBeforeFirst()) {
						if (resultSet.last()) {
							nameChange(resultSet.getString("name"));
							addressChange(resultSet.getString("street"));
							cityChange(resultSet.getString("city"));
							stateChange(resultSet.getString("state"));
							zipChange(resultSet.getString("zip"));
						}
					}

				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});
		// Implement the 'Next' button functionality.
		buttonNext.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				try {
					// Move to the next row.
					if (resultSet.next()) {

						nameChange(resultSet.getString("Name"));
						addressChange(resultSet.getString("Street"));
						cityChange(resultSet.getString("City"));
						stateChange(resultSet.getString("State"));
						zipChange(resultSet.getString("Zip"));
					}
					// If the cursor is after the last row, move to the first row.
					if (resultSet.isAfterLast()) {
						if (resultSet.first()) {
							nameChange(resultSet.getString("name"));
							addressChange(resultSet.getString("street"));
							cityChange(resultSet.getString("city"));
							stateChange(resultSet.getString("state"));
							zipChange(resultSet.getString("zip"));
						}
					}

				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});
		// Implement the 'Reset' button functionality.
		buttonReset.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				try {
					// Move the cursor to the first row.
					resultSet.first();
					nameChange(resultSet.getString("name"));
					addressChange(resultSet.getString("street"));
					cityChange(resultSet.getString("city"));
					stateChange(resultSet.getString("state"));
					zipChange(resultSet.getString("zip"));

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private void shutDown() {

		int returnVal = JOptionPane.showConfirmDialog(this, "Are you sure you want to quit?");

		if (returnVal == JOptionPane.YES_OPTION) {

			System.exit(0);
		}
	}

	// Methods to change the text fields.
	public void nameChange(String name) throws SQLException {
		this.textFieldName.setText(name);

	}

	public void addressChange(String address) throws SQLException {
		this.textFieldAddress.setText(address);

	}

	public void cityChange(String city) throws SQLException {
		this.textFieldCity.setText(city);

	}

	public void stateChange(String state) throws SQLException {
		this.textFieldState.setText(state);
	}

	public void zipChange(String zip) throws SQLException {
		this.textFieldZip.setText(zip);
	}

	public static void main(String args[]) {

		Assignment_02Source a2 = new Assignment_02Source("Database Browser");

		a2.setSize(400, 350);
		a2.setVisible(true);
	}
}
