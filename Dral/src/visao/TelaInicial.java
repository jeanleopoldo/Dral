package visao;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import controle.Controle;

public class TelaInicial extends JFrame {

	private Controle controle;
	private GridBagConstraints gbc;

	public TelaInicial(Controle controle) {
		
		this.controle = controle;
		this.gbc = new GridBagConstraints();
		this.setContents();
		this.setButtons();
		
		
	}

	private void setButtons() {
		
		//###############################
		// iniciar jogo
		
		this.gbc.gridx = 0;
		this.gbc.gridy = 0;
		JButton iniciar = new JButton("Iniciar Jogo");
		this.add(iniciar, gbc);
		iniciar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				controle.iniciarJogo();
				
				
			}
		});
		
		this.gbc.gridx = 0;
		this.gbc.gridy = 1;
		JButton verRegras = new JButton("Ver Regras");
		this.add(verRegras, gbc);
		verRegras.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new VerRegrasView();
				
			}
		});
		
		this.gbc.gridx = 0;
		this.gbc.gridy = 2;
		JButton sair = new JButton("Sair");
		this.add(sair, gbc);
		sair.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
				
			}
		});
		
		

	}

	private void setContents() {
		this.setTitle("DRAL");
		this.setSize(new Dimension(300, 500));
		this.setVisible(true);
		this.setLocation(700, 300);
		this.setLayout(new GridBagLayout());
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

}
