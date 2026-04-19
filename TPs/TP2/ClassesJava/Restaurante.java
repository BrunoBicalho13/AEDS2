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
		this.tiposCozinha = null;
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
		this.tiposCozinha = tiposCozinha;
		this.faixaPreco = faixaPreco;
		this.horarioAbertura = new Hora(horaAbertura,minutoAbertura);
		this.horarioFechamento = new Hora(horaFechamento,minutoFechamento);
		this.dataAbertura = new Data(ano,mes,dia); 
		this.aberto = aberto;
	}


	public int getId(){
		return this.id;
	}

	public void setId(int Id){
		this.id = Id;
	}

	public String getNome(){
		return this.nome;
	}

	public void setNome(String Nome){
		 this.nome = Nome;
	}
	
	public String getCidade(){
		return this.cidade;
	}

	public void setCidade(String Cidade){
		this.cidade = Cidade;
	}
	
	public int getCapacidade(){
		return this.capacidade;
	}

	public void setCapacidade(int Capacidade){
		this.capacidade = Capacidade;
	}

	public double getAvaliacao(){
		return this.avaliacao;
	}

	public void setAvaliacao(double Avaliacao){
		this.avaliacao = Avaliacao;
	}

	public String[] getTiposCozinha(){
		return this.tiposCozinha;
	}

	public void setTiposCozinha(String[] Tipos){
		this.tiposCozinha = Tipos;
	}

	public int getFaixapreco(){
		return this.faixaPreco;
	}

	public void setFaixaPreco(int Faixa){
		this.faixaPreco = Faixa;
	}

	public Hora getHorarioAbertura(){
		return this.horarioAbertura;
	}

	public void setHorarioAbertura(Hora horarioAbertura){
		this.horarioAbertura = horarioAbertura;
	}

	public Hora getHorarioFechamento(){
                 return this.horarioFechamento;
         }
 
         public void setHorarioFechamento(Hora horarioFechamento){
                 this.horarioFechamento = horarioFechamento;
        }


	public Data getDataAbertura(){
		return this.dataAbertura;
	}

	public void setDataAbertura(Data dataAbertura){
		this.dataAbertura = dataAbertura;
	}
	
	public boolean getAberto(){
		return this.aberto;
	}
	
	public void setAberto(boolean Aberto){
		this.aberto = Aberto;
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
		return "N/A"; // pelo visto dá erro se n tiver essa brincadeira aqui	
	}

	public static int pegarFaixaPreco(String s){
		return s.length(); // retorna o tamanho de caracteres = numero de $$
	}

	public static Restaurante parseRestaurante(String s){
		Scanner scan = new Scanner(s);
        	scan.useLocale(Locale.US);// usei para ler o double, pois vem na string ex:4.4 
        	scan.useDelimiter(",");// usa , como delimitador
        	int id = scan.nextInt();
        	String nome = scan.next();
        	String cidade = scan.next();
        	int capacidade = scan.nextInt();
        	double avaliacao = scan.nextDouble();
        	String tpCozinha = scan.next();  
        	int faixaPreco = pegarFaixaPreco(scan.next());
        	String horarios = scan.next();
        	Scanner scanHorarios = new Scanner(horarios); // novo scanner para ler os horarios
        	scanHorarios.useDelimiter("-");// delimitei para pegar ate - (pois dois horarios)
        	Hora horaAbertura = Hora.parseHora(scanHorarios.next()); // chama da funcao para o parseHora
        	Hora horaFechamento = Hora.parseHora(scanHorarios.next());
        	scanHorarios.close(); // fechamento do scanner de horas
        	Data dataAbertura = Data.parseData(scan.next()); // chamada da funcao para o parseData
        	String abertoStr = scan.next(); // pega a string true ou false
        	boolean aberto = (abertoStr.compareTo("true") == 0); 

        	scan.close(); // fachamento do scanner principal

        	String[] aux = new String[10]; // variavel auxiliar para pegar os Tipos de cozinhas
        	int count = 0;// contador para pegar o tamanho exato de tipos
        	Scanner scanTp = new Scanner(tpCozinha); 
        	scanTp.useDelimiter(";");// delimitei o ; pois ele separa os restaurantes
        	while(scanTp.hasNext()){// verifica se existe palavra
            		String palavra = scanTp.next();// lê a palavra do vetor de string
            		if(palavra.length() > 0){// se o tamanho da palavra for maior que 0
                		aux[count] = palavra; // auxiliar recebe a palavra adiciona a posição
                		count++;
            		}
        	}
        	scanTp.close();
    
        	String[] tipoCozinha = new String[count]; // crio um novo vetor de string
        	for(int i = 0; i < count; i++){// pego a quantidade exata de tipos
            		tipoCozinha[i] = aux[i];// adiciono no vetor de tipoCozinha
        	}
        		//retorno um objeto restaurante
		Restaurante r = new Restaurante();
       		r.id = id;
		r.nome = nome;
		r.cidade = cidade;
		r.capacidade = capacidade;
		r.avaliacao = avaliacao;
		r.tiposCozinha = tipoCozinha;
		r.faixaPreco = faixaPreco;
		r.horarioAbertura = horaAbertura;
		r.horarioFechamento = horaFechamento;
		r.dataAbertura = dataAbertura;
		r.aberto = aberto;

		return r; 
	}
	

	public String formatar(){
		String rest = String.format("[ %d ## %s ## %d ## %f ## %s ## %s ## %s-%s ## %s ## %b]", this.id, this.nome, this.capacidade, this.avaliacao, Arrays.toString(this.tiposCozinha), this.transformaFaixaPreco(), this.horarioAbertura.formatarHora(), this.horarioFechamento.formatarHora(), this.dataAbertura.formatarData(), this.aberto);

		return rest;
	}
} 
