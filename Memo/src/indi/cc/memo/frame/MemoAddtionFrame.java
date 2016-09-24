package indi.cc.memo.frame;

import indi.cc.memo.bean.MemoBean;
import indi.cc.memo.dao.JdbcHelper;
import indi.cc.memo.util.ValidationUtil;
import indi.cc.memo.util.WindowUtil;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;

//���ӱ���¼����
public class MemoAddtionFrame extends JDialog {
	private JPanel contentPane;	//���
	private JPanel othersPanel;	//���
	private JPanel nttPanel;	//���
	private JPanel contentPanel;	//���
	private JLabel usernameLabel;	//������ǩ
	private JTextField usernameTextField;	//�����ı���
	private JLabel memotypeLabel;	//���ͱ�ǩ
	private JTextField memotypeTextField;	//�����ı���
	private JLabel memotimeLabel;	//ʱ���ǩ
	private JTextField memotimeTextField;	//ʱ���ı���
	private JPanel titlePanel;	//���
	private JLabel titleLabel;	//�����ǩ
	private JTextField titleTextField;	//�����ı���
	private JLabel contentLabel;	//���ݱ�ǩ
	private JTextArea contentTextArea;	//�����ı���
	private JPanel buttonPanel;	//��ť���
	private JButton saveButton;	//���水ť
	private JButton clearButton;	//��հ�ť
	private JButton returnButton;	//���ذ�ť
	private JDialog jd;	//��ǰ����
	/**
	 * 
	 * @param owner ���ĸ�����
	 * @param title ������
	 * @param modal ָ����ģʽ���ڣ����з�ģʽ����
	 */
	public MemoAddtionFrame(JFrame owner, String title, boolean modal){ 
		super(owner,title,modal);
		this.jd = this;
		contentPane = new JPanel();	//���������
		contentPane.setLayout(new BorderLayout(0,0));
		this.setContentPane(contentPane);	//Ӧ�����
		
		othersPanel = new JPanel();	//�������
		contentPane.add(othersPanel,BorderLayout.NORTH);// Ӧ�����
		
		othersPanel.setLayout(new GridLayout(2, 1, 5, 5));// Ϊ����������񲼾�
		nttPanel = new JPanel();	//�������
		nttPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));// �������ı߿�
	    FlowLayout fl_nttPanel = (FlowLayout) nttPanel.getLayout();// �����岼��
	    fl_nttPanel.setAlignment(FlowLayout.LEFT);// ����пؼ����������
	    othersPanel.add(nttPanel);// Ӧ�����
	    
	    usernameLabel = new JLabel("������");// ����������ǩ
	    nttPanel.add(usernameLabel);	//Ӧ��������ǩ
	    nttPanel.add(usernameLabel);// Ӧ��������ǩ
	    
	    usernameTextField = new JTextField();// ���������ı���
	    nttPanel.add(usernameTextField);// Ӧ�������ı���
        usernameTextField.setColumns(7);// ���������ı�����
        
        memotypeLabel = new JLabel("���ͣ�");// �������ͱ�ǩ
        nttPanel.add(memotypeLabel);// Ӧ�����ͱ�ǩ
        
        memotypeTextField = new JTextField();// ���������ı���
        nttPanel.add(memotypeTextField);// Ӧ�������ı���
        memotypeTextField.setColumns(7);// ���������ı�����
        
        memotimeLabel = new JLabel("ʱ�䣺");// ����ʱ���ǩ
        nttPanel.add(memotimeLabel);// Ӧ��ʱ���ǩ
        
        memotimeTextField = new JTextField();// ����ʱ���ı���
        nttPanel.add(memotimeTextField);// Ӧ��ʱ���ı���
        memotimeTextField.setColumns(8);// ����ʱ���ı�����
        
        titlePanel = new JPanel();// �������
        titlePanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));// �������ı߿�
        FlowLayout fl_titlePanel = (FlowLayout) titlePanel.getLayout();// �����岼��
        fl_titlePanel.setAlignment(FlowLayout.LEFT);// ����пؼ����������
        othersPanel.add(titlePanel);// Ӧ�����
        
        titleLabel = new JLabel("���⣺");// ������ǩ
        titlePanel.add(titleLabel);// Ӧ�ñ�ǩ
        
        titleTextField = new JTextField();// �����ı���
        titlePanel.add(titleTextField);// Ӧ���ı���
        titleTextField.setColumns(32);// �����ı�����
        
        contentPanel = new JPanel();// �������
        contentPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));// �������ı߿�
        FlowLayout fl_contentPanel = (FlowLayout) contentPanel.getLayout();// �����岼��
        fl_contentPanel.setAlignment(FlowLayout.LEFT);// ����пؼ����������
        contentPane.add(contentPanel, BorderLayout.CENTER);// Ӧ�����
        
        contentLabel = new JLabel("���ݣ�");// ������ǩ
        contentPanel.add(contentLabel);// Ӧ�ñ�ǩ

        contentTextArea = new JTextArea();// �����ı���
        contentTextArea.setColumns(32);// �����ı�������
        contentTextArea.setLineWrap(true);// �����ı����Զ�����
        contentTextArea.setRows(8);// �����ı�������
        
        JScrollPane contentScrollPane = new JScrollPane(contentTextArea);// ʹ���ı���������������
        contentPanel.add(contentScrollPane);// Ӧ�ù�������
        
        buttonPanel = new JPanel();// �������
        buttonPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));// �������ı߿�
        contentPane.add(buttonPanel, BorderLayout.SOUTH);// Ӧ�����
        
        saveButton = new JButton("����");// ���������桱��ť
        //ע�ᱣ�水ť���¼�����
        saveButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String username = usernameTextField.getText().trim();	//�õ��û���
				String title = titleTextField.getText().trim();	//�õ�����
				String time = memotimeTextField.getText().trim();	//�õ�ʱ��
				String content = contentTextArea.getText().trim();	//�õ�����
				String type = memotypeTextField.getText().trim();	//�õ�����
				if(username.isEmpty()){
					 JOptionPane.showMessageDialog(jd, "��������Ϊ�գ�", "", JOptionPane.WARNING_MESSAGE);
			            return;
				}
				if(title.isEmpty()){
					 JOptionPane.showMessageDialog(jd, "���Ͳ���Ϊ�գ�", "", JOptionPane.WARNING_MESSAGE);
			            return;
				}
				if(time.isEmpty()){
					 JOptionPane.showMessageDialog(jd, "ʱ�䲻��Ϊ�գ�", "", JOptionPane.WARNING_MESSAGE);
			            return;
				}
				if(content.isEmpty()){
					 JOptionPane.showMessageDialog(jd, "���ݲ���Ϊ�գ�", "", JOptionPane.WARNING_MESSAGE);
			            return;
				}
				if(type.isEmpty()){
					 JOptionPane.showMessageDialog(jd, "���Ͳ���Ϊ�գ�", "", JOptionPane.WARNING_MESSAGE);
			            return;
				}
				if(!ValidationUtil.validateTimeFormat(time)){
					 JOptionPane.showMessageDialog(jd, "���ڸ�ʽΪxxxx-xx-xx��ʽ��", "", JOptionPane.WARNING_MESSAGE);
			            return;
				}
				MemoBean memoBean = new MemoBean();	//����MemoBean����
				memoBean.setUsername(username);
				memoBean.setTitle(title);
				memoBean.setMemotime(time);
				memoBean.setMemotype(type);
				memoBean.setContent(content);
				//����ͨѶ¼
				if(JdbcHelper.save(memoBean)){
					 JOptionPane.showMessageDialog(jd, "����¼��ӳɹ���");
			            return;
				}else{
					 JOptionPane.showMessageDialog(jd, "����¼���ʧ�ܣ�");
			            return;
				}
			}
		});
        buttonPanel.add(saveButton);// Ӧ�ð�ť
        
        clearButton = new JButton("���");// ��������ա���ť
        //��հ�ť�¼�����
        clearButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				titleTextField.setText("");
				memotimeTextField.setText("");
				usernameTextField.setText("");
				contentTextArea.setText("");
				memotypeTextField.setText("");
			}
		});
        buttonPanel.add(clearButton);// Ӧ�ð�ť
        
        returnButton = new JButton("����");// ���������ء���ť
        //���ذ�ť�¼�����
        returnButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				jd.dispose();
			}
		});
        buttonPanel.add(returnButton);// Ӧ�ð�ť
        
        setLocation(WindowUtil.getLocation());// ���ô�����ʾλ��
        setSize(WindowUtil.getSize());// ���ô����С
        this.setResizable(false);
        this.setVisible(true);
       
	}
}
