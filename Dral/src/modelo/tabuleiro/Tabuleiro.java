package modelo.tabuleiro;

import constante.Constantes;
import modelo.personagem.Personagem;

public class Tabuleiro {

	private Celula [][] tabuleiro;
	private int tamLinha;
	private int tamColuna;

	public Tabuleiro() {

		this.tamLinha = Constantes.getTamLinha();
		this.tamColuna = Constantes.getTamColuna();
		this.tabuleiro = new Celula[tamLinha][tamColuna];
		iniciarTabuleiroPadrao();
	
	}

	private void iniciarTabuleiroPadrao() {

		Celula celula;
		for (int i = 0; i < this.tamLinha; i++) {
			for (int j = 0; j < this.tamColuna; j++) {
				celula = new Celula(i, j, TipoSolo.GRAMA);
				tabuleiro[i][j] = celula;
			}
		}
	}



	public int getDistancia(Celula celulaSelecionada, Celula clickedPosition) {
		
		int distancia;

		int horizontal = Math.abs(celulaSelecionada.getX() - clickedPosition.getX());
		int vertical= Math.abs(celulaSelecionada.getY() - clickedPosition.getY());

		distancia = horizontal + vertical;

		return distancia;
	}

	public Celula getCelula(int x, int y) {
		return this.tabuleiro[x][y];
	}

	public int getTamLinha() {
		return this.tamLinha;
	}

	public int getTamColuna() {
		return this.tamColuna;
	}

	public void adicionarPersonagem(Celula base, Personagem personagem) {
		base.setPersonagem(personagem);
	}

	public void adicionarPersonagemAoTabuleiro(Celula celulaSelecionada, Personagem personagem) {

	}


	public boolean inRange(int rangePersonagem, int distancia) {

		if(rangePersonagem >= distancia)
			return true;
		return false;

	}
}
