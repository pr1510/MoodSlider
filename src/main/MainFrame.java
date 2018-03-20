package main;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.*;

import util.XMLFileReader;

import javax.swing.JFileChooser;
import javax.swing.JSlider;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeListener;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import components.Movie;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	private JLabel movieLabel1;
	private JLabel movieLabel2;
	private JLabel movieLabel3;
	private JLabel movieLabel4;
	private HashMap<String,JLabel> movieLabelList;

	private JSlider slider1;
	private JSlider slider2;
	private JSlider slider3;
	private JSlider slider4;
	private ArrayList<JSlider> sliderList;
	private List<Movie> movieList;
	private JLabel lblNewLabel_1;
	private JTextField txtCalm;
	private JTextField txtAgitated;
	private JScrollBar scrollBar;
	private JTextField txtHappy;
	private JTextField txtAgitated_1;
	private JTextField txtTired;
	private JTextField txtWideAwake;
	private JTextField txtScared;
	private JTextField txtFearless;
	private JTextField textField1;
	private JTextField textField2;
	private JTextField textField3;
	private JTextField textField4;
	private HashMap<String,JTextField> txtList;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		JPanel content = new JPanel();
		JScrollPane pane = new JScrollPane(content);
		this.getContentPane().add(pane);
		sliderList = new ArrayList<JSlider>();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 551, 403);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		createLabels();
		createMovieLabels();

		JButton btnChooseAFile = new JButton("Upload Content");
		btnChooseAFile.setFont(new Font("Lucida Grande", Font.BOLD, 11));
		btnChooseAFile.setBackground(new Color(192, 192, 192));
		btnChooseAFile.setOpaque(true);
		btnChooseAFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				int result = fileChooser.showOpenDialog(new JFrame());
				if (result == JFileChooser.APPROVE_OPTION) {
					File selectedFile = fileChooser.getSelectedFile();
					XMLFileReader reader = new XMLFileReader(selectedFile);
					movieList = reader.getMovieList();
				}
			}
		});
		btnChooseAFile.setBounds(193, 45, 111, 24);
		contentPane.add(btnChooseAFile);

		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setBounds(6, 6, 85, 50);
		contentPane.add(lblNewLabel);
		ImageIcon imageIcon = new ImageIcon(new ImageIcon("resources/images/sky_logo.jpg").getImage()
				.getScaledInstance(lblNewLabel.getWidth(), lblNewLabel.getHeight(), Image.SCALE_DEFAULT));
		lblNewLabel.setIcon(imageIcon);

		lblNewLabel_1 = new JLabel("MOOD-SLIDER");
		lblNewLabel_1.setBackground(Color.DARK_GRAY);
		lblNewLabel_1.setForeground(new Color(245, 245, 245));
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_1.setBounds(179, 6, 174, 37);
		contentPane.add(lblNewLabel_1);

		txtCalm = new JTextField();
		txtCalm.setForeground(new Color(0, 255, 255));
		txtCalm.setBackground(Color.LIGHT_GRAY);
		txtCalm.setText("Calm");
		txtCalm.setBounds(414, 65, 66, 26);
		txtCalm.setBorder(new LineBorder(Color.GRAY, 0));
		contentPane.add(txtCalm);
		txtCalm.setColumns(10);

		txtAgitated = new JTextField();
		txtAgitated.setText("                Agitated");
		txtAgitated.setForeground(new Color(255, 69, 0));
		txtAgitated.setColumns(10);
		txtAgitated.setBackground(Color.LIGHT_GRAY);
		txtAgitated.setBounds(29, 65, 85, 26);
		txtAgitated.setBorder(new LineBorder(Color.GRAY, 0));
		// txtAgitated.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		contentPane.add(txtAgitated);
		
		txtHappy = new JTextField();
		txtHappy.setText("               Happy");
		txtHappy.setForeground(new Color(255, 69, 0));
		txtHappy.setColumns(10);
		txtHappy.setBorder(new LineBorder(Color.GRAY, 0));
		txtHappy.setBackground(Color.LIGHT_GRAY);
		txtHappy.setBounds(29, 94, 85, 26);
		contentPane.add(txtHappy);
		
		txtAgitated_1 = new JTextField();
		txtAgitated_1.setText("Sad");
		txtAgitated_1.setForeground(new Color(0, 255, 255));
		txtAgitated_1.setColumns(10);
		txtAgitated_1.setBorder(new LineBorder(Color.GRAY, 0));
		txtAgitated_1.setBackground(Color.LIGHT_GRAY);
		txtAgitated_1.setBounds(414, 94, 85, 26);
		contentPane.add(txtAgitated_1);
		
		txtTired = new JTextField();
		txtTired.setText("                Tired");
		txtTired.setForeground(new Color(255, 69, 0));
		txtTired.setColumns(10);
		txtTired.setBorder(new LineBorder(Color.GRAY, 0));
		txtTired.setBackground(Color.LIGHT_GRAY);
		txtTired.setBounds(29, 119, 85, 26);
		contentPane.add(txtTired);
		
		txtWideAwake = new JTextField();
		txtWideAwake.setText("Wide Awake");
		txtWideAwake.setForeground(new Color(0, 255, 255));
		txtWideAwake.setColumns(10);
		txtWideAwake.setBorder(new LineBorder(Color.GRAY, 0));
		txtWideAwake.setBackground(Color.LIGHT_GRAY);
		txtWideAwake.setBounds(414, 119, 85, 26);
		contentPane.add(txtWideAwake);
		
		txtScared = new JTextField();
		txtScared.setText("                Scared");
		txtScared.setForeground(new Color(255, 69, 0));
		txtScared.setColumns(10);
		txtScared.setBorder(new LineBorder(Color.GRAY, 0));
		txtScared.setBackground(Color.LIGHT_GRAY);
		txtScared.setBounds(29, 144, 85, 26);
		contentPane.add(txtScared);
		
		txtFearless = new JTextField();
		txtFearless.setText("Fearless");
		txtFearless.setForeground(new Color(0, 255, 255));
		txtFearless.setColumns(10);
		txtFearless.setBorder(new LineBorder(Color.GRAY, 0));
		txtFearless.setBackground(Color.LIGHT_GRAY);
		txtFearless.setBounds(414, 144, 85, 26);
		contentPane.add(txtFearless);
		
		txtList = new HashMap<>();
		
		textField1 = new JTextField();
		textField1.setText("No Content");
		textField1.setHorizontalAlignment(SwingConstants.CENTER);
		textField1.setForeground(Color.WHITE);
		textField1.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		textField1.setBackground(Color.DARK_GRAY);
		textField1.setBounds(6, 333, 120, 42);
		contentPane.add(textField1);
		textField1.setColumns(10);
		
		textField2 = new JTextField();
		textField2.setText("No Content");
		textField2.setHorizontalAlignment(SwingConstants.CENTER);
		textField2.setForeground(Color.WHITE);
		textField2.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		textField2.setBackground(Color.DARK_GRAY);
		textField2.setColumns(10);
		textField2.setBounds(138, 333, 120, 42);
		contentPane.add(textField2);
		
		textField3 = new JTextField();
		textField3.setText("No Content");
		textField3.setForeground(Color.WHITE);
		textField3.setHorizontalAlignment(SwingConstants.CENTER);
		textField3.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		textField3.setBackground(Color.DARK_GRAY);
		textField3.setColumns(10);
		textField3.setBounds(270, 333, 120, 42);
		contentPane.add(textField3);
		
		textField4 = new JTextField();
		textField4.setText("No Content");
		textField4.setForeground(Color.WHITE);
		textField4.setHorizontalAlignment(SwingConstants.CENTER);
		textField4.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		textField4.setBackground(Color.DARK_GRAY);
		textField4.setColumns(10);
		textField4.setBounds(402, 333, 120, 42);
		contentPane.add(textField4);
		
		txtList.put("1", textField1);
		txtList.put("2", textField2);
		txtList.put("3", textField3);
		txtList.put("4", textField4);

	}

	private void createMovieLabels() {
		
		movieLabelList = new HashMap<>();
		movieLabel1 = new JLabel("No Content");
		movieLabel1.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		movieLabel1.setHorizontalAlignment(SwingConstants.CENTER);
		movieLabel1.setOpaque(true);
		movieLabel1.setForeground(Color.WHITE);
		movieLabel1.setBackground(Color.DARK_GRAY);
		movieLabel1.setBounds(16, 198, 98, 134);
		contentPane.add(movieLabel1);

		movieLabel2 = new JLabel("No Content");
		movieLabel2.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		movieLabel2.setHorizontalAlignment(SwingConstants.CENTER);
		movieLabel2.setForeground(Color.WHITE);
		movieLabel2.setOpaque(true);
		movieLabel2.setBackground(Color.DARK_GRAY);
		movieLabel2.setBounds(150, 198, 98, 134);
		contentPane.add(movieLabel2);

		movieLabel3 = new JLabel("No Content");
		movieLabel3.setHorizontalAlignment(SwingConstants.CENTER);
		movieLabel3.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		movieLabel3.setForeground(Color.WHITE);
		movieLabel3.setOpaque(true);
		movieLabel3.setBackground(Color.DARK_GRAY);
		movieLabel3.setBounds(279, 198, 98, 134);
		contentPane.add(movieLabel3);

		movieLabel4 = new JLabel("No Content");
		movieLabel4.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		movieLabel4.setHorizontalAlignment(SwingConstants.CENTER);
		movieLabel4.setForeground(Color.WHITE);
		movieLabel4.setOpaque(true);
		movieLabel4.setBackground(Color.DARK_GRAY);
		movieLabel4.setBounds(414, 198, 98, 134);
		contentPane.add(movieLabel4);

		movieLabelList.put("1",movieLabel1);
		movieLabelList.put("2",movieLabel2);
		movieLabelList.put("3",movieLabel3);
		movieLabelList.put("4",movieLabel4);
		
		//JPanel panel = new JPanel();
		//for (JLabel jl: movieLabelList)
		//{
		//	panel.add(jl);
		//}
		//panel.setBounds(6, 170, 398, 108);
		
		
		
		//contentPane.add(panel);
	}

	private void createLabels() {
		slider1 = new JSlider();
		slider1.setBounds(108, 71, 311, 20);
		slider1.setMajorTickSpacing(31);
		slider1.setPaintTicks(true);
		addSlide1Listeners();
		contentPane.add(slider1);

		slider2 = new JSlider();
		slider2.setBounds(108, 100, 311, 20);
		slider2.setMajorTickSpacing(31);
		slider2.setPaintTicks(true);
		addSlide2Listeners();
		contentPane.add(slider2);

		slider3 = new JSlider();
		slider3.setBounds(108, 125, 311, 20);
		slider3.setMajorTickSpacing(31);
		slider3.setPaintTicks(true);
		addSlide3Listeners();
		contentPane.add(slider3);

		slider4 = new JSlider();
		slider4.setBounds(108, 150, 311, 20);
		slider4.setMajorTickSpacing(31);
		slider4.setPaintTicks(true);
		addSlide4Listeners();
		contentPane.add(slider4);
		
		sliderList.add(slider1);
		sliderList.add(slider2);
		sliderList.add(slider3);
		sliderList.add(slider4);
	}
			
	
	public void clearMovieLabels()
	{
		for (Map.Entry<String, JLabel> entry : movieLabelList.entrySet())
		{
			if(entry.getValue().getIcon()!=null)
			{
				entry.getValue().setIcon(null);
			}
		}
	}
	
	public void clearTextLabels()
	{
		for (Map.Entry<String, JTextField> entry : txtList.entrySet())
		{
			JTextField jf = entry.getValue();
			if(!jf.getText().isEmpty())
			{
				jf.setText("");
			}
		}
	}
	
	public void addSlide1Listeners()
	{
		slider1.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if (slider1.getValue() == 1) {
					clearMovieLabels();
					clearTextLabels();
					for (Movie m : movieList) {
						if (m.getMood().equals("agitated") && m.getLevel().equals("1") && m.getState()) {
							for (Map.Entry<String, JLabel> entry : movieLabelList.entrySet()) {
								if (entry.getValue().getIcon() == null) {
									ImageIcon imageIcon = new ImageIcon(new ImageIcon(m.getPath()).getImage()
											.getScaledInstance(entry.getValue().getWidth(), entry.getValue().getHeight(), Image.SCALE_DEFAULT));
									entry.getValue().setIcon(imageIcon);
									JTextField tf = txtList.get(entry.getKey());
									tf.setText(m.getName());
									break;
								}
							}
						}
						
					}
				}
				if (slider1.getValue() == 31) {
					clearMovieLabels();
					clearTextLabels();
					for (Movie m : movieList) {
						if (m.getMood().equals("agitated") && m.getLevel().equals("2") && m.getState()) {
							for (Map.Entry<String, JLabel> entry : movieLabelList.entrySet()) {
								JLabel lbl = entry.getValue();
								if (lbl.getIcon() == null) {
									ImageIcon imageIcon = new ImageIcon(new ImageIcon(m.getPath()).getImage()
											.getScaledInstance(lbl.getWidth(), lbl.getHeight(), Image.SCALE_DEFAULT));
									lbl.setIcon(imageIcon);
									JTextField tf = txtList.get(entry.getKey());
									tf.setText(m.getName());
									break;
								}
							}
						}
						
					}
				}
				
				if (slider1.getValue() == 62) {
					clearMovieLabels();
					clearTextLabels();
					for (Movie m : movieList) {
						if (m.getMood().equals("agitated") && m.getLevel().equals("3") && m.getState()) {
							for (Map.Entry<String, JLabel> entry : movieLabelList.entrySet()) {
								JLabel lbl = entry.getValue();
								if (lbl.getIcon() == null) {
									ImageIcon imageIcon = new ImageIcon(new ImageIcon(m.getPath()).getImage()
											.getScaledInstance(lbl.getWidth(), lbl.getHeight(), Image.SCALE_DEFAULT));
									lbl.setIcon(imageIcon);
									JTextField tf = txtList.get(entry.getKey());
									tf.setText(m.getName());
									break;
								}
							}
						}
						
					}
				}
				
				if (slider1.getValue() == 93) {
					clearMovieLabels();
					clearTextLabels();
					for (Movie m : movieList) {
						if (m.getMood().equals("agitated") && m.getLevel().equals("4") && m.getState()) {
							for (Map.Entry<String, JLabel> entry : movieLabelList.entrySet()) {
								JLabel lbl = entry.getValue();
								if (lbl.getIcon() == null) {
									ImageIcon imageIcon = new ImageIcon(new ImageIcon(m.getPath()).getImage()
											.getScaledInstance(lbl.getWidth(), lbl.getHeight(), Image.SCALE_DEFAULT));
									lbl.setIcon(imageIcon);
									JTextField tf = txtList.get(entry.getKey());
									tf.setText(m.getName());
									break;
								}
							}
						}
						
					}
				}
			}
		});
		
		
		
	}
	
	public void addSlide2Listeners()
	{
		slider2.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if (slider2.getValue() == 93) {
					clearMovieLabels();
					clearTextLabels();
					for (Movie m : movieList) {
						if (m.getMood().equals("sad") && m.getLevel().equals("1") && m.getState()) {
							for (Map.Entry<String, JLabel> entry : movieLabelList.entrySet()) {
								JLabel lbl= entry.getValue();
								if (lbl.getIcon() == null) {
									ImageIcon imageIcon = new ImageIcon(new ImageIcon(m.getPath()).getImage()
											.getScaledInstance(lbl.getWidth(), lbl.getHeight(), Image.SCALE_DEFAULT));
									lbl.setIcon(imageIcon);
									JTextField tf = txtList.get(entry.getKey());
									tf.setText(m.getName());
									break;
								}
							}
						}
						
					}
				}
				
				if (slider2.getValue() == 62) {
					clearMovieLabels();
					clearTextLabels();
					for (Movie m : movieList) {
						if (m.getMood().equals("sad") && m.getLevel().equals("2") && m.getState()) {
							for (Map.Entry<String, JLabel> entry : movieLabelList.entrySet()) {
								JLabel lbl= entry.getValue();
								if (lbl.getIcon() == null) {
									ImageIcon imageIcon = new ImageIcon(new ImageIcon(m.getPath()).getImage()
											.getScaledInstance(lbl.getWidth(), lbl.getHeight(), Image.SCALE_DEFAULT));
									lbl.setIcon(imageIcon);
									JTextField tf = txtList.get(entry.getKey());
									tf.setText(m.getName());
									break;
								}
							}
						}
						
					}
				}
				
				if (slider2.getValue() == 31) {
					clearMovieLabels();
					clearTextLabels();
					for (Movie m : movieList) {
						if (m.getMood().equals("sad") && m.getLevel().equals("3") && m.getState()) {
							for (Map.Entry<String, JLabel> entry : movieLabelList.entrySet()) {
								JLabel lbl= entry.getValue();
								if (lbl.getIcon() == null) {
									ImageIcon imageIcon = new ImageIcon(new ImageIcon(m.getPath()).getImage()
											.getScaledInstance(lbl.getWidth(), lbl.getHeight(), Image.SCALE_DEFAULT));
									lbl.setIcon(imageIcon);
									JTextField tf = txtList.get(entry.getKey());
									tf.setText(m.getName());
									break;
								}
							}
						}
						
					}
				}
				
				if (slider2.getValue() == 1) {
					clearMovieLabels();
					clearTextLabels();
					for (Movie m : movieList) {
						if (m.getMood().equals("sad") && m.getLevel().equals("4") && m.getState()) {
							for (Map.Entry<String, JLabel> entry : movieLabelList.entrySet()) {
								JLabel lbl= entry.getValue();
								if (lbl.getIcon() == null) {
									ImageIcon imageIcon = new ImageIcon(new ImageIcon(m.getPath()).getImage()
											.getScaledInstance(lbl.getWidth(), lbl.getHeight(), Image.SCALE_DEFAULT));
									lbl.setIcon(imageIcon);
									JTextField tf = txtList.get(entry.getKey());
									tf.setText(m.getName());
									break;
								}
							}
						}
						
					}
				}
			}
		});
	}
	
	public void addSlide3Listeners()
	{
		slider3.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if (slider3.getValue() == 62) {
					clearMovieLabels();
					clearTextLabels();
					for (Movie m : movieList) {
						if (m.getMood().equals("wide_awake") && m.getLevel().equals("3") && m.getState()) {
							for (Map.Entry<String, JLabel> entry : movieLabelList.entrySet()) {
								JLabel lbl = entry.getValue();
								if (lbl.getIcon() == null) {
									ImageIcon imageIcon = new ImageIcon(new ImageIcon(m.getPath()).getImage()
											.getScaledInstance(lbl.getWidth(), lbl.getHeight(), Image.SCALE_DEFAULT));
									lbl.setIcon(imageIcon);
									JTextField tf = txtList.get(entry.getKey());
									tf.setText(m.getName());
									break;
								}
							}
						}
						
					}
				}
				
				if (slider3.getValue() == 93) {
					clearMovieLabels();
					clearTextLabels();
					for (Movie m : movieList) {
						if (m.getMood().equals("wide_awake") && m.getLevel().equals("4") && m.getState()) {
							for (Map.Entry<String, JLabel> entry : movieLabelList.entrySet()) {
								JLabel lbl = entry.getValue();
								if (lbl.getIcon() == null) {
									ImageIcon imageIcon = new ImageIcon(new ImageIcon(m.getPath()).getImage()
											.getScaledInstance(lbl.getWidth(), lbl.getHeight(), Image.SCALE_DEFAULT));
									lbl.setIcon(imageIcon);
									JTextField tf = txtList.get(entry.getKey());
									tf.setText(m.getName());
									break;
								}
							}
						}
						
					}
				}
				
				if (slider3.getValue() == 1) {
					clearMovieLabels();
					clearTextLabels();
					for (Movie m : movieList) {
						if (m.getMood().equals("wide_awake") && m.getLevel().equals("1") && m.getState()) {
							for (Map.Entry<String, JLabel> entry : movieLabelList.entrySet()) {
								JLabel lbl = entry.getValue();
								if (lbl.getIcon() == null) {
									ImageIcon imageIcon = new ImageIcon(new ImageIcon(m.getPath()).getImage()
											.getScaledInstance(lbl.getWidth(), lbl.getHeight(), Image.SCALE_DEFAULT));
									lbl.setIcon(imageIcon);
									JTextField tf = txtList.get(entry.getKey());
									tf.setText(m.getName());
									break;
								}
							}
						}
						
					}
				}
				
				if (slider3.getValue() == 31) {
					clearMovieLabels();
					clearTextLabels();
					for (Movie m : movieList) {
						if (m.getMood().equals("wide_awake") && m.getLevel().equals("2") && m.getState()) {
							for (Map.Entry<String, JLabel> entry : movieLabelList.entrySet()) {
								JLabel lbl = entry.getValue();
								if (lbl.getIcon() == null) {
									ImageIcon imageIcon = new ImageIcon(new ImageIcon(m.getPath()).getImage()
											.getScaledInstance(lbl.getWidth(), lbl.getHeight(), Image.SCALE_DEFAULT));
									lbl.setIcon(imageIcon);
									JTextField tf = txtList.get(entry.getKey());
									tf.setText(m.getName());
									break;
								}
							}
						}
						
					}
				}
			}
		});
	}
	
	public void addSlide4Listeners()
	{
		slider4.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if (slider4.getValue() == 93) {
					clearMovieLabels();
					clearTextLabels();
					for (Movie m : movieList) {
						if (m.getMood().equals("fearless") && m.getLevel().equals("4") && m.getState()) {
							for (Map.Entry<String, JLabel> entry : movieLabelList.entrySet()) {
								JLabel lbl = entry.getValue();
								if (lbl.getIcon() == null) {
									ImageIcon imageIcon = new ImageIcon(new ImageIcon(m.getPath()).getImage()
											.getScaledInstance(lbl.getWidth(), lbl.getHeight(), Image.SCALE_DEFAULT));
									lbl.setIcon(imageIcon);
									JTextField tf = txtList.get(entry.getKey());
									tf.setText(m.getName());
									break;
								}
							}
						}
						
					}
				}
				
				if (slider4.getValue() == 62) {
					clearMovieLabels();
					clearTextLabels();
					for (Movie m : movieList) {
						if (m.getMood().equals("fearless") && m.getLevel().equals("3") && m.getState()) {
							for (Map.Entry<String, JLabel> entry : movieLabelList.entrySet()) {
								JLabel lbl = entry.getValue();
								if (lbl.getIcon() == null) {
									ImageIcon imageIcon = new ImageIcon(new ImageIcon(m.getPath()).getImage()
											.getScaledInstance(lbl.getWidth(), lbl.getHeight(), Image.SCALE_DEFAULT));
									lbl.setIcon(imageIcon);
									JTextField tf = txtList.get(entry.getKey());
									tf.setText(m.getName());
									break;
								}
							}
						}
						
					}
				}
				
				if (slider4.getValue() == 31) {
					clearMovieLabels();
					clearTextLabels();
					for (Movie m : movieList) {
						if (m.getMood().equals("fearless") && m.getLevel().equals("2") && m.getState()) {
							for (Map.Entry<String, JLabel> entry : movieLabelList.entrySet()) {
								JLabel lbl = entry.getValue();
								if (lbl.getIcon() == null) {
									ImageIcon imageIcon = new ImageIcon(new ImageIcon(m.getPath()).getImage()
											.getScaledInstance(lbl.getWidth(), lbl.getHeight(), Image.SCALE_DEFAULT));
									lbl.setIcon(imageIcon);
									JTextField tf = txtList.get(entry.getKey());
									tf.setText(m.getName());
									break;
								}
							}
						}
						
					}
				}
				
				if (slider4.getValue() == 0) {
					clearMovieLabels();
					clearTextLabels();
					for (Movie m : movieList) {
						if (m.getMood().equals("fearless") && m.getLevel().equals("1") && m.getState()) {
							for (Map.Entry<String, JLabel> entry : movieLabelList.entrySet()) {
								JLabel lbl = entry.getValue();
								if (lbl.getIcon() == null) {
									ImageIcon imageIcon = new ImageIcon(new ImageIcon(m.getPath()).getImage()
											.getScaledInstance(lbl.getWidth(), lbl.getHeight(), Image.SCALE_DEFAULT));
									lbl.setIcon(imageIcon);
									JTextField tf = txtList.get(entry.getKey());
									tf.setText(m.getName());
									break;
								}
							}
						}
						
					}
				}
			}
		});
	}
}
