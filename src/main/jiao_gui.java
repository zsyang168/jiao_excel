package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.FileReader;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.UIManager;

@SuppressWarnings("serial")
public class jiao_gui extends JFrame {

	public String excel_file_path;
	public String excel_list_path;
	// 背景面板
	private BackgroundPanel bg = new BackgroundPanel();
	// 设置运行时窗口的大小
	private int Width = 500;
	private int Height = 300;
	Dimension faceSize = new Dimension(Width, Height);
	// 获得屏幕的大小
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	// TODO 静态变量区
	private static JProgressBar progressbar;// 进度条

	public jiao_gui() {
		// TODO Auto-generated constructor stub
		// TODO 自动生成的构造函数存根
		super("");
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
		// 面板初始化
		panel_init();
		// 文件路径初始化
		file_path_init();
		System.out.println(excel_file_path);
	}

	// 文件路径初始化
	public void file_path_init() {
		String[] FilePath = new String[20];
		try {
			FileReader fileReader1 = new FileReader("path.txt");
			BufferedReader buf1 = new BufferedReader(fileReader1);
			String readLine = "";
			int i = 0;
			while ((readLine = buf1.readLine()) != null) {
				FilePath[i] = readLine;
				i++;
			}
			buf1.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "路径文件文件读入失败！\n" + e, "提示", JOptionPane.WARNING_MESSAGE);
			System.exit(0);
		}
		//
		excel_file_path = FilePath[1];
		excel_list_path = FilePath[3];
	}

	// 面板初始化
	public void panel_init() {
		JPanel box = new JPanel();
		box.setLayout(null);
		box.setOpaque(false);
		// 字体格式
		Font font = new Font("微软雅黑", Font.BOLD, 12);
		// 标题
		JPanel head = new JPanel();
		head.setLayout(new FlowLayout());
		JLabel title = new JLabel("");
		title.setFont(new Font("Arial", Font.BOLD, 20));
		head.add(title);
		head.setOpaque(false);

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
		// 添加面板
		box.add(head);
		head.setBounds(40, 0, 400, 40);
		box.add(foot);
		foot.setBounds(80, 200, 320, 30);
		box.setBackground(null);
		box.setOpaque(false);
		foot.setBounds(60, 200, Width * 3 / 4, 30);
		bg.setLayout(new BorderLayout(5, 5));
		bg.add("Center", box);
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

	// 背景面板
	class BackgroundPanel extends JPanel {
		/**
		 * 
		 */
		private static final long serialVersionUID = -6061254351690162507L;
		// 背景图片
		private Image BackgroubdImage = Toolkit.getDefaultToolkit().getImage(jiao_gui.class.getResource("logo.png"));

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
}
