import java.util.*;
public class Restaurante{
	private int id;
        private String nome;
        private String cidade;
        private float avaliacao;
        private String[] tiposCozinha;
        private String faixaPreco;
        private String horario;
        private Data dataAbertura;
        private boolean aberto;


	Restaurante(){
		this.id = -1;
		this.nome = "";
		this.cidade = "";
		this.avaliacao = 0.0f;
		this.tiposCozinha = new String();
		this.faixaPreco = "";
		this.horario = "";
		this.dataAbertura = new Data(); 
		this.aberto = false;
	}

	Restaurante(int id, String nome, String cidade, float avaliacao, String[] tiposCozinha, String faixaPreco, String horario, String dia, String mes, String ano, boolean aberto){
		
		this.id = id;
		this.nome = nome;
		this.cidade = cidade;
		this.avaliacao = avaliacao;
		this.tiposCozinha = string;
		this.faixaPreco = faixaPreco;
		this.horario = horario;
		this.dataAbertura = new Data(ano,mes,dia); 
		this.aberto = aberto;
	}


	public int getId(){
		return this.id;
	}

	public String getNome(){
		return this.nome;
	}
	
	public String getCidade(){
		return this.cidade;
	}

	public float getAvaliacao(){
		return this.avaliacao;
	}

	public String getTiposCozinha(){
		return this.tiposCozinha;
	}

	public String getFaixapreco(){
		return this.faixaPreco;
	}

	public String getHorario(){
		return this.horario;
	}

	public Data getDataAbertura(){
		return this.dataAbertura;
	}

	public boolean getAberto(){
		return this.aberto;
	}
} 
