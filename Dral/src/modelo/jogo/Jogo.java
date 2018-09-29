package modelo.jogo;


import modelo.jogador.AreaDeCriacao;
import modelo.jogador.Jogador;
import modelo.personagem.Personagem;
import modelo.personagem.TipoPersonagem;
import modelo.tabuleiro.Celula;
import modelo.tabuleiro.Tabuleiro;

public class Jogo {

	private Tabuleiro tabuleiro;
	private Jogador jogadorUm;
	private Jogador jogadorDois;
	private int turnoAtual;
	
	public Jogo() {
		
		this.tabuleiro = new Tabuleiro();
		this.jogadorUm = new Jogador("Jogador 1");
		this.jogadorDois = new Jogador("Jogador 2");
		this.turnoAtual = 0;
	
	}

	public Personagem selecionarPersonagem(TipoPersonagem tipoPersonagem) {
        
		switch (tipoPersonagem) {

    		case BARDO:
    			return new Personagem(0, 0, TipoPersonagem.BARDO);
    		
    		case ARQUEIRO:
       			return new Personagem(0, 0, TipoPersonagem.ARQUEIRO);
    		
    		case ASSASSINO:
    			return new Personagem(0, 0, TipoPersonagem.ASSASSINO);
    		
    		case CLERIGO:
    			return new Personagem(0, 0, TipoPersonagem.CLERIGO);
    		
    		case GUERREIRO:
    			return new Personagem(0, 0, TipoPersonagem.GUERREIRO);
    		
    		default:
    			return null;
		}
	}


	public void mover(Celula celulaSelecionada, Celula clickedPosition) {

		Personagem personagem = celulaSelecionada.getPersonagem();
		int rangePersonagem = personagem.getTipoPersonagem().getRangeMover();
		int distancia = this.tabuleiro.getDistancia(celulaSelecionada, clickedPosition);

		if (this.tabuleiro.inRange(rangePersonagem, distancia)) {
			
			if (!personagem.getMoveu()) {

				clickedPosition.setPersonagem(personagem);
				personagem.setMoveu(true);
				celulaSelecionada.setPersonagem(null);
			
			}
		}
	}

	public boolean ehEtapaDeSelecionarPersonagem() {
		if(this.turnoAtual == 0 || this.turnoAtual == 1)
			return true;
		return false;
	}

	
	public void atacar(Celula celulaSelecionada, Celula clickedPosition) {
		
		//personagens na ação
		Personagem personagemAtck = celulaSelecionada.getPersonagem();
		Personagem personagemDfns = clickedPosition.getPersonagem();
		
		//atributos de range do personagem atacante
		int rangePersonagem = personagemAtck.getTipoPersonagem().getRangeAtacar();
		int distancia = this.tabuleiro.getDistancia(celulaSelecionada, clickedPosition);

		//atributos de dano do personagem atacante
		int danoDoPersonagem = personagemAtck.getTipoPersonagem().getDano();
		int energia = personagemAtck.getEnergia();
		
		int danoAInfligir = this.calcularDanoAInfligir(danoDoPersonagem, energia);
		
		if (this.tabuleiro.inRange(rangePersonagem, distancia)) {

			personagemDfns.setDanoInfligido(danoAInfligir);


		}
	}

	public int calcularDanoAInfligir(int dano, int energia) {
		
		return 0;
	}

	public int calcularEnergiaAdicional() {
		return 0;
	}

	public void adicionarAreaDeCriacaoDosJogadores() {
		Celula infEsquerda;
		Celula supEsquerda;

		Celula infDireita;
		Celula supDireita; 
		AreaDeCriacao areaDeCriacao;
		
		//Jogador UM
		infEsquerda = this.tabuleiro.getCelula(0, 0);
		supEsquerda = this.tabuleiro.getCelula(0, 4);

		infDireita = this.tabuleiro.getCelula(27, 0);
		supDireita = this.tabuleiro.getCelula(27, 4);

		areaDeCriacao = new AreaDeCriacao(infEsquerda, supEsquerda, infDireita, supDireita);
		this.jogadorUm.setAreaDeCriacao(areaDeCriacao);


		// Jogador DOIS
		infEsquerda = this.tabuleiro.getCelula(0, 27);
		supEsquerda = this.tabuleiro.getCelula(0, 23);

		infDireita = this.tabuleiro.getCelula(27, 27);
		supDireita = this.tabuleiro.getCelula(27, 23);

		areaDeCriacao = new AreaDeCriacao(infEsquerda, supEsquerda, infDireita, supDireita);
		this.jogadorDois.setAreaDeCriacao(areaDeCriacao);
		
	
	}

	public void passarTurnoAtual() {
		this.turnoAtual++;
	}

	

	public int turnoAtual() {
		return this.turnoAtual;
	}

	public Jogador getJogadorUm() {
		return this.jogadorUm;
	}

	public Jogador getJogadorDois() {
		return this.jogadorDois;
	}

	public Tabuleiro getTabuleiro() {
		return this.tabuleiro;
	}

}