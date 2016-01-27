package guis;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import components.Answer;
import components.Question;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;

import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;

public class questionWindow extends JFrame{
	private static final long serialVersionUID = 1L;
	questionWindow window;
	JLabel question;
	JPanel answerPanel;
	JButton submit;
	private JPanel panel;
	private JPanel panel_1;
	private ButtonGroup answerGroup;
	
	public questionWindow(Question p_1){
		super(p_1.getTest().getName());
		window = this;
		setSize(512,512);
		getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		
		question = new JLabel(p_1.getQuestion());
		getContentPane().add(question);
		JLabel label = new JLabel("");
		getContentPane().add(label);
		
		answerPanel = new JPanel();
		answerPanel.setLayout(new GridLayout(0, 2));
		
		answerGroup = new ButtonGroup();
		
		for(Answer t_1 : p_1.getAList()){
			JRadioButton t_2 = new JRadioButton(t_1.getLetter());
			t_2.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					p_1.setMarkedAnswer(t_1);
				}
				
			});
			if(p_1.isAnswered()){
				if(t_1 == p_1.getMarkedAnswer()){
					t_2.setSelected(true);
				}
			}
			answerGroup.add(t_2);
			
			JPanel t_3 = new JPanel();
			t_3.add(t_2);
			t_3.add(new JLabel(t_1.getAnswer()));
			
			answerPanel.add(t_3);
		}
		
		panel = new JPanel();
		getContentPane().add(panel);
		getContentPane().add(answerPanel);
		
		
		
		submit = new JButton("Submit");
		submit.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				window.dispose();
			}
			
		});
		
		panel_1 = new JPanel();
		getContentPane().add(panel_1);
		getContentPane().add(submit);
		getContentPane().setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{question, label, answerPanel, submit}));
		
		setVisible(true);
	}
}
