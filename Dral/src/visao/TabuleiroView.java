package visao;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

import controle.Controle;
import modelo.tabuleiro.Celula;
import modelo.tabuleiro.Tabuleiro;

public class TabuleiroView extends JFrame {

	private Controle controle;
	private JPanel tab;
	

	public TabuleiroView(Controle controle) {
		super();
		this.controle = controle;
		this.tab = new JPanel();


		this.setVisible(true);
		this.setLocation(500, 0);
		this.setSize(new Dimension(1000, 950));
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		this.setLayout(new GridLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		this.criarTabuleiro();
		this.add(tab);

	}


	public void criarTabuleiro() {

		Tabuleiro tabuleiro = this.controle.getJogo().getTabuleiro();
		int tamLinha = tabuleiro.getTamLinha();
		int tamColuna = tabuleiro.getTamColuna();
		this.tab.setSize(tamLinha * tamLinha, tamColuna * tamColuna);
		this.tab.setLayout(new GridLayout(tamLinha, tamColuna));
		GridBagConstraints gbc = new GridBagConstraints();
		Celula cell;

		for (int lin = 0; lin < tamLinha; lin++) {

			for (int col = 0; col < tamColuna; col++) {
				gbc.gridx = lin;
				gbc.gridy = col;

				cell = tabuleiro.getCelula(lin, col);
				CellPane cellPane = new CellPane(lin, col, cell);
				this.tab.add(cellPane, gbc);

			}
		}

	}

	public BufferedImage getImage(String path) {
		BufferedImage bi = null;
		try {
			bi = ImageIO.read(new File(path));
		} catch (IOException e) {
			System.out.println("can't read image from " + path);
			e.printStackTrace();

		}
		return bi;
	}

	private class CellPane extends JPanel {

		private final Celula cell;

		CellPane(final int x, final int y, final Celula cell) {
			super();
			this.cell = cell;
			this.setSize(32,32);
			
			addMouseListener(new MouseListener() {
				
				@Override
				public void mouseReleased(MouseEvent arg0) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mousePressed(MouseEvent arg0) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseExited(MouseEvent arg0) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseEntered(MouseEvent arg0) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseClicked(MouseEvent e) {
					controle.selecionarAcao(x, y);
					System.out.println("x:" +x+", y: "+y);
					
				}
			});
		}

		public void paint(Graphics g) {
			super.paintComponent(g);
			String path = this.cell.getTipoSolo().getImagePath();

			BufferedImage bi = getImage(path);
			g.drawImage(bi, 0, 0, null);

		}
	}

}
