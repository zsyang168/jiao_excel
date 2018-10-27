package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.event.DocumentEvent;

public class jiao_gui extends JFrame {

	public enum MODULE {
		CLONE, ALTER
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// 设置运行时窗口的大小
	private int Width = 480;
	private int Height = 240;
	Dimension faceSize = new Dimension(Width, Height);
	// 获得屏幕的大小
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	// 功能键
	protected JButton Confirm = new JButton();// 确认
	// 字体
	private Font cfont = new Font("微软雅黑", Font.BOLD, 12);
	// 进度条
	private static JProgressBar progressbar;

	private JTextField tf_source_name = new JTextField();
	private JTextField tf_source_sheet = new JTextField();
	private JTextField tf_source_key = new JTextField();

	protected String source_name = "台账.xlsx";
	protected String source_sheet = "喷播植草护坡";
	protected String source_key = "里程位置";

	private JTextField tf_sample_name = new JTextField();
	private JTextField tf_sample_sheet = new JTextField();
	private JTextField tf_sample_key = new JTextField();
	//
	protected String sample_name = "sample.xls";
	protected String sample_sheet = "检验单";
	protected String sample_key = "路基工程";

	private JTextField tf_src_key = new JTextField();
	private JTextField tf_dst_key = new JTextField();
	protected String src_key = "段";
	protected String dst_key = "";

	protected MODULE module = MODULE.CLONE;

	private JRadioButton jrb1 = new JRadioButton("克隆");
	private JRadioButton jrb2 = new JRadioButton("修改");

	public jiao_gui() {
		// TODO Auto-generated constructor stub
		super("Excel Operation System");
		// 初始化面板
		panel_init();
		//
		tf_source_name.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
			public void changedUpdate(DocumentEvent e) {// 这是更改操作的处理
				source_name = tf_source_name.getText().trim();// trim()方法用于去掉你可能误输入的空格号
			}

			public void insertUpdate(DocumentEvent e) {// 这是插入操作的处理
				source_name = tf_source_name.getText().trim();
			}

			public void removeUpdate(DocumentEvent e) {// 这是删除操作的处理
				source_name = tf_source_name.getText().trim();
			}
		});
		
		tf_source_sheet.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
			public void changedUpdate(DocumentEvent e) {// 这是更改操作的处理
				source_sheet = tf_source_sheet.getText().trim();// trim()方法用于去掉你可能误输入的空格号
			}

			public void insertUpdate(DocumentEvent e) {// 这是插入操作的处理
				source_sheet = tf_source_sheet.getText().trim();
			}

			public void removeUpdate(DocumentEvent e) {// 这是删除操作的处理
				source_sheet = tf_source_sheet.getText().trim();
			}
		});
		
		tf_source_key.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
			public void changedUpdate(DocumentEvent e) {// 这是更改操作的处理
				source_key = tf_source_key.getText().trim();// trim()方法用于去掉你可能误输入的空格号
			}

			public void insertUpdate(DocumentEvent e) {// 这是插入操作的处理
				source_key = tf_source_key.getText().trim();
			}

			public void removeUpdate(DocumentEvent e) {// 这是删除操作的处理
				source_key = tf_source_key.getText().trim();
			}
		});

		
		tf_sample_name.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
			public void changedUpdate(DocumentEvent e) {// 这是更改操作的处理
				sample_name = tf_sample_name.getText().trim();// trim()方法用于去掉你可能误输入的空格号
			}

			public void insertUpdate(DocumentEvent e) {// 这是插入操作的处理
				sample_name = tf_sample_name.getText().trim();
			}

			public void removeUpdate(DocumentEvent e) {// 这是删除操作的处理
				sample_name = tf_sample_name.getText().trim();
			}
		});
		
		tf_sample_sheet.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
			public void changedUpdate(DocumentEvent e) {// 这是更改操作的处理
				sample_sheet = tf_sample_sheet.getText().trim();// trim()方法用于去掉你可能误输入的空格号
			}

			public void insertUpdate(DocumentEvent e) {// 这是插入操作的处理
				sample_sheet = tf_sample_sheet.getText().trim();
			}

			public void removeUpdate(DocumentEvent e) {// 这是删除操作的处理
				sample_sheet = tf_sample_sheet.getText().trim();
			}
		});
		
		tf_sample_key.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
			public void changedUpdate(DocumentEvent e) {// 这是更改操作的处理
				sample_key = tf_sample_key.getText().trim();// trim()方法用于去掉你可能误输入的空格号
			}

			public void insertUpdate(DocumentEvent e) {// 这是插入操作的处理
				sample_key = tf_sample_key.getText().trim();
			}

			public void removeUpdate(DocumentEvent e) {// 这是删除操作的处理
				sample_key = tf_sample_key.getText().trim();
			}
		});
		
		tf_src_key.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
			public void changedUpdate(DocumentEvent e) {// 这是更改操作的处理
				src_key = tf_src_key.getText().trim();// trim()方法用于去掉你可能误输入的空格号
			}

			public void insertUpdate(DocumentEvent e) {// 这是插入操作的处理
				src_key = tf_src_key.getText().trim();
			}

			public void removeUpdate(DocumentEvent e) {// 这是删除操作的处理
				src_key = tf_src_key.getText().trim();
			}
		});
		
		tf_dst_key.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
			public void changedUpdate(DocumentEvent e) {// 这是更改操作的处理
				dst_key = tf_dst_key.getText().trim();// trim()方法用于去掉你可能误输入的空格号
			}

			public void insertUpdate(DocumentEvent e) {// 这是插入操作的处理
				dst_key = tf_dst_key.getText().trim();
			}

			public void removeUpdate(DocumentEvent e) {// 这是删除操作的处理
				dst_key = tf_dst_key.getText().trim();
			}
		});
		
		jrb1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				jrb1.setSelected(true);
				jrb2.setSelected(false);
				module = MODULE.CLONE; 
			}
		});
		
		jrb2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				jrb2.setSelected(true);
				jrb1.setSelected(false);
				module = MODULE.ALTER;
			}
		});
	}

	// 面板初始化
	public void panel_init() {
		JPanel box = new JPanel();
		box.setLayout(null);
		box.setOpaque(false);
		/************* 台帐面板 *************/
		BoxPanel top = new BoxPanel("台帐");
		JLabel tfsn = new JLabel("文件名:");
		tfsn.setFont(cfont);
		top.add(tfsn);
		tfsn.setBounds(40, 10, 45, 20);
		top.add(tf_source_name);
		tf_source_name.setText(source_name);
		tf_source_name.setBounds(85, 10, 120, 20);

		JLabel tfss = new JLabel("表名:");
		tfss.setFont(cfont);
		top.add(tfss);
		tfss.setBounds(210, 10, 30, 20);
		top.add(tf_source_sheet);
		tf_source_sheet.setText(source_sheet);
		tf_source_sheet.setBounds(240, 10, 100, 20);

		JLabel tfsk = new JLabel("关键字:");
		tfsk.setFont(cfont);
		top.add(tfsk);
		tfsk.setBounds(345, 10, 45, 20);
		top.add(tf_source_key);
		tf_source_key.setText(source_key);
		tf_source_key.setBounds(390, 10, 65, 20);

		/************* 模板面板 *************/
		BoxPanel mid = new BoxPanel("模板");
		JLabel tfsn2 = new JLabel("文件名:");
		tfsn.setFont(cfont);
		mid.add(tfsn2);
		tfsn2.setBounds(40, 10, 45, 20);
		mid.add(tf_sample_name);
		tf_sample_name.setText(sample_name);
		tf_sample_name.setBounds(85, 10, 120, 20);

		JLabel tfss2 = new JLabel("表名:");
		tfss.setFont(cfont);
		mid.add(tfss2);
		tfss2.setBounds(210, 10, 30, 20);
		mid.add(tf_sample_sheet);
		tf_sample_sheet.setText(sample_sheet);
		tf_sample_sheet.setBounds(240, 10, 100, 20);

		JLabel tfsk2 = new JLabel("关键字:");
		tfsk.setFont(cfont);
		mid.add(tfsk2);
		tfsk2.setBounds(345, 10, 45, 20);
		mid.add(tf_sample_key);
		tf_sample_key.setText(sample_key);
		tf_sample_key.setBounds(390, 10, 65, 20);

		/************* 功能面板 *************/
		BoxPanel bot = new BoxPanel("设置");
		JLabel tfs = new JLabel("替换:");
		tfs.setFont(cfont);
		bot.add(tfs);
		tfs.setBounds(40, 10, 30, 20);
		bot.add(tf_src_key);
		tf_src_key.setText(src_key);
		tf_src_key.setBounds(70, 10, 60, 20);
		
		JLabel tfd = new JLabel("to");
		tfd.setFont(cfont);
		bot.add(tfd);
		tfd.setBounds(130, 10, 15, 20);
		
		bot.add(tf_dst_key);
		tf_dst_key.setText(dst_key);
		tf_dst_key.setBounds(145, 10, 60, 20);

		JLabel lm = new JLabel("模式:");
		lm.setFont(cfont);
		bot.add(lm);
		lm.setBounds(220, 10, 30, 20);
		bot.add(jrb1);
		jrb1.setSelected(true);
		jrb1.setBounds(250, 10, 60, 20);
		jrb1.setOpaque(false);
		bot.add(jrb2);
		jrb2.setSelected(false);
		jrb2.setBounds(300, 10, 60, 20);
		jrb2.setOpaque(false);
		jrb2.setContentAreaFilled(false);
		// 按钮
		Confirm = new JButton("运行");
		Confirm.setFont(cfont);
		Confirm.setBorder(BorderFactory.createEmptyBorder());

		bot.add(Confirm);
		Confirm.setBounds(380, 10, 60, 20);
		// bot.add(Confirm);
		/** 进度条，状态栏 **/
		// 面板，用来装进度条
		JPanel foot = new JPanel();
		// 设置背景色
		foot.setOpaque(false);
		UIManager.put("ProgressBar.selectionForeground", Color.BLACK); // 进度条字体颜色
		progressbar = new JProgressBar(0, 100);
		progressbar.setStringPainted(true);// 设置进度条上的字符串显示，false则不能显示
		progressbar.setPreferredSize(new Dimension(Width * 3 / 4, 25));// 设置进度条大小
		progressbar.setBackground(Color.WHITE);// 设置进度条背景色
		progressbar.setForeground(Color.GREEN);// 设置进度条前景色
		progressbar.setString("");
		foot.add(progressbar);
		/************* 背景面板 *************/
		BackgroundPanel bg = new BackgroundPanel();
		box.add(top);
		top.setBounds(5, 30, 465, 40);

		box.add(mid);
		mid.setBounds(5, 70, 465, 40);

		box.add(bot);
		bot.setBounds(5, 110, 465, 40);

		box.add(foot);
		foot.setBounds(80, 150, 320, 20);
		box.setBackground(null);
		box.setOpaque(false);
		foot.setBounds(45, 150, Width * 4 / 5, 30);
		bg.setLayout(new BorderLayout(5, 5));
		bg.add("Center", box);
		//
		// 设置窗口居中
		setLocation((int) (screenSize.width - faceSize.getWidth()) / 2,
				(int) (screenSize.height - faceSize.getHeight()) / 2);
		// 设置窗口大小
		setSize(faceSize);
		// 设置为右见
		setVisible(true);
		// 设置为不可最大化
		setResizable(false);
		// 设置可关闭
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(bg);
		validate();
	}

	// 设置程序出错情况
	public static void setProgressError(String message) {
		Dimension d = progressbar.getSize();
		Rectangle rect = new Rectangle(0, 0, d.width, d.height);
		// 程序出错，设前景色为红色
		progressbar.setForeground(Color.RED);
		// 设置进度值
		progressbar.setValue(100);
		// 显示运状态
		progressbar.setString(message);
		// 立即重绘
		progressbar.paintImmediately(rect);
	}

	// 设置进度条显示的值
	public static void setProgressString(int value, String text) {
		Dimension d = progressbar.getSize();
		Rectangle rect = new Rectangle(0, 0, d.width, d.height);
		// 判断是前景色是否为绿色，不是则改为绿色，因程序可能出错把前景色设为红色
		if (progressbar.getForeground() != Color.GREEN)
			progressbar.setForeground(Color.GREEN);
		// 设置进度值
		progressbar.setValue(value);
		// 显示运状态
		progressbar.setString(text);
		// 立即重绘
		progressbar.paintImmediately(rect);
	}

	// 背景面板
	class BackgroundPanel extends JPanel {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		// 背景图片
		private Image BackgroubdImage = Toolkit.getDefaultToolkit().getImage(jiao_gui.class.getResource("logo.png"));

		// 构造方法
		public BackgroundPanel() {
			super();
			setOpaque(false);
			setLayout(null);
			JLabel title = new JLabel("Excel Operation System");
			title.setFont(new Font("Arial", Font.BOLD, 20));
			add(title);
			title.setBounds(120, 0, 240, 40);
		}

		public void paintComponent(Graphics g) {
			super.paintComponents(g);
			if (BackgroubdImage != null) {
				int width = getWidth();// 获取组件大小
				int height = getHeight();
				// 绘制背景图片
				g.drawImage(BackgroubdImage, 0, 0, width, height, this);// 绘制图片与组件大小相同
			}
		}

	}

	// 功能面板
	class BoxPanel extends JPanel {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		// 构造方法
		public BoxPanel(String message) {
			super();
			setOpaque(false);
			setLayout(null);
			JLabel title = new JLabel(message);
			title.setFont(new Font("微软雅黑", Font.BOLD, 12));
			add(title);
			title.setBounds(5, 5, 60, 30);
		}

		protected void paintComponent(Graphics g) {// 重写绘制组件外观
			int width = getWidth();// 获取组件大小
			int height = getHeight();
			g.drawLine(20, 5, width - 5, 5);
			g.drawLine(20, height - 5, width - 5, height - 5);
			g.drawLine(width - 5, 5, width - 5, height - 5);
			g.drawLine(20, 5, 20, 10);
			g.drawLine(20, height - 10, 20, height - 5);
			super.paintComponent(g);// 执行超类方法
		}
	}
}
