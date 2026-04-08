import java.util.*;
public class Restaurante{
	private int id;
        private String nome;
        private String cidade;
	private int capacidade;
        private double avaliacao;
        private String[] tiposCozinha;
        private int faixaPreco;
        private Hora horarioAbertura;
	private Hora horarioFechamento;
        private Data dataAbertura;
        private boolean aberto;


	Restaurante(){
		this.id = -1;
		this.nome = "";
		this.cidade = "";
		this.capacidade = 0;
		this.avaliacao = 0.0;
		this.tiposCozinha = new String();
		this.faixaPreco = 0;
		this.horarioAbertura = new Hora();
		this.horarioFechamento = new Hora();
		this.dataAbertura = new Data(); 
		this.aberto = false;
	}

	Restaurante(int id, String nome, String cidade,int capacidade, double avaliacao, String[] tiposCozinha, int faixaPreco, int horaAbertura, int minutoAbertura,int horaFechamento, int minutoFechamento, int dia, int mes, int ano, boolean aberto){
		
		this.id = id;
		this.nome = nome;
		this.cidade = cidade;
		this.capacidade = capacidade;
		this.avaliacao = avaliacao;
		this.tiposCozinha = string;
		this.faixaPreco = faixaPreco;
		this.horarioAbertura = new Hora(horaAbertura,minutoAbertura);
		this.horarioFechamento = new Hora(horaFechamento,minutoFechamento);
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
	
	public int getCapacidade(){
		return this.capacidade;
	}

	public double getAvaliacao(){
		return this.avaliacao;
	}

	public String[] getTiposCozinha(){
		return this.tiposCozinha;
	}

	public int getFaixapreco(){
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
	
	public String transformaFaixaPreco(){
		if(this.faixaPreco == 1){
			return "$";
		}else if(this.faixaPreco == 2){
			return "$$";
		}else if(this.faixaPreco == 3){
			return "$$$";
		}else if(this.faixaPreco== 4){
			return "$$$$";
		}
			
	}

	public static Restaurante parseRestaurante(String s){
		// pode usar split?
	}
	public String formatar(){
		String rest = string.format("[ %d ## %s ## %d ## %f ## %s ## %s ## %s-%s ## %s ## %b]", this.id, this.nome, this.capaciadde, this.avaliacao, Arrays.toString(this.TiposCozinha), this.faixaPreco.transformaFaixaPreco, this.horaAbertura.formatarHora(), this.horaFechamento.formatarHora(), this.dataAbertura.formatarData(), this.aberto);

		return rest;
	}
} 
