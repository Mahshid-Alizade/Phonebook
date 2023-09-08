package MainPackage;

import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Window.Type;
import javax.swing.border.TitledBorder;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Point;

import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.UIManager;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JScrollBar;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class ContactFrame extends JFrame {

	private JPanel mainPanel;
	private JTextField nameTextField;// name
	private JTextField numberTextField;// number
	private JTextField locationTextField;// location
	private JTextField birthDayTextField;// birthday
	private JTextField emailTextField;// email
	private JTable table;// main table
	private JScrollPane scrollPane;
	JRadioButton rdbtnMale;// male radio button
	JRadioButton rdbtnFemale;// female radio button
	JComboBox comboGroup;// combobox of group
	JLabel errorLabel;// error lable of contct panel
	JLabel groupErrorLabel;// error label of group panel
	JPanel informationPanel;// information panel
	JLabel locationErrorLabel;// error label of location panel
	AddressBook obj = new AddressBook();
	AddressBook.Location locOBJ = obj.new Location();// an object of inner class
	Contact c;
	String[] s;// String array for combobox
	int num;// the ID of contact

	public String getLocationMethod(int i) {

		return obj.getLocationArrayList(i);
	}

	/////////////////////////////////////////////////

	// To update Array list
	String name1;
	String phoneNumber1;
	String location1;
	String birthDay1;
	String gender1;
	String group1;
	String email1;

	/////////////////////////////////////////////////

	String name;
	String phoneNumber;
	private String location;
	String birthDay;
	String gender;
	String group;
	String email;
	private JButton btnAdd;
	private JTextField newGroup;
	private JTable groupTable;
	private JTable locationTable;
	private JTable locationTable2;

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ContactFrame frame = new ContactFrame();
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
	public ContactFrame() {
		setResizable(false);
		// main panel

		setTitle("Contact");
		setType(Type.UTILITY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 752, 350);
		mainPanel = new JPanel();
		mainPanel.setBackground(UIManager.getColor("CheckBox.background"));
		mainPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(mainPanel);
		mainPanel.setLayout(null);

		// information panel
		informationPanel = new JPanel();
		informationPanel.setBorder(new TitledBorder(new LineBorder(new Color(255, 175, 175), 4), "  Information  ",
				TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		informationPanel.setBounds(10, 11, 272, 298);
		mainPanel.add(informationPanel);
		informationPanel.setLayout(null);

		///////////////////////////////////////////////////////////////////////////////////////
		///////////////////////////////////////////////////////////////////////////////////////

		// our labels
		JLabel lblName = new JLabel("Name :");
		lblName.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		lblName.setHorizontalAlignment(SwingConstants.LEFT);
		lblName.setBounds(20, 21, 82, 28);
		informationPanel.add(lblName);

		JLabel lblPhoneNumber = new JLabel("Phone Number :");
		lblPhoneNumber.setHorizontalAlignment(SwingConstants.LEFT);
		lblPhoneNumber.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		lblPhoneNumber.setBounds(20, 47, 117, 28);
		informationPanel.add(lblPhoneNumber);

		JLabel lblAddress = new JLabel("Address :");
		lblAddress.setHorizontalAlignment(SwingConstants.LEFT);
		lblAddress.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		lblAddress.setBounds(20, 77, 82, 28);
		informationPanel.add(lblAddress);

		JLabel lblBirthday = new JLabel("BirthDay :");
		lblBirthday.setHorizontalAlignment(SwingConstants.LEFT);
		lblBirthday.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		lblBirthday.setBounds(20, 105, 82, 28);
		informationPanel.add(lblBirthday);

		JLabel lblEmail = new JLabel("Email :");
		lblEmail.setHorizontalAlignment(SwingConstants.LEFT);
		lblEmail.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		lblEmail.setBounds(20, 192, 82, 28);
		informationPanel.add(lblEmail);

		JLabel lblGroup = new JLabel("Group :");
		lblGroup.setHorizontalAlignment(SwingConstants.LEFT);
		lblGroup.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		lblGroup.setBounds(20, 159, 82, 28);
		informationPanel.add(lblGroup);

		JLabel lblGender = new JLabel("Gender :");
		lblGender.setHorizontalAlignment(SwingConstants.LEFT);
		lblGender.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		lblGender.setBounds(20, 133, 82, 28);
		informationPanel.add(lblGender);

		/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		// text fields
		// ****************************************************************************
		nameTextField = new JTextField();
		nameTextField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				name = nameTextField.getText();
			}
		});
		// name text field
		nameTextField.setBackground(Color.PINK);
		nameTextField.setBounds(74, 27, 175, 20);
		informationPanel.add(nameTextField);
		nameTextField.setColumns(10);

		numberTextField = new JTextField();
		numberTextField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				phoneNumber = numberTextField.getText();
			}
		});
		// number text field
		numberTextField.setBackground(Color.PINK);
		numberTextField.setBounds(132, 53, 117, 20);
		informationPanel.add(numberTextField);
		numberTextField.setColumns(10);

		locationTextField = new JTextField();
		locationTextField.setToolTipText("X Y R Country Province City  Parish Alley");
		locationTextField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				location = locationTextField.getText();
			}
		});
		// location text field
		locationTextField.setBackground(Color.PINK);
		locationTextField.setBounds(99, 83, 150, 20);
		informationPanel.add(locationTextField);
		locationTextField.setColumns(10);

		birthDayTextField = new JTextField();
		birthDayTextField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				birthDay = birthDayTextField.getText();
			}
		});
		// birthDay text field
		birthDayTextField.setBackground(Color.PINK);
		birthDayTextField.setBounds(99, 111, 150, 20);
		informationPanel.add(birthDayTextField);
		birthDayTextField.setColumns(10);

		emailTextField = new JTextField();
		email = emailTextField.getText();
		emailTextField.setBackground(Color.PINK);
		emailTextField.setBounds(85, 198, 164, 20);
		informationPanel.add(emailTextField);
		emailTextField.setColumns(10);

		// Radio button *************************************************************
		rdbtnMale = new JRadioButton("Male");
		rdbtnMale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (rdbtnMale.isSelected())
					gender = rdbtnMale.getText();

			}
		});
		rdbtnMale.setFont(new Font("Comic Sans MS", Font.ITALIC, 14));
		rdbtnMale.setBounds(83, 138, 64, 23);
		informationPanel.add(rdbtnMale);

		rdbtnFemale = new JRadioButton("Female");
		rdbtnFemale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (rdbtnFemale.isSelected())
					gender = rdbtnFemale.getText();

			}
		});
		rdbtnFemale.setFont(new Font("Comic Sans MS", Font.ITALIC, 14));
		rdbtnFemale.setBounds(149, 138, 100, 23);
		informationPanel.add(rdbtnFemale);

		ButtonGroup bg = new ButtonGroup();
		bg.add(rdbtnFemale);
		bg.add(rdbtnMale);

		//////////////////////////////// COMBOBOX////////////////////////////////////
		////////////////////////////////////////////////////////////////////////////

		// COMBO GROUP
		comboGroup = new JComboBox();

		comboGroup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				newGroup.setText((String) comboGroup.getSelectedItem());
			}
		});

		comboGroup.setBackground(Color.WHITE);
		comboGroup.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		s = new String[4];
		s[0] = "unasigned";
		s[1] = "Family";
		s[2] = "Friend";
		s[3] = "favrite";

		comboGroup.setModel(new DefaultComboBoxModel(s));
		comboGroup.setBounds(85, 165, 164, 22);
		informationPanel.add(comboGroup);

		//////////////////////////////////////////////////////////////////////////////

		// contact add button
		btnAdd = new JButton("+");
		btnAdd.setIcon(null);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnAddRowAction(e);
				scrollPane.setVisible(true);
				setBounds(100, 100, 752, 495);
			}
		});
		btnAdd.setBackground(Color.GREEN);
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnAdd.setBounds(23, 259, 49, 23);
		informationPanel.add(btnAdd);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(10, 86, 127, -5);
		informationPanel.add(lblNewLabel);

		///////////////////////////////////////////////////////////////////////////////////////////

		// contact delete button
		JButton btnDelete = new JButton("-");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				groupErrorLabel.setText("");
				DefaultTableModel model = (DefaultTableModel) table.getModel();

				boolean itsSelected = false;
				int size = obj.contactArraylist.size();
				for (int i = 0; i < size; i++) {
					if ((boolean) table.getValueAt(i, 0)) {
						itsSelected = true;
						break;
					}
				}

				if (!itsSelected) {
					if (table.getRowCount() == 0)
						errorLabel.setText("Table is empty");
					else
						errorLabel.setText("select the contact that you want to detet");

				} else if (itsSelected) {
					for (int i = size - 1; i >= 0; i--) {

						if ((boolean) table.getValueAt(i, 0)) {
							obj.contactArraylist.remove(i);
							model.removeRow(i);
						}
					}
				}

				nameTextField.setText("");
				numberTextField.setText("");
				locationTextField.setText("");
				birthDayTextField.setText("");
				emailTextField.setText("");

			}
		});
		btnDelete.setBackground(Color.RED);
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnDelete.setBounds(82, 259, 49, 23);
		informationPanel.add(btnDelete);

		errorLabel = new JLabel("");
		errorLabel.setForeground(Color.RED);
		errorLabel.setBackground(Color.RED);
		errorLabel.setBounds(10, 228, 252, 20);
		informationPanel.add(errorLabel);

		/////////////////////////////////////////////////////////////////////////////////////////////////////

		// update contact button
		JButton btnUpdate = new JButton("UD");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				groupErrorLabel.setText("");
				DefaultTableModel model = (DefaultTableModel) table.getModel();

				if (table.getSelectedRow() == -1) {
					if (table.getRowCount() == 0)
						errorLabel.setText("Table is empty");
					else
						errorLabel.setText("you must select a row");

				} else {
					if (!nameTextField.getText().equals("")) {
						model.setValueAt(nameTextField.getText(), table.getSelectedRow(), 1);
						name1 = nameTextField.getText();
					} else {
						name1 = obj.getNameArrayList(table.getSelectedRow());
					}
					if (!numberTextField.getText().equals("")) {
						model.setValueAt(numberTextField.getText(), table.getSelectedRow(), 2);
						phoneNumber1 = numberTextField.getText();
					} else {
						phoneNumber1 = obj.getNumberArrayList(table.getSelectedRow());
					}
					if (!locationTextField.getText().equals("")) {
						model.setValueAt(locationTextField.getText(), table.getSelectedRow(), 3);
						location1 = locationTextField.getText();
					} else {
						location1 = obj.getLocationArrayList(table.getSelectedRow());
					}
					if (!birthDayTextField.getText().equals("")) {
						model.setValueAt(birthDayTextField.getText(), table.getSelectedRow(), 4);
						birthDay1 = birthDayTextField.getText();
					} else {
						birthDay1 = obj.getBirthDayArrayList(table.getSelectedRow());
					}
					String gender;

					if (rdbtnMale.isSelected())
						gender = rdbtnMale.getText();
					else if (rdbtnFemale.isSelected())
						gender = rdbtnFemale.getText();
					else
						gender = "";
					if (!gender.equals("")) {
						model.setValueAt(gender, table.getSelectedRow(), 5);
						gender1 = gender;
					} else {
						gender1 = obj.getGenderArrayList(table.getSelectedRow());
					}
					if (!((String) comboGroup.getSelectedItem()).equals("")) {
						model.setValueAt((String) comboGroup.getSelectedItem(), table.getSelectedRow(), 6);
						group1 = (String) comboGroup.getSelectedItem();
					} else {
						group1 = obj.getGroupArrayList(table.getSelectedRow());
					}
					if (!emailTextField.getText().equals("")) {
						model.setValueAt(emailTextField.getText(), table.getSelectedRow(), 7);
						email1 = emailTextField.getText();
					} else {
						email1 = obj.getEmailArrayList(table.getSelectedRow());
					}

					// Update Array list
					obj.contactArraylist.remove(table.getSelectedRow());
					c = new Contact(name1, phoneNumber1, location1, birthDay1, gender1, group1, email1);
					obj.contactArraylist.add(c);

				}

				nameTextField.setText("");
				numberTextField.setText("");
				locationTextField.setText("");
				birthDayTextField.setText("");
				emailTextField.setText("");
			}
		});
		btnUpdate.setBackground(Color.YELLOW);
		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnUpdate.setBounds(200, 259, 49, 23);
		informationPanel.add(btnUpdate);

		/////////////////////////////////////////////////////////////////////////////////////////////////

		// Update Jdaval with Array List
		JButton btnNewButton = new JButton("F5");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				groupErrorLabel.setText("");
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				for (int i = 0; i < obj.contactArraylist.size(); i++) {
					model.setValueAt(obj.getNameArrayList(i), i, 1);
					model.setValueAt(obj.getNumberArrayList(i), i, 2);
					model.setValueAt(obj.getLocationArrayList(i), i, 3);
					model.setValueAt(obj.getBirthDayArrayList(i), i, 4);
					model.setValueAt(obj.getGenderArrayList(i), i, 5);
					model.setValueAt(obj.getGroupArrayList(i), i, 6);
					model.setValueAt(obj.getEmailArrayList(i), i, 7);
					model.setValueAt(i + 1, i, 8);
				}

			}
		});
		btnNewButton.setBackground(Color.ORANGE);
		btnNewButton.setBounds(141, 259, 49, 23);
		informationPanel.add(btnNewButton);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 315, 716, 128);
		scrollPane.setVisible(false);
		mainPanel.add(scrollPane);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				DefaultTableModel model = (DefaultTableModel) table.getModel();

				nameTextField.setText(model.getValueAt(table.getSelectedRow(), 1).toString());
				numberTextField.setText(model.getValueAt(table.getSelectedRow(), 2).toString());
				locationTextField.setText(model.getValueAt(table.getSelectedRow(), 3).toString());
				birthDayTextField.setText(model.getValueAt(table.getSelectedRow(), 4).toString());
				emailTextField.setText(model.getValueAt(table.getSelectedRow(), 7).toString());

			}
		});
		table.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		table.setFont(new Font("Tahoma", Font.PLAIN, 13));
		table.setBackground(Color.PINK);

		// Column of Jadval
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Delete", "      Name", "        Nmber",
				"     Loction", "   BirthDay", "      Gender", "     Group", "       Email", "ContactNum" }) {
			Class[] columnTypes = new Class[] { Boolean.class, Object.class, Object.class, Object.class, Object.class,
					Object.class, Object.class, Object.class, Object.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});

		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(44);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(2).setPreferredWidth(95);
		table.getColumnModel().getColumn(3).setResizable(false);
		table.getColumnModel().getColumn(4).setResizable(false);
		table.getColumnModel().getColumn(5).setResizable(false);
		table.getColumnModel().getColumn(5).setPreferredWidth(85);
		table.getColumnModel().getColumn(6).setResizable(false);
		table.getColumnModel().getColumn(7).setResizable(false);
		scrollPane.setViewportView(table);

		//////////////////////////////////// group panel
		//////////////////////////////////// //////////////////////////////////////////////////

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new LineBorder(new Color(255, 175, 175), 3), "  Group  ", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(283, 11, 231, 298);
		mainPanel.add(panel);
		panel.setLayout(null);

		//////////////////////////////////////////////////////////////////////////////////////////////////

		newGroup = new JTextField();
		newGroup.setBackground(Color.PINK);
		newGroup.setBounds(10, 21, 155, 20);
		panel.add(newGroup);
		newGroup.setColumns(10);

		//////////////////////////////////////////////////////////////////////////////////////////////////

		// add group button
		JButton btnNewGroup = new JButton("+");
		btnNewGroup.setBackground(Color.GREEN);
		btnNewGroup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (newGroup.getText().equals(""))
					groupErrorLabel.setText("text field is empty!");
				else {
					comboGroup.addItem(newGroup.getText());
					newGroup.setText("");

					groupErrorLabel.setText("Added Successfully :D");
				}
			}
		});
		btnNewGroup.setBounds(10, 46, 43, 23);
		panel.add(btnNewGroup);

		///////////////////////////////////////////////////////////////////////////////////////////////

		// REMOVE GROUP BUTTON
		JButton btnRemove = new JButton("-");
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (newGroup.getText().equals(""))
					groupErrorLabel.setText("text field is empty!");
				else {

					if (newGroup.getText().equals("unasigned"))
						groupErrorLabel.setText("You CAN'T!!!");

					else {

						int size = obj.contactArraylist.size();
						for (int i = size - 1; i >= 0; i--) {
							if (obj.getGroupArrayList(i).equals(newGroup.getText())) {

								String name = obj.getNameArrayList(i);
								String phoneNumber = obj.getNumberArrayList(i);
								String location = obj.getLocationArrayList(i);
								String birthDay = obj.getBirthDayArrayList(i);
								String gender = obj.getGenderArrayList(i);
								String group = "unasigned";
								String email = obj.getEmailArrayList(i);

								Contact c = new Contact(name, phoneNumber, location, birthDay, gender, group, email);

								obj.contactArraylist.remove(i);
								obj.contactArraylist.add(c);
							}
						}

						comboGroup.removeItem(newGroup.getText());
						newGroup.setText("");
						groupErrorLabel.setText("Deleted Successfully :D");

					}
				}
			}
		});
		btnRemove.setBackground(Color.RED);
		btnRemove.setBounds(175, 46, 43, 23);
		panel.add(btnRemove);

		//////////////////////////////////////////////////////////////////////////////////////////////////////

		// group table
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 74, 208, 185);
		panel.add(scrollPane_1);

		groupTable = new JTable();
		groupTable.setBackground(Color.PINK);
		groupTable.setFont(new Font("Tahoma", Font.PLAIN, 13));
		groupTable.setModel(
				new DefaultTableModel(new Object[][] {}, new String[] { "      Name", "    Number", "check" }) {
					Class[] columnTypes = new Class[] { Object.class, Object.class, Boolean.class };

					public Class getColumnClass(int columnIndex) {
						return columnTypes[columnIndex];
					}
				});
		groupTable.getColumnModel().getColumn(0).setResizable(false);
		groupTable.getColumnModel().getColumn(1).setResizable(false);
		groupTable.getColumnModel().getColumn(2).setResizable(false);
		groupTable.getColumnModel().getColumn(2).setPreferredWidth(37);
		scrollPane_1.setViewportView(groupTable);

		JButton btnList = new JButton("L");
		btnList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				groupErrorLabel.setText("");
				boolean thereIS = false;
				boolean here = false;
				DefaultTableModel model = (DefaultTableModel) groupTable.getModel();
				for (int i = 0; i < obj.contactArraylist.size(); i++) {
					String name;
					String number;
					here = true;
					if (obj.getGroupArrayList(i).equals(newGroup.getText())) {
						name = obj.getNameArrayList(i);
						number = obj.getNumberArrayList(i);
						thereIS = true;
						model.addRow(new Object[] { name, number, true });
					}
				}

				if (!thereIS && here)
					groupErrorLabel.setText("this Group is empty!!");
				else if (!here)
					groupErrorLabel.setText("There is no contact!!");
			}
		});
		btnList.setBackground(Color.YELLOW);
		btnList.setBounds(63, 46, 49, 23);
		panel.add(btnList);

		groupErrorLabel = new JLabel("");
		groupErrorLabel.setForeground(Color.RED);
		groupErrorLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		groupErrorLabel.setBounds(10, 262, 208, 25);
		panel.add(groupErrorLabel);

		// group F5 button
		JButton btnF = new JButton("F5");
		btnF.setFont(new Font("Tahoma", Font.PLAIN, 8));
		btnF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				DefaultTableModel model = (DefaultTableModel) groupTable.getModel();

				if (model.getRowCount() == 0)
					groupErrorLabel.setText("table is empty!!!");

				else {
					boolean select = false;
					int size = model.getRowCount() - 1;
					for (int i = size; i >= 0; i--) {
						if ((boolean) model.getValueAt(i, 2)) {
							model.removeRow(i);
							select = true;
						}
					}
					if (!select)
						groupErrorLabel.setText("select contacts!!");
				}
			}
		});
		btnF.setBackground(Color.ORANGE);
		btnF.setBounds(122, 46, 43, 23);
		panel.add(btnF);

		// group edit button
		JButton editButton = new JButton("E");
		editButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				int size = obj.contactArraylist.size();
				System.out.println(size);
				for (int i = size - 1; i >= 0; i--) {
					if (obj.getGroupArrayList(i).equals(((String) comboGroup.getSelectedItem()).trim())) {

						String name = obj.getNameArrayList(i);
						String phoneNumber = obj.getNumberArrayList(i);
						String location = obj.getLocationArrayList(i);
						String birthDay = obj.getBirthDayArrayList(i);
						String gender = obj.getGenderArrayList(i);
						String group = newGroup.getText();
						String email = obj.getEmailArrayList(i);

						Contact c = new Contact(name, phoneNumber, location, birthDay, gender, group, email);

						obj.contactArraylist.remove(i);
						obj.contactArraylist.add(c);
					}

				}
				comboGroup.addItem(newGroup.getText());
				comboGroup.removeItem((String) comboGroup.getSelectedItem());
			}
		});
		editButton.setBackground(Color.CYAN);
		editButton.setBounds(175, 20, 43, 23);
		panel.add(editButton);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new LineBorder(new Color(255, 175, 175), 3), "  location   ",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(516, 11, 210, 298);
		mainPanel.add(panel_1);
		panel_1.setLayout(null);

		// find neighbour button
		JButton btnFindNeighbour = new JButton("Find Neighbour");
		btnFindNeighbour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				boolean findIt = false;
				boolean check = false;
				DefaultTableModel model2 = (DefaultTableModel) locationTable.getModel();
				DefaultTableModel model = (DefaultTableModel) table.getModel();

				for (int i = 0; i < obj.contactArraylist.size(); i++) {
					if ((boolean) model.getValueAt(i, 0)) {
						check = true;
					}
				}

				if (model.getRowCount() == 0)
					locationErrorLabel.setText("There is no Contact!!!");

				else if (!check)
					locationErrorLabel.setText("select a contact");

				else {
					inja: for (int i = 0; i < obj.contactArraylist.size(); i++) {
						if ((boolean) model.getValueAt(i, 0)) {
							for (int j = 0; j < obj.contactArraylist.size(); j++) {
								if (i != j) {
									if (obj.getLocationArrayList(i).equals("")) {
										locationErrorLabel.setText("this contact dosn't have Address!!");
										check = false;
										break inja;
									}
									try {
										if (findNeighbour(locOBJ.getX(i), locOBJ.getY(i), locOBJ.getR(i),
												locOBJ.getX(j), locOBJ.getY(j))) {
											model2.addRow(new Object[] { obj.getNameArrayList(j),
													obj.getNumberArrayList(j), obj.getLocationArrayList(j) });
											findIt = true;
										}
									} catch (Exception e) {
										locationErrorLabel.setText("we couldn't find any neighbour!!");
										check = false;
									}
								}
							}
						}
					}
				}

				if (!findIt && check && model.getRowCount() != 0)
					locationErrorLabel.setText("There isn't any neighbour");

			}
		});
		btnFindNeighbour.setBackground(Color.GREEN);
		btnFindNeighbour.setBounds(10, 23, 126, 23);
		panel_1.add(btnFindNeighbour);

		/////////////////////////////////////////////////////////////////////////////

		// location table
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 55, 190, 99);
		panel_1.add(scrollPane_2);

		locationTable = new JTable();
		locationTable.setModel(
				new DefaultTableModel(new Object[][] {}, new String[] { "      Name", "    Number", "   Address" }));
		scrollPane_2.setViewportView(locationTable);

		locationErrorLabel = new JLabel("");
		locationErrorLabel.setForeground(Color.RED);
		locationErrorLabel.setBounds(10, 264, 190, 23);
		panel_1.add(locationErrorLabel);

		// loction delete button
		JButton btnNewButton_1 = new JButton("Del");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DefaultTableModel model2 = (DefaultTableModel) locationTable.getModel();
				int size = model2.getRowCount();
				for (int i = size - 1; i >= 0; i--)
					model2.removeRow(i);

				DefaultTableModel model3 = (DefaultTableModel) locationTable2.getModel();
				int size2 = model3.getRowCount();
				for (int i = size2 - 1; i >= 0; i--)
					model3.removeRow(i);
			}
		});
		btnNewButton_1.setBackground(Color.RED);
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnNewButton_1.setBounds(139, 23, 61, 23);
		panel_1.add(btnNewButton_1);

		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(10, 186, 190, 74);
		panel_1.add(scrollPane_3);

		locationTable2 = new JTable();
		locationTable2.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Name", "Number", "Address" }));
		locationTable2.getColumnModel().getColumn(0).setPreferredWidth(67);
		scrollPane_3.setViewportView(locationTable2);

		// find contacts in a country
		JButton countryButton = new JButton("");
		countryButton.setToolTipText("Country");
		countryButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean check = false;
				boolean findIt = false;
				DefaultTableModel model2 = (DefaultTableModel) locationTable2.getModel();
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				for (int i = 0; i < obj.contactArraylist.size(); i++) {
					if ((boolean) model.getValueAt(i, 0)) {
						check = true;
					}
				}

				if (model.getRowCount() == 0)
					locationErrorLabel.setText("There is no Contact!!!");

				else if (!check)
					locationErrorLabel.setText("select a contact");

				else {
					inja: for (int i = 0; i < obj.contactArraylist.size(); i++) {
						if ((boolean) model.getValueAt(i, 0)) {
							for (int j = 0; j < obj.contactArraylist.size(); j++) {
								if (i != j) {
									try {
										if (locOBJ.getCountry(i).equals("_")) {
											locationErrorLabel.setText("this contact dosn't have CountryName");
											check = false;
											break inja;
										}
										if (locOBJ.getCountry(j).equals(locOBJ.getCountry(i))) {
											model2.addRow(new Object[] { obj.getNameArrayList(j),
													obj.getNumberArrayList(j), locOBJ.getCountry(j) });
											findIt = true;
										}
									} catch (Exception e) {
									}
								}
							}
						}
					}
				}
				if (!findIt && check && model.getRowCount() != 0)
					locationErrorLabel.setText("None are in a country!");
				else if (findIt)
					locationErrorLabel.setText("these are in a Country :D");
			}
		});
		countryButton.setFont(new Font("Tahoma", Font.PLAIN, 5));
		countryButton.setBackground(Color.RED);
		countryButton.setBounds(10, 159, 24, 23);
		panel_1.add(countryButton);

		// find contacts in a province
		JButton proviceButton = new JButton("");
		proviceButton.setToolTipText("Province");
		proviceButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean check = false;
				boolean findIt = false;
				DefaultTableModel model2 = (DefaultTableModel) locationTable2.getModel();
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				for (int i = 0; i < obj.contactArraylist.size(); i++) {
					if ((boolean) model.getValueAt(i, 0)) {
						check = true;
					}
				}

				if (model.getRowCount() == 0)
					locationErrorLabel.setText("There is no Contact!!!");

				else if (!check)
					locationErrorLabel.setText("select a contact");

				else {
					inja: for (int i = 0; i < obj.contactArraylist.size(); i++) {
						if ((boolean) model.getValueAt(i, 0)) {
							for (int j = 0; j < obj.contactArraylist.size(); j++) {
								if (i != j) {
									try {
										if (locOBJ.getProvince(i).equals("_")) {
											locationErrorLabel.setText("this contact dosn't have ProvinceName");
											check = false;
											break inja;
										}
										if (locOBJ.getProvince(j).equals(locOBJ.getProvince(i))) {
											model2.addRow(new Object[] { obj.getNameArrayList(j),
													obj.getNumberArrayList(j), locOBJ.getProvince(j) });
											findIt = true;
										}
									} catch (Exception e) {
									}
								}
							}
						}
					}
				}
				if (!findIt && check && model.getRowCount() != 0)
					locationErrorLabel.setText("None are in a Province");
				else if (findIt)
					locationErrorLabel.setText("these are in a Province :D");
			}
		});
		proviceButton.setBackground(Color.ORANGE);
		proviceButton.setBounds(51, 159, 24, 23);
		panel_1.add(proviceButton);

		// fine contacts in a city
		JButton cityButton = new JButton("");
		cityButton.setToolTipText("City");
		cityButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean check = false;
				boolean findIt = false;
				DefaultTableModel model2 = (DefaultTableModel) locationTable2.getModel();
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				for (int i = 0; i < obj.contactArraylist.size(); i++) {
					if ((boolean) model.getValueAt(i, 0)) {
						check = true;
					}
				}

				if (model.getRowCount() == 0)
					locationErrorLabel.setText("There is no Contact!!!");

				else if (!check)
					locationErrorLabel.setText("select a contact");

				else {
					inja: for (int i = 0; i < obj.contactArraylist.size(); i++) {
						if ((boolean) model.getValueAt(i, 0)) {
							for (int j = 0; j < obj.contactArraylist.size(); j++) {
								if (i != j) {
									try {
										if (locOBJ.getCity(i).equals("_")) {
											locationErrorLabel.setText("this contact dosn't have CityName");
											check = false;
											break inja;
										}

										if (locOBJ.getCity(j).equals(locOBJ.getCity(i))) {
											model2.addRow(new Object[] { obj.getNameArrayList(j),
													obj.getNumberArrayList(j), locOBJ.getCity(j) });
											findIt = true;
										}
									} catch (Exception e) {
									}
								}
							}
						}
					}
				}
				if (!findIt && check && model.getRowCount() != 0)
					locationErrorLabel.setText("None are in a City!");
				else if (findIt)
					locationErrorLabel.setText("these are in a City :D");
			}
		});
		cityButton.setBackground(Color.YELLOW);
		cityButton.setBounds(92, 159, 24, 23);
		panel_1.add(cityButton);

		// find contact in a parish
		JButton parishButton = new JButton("");
		parishButton.setToolTipText("Parish");
		parishButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean check = false;
				boolean findIt = false;
				DefaultTableModel model2 = (DefaultTableModel) locationTable2.getModel();
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				for (int i = 0; i < obj.contactArraylist.size(); i++) {
					if ((boolean) model.getValueAt(i, 0)) {
						check = true;
					}
				}

				if (model.getRowCount() == 0)
					locationErrorLabel.setText("There is no Contact!!!");

				else if (!check)
					locationErrorLabel.setText("select a contact");

				else {
					inja: for (int i = 0; i < obj.contactArraylist.size(); i++) {
						if ((boolean) model.getValueAt(i, 0)) {
							for (int j = 0; j < obj.contactArraylist.size(); j++) {
								if (i != j) {
									try {
										if (locOBJ.getParish(i).equals("_")) {
											locationErrorLabel.setText("this contact dosn't have ParishName");
											check = false;
											break inja;
										}
										if (locOBJ.getParish(j).equals(locOBJ.getParish(i))) {
											model2.addRow(new Object[] { obj.getNameArrayList(j),
													obj.getNumberArrayList(j), locOBJ.getParish(j) });
											findIt = true;
										}

									} catch (Exception e) {
									}
								}
							}
						}
					}
				}
				if (!findIt && check && model.getRowCount() != 0)
					locationErrorLabel.setText("None are in a Parish!");
				else if (findIt)
					locationErrorLabel.setText("these are in a Parish :D");
			}
		});
		parishButton.setBackground(Color.GREEN);
		parishButton.setBounds(133, 159, 24, 23);
		panel_1.add(parishButton);

		// find contacts in a alley
		JButton alleyButton = new JButton("");
		alleyButton.setToolTipText("Alley");
		alleyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean check = false;
				boolean findIt = false;
				DefaultTableModel model2 = (DefaultTableModel) locationTable2.getModel();
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				for (int i = 0; i < obj.contactArraylist.size(); i++) {
					if ((boolean) model.getValueAt(i, 0)) {
						check = true;
					}
				}

				if (model.getRowCount() == 0)
					locationErrorLabel.setText("There is no Contact!!!");

				else if (!check)
					locationErrorLabel.setText("select a contact");

				else {
					inja: for (int i = 0; i < obj.contactArraylist.size(); i++) {
						if ((boolean) model.getValueAt(i, 0)) {
							for (int j = 0; j < obj.contactArraylist.size(); j++) {
								if (i != j) {
									try {
										if (locOBJ.getAlley(i).equals("_")) {
											locationErrorLabel.setText("this contact dosn't have AlleyName");
											check = false;
											break inja;
										}
										if (locOBJ.getAlley(j).equals(locOBJ.getAlley(i))) {
											model2.addRow(new Object[] { obj.getNameArrayList(j),
													obj.getNumberArrayList(j), locOBJ.getAlley(j) });
											findIt = true;
										}
									} catch (Exception e) {
									}
								}
							}
						}
					}
				}
				if (!findIt && check && model.getRowCount() != 0)
					locationErrorLabel.setText("None are in a Alley!");
				else if (findIt)
					locationErrorLabel.setText("these are in a Alley :D");
			}
		});
		alleyButton.setBackground(Color.CYAN);
		alleyButton.setBounds(175, 159, 24, 23);
		panel_1.add(alleyButton);

	}

	// add to jadval ///////////////////////////////////////////////////////////////
	private void btnAddRowAction(java.awt.event.ActionEvent evt) {
		groupErrorLabel.setText("");
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		String gender;

		if (rdbtnMale.isSelected()) {
			gender = rdbtnMale.getText();
			gender1 = rdbtnMale.getText();

		} else if (rdbtnFemale.isSelected()) {
			gender = rdbtnFemale.getText();
			gender1 = rdbtnFemale.getText();
		} else {
			gender = "";
			gender1 = "";

		}
		name = nameTextField.getText();
		name1 = nameTextField.getText();
		phoneNumber = numberTextField.getText();
		phoneNumber1 = numberTextField.getText();
		if (!name.equals("") && !phoneNumber.equals("")) {
			errorLabel.setText("");

			location = locationTextField.getText();
			location1 = locationTextField.getText();
			birthDay = birthDayTextField.getText();
			birthDay1 = birthDayTextField.getText();
			group = (String) comboGroup.getSelectedItem();
			group1 = (String) comboGroup.getSelectedItem();
			email = emailTextField.getText();
			email1 = emailTextField.getText();

			c = new Contact(name, phoneNumber, location, birthDay, gender, group, email);
			obj.addContact(c);
			obj.getNameArrayList(0);
			num = obj.contactNumber;

			model.addRow(new Object[] { false, name, phoneNumber, location, birthDay, gender, group, email, num });

		} else {
			errorLabel.setText("FILL NAME AND NUMBER FIELD");
		}

		nameTextField.setText("");
		numberTextField.setText("");
		locationTextField.setText("");
		birthDayTextField.setText("");
		emailTextField.setText("");

	}

	// find neighbour Method
	public boolean findNeighbour(int x1, int y1, double r, int x2, int y2) {

		if (((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2)) <= (r * r))
			return true;
		else
			return false;
	}
}
