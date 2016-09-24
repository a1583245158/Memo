package indi.cc.memo.frame;

import indi.cc.memo.util.WindowUtil;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

//����¼������
public class MainFrame extends JFrame{
	private JMenuBar menuBar;	//Ӧ�ò˵���
	private JMenu memoManagementMenu;	//����¼����˵�
	private JMenu toolMenu;	//С���߲˵�
	private JMenuItem calculatorMemoMenuItem;	//�������˵���
	private JMenuItem notepadMenuItem;	//���±��˵���
	private JMenuItem addMemoMenuItem;	//���ӱ���¼�˵���
	private JMenuItem modifyMemoMemuItem;	//�޸ı���¼�˵���
	private JMenuItem queryMemoMenuItem;	//��ѯ����¼�˵���
	private JMenuItem deleteMemoMenuItem;	//ɾ������¼�˵���
	private JPanel contentPane;	//���
	private JFrame jf;	//��ǰ����
	public MainFrame(){
		this.jf = this;
		this.setTitle("����¼ģ��");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menuBar = new JMenuBar();	//����Ӧ�ò˵���
		this.setJMenuBar(menuBar);	//���Ӧ�ò˵���
		memoManagementMenu = new JMenu("����¼����");	//��������¼����˵�
		menuBar.add(memoManagementMenu);	//�ڲ˵�������ӱ���¼����˵�
		
		addMemoMenuItem = new JMenuItem("���ӱ���¼");//�������ӱ���¼�˵���
		//ע���¼�����
		addMemoMenuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				MemoAddtionFrame addtionFrame = new MemoAddtionFrame(jf, "���ӱ���¼", true);
			}
		});
		memoManagementMenu.add(addMemoMenuItem);	//�ڱ���¼����˵���������ӱ���¼�˵���
		
		modifyMemoMemuItem = new JMenuItem("�޸ı���¼");//�����޸ı���¼�˵���
		//ע���¼�����
		modifyMemoMemuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				MemoModificationFrame memoModificationFrame = new MemoModificationFrame(jf, "�޸ı���¼", true);
				
			}
		});
		memoManagementMenu.add(modifyMemoMemuItem);	//�ڱ���¼����˵�������޸ı���¼�˵���
		
		queryMemoMenuItem = new JMenuItem("��ѯ����¼");	//������ѯ����¼�˵���
		//ע���¼�����
		queryMemoMenuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				MemoQueryFrame memoQueryFrame = new MemoQueryFrame(jf, "��ѯ����¼", true);
				
			}
		});
		memoManagementMenu.add(queryMemoMenuItem);	//�ڱ���¼����˵�����Ӳ�ѯ����¼�˵���
		
		deleteMemoMenuItem = new JMenuItem("ɾ������¼");//����ɾ������¼�˵���
		//ע���¼�����
		deleteMemoMenuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				MemoDeletionFrame memodeletionFrame = new MemoDeletionFrame(jf, "ɾ������¼", true);
				
			}
		});
		memoManagementMenu.add(deleteMemoMenuItem);	//�ڱ���¼����˵������ɾ������¼�˵���
		
		toolMenu = new JMenu("С����");	//����С���߲˵�
		menuBar.add(toolMenu);	//�ڲ˵��������С���߲˵�
		
		notepadMenuItem = new JMenuItem("���±�");	//�������±��˵���
		//"���±�"�˵����¼�����
		notepadMenuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Runtime runtime = Runtime.getRuntime();// ���Runtime���Ͷ���
				try {
					runtime.exec("notepad");// ִ��notepad����򿪼��±�
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		toolMenu.add(notepadMenuItem);	//��С���߲˵�����Ӽ��±��˵���
		
		calculatorMemoMenuItem = new JMenuItem("������");	//�����������˵���
		//"������"�˵����¼�����
		calculatorMemoMenuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Runtime runtime = Runtime.getRuntime();// ���Runtime���Ͷ���
				try {
					runtime.exec("calc");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}	//ִ�д򿪼���������
				
			}
		});
		toolMenu.add(calculatorMemoMenuItem);	//��С���߲˵�����Ӽ������˵���
		
		contentPane = new JPanel(){
			public void paint(Graphics g) {
				 super.paint(g);// ���ø��๹�췽��
	                Graphics2D g2 = (Graphics2D) g;// ���Graphics2D����
	                String str = "����¼ģ��";// ����Ҫ��ʾ���ַ���
	                Font font = new Font("����", Font.BOLD | Font.ITALIC, 40);// ����������
	                g2.setFont(font);// Ӧ������
	                for (int i = 0; i < str.length(); i++) {
	                    g2.setColor(Color.GRAY); // ����ǰ��ɫ
	                    g2.drawString(str.charAt(i) + "", 50 + i * font.getSize(), 50 + i * font.getSize()); // ��ָ��λ�û����ı�
	                    g2.drawString(str.charAt(i) + "", 370 - i * font.getSize(), 50 + i * font.getSize()); // ��ָ��λ�û����ı�
	                }
	                for (int i = 0; i < str.length(); i++) {
	                    g2.setColor(Color.BLUE); // ����ǰ��ɫ
	                    g2.drawString(str.charAt(i) + "", 40 + i * font.getSize(), 40 + i * font.getSize()); // ��ָ��λ�û����ı�
	                    g2.drawString(str.charAt(i) + "", 360 - i * font.getSize(), 40 + i * font.getSize()); // ��ָ��λ�û����ı�
	                }
	        	}
		};
		contentPane.setBackground(Color.CYAN);
	        setContentPane(contentPane);// Ӧ�����
	        
	        setLocation(WindowUtil.getLocation());// ���ô�����ʾλ��
	        setSize(WindowUtil.getSize());// ���ô����С
	        this.setResizable(false);
	        this.setVisible(true);
	}
}
