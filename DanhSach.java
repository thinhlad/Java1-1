package DoAn;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class DanhSach extends JFrame implements ActionListener {
	/*Khoi tao du lieu*/
	String []columns = {"ID","Name","Toan","Ly","Hoa","Diem Trung Binh"};
	String [][] Data = {{"1","Minh Nhat","10","9","8","7","8"}};
	Vector vData = new Vector();
	Vector vTitle = new Vector();
	DefaultTableModel model;
	JTable tb;
	JScrollPane tableResult;
	/*2 nut chen va xoa*/
	JButton insertbt,deletebt;
	int selectedRow=0;
	
	public DanhSach() {
		/*Tao panel chua 2 nut*/
		JPanel panel = new JPanel();
		insertbt = new JButton("Insert");
		insertbt.addActionListener(this);
		panel.add(insertbt);
		deletebt = new JButton("Delete");
		deletebt.addActionListener(this);
		panel.add(deletebt);
		/*Dat panel vao vung duoi cung cua giao dien*/
		this.getContentPane().add(panel,"South");
		
		/*Dien du lieu vao 2 vector*/
		load();
		/*Tao bang hien thi thong tin len cua so*/
		model = new DefaultTableModel(vData,vTitle);
		tb = new JTable(model);
		tableResult = new JScrollPane(tb);
		/*Dat bang o vung tren cung giao dien*/
		this.getContentPane().add(tableResult,"North");
		
		tb.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent me) {
				selectedRow = tb.getSelectedRow();
			}
		});
		
		this.setSize(400,350);
		this.setVisible(true);
		this.setLocation(600, 450);
	}
	
	public void delete() {
		vData.removeElementAt(selectedRow);
		/*Cap nhap lai giao dien sau khi xoa*/
		model.fireTableDataChanged();
	}
	
	/*Dung de chua du lieu */
	public void insertList(String id , String name , float math , float phys , float chem , float aver) {
		try {
			Vector data = new Vector();
			data.add(id);
			data.add(name);
			data.add(math+"");
			data.add(phys+"");
			data.add(chem+"");
			data.add(aver+"");
			/*Them doi tuong vao danh sach chinh*/
			vData.add(data);
			model.fireTableDataChanged();
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void load() {
		vData.clear();
		vTitle.clear();
		int column = columns.length;
		/*Tao cot*/
		for(int i=0 ; i < column ; i++) {
			vTitle.add(columns[i]);
		}
		/*Tao du lieu trong bang*/
		for(int i=0 ; i < Data.length ; i++) {
			Vector row = new Vector<>(column);
			for(int j=0 ; j < column ; j++) {
				row.add(Data[i][j]);
			}
			vData.add(row);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == insertbt) {
			new insert("Insert", this, "", "", "0", "0", "0");
		}
		if(e.getSource() == deletebt) {
			delete();
		}
	}
	
	public static void main(String[] args) {
		new DanhSach();
	}
}

class insert extends JFrame implements ActionListener {
	/*Cac thanh phan trong giao dien*/
	JLabel idlb;
	JTextField Id;
	JLabel namelb;
	JTextField name;
	JLabel mathlb;
	JTextField math;
	JLabel phylb;
	JTextField phy;
	JLabel chemlb;
	JTextField chem;
	/*Tao 2 nut luu va huy bo viec cap nhap thong tin*/
	JButton savebt,cancelbt;
	DanhSach d;
	
	public insert(String title , DanhSach ds , String id , String na , String ma , String ph , String ch) {
		Container cont = this.getContentPane();
		d=ds;
		Container cont1 = this.getContentPane();
		
		cont.setLayout(new GridLayout(6,2));
		idlb = new JLabel("Id: ");
		Id = new JTextField(id);
		namelb = new JLabel("Name: ");
		name = new JTextField(na);
		mathlb = new JLabel("Math: ");
		math = new JTextField(ma);
		phylb = new JLabel("Physics: ");
		phy = new JTextField(ph);
		chemlb = new JLabel("Chemistry: ");
		chem = new JTextField(ch);
		cont1.add(idlb);
		cont1.add(Id);
		cont1.add(namelb);
		cont1.add(name);
		cont1.add(mathlb);
		cont1.add(math);
		cont1.add(phylb);
		cont1.add(phy);
		cont1.add(chemlb);
		cont1.add(chem);
		
		/*Thiet lap 2 nut save va cancel */
		savebt = new JButton("Save");
		savebt.addActionListener(this);
		cancelbt = new JButton("Cancel");
		cancelbt.addActionListener(this);
		cont.add(savebt);
		cont.add(cancelbt);
		/*Thiet lap kich thuoc , vi tri va hien thi giao dien*/
		this.setSize(400,300);
		this.setLocation(650,350);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == savebt) {
			insertData();
		} else {
			this.dispose();
		}
	}
	
	public void insertData() {
		/*Neu khong nhap thi bao loi*/
		if(Id.getText().equals("")) {
			JOptionPane.showMessageDialog(insert.this, "Nhap ID","Insert Error!", JOptionPane.ERROR_MESSAGE);
		} else if(name.getText().equals("")) {
			JOptionPane.showMessageDialog(insert.this, "Nhap ten","Insert Error!", JOptionPane.ERROR_MESSAGE);
		} else if(math.getText().equals("")) {
			JOptionPane.showMessageDialog(insert.this, "Nhap diem toan","Insert Error!" , JOptionPane.ERROR_MESSAGE);
		} else if(phy.getText().equals("")) {
			JOptionPane.showMessageDialog(insert.this, "Nhap diem ly","Insert Error!" , JOptionPane.ERROR_MESSAGE);
		} else if(chem.getText().equals("")){
			JOptionPane.showMessageDialog(insert.this, "Nhap diem hoa","Insert Error!" , JOptionPane.ERROR_MESSAGE);
		} else {
			try {
				String id = Id.getText();
				String na = name.getText();
				float ma = Float.parseFloat(math.getText());
				float ph = Float.parseFloat(phy.getText());
				float ch = Float.parseFloat(chem.getText());
				d.insertList(id, na, ma, ph, ch, (ma+ph+ch)/3);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
