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
	// ��������ʱ���ڵĴ�С
	private int Width = 480;
	private int Height = 240;
	Dimension faceSize = new Dimension(Width, Height);
	// �����Ļ�Ĵ�С
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	// ���ܼ�
	protected JButton Confirm = new JButton();// ȷ��
	// ����
	private Font cfont = new Font("΢���ź�", Font.BOLD, 12);
	// ������
	private static JProgressBar progressbar;

	private JTextField tf_source_name = new JTextField();
	private JTextField tf_source_sheet = new JTextField();
	private JTextField tf_source_key = new JTextField();

	protected String source_name = "̨��.xlsx";
	protected String source_sheet = "�粥ֲ�ݻ���";
	protected String source_key = "���λ��";

	private JTextField tf_sample_name = new JTextField();
	private JTextField tf_sample_sheet = new JTextField();
	private JTextField tf_sample_key = new JTextField();
	//
	protected String sample_name = "sample.xls";
	protected String sample_sheet = "���鵥";
	protected String sample_key = "·������";

	private JTextField tf_src_key = new JTextField();
	private JTextField tf_dst_key = new JTextField();
	protected String src_key = "��";
	protected String dst_key = "";

	protected MODULE module = MODULE.CLONE;

	private JRadioButton jrb1 = new JRadioButton("��¡");
	private JRadioButton jrb2 = new JRadioButton("�޸�");

	public jiao_gui() {
		// TODO Auto-generated constructor stub
		super("Excel Operation System");
		// ��ʼ�����
		panel_init();
		//
		tf_source_name.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
			public void changedUpdate(DocumentEvent e) {// ���Ǹ��Ĳ����Ĵ���
				source_name = tf_source_name.getText().trim();// trim()��������ȥ�������������Ŀո��
			}

			public void insertUpdate(DocumentEvent e) {// ���ǲ�������Ĵ���
				source_name = tf_source_name.getText().trim();
			}

			public void removeUpdate(DocumentEvent e) {// ����ɾ�������Ĵ���
				source_name = tf_source_name.getText().trim();
			}
		});
		
		tf_source_sheet.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
			public void changedUpdate(DocumentEvent e) {// ���Ǹ��Ĳ����Ĵ���
				source_sheet = tf_source_sheet.getText().trim();// trim()��������ȥ�������������Ŀո��
			}

			public void insertUpdate(DocumentEvent e) {// ���ǲ�������Ĵ���
				source_sheet = tf_source_sheet.getText().trim();
			}

			public void removeUpdate(DocumentEvent e) {// ����ɾ�������Ĵ���
				source_sheet = tf_source_sheet.getText().trim();
			}
		});
		
		tf_source_key.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
			public void changedUpdate(DocumentEvent e) {// ���Ǹ��Ĳ����Ĵ���
				source_key = tf_source_key.getText().trim();// trim()��������ȥ�������������Ŀո��
			}

			public void insertUpdate(DocumentEvent e) {// ���ǲ�������Ĵ���
				source_key = tf_source_key.getText().trim();
			}

			public void removeUpdate(DocumentEvent e) {// ����ɾ�������Ĵ���
				source_key = tf_source_key.getText().trim();
			}
		});

		
		tf_sample_name.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
			public void changedUpdate(DocumentEvent e) {// ���Ǹ��Ĳ����Ĵ���
				sample_name = tf_sample_name.getText().trim();// trim()��������ȥ�������������Ŀո��
			}

			public void insertUpdate(DocumentEvent e) {// ���ǲ�������Ĵ���
				sample_name = tf_sample_name.getText().trim();
			}

			public void removeUpdate(DocumentEvent e) {// ����ɾ�������Ĵ���
				sample_name = tf_sample_name.getText().trim();
			}
		});
		
		tf_sample_sheet.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
			public void changedUpdate(DocumentEvent e) {// ���Ǹ��Ĳ����Ĵ���
				sample_sheet = tf_sample_sheet.getText().trim();// trim()��������ȥ�������������Ŀո��
			}

			public void insertUpdate(DocumentEvent e) {// ���ǲ�������Ĵ���
				sample_sheet = tf_sample_sheet.getText().trim();
			}

			public void removeUpdate(DocumentEvent e) {// ����ɾ�������Ĵ���
				sample_sheet = tf_sample_sheet.getText().trim();
			}
		});
		
		tf_sample_key.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
			public void changedUpdate(DocumentEvent e) {// ���Ǹ��Ĳ����Ĵ���
				sample_key = tf_sample_key.getText().trim();// trim()��������ȥ�������������Ŀո��
			}

			public void insertUpdate(DocumentEvent e) {// ���ǲ�������Ĵ���
				sample_key = tf_sample_key.getText().trim();
			}

			public void removeUpdate(DocumentEvent e) {// ����ɾ�������Ĵ���
				sample_key = tf_sample_key.getText().trim();
			}
		});
		
		tf_src_key.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
			public void changedUpdate(DocumentEvent e) {// ���Ǹ��Ĳ����Ĵ���
				src_key = tf_src_key.getText().trim();// trim()��������ȥ�������������Ŀո��
			}

			public void insertUpdate(DocumentEvent e) {// ���ǲ�������Ĵ���
				src_key = tf_src_key.getText().trim();
			}

			public void removeUpdate(DocumentEvent e) {// ����ɾ�������Ĵ���
				src_key = tf_src_key.getText().trim();
			}
		});
		
		tf_dst_key.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
			public void changedUpdate(DocumentEvent e) {// ���Ǹ��Ĳ����Ĵ���
				dst_key = tf_dst_key.getText().trim();// trim()��������ȥ�������������Ŀո��
			}

			public void insertUpdate(DocumentEvent e) {// ���ǲ�������Ĵ���
				dst_key = tf_dst_key.getText().trim();
			}

			public void removeUpdate(DocumentEvent e) {// ����ɾ�������Ĵ���
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

	// ����ʼ��
	public void panel_init() {
		JPanel box = new JPanel();
		box.setLayout(null);
		box.setOpaque(false);
		/************* ̨����� *************/
		BoxPanel top = new BoxPanel("̨��");
		JLabel tfsn = new JLabel("�ļ���:");
		tfsn.setFont(cfont);
		top.add(tfsn);
		tfsn.setBounds(40, 10, 45, 20);
		top.add(tf_source_name);
		tf_source_name.setText(source_name);
		tf_source_name.setBounds(85, 10, 120, 20);

		JLabel tfss = new JLabel("����:");
		tfss.setFont(cfont);
		top.add(tfss);
		tfss.setBounds(210, 10, 30, 20);
		top.add(tf_source_sheet);
		tf_source_sheet.setText(source_sheet);
		tf_source_sheet.setBounds(240, 10, 100, 20);

		JLabel tfsk = new JLabel("�ؼ���:");
		tfsk.setFont(cfont);
		top.add(tfsk);
		tfsk.setBounds(345, 10, 45, 20);
		top.add(tf_source_key);
		tf_source_key.setText(source_key);
		tf_source_key.setBounds(390, 10, 65, 20);

		/************* ģ����� *************/
		BoxPanel mid = new BoxPanel("ģ��");
		JLabel tfsn2 = new JLabel("�ļ���:");
		tfsn.setFont(cfont);
		mid.add(tfsn2);
		tfsn2.setBounds(40, 10, 45, 20);
		mid.add(tf_sample_name);
		tf_sample_name.setText(sample_name);
		tf_sample_name.setBounds(85, 10, 120, 20);

		JLabel tfss2 = new JLabel("����:");
		tfss.setFont(cfont);
		mid.add(tfss2);
		tfss2.setBounds(210, 10, 30, 20);
		mid.add(tf_sample_sheet);
		tf_sample_sheet.setText(sample_sheet);
		tf_sample_sheet.setBounds(240, 10, 100, 20);

		JLabel tfsk2 = new JLabel("�ؼ���:");
		tfsk.setFont(cfont);
		mid.add(tfsk2);
		tfsk2.setBounds(345, 10, 45, 20);
		mid.add(tf_sample_key);
		tf_sample_key.setText(sample_key);
		tf_sample_key.setBounds(390, 10, 65, 20);

		/************* ������� *************/
		BoxPanel bot = new BoxPanel("����");
		JLabel tfs = new JLabel("�滻:");
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

		JLabel lm = new JLabel("ģʽ:");
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
		// ��ť
		Confirm = new JButton("����");
		Confirm.setFont(cfont);
		Confirm.setBorder(BorderFactory.createEmptyBorder());

		bot.add(Confirm);
		Confirm.setBounds(380, 10, 60, 20);
		// bot.add(Confirm);
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
		/************* ������� *************/
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

	// ���ý�������ʾ��ֵ
	public static void setProgressString(int value, String text) {
		Dimension d = progressbar.getSize();
		Rectangle rect = new Rectangle(0, 0, d.width, d.height);
		// �ж���ǰ��ɫ�Ƿ�Ϊ��ɫ���������Ϊ��ɫ���������ܳ����ǰ��ɫ��Ϊ��ɫ
		if (progressbar.getForeground() != Color.GREEN)
			progressbar.setForeground(Color.GREEN);
		// ���ý���ֵ
		progressbar.setValue(value);
		// ��ʾ��״̬
		progressbar.setString(text);
		// �����ػ�
		progressbar.paintImmediately(rect);
	}

	// �������
	class BackgroundPanel extends JPanel {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		// ����ͼƬ
		private Image BackgroubdImage = Toolkit.getDefaultToolkit().getImage(jiao_gui.class.getResource("logo.png"));

		// ���췽��
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
				int width = getWidth();// ��ȡ�����С
				int height = getHeight();
				// ���Ʊ���ͼƬ
				g.drawImage(BackgroubdImage, 0, 0, width, height, this);// ����ͼƬ�������С��ͬ
			}
		}

	}

	// �������
	class BoxPanel extends JPanel {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		// ���췽��
		public BoxPanel(String message) {
			super();
			setOpaque(false);
			setLayout(null);
			JLabel title = new JLabel(message);
			title.setFont(new Font("΢���ź�", Font.BOLD, 12));
			add(title);
			title.setBounds(5, 5, 60, 30);
		}

		protected void paintComponent(Graphics g) {// ��д����������
			int width = getWidth();// ��ȡ�����С
			int height = getHeight();
			g.drawLine(20, 5, width - 5, 5);
			g.drawLine(20, height - 5, width - 5, height - 5);
			g.drawLine(width - 5, 5, width - 5, height - 5);
			g.drawLine(20, 5, 20, 10);
			g.drawLine(20, height - 10, 20, height - 5);
			super.paintComponent(g);// ִ�г��෽��
		}
	}
}
