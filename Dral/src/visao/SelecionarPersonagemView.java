package visao;

import javax.swing.*;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import controle.Controle;

public class SelecionarPersonagemView extends JFrame{
	
	private Controle controle;
	private GridBagConstraints gbc;

	public SelecionarPersonagemView(Controle controle) {
		this.controle = controle;
		this.gbc = new GridBagConstraints();
		this.setContents();
		this.setButtons();
		this.pack();
	}

	private void setButtons() {
		this.gbc.gridx = 0;
		this.gbc.gridy = 0;
		JButton bardo = new JButton("BARDO");
		this.add(bardo, gbc);

		this.gbc.gridx = 0;
		this.gbc.gridy = 1;
		JButton clerigo = new JButton("CLERIGO");
		this.add(clerigo, gbc);

		this.gbc.gridx = 0;
		this.gbc.gridy = 2;
		JButton assassino = new JButton("ASSASSINO");
		this.add(assassino, gbc);

		this.gbc.gridx = 0;
		this.gbc.gridy = 3;
		JButton arqueiro = new JButton("ARQUEIRO");
		this.add(arqueiro, gbc);

		this.gbc.gridx = 0;
		this.gbc.gridy = 4;
		JButton guerreiro = new JButton("GUERREIRO");
		this.add(guerreiro, gbc);
	}

	private void setContents() {
		this.setTitle("DRAL - Selecionar Personagem");
		this.setSize(new Dimension(300, 500));
		this.setVisible(true);
		this.setLocation(700, 300);
		this.setLayout(new GridBagLayout());
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}