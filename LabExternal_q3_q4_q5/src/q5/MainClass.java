package q5;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class MainClass implements ActionListener{
	JFrame jf;
	JProgressBar pb;
	JButton jb;
	JTextArea jt;
	int stop=0;
	public static void main(String[] args) throws IOException, InterruptedException {
		MainClass mc= new MainClass();
		mc.setComponents();
		BufferedWriter wr=new BufferedWriter(new FileWriter("file2.txt"));
		BufferedReader rd=new BufferedReader(new FileReader("file1.txt"));
		int i=0;
		String s="";
		String line;
		while((line=rd.readLine())!=null) {
			wr.write(line);
			wr.newLine();
			mc.pb.setValue(i+1);
			i+=5;
			s=s+line+"\n";
			Thread.sleep(1000);
			if(mc.stop==1) {
				break;
			}
		}
		mc.jt.setText(s);
		wr.close();
		rd.close();
	}
	public void setComponents() {
		jf=new JFrame("ProgressBar_FileCopy");
		pb=new JProgressBar();
		pb.setValue(0);
		jb=new JButton("Stop");
		jb.addActionListener(this);
		jt=new JTextArea(10,10);
		pb.setStringPainted(true);
		jf.add(pb);
		jf.add(jb);
		jf.add(jt);
		jf.add(new JScrollPane(jt));
		jf.setLayout(new FlowLayout());
		jf.setVisible(true);
		jf.setSize(300,250);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent e) {
		this.stop=1;
	}
}
