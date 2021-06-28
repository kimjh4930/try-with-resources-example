package study;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileNotFoundException;

public class FileReaderUI extends JFrame {
	private JTextField textContentField;

	public FileReaderUI() {
		initUI();
	}

	private void initUI() {
		JLabel contentLabel = new JLabel("Content");
		textContentField = new JTextField(30);

		JButton readButton = new JButton("Read");
		readButton.addActionListener(new ReadButton(this));

		JButton deleteButton = new JButton("Delete");
		deleteButton.addActionListener(new DeleteButton(this));

		createLayout(contentLabel, textContentField, readButton, deleteButton);

		setTitle("Sample");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void createLayout(Component... arg) {
		Container pane = getContentPane();
		pane.setSize(600, 400);

		GroupLayout groupLayout = new GroupLayout(pane);
		pane.setLayout(groupLayout);

		groupLayout.setAutoCreateGaps(true);
		groupLayout.setAutoCreateContainerGaps(true);

		groupLayout.setHorizontalGroup(
			groupLayout.createSequentialGroup()
				.addGap(50)
				.addGroup(groupLayout.createParallelGroup()
					.addComponent(arg[0])
					.addComponent(arg[1])
					.addGroup(
						groupLayout.createSequentialGroup()
							.addComponent(arg[2])
							.addComponent(arg[3])
					)
				)
				.addGap(50)
		);

		groupLayout.setVerticalGroup(
			groupLayout.createSequentialGroup()
				.addGap(50)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(arg[0])
					.addComponent(arg[1])
				)
				.addGap(20)
				.addGroup(groupLayout.createParallelGroup()
					.addComponent(arg[2])
					.addComponent(arg[3])
				)
				.addGap(50)
		);
		pack();
	}

	private class ReadButton extends AbstractAction {
		private JFrame frame;

		public ReadButton(JFrame frame) {
			this.frame = frame;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				textContentField.setText(new FileReader().read());
			} catch (FileNotFoundException fileNotFoundException) {
				JOptionPane.showMessageDialog(
					frame,
					fileNotFoundException.getMessage(),
					"File Reader",
					JOptionPane.ERROR_MESSAGE
				);
			}
		}
	}

	private class DeleteButton extends AbstractAction {
		private JFrame frame;

		DeleteButton(JFrame frame) {
			this.frame = frame;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				File file = new File("test.txt");
				if (file.exists()) {
					file.delete();
				}
			} catch (Exception exception){
				System.out.println(exception.getMessage());
			}
		}
	}
}
