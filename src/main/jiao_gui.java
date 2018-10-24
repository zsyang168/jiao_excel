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
	// �������
	private BackgroundPanel bg = new BackgroundPanel();
	// ��������ʱ���ڵĴ�С
	private int Width = 500;
	private int Height = 300;
	Dimension faceSize = new Dimension(Width, Height);
	// �����Ļ�Ĵ�С
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	// TODO ��̬������
	private static JProgressBar progressbar;// ������

	public jiao_gui() {
		// TODO Auto-generated constructor stub
		// TODO �Զ����ɵĹ��캯�����
		super("");
		// ���ô��ھ���
		setLocation((int) (screenSize.width - faceSize.getWidth()) / 2,
				(int) (screenSize.height - faceSize.getHeight()) / 2);
		// ���ô��ڴ�С
		setSize(faceSize);
		// ����Ϊ�Ҽ�
		setVisible(true);
		// ����Ϊ�������
		setResizable(false);
		// ���ÿɹر�
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// ����ʼ��
		panel_init();
		// �ļ�·����ʼ��
		file_path_init();
		System.out.println(excel_file_path);
	}

	// �ļ�·����ʼ��
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
			JOptionPane.showMessageDialog(null, "·���ļ��ļ�����ʧ�ܣ�\n" + e, "��ʾ", JOptionPane.WARNING_MESSAGE);
			System.exit(0);
		}
		//
		excel_file_path = FilePath[1];
		excel_list_path = FilePath[3];
	}

	// ����ʼ��
	public void panel_init() {
		JPanel box = new JPanel();
		box.setLayout(null);
		box.setOpaque(false);
		// �����ʽ
		Font font = new Font("΢���ź�", Font.BOLD, 12);
		// ����
		JPanel head = new JPanel();
		head.setLayout(new FlowLayout());
		JLabel title = new JLabel("");
		title.setFont(new Font("Arial", Font.BOLD, 20));
		head.add(title);
		head.setOpaque(false);

		/** ��������״̬�� **/
		// ��壬����װ������
		JPanel foot = new JPanel();
		// ���ñ���ɫ
		foot.setOpaque(false);
		UIManager.put("ProgressBar.selectionForeground", Color.BLACK); // ������������ɫ
		progressbar = new JProgressBar(0, 100);
		progressbar.setStringPainted(true);// ���ý������ϵ��ַ�����ʾ��false������ʾ
		progressbar.setPreferredSize(new Dimension(Width * 3 / 4, 25));// ���ý�������С
		progressbar.setBackground(Color.WHITE);// ���ý���������ɫ
		progressbar.setForeground(Color.GREEN);// ���ý�����ǰ��ɫ
		progressbar.setString("");
		foot.add(progressbar);
		// ������
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

	// ���ó���������
	public static void setProgressError(String message) {
		Dimension d = progressbar.getSize();
		Rectangle rect = new Rectangle(0, 0, d.width, d.height);
		// ���������ǰ��ɫΪ��ɫ
		progressbar.setForeground(Color.RED);
		// ���ý���ֵ
		progressbar.setValue(100);
		// ��ʾ��״̬
		progressbar.setString(message);
		// �����ػ�
		progressbar.paintImmediately(rect);
	}

	// �������
	class BackgroundPanel extends JPanel {
		/**
		 * 
		 */
		private static final long serialVersionUID = -6061254351690162507L;
		// ����ͼƬ
		private Image BackgroubdImage = Toolkit.getDefaultToolkit().getImage(jiao_gui.class.getResource("logo.png"));

		public void paintComponent(Graphics g) {
			super.paintComponents(g);
			if (BackgroubdImage != null) {
				int width = getWidth();// ��ȡ�����С
				int height = getHeight();
				// ���Ʊ���ͼƬ
				g.drawImage(BackgroubdImage, 0, 0, width, height, this);// ����ͼƬ�������С��ͬ
			}
		}
	}
}
