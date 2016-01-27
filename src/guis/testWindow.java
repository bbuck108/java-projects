package guis;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import components.Question;
import components.Test;

public class testWindow extends JFrame{
	private static final long serialVersionUID = 1L;
	JLabel name;
	JPanel questionPanel;
	JButton submit;
	
	public testWindow(Test p_1){
		super(p_1.getName());
		setSize(512,512);
		setLayout(new BorderLayout());
		
		name = new JLabel(p_1.getName());
		add(name, BorderLayout.NORTH);
		
		questionPanel = new JPanel();
		questionPanel.setLayout(new GridLayout(0, 2, 10, 10));
		for(Question t_1 : p_1.getQList()){
			questionPanel.add(new JLabel("#"+t_1.getNumber()+": "+t_1.getQuestion()));
			
			JButton t_2 = new JButton("Go");
			t_2.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					new questionWindow(t_1);
				}
				
			});
			questionPanel.add(t_2);
		}
		add(questionPanel);
		
		submit = new JButton("Submit");
		submit.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(p_1.gradeTest());
				System.exit(0);
			}
			
		});
		add(submit, BorderLayout.SOUTH);
		
		setVisible(true);
	}
}
