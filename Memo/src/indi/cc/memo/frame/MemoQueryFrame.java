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

//查询备忘录窗体
public class MemoQueryFrame extends JDialog{
	private JPanel contentPane;	//面板
	private JPanel othersPanel;	//面板
	private JPanel nttPanel;	//面板
	private JPanel contentPanel;	//面板
	private JLabel usernameLabel;	//姓名标签
	private JTextField usernameTextField;	//姓名文本域
	private JLabel memotypeLabel;	//类型标签
	private JTextField memotypeTextField;	//类型文本域
	private JLabel memotimeLabel;	//时间标签
	private JTextField memotimeTextField;	//时间文本域
	private JPanel titlePanel;	//面板
	private JLabel titleLabel;	//主题标签
	private JTextField titleTextField;	//主题文本域
	private JLabel contentLabel;	//内容标签
	private JTextArea contentTextArea;	//内容文本区
	private JPanel buttonPanel;	//按钮面板
	private JButton queryButton;	//查询按钮
	private JButton clearButton;	//清空按钮
	private JButton returnButton;	//返回按钮
	private JDialog jd;	//当前窗口
	/**
	 * 
	 * @param owner 它的父窗口
	 * @param title 窗口名
	 * @param modal 指定的模式窗口，还有非模式窗口
	 */
	public MemoQueryFrame(JFrame owner, String title, boolean modal){ 
		super(owner,title,modal);
		this.jd = this;
		contentPane = new JPanel();	//创建主面板
		contentPane.setLayout(new BorderLayout(0,0));
		this.setContentPane(contentPane);	//应用面板
		
		othersPanel = new JPanel();	//创建面板
		contentPane.add(othersPanel,BorderLayout.NORTH);// 应用面板
		
		othersPanel.setLayout(new GridLayout(2, 1, 5, 5));// 为面板设置网格布局
		nttPanel = new JPanel();	//创建面板
		nttPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));// 设置面板的边框
	    FlowLayout fl_nttPanel = (FlowLayout) nttPanel.getLayout();// 获得面板布局
	    fl_nttPanel.setAlignment(FlowLayout.LEFT);// 面板中控件采用左对齐
	    othersPanel.add(nttPanel);// 应用面板
	    
	    usernameLabel = new JLabel("姓名：");// 创建姓名标签
	    nttPanel.add(usernameLabel);	//应用姓名标签
	    nttPanel.add(usernameLabel);// 应用姓名标签
	    
	    usernameTextField = new JTextField();// 创建姓名文本域
	    nttPanel.add(usernameTextField);// 应用姓名文本域
        usernameTextField.setColumns(7);// 设置姓名文本域宽度
        
        memotypeLabel = new JLabel("类型：");// 创建类型标签
        nttPanel.add(memotypeLabel);// 应用类型标签
        
        memotypeTextField = new JTextField();// 创建类型文本域
        nttPanel.add(memotypeTextField);// 应用类型文本域
        memotypeTextField.setColumns(7);// 设置类型文本域宽度
        
        memotimeLabel = new JLabel("时间：");// 创建时间标签
        nttPanel.add(memotimeLabel);// 应用时间标签
        
        memotimeTextField = new JTextField();// 创建时间文本域
        nttPanel.add(memotimeTextField);// 应用时间文本域
        memotimeTextField.setColumns(8);// 设置时间文本域宽度
        
        titlePanel = new JPanel();// 创建面板
        titlePanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));// 设置面板的边框
        FlowLayout fl_titlePanel = (FlowLayout) titlePanel.getLayout();// 获得面板布局
        fl_titlePanel.setAlignment(FlowLayout.LEFT);// 面板中控件采用左对齐
        othersPanel.add(titlePanel);// 应用面板
        
        titleLabel = new JLabel("主题：");// 创建标签
        titlePanel.add(titleLabel);// 应用标签
        
        titleTextField = new JTextField();// 创建文本域
        titlePanel.add(titleTextField);// 应用文本域
        titleTextField.setColumns(32);// 设置文本域宽度
        
        contentPanel = new JPanel();// 创建面板
        contentPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));// 设置面板的边框
        FlowLayout fl_contentPanel = (FlowLayout) contentPanel.getLayout();// 获得面板布局
        fl_contentPanel.setAlignment(FlowLayout.LEFT);// 面板中控件采用左对齐
        contentPane.add(contentPanel, BorderLayout.CENTER);// 应用面板
        
        contentLabel = new JLabel("内容：");// 创建标签
        contentPanel.add(contentLabel);// 应用标签

        contentTextArea = new JTextArea();// 创建文本区
        contentTextArea.setColumns(32);// 设置文本区列数
        contentTextArea.setLineWrap(true);// 设置文本区自动换行
        contentTextArea.setRows(8);// 设置文本区行数
        
        JScrollPane contentScrollPane = new JScrollPane(contentTextArea);// 使用文本区创建滚动窗格
        contentPanel.add(contentScrollPane);// 应用滚动窗格
        
        buttonPanel = new JPanel();// 创建面板
        buttonPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));// 设置面板的边框
        contentPane.add(buttonPanel, BorderLayout.SOUTH);// 应用面板
        
        queryButton = new JButton("查询");// 创建“查询”按钮
        //查询按钮事件监听
        queryButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String username = usernameTextField.getText().trim();	//得到用户名
				String title = titleTextField.getText().trim();	//得到标题
				String time = memotimeTextField.getText().trim();	//得到时间
				String content = contentTextArea.getText().trim();	//得到内容
				String type = memotypeTextField.getText().trim();	//得到类型
				if(username.isEmpty()&&title.isEmpty()&&time.isEmpty()&&content.isEmpty()&&type.isEmpty()){
					JOptionPane.showMessageDialog(jd, "查询内容不能为空！","",JOptionPane.WARNING_MESSAGE);
					return ;
				}
				if((!time.isEmpty()) && (!ValidationUtil.validateTimeFormat(time))){
			            JOptionPane.showMessageDialog(jd, "日期格式为xxxx-xx-xx样式！", "", JOptionPane.WARNING_MESSAGE);
			            return;
			    }
				MemoBean memoBean = new MemoBean();
				memoBean.setUsername(username);
				memoBean.setTitle(title);
				memoBean.setMemotime(time);
				memoBean.setMemotype(type);
				memoBean.setContent(content);
				final List<MemoBean> memoBeans = JdbcHelper.query(memoBean);
				if(memoBeans.size()>0){
					MemoQueryResultsFrame memoQueryResultsFrame = new MemoQueryResultsFrame(jd, "查询结果", true, memoBeans);//传入list
				}else{
					JOptionPane.showMessageDialog(jd, "没有符合条件的记录！");
					return;
				}
			}
		});
        buttonPanel.add(queryButton);// 应用按钮
        
        clearButton = new JButton("清空");// 创建“清空”按钮
        //清空按钮事件监听
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
        buttonPanel.add(clearButton);// 应用按钮
        
        returnButton = new JButton("返回");// 创建“返回”按钮
        //返回按钮事件监听
        returnButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				jd.dispose();
			}
		});
        buttonPanel.add(returnButton);// 应用按钮
        
        setLocation(WindowUtil.getLocation());// 设置窗体显示位置
        setSize(WindowUtil.getSize());// 设置窗体大小
        this.setResizable(false);
        this.setVisible(true);
       
	}
}
