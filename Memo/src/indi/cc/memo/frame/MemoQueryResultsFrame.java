package indi.cc.memo.frame;

import indi.cc.memo.bean.MemoBean;
import indi.cc.memo.util.WindowUtil;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

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

//��ѯ�������
public class MemoQueryResultsFrame extends JDialog {
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
	private JButton returnButton;	//���ذ�ť
	private JButton previousButton;	//��һ����ť
	private JButton nextButton;	//��һ����ť
	private JDialog jd;	//��ǰ����
	private List<MemoBean> memoBeans;	//���ղ�ѯ�����List����
	private int index = 0;	//��ѯ����ļ����±�

	/**
	 * 
	 * @param owner ���ĸ�����
	 * @param title ������
	 * @param modal ָ����ģʽ���ڣ����з�ģʽ����
	 */
	public MemoQueryResultsFrame(JDialog owner, String title, boolean modal,List<MemoBean> memoBeans){ 
		super(owner,title,modal);
		this.memoBeans = memoBeans;
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
	    usernameTextField.setEditable(false);
	    nttPanel.add(usernameTextField);// Ӧ�������ı���
        usernameTextField.setColumns(7);// ���������ı�����
        
        memotypeLabel = new JLabel("���ͣ�");// �������ͱ�ǩ
        nttPanel.add(memotypeLabel);// Ӧ�����ͱ�ǩ
        
        memotypeTextField = new JTextField();// ���������ı���
        memotypeTextField.setEditable(false);
        nttPanel.add(memotypeTextField);// Ӧ�������ı���
        memotypeTextField.setColumns(7);// ���������ı�����
        
        memotimeLabel = new JLabel("ʱ�䣺");// ����ʱ���ǩ
        nttPanel.add(memotimeLabel);// Ӧ��ʱ���ǩ
        
        memotimeTextField = new JTextField();// ����ʱ���ı���
        memotimeTextField.setEditable(false);
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
        titleTextField.setEditable(false);
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
        contentTextArea.setEditable(false);
        JScrollPane contentScrollPane = new JScrollPane(contentTextArea);// ʹ���ı���������������
        contentPanel.add(contentScrollPane);// Ӧ�ù�������
        
        buttonPanel = new JPanel();// �������
        buttonPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));// �������ı߿�
        contentPane.add(buttonPanel, BorderLayout.SOUTH);// Ӧ�����
        
        previousButton = new JButton("��һ��");// ��������һ������ť
        //����һ������ť�¼�����
        previousButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(index<=0){
					JOptionPane.showMessageDialog(jd, "�Ѿ��ǵ�һ����¼","",JOptionPane.WARNING_MESSAGE);
					return;
				}
				updateContent(--index);
				
			}
		});
        buttonPanel.add(previousButton);// Ӧ�ð�ť
        
        JButton nextButton = new JButton("��һ��");// ��������һ������ť
        //"��һ��"��ť�¼�����
        nextButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(index>=(memoBeans.size()-1)){
		        	JOptionPane.showMessageDialog(jd, "�Ѿ������һ����¼","",JOptionPane.WARNING_MESSAGE);
					return;
		        }
		        updateContent(++index);
				
			}
		});
        
        buttonPanel.add(nextButton);// Ӧ�ð�ť
        
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
        //��ʾ��ѯ���
        updateContent(index);
       
        this.setVisible(true);
        
        
	}
	
	//���²�ѯ���
	public void updateContent(int index){
		MemoBean memoBean = memoBeans.get(index);//��õ�index������
		usernameTextField.setText(memoBean.getUsername());
		titleTextField.setText(memoBean.getTitle());
		memotypeTextField.setText(memoBean.getMemotype());
		contentTextArea.setText(memoBean.getContent());
		memotimeTextField.setText(memoBean.getMemotime());
		
	}
}
