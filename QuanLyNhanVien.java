package CS311;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class QuanLyNhanVien extends JFrame implements ActionListener {
	JLabel maNhanVienlb,hoTenlb,ngayVaolb;
	JTextField maNhanVien,hoTen,ngayVao;
	JButton addbt,removebt,editbt,timbt;
	JCheckBox phongYeuCau = new JCheckBox("Phong yeu cau",false);
	JComboBox loaiBaoHiem = new JComboBox();
	JLabel mabhytlb,mabhxhlb;
	JTextField maBHYT,maBHXH;
	
	public QuanLyNhanVien() {
		Container cont = this.getContentPane();
		cont.setLayout(null);
		
		maNhanVienlb = new JLabel("Ma benh nhan: ");
		maNhanVienlb.setBounds(10, 0, 90, 60);
		cont.add(maNhanVienlb);
		maNhanVien = new JTextField();
		maNhanVien.setBounds(100, 10, 180, 40);
		cont.add(maNhanVien);
		
		hoTenlb = new JLabel("Ho va ten: ");
		hoTenlb.setBounds(20, 50, 90, 60);
		cont.add(hoTenlb);
		hoTen = new JTextField();
		hoTen.setBounds(100, 60, 180, 40);
		cont.add(hoTen);
		
		ngayVaolb = new JLabel("Ngay nhap: ");
		ngayVaolb.setBounds(20, 100, 90, 60);
		ngayVao = new JTextField();
		ngayVao.setBounds(100, 110, 180, 40);
		cont.add(ngayVaolb);	
		cont.add(ngayVao);
		phongYeuCau.setBounds(20, 150, 200, 60);
		cont.add(phongYeuCau);
		
		loaiBaoHiem.addItem("Xa hoi");
		loaiBaoHiem.addItem("Y te");
		loaiBaoHiem.setBounds(20, 220, 200, 30);
		cont.add(loaiBaoHiem);
		
		mabhytlb = new JLabel("Ma benh nhan bao hiem y te");
		mabhytlb.setBounds(20, 250, 200, 40);
		cont.add(mabhytlb);
		maBHYT = new JTextField();
		maBHYT.setBounds(20, 290, 240, 30);
		cont.add(maBHYT);

		mabhxhlb = new JLabel("Ma benh nhan bao hiem xa hoi");
		mabhxhlb.setBounds(400, 250, 200, 40);
		maBHXH = new JTextField();
		maBHXH.setBounds(400, 290, 240, 30);
		cont.add(mabhxhlb);
		cont.add(maBHXH);
		
		addbt = new JButton("Them moi");
		addbt.setBounds(20, 360, 120, 40);
		cont.add(addbt);
		removebt = new JButton("Xoa");
		removebt.setBounds(200, 360, 90, 40);
		cont.add(removebt);
		editbt = new JButton("Sua");
		editbt.setBounds(340, 360, 90, 40);
		cont.add(editbt);
		timbt = new JButton("Tim");
		timbt.setBounds(490, 360, 90, 40);
		cont.add(timbt);
		
		this.setSize(800,600);
		this.setVisible(true);
		this.setLocation(550, 400);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
	}

	public static void main(String[] args) {
		 new QuanLyNhanVien();
	}
}
