package guis;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import components.Answer;
import components.Question;

public class questionWindow extends JFrame{
	private static final long serialVersionUID = 1L;
	questionWindow window;
	JLabel question;
	JPanel answerPanel;
	JButton submit;
	
	public questionWindow(Question p_1){
		super(p_1.getTest().getName());
		window = this;
		setSize(512,512);
		setLayout(new FlowLayout());
		
		question = new JLabel(p_1.getQuestion());
		add(question);
		add(new JLabel(""));
		
		answerPanel = new JPanel();
		answerPanel.setLayout(new GridLayout(0, 2));
		for(Answer t_1 : p_1.getAList()){
			JButton t_2 = new JButton(t_1.getLetter());
			t_2.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					p_1.setMarkedAnswer(t_1);
				}
				
			});
			answerPanel.add(t_2);
			answerPanel.add(new JLabel(t_1.getAnswer()));
		}
		add(answerPanel);
		
		submit = new JButton("Submit");
		submit.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				window.dispose();
			}
			
		});
		add(submit);
		
		setVisible(true);
	}
}
