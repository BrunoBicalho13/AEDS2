import java.util.*;
import java.io.*;
class Data{
		private int ano;
           	private int mes;
           	private int dia;
   
	        Data(){
        	        this.ano = 0;
                 	this.mes = 0;
                  	this.dia = 0;
          	}
  
         	Data(int ano, int mes, int dia){
                 	this.ano = ano;
                  	this.mes = mes;
                  	this.dia = dia;
          	}
  
          	public int getAno(){
                	return this.ano;
          	}
  
          	public int getMes(){
                  	return this.mes;
          	}
  
          	public int getDia(){
                  	return this.dia;
          	}
  
          	public void setAno(int Ano){
                  	this.ano = Ano;
          	}
  
          	public void setMes(int Mes){
                  	this.mes = Mes;
          	}
  
          	public void setDia(int Dia){
                  	this.dia = Dia;
          	}
  
          	public static Data parseData(String s){
                  	Scanner scan = new Scanner(s);
                  	scan.useDelimiter("-");// - como delimitador
                  	int ano = scan.nextInt();
			int mes = scan.nextInt();
                  	int dia = scan.nextInt();
                  	scan.close();
                  	Data data = new Data(ano, mes, dia);// cria um objeto data
                  	return data;// retorna a nova data
          	}
  
          	public String formatarData(){
                  	return String.format("%02d/%02d/%04d",this.dia,this.mes,this.ano);
          	}
} // fechamento classe Data

class Hora{
		private int hora;
           	private int minuto;
   
           	Hora(){
                   	this.hora = 0;
                   	this.minuto = 0;
           	}
  
          	Hora(int hora, int minuto){
                  	if(hora >= 0 && hora <= 23)
                          	this.hora = hora;
                  	if(minuto >= 0 && minuto <=59)
                          	this.minuto = minuto;
          	}
  
          	public int getHora(){
                 	 return this.hora;
          	}
  
          	public int getMinuto(){
                	  return this.minuto;
          	}
  
          	public void setHora(int Hora){
                  	this.hora = Hora;
          	}
  
          	public void setMinuto(int Minuto){
                  	this.minuto = Minuto;
          	}
  
          	public static Hora parseHora(String s){
                  	Scanner scan = new Scanner(s);
                  	scan.useDelimiter(":");// separa por :
                  	int hora = scan.nextInt();
                  	int minuto = scan.nextInt();
                  	Hora h = new Hora(hora,minuto);// criar o objeto hora
                  	return h;// retona a nova hora
          	}
  
          	public String formatarHora(){
                  	String horario = String.format("%02d:%02d", this.hora, this.minuto);
                  	return horario;
		}
} //fechamento classe Hora

class Restaurante{
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
	        	String tipoStr = Arrays.toString(this.tiposCozinha);
			tipoStr = tipoStr.replace(", ", ","); // remove as virgulas que o java coloca automaticamente
		
       			double valor = this.avaliacao;                                                                             
                     	String strAvaliacao = valor + ""; // pego o valor atual do double e coloco como string 

		
		 	String rest = String.format("[%d ## %s ## %s ## %d ## %s ## %s ## %s ## %s-%s ## %s ## %b]", this.id, this.nome,this.cidade, this.capacidade, strAvaliacao, tipoStr, this.transformaFaixaPreco(), this.horarioAbertura.formatarHora(), this.horarioFechamento.formatarHora(), this.dataAbertura.formatarData(), this.aberto);
 
        	         return rest;
         	}
}// Fim da classe Restaurante


 class ColecaoRestaurantes{
		private int tamanho;
           	private Restaurante[] restaurantes;

		ColecaoRestaurantes(){
                   	this.tamanho = 0;
                   	this.restaurantes = null;
        	}
  
          	ColecaoRestaurantes(int tamanho){
                  	this.tamanho = tamanho;
                  	this.restaurantes = new Restaurante[tamanho];
          	}

		public void setTamanho(int tamanho){
                  	this.tamanho = tamanho;
          	}
  
          	public void setRestaurante(Restaurante[] rest){
                  	this.restaurantes = rest;
          	}
  
          	public int getTamanho(){
                  	return this.tamanho;
          	}
  
          	public Restaurante[] getRestaurantes(){
                  	return this.restaurantes;
          	}

		public Restaurante pesquisarId(int id){
                  	for(int i = 0; i < this.tamanho; i++){
                          	if(this.restaurantes[i] != null && this.restaurantes[i].getId() == id){ //busca sequencial por Id
                                  	return this.restaurantes[i];
                          	}
                  	}
                  	return null; // retorna null se não encontrar o restaurante buscado
          	}

		public void lerCsv(String path) throws Exception{
                  	File arquivo = new File(path);
                  	Scanner sc = new Scanner(arquivo);
  
                  	if(sc.hasNextLine()) // pula o cabeçalho
                          	sc.nextLine();
  
                  	int i = 0;
                  	while(sc.hasNextLine()){
                          	String linha = sc.nextLine(); // Escaneia a string com as infos do restaurante
                          	restaurantes[i] = Restaurante.parseRestaurante(linha); // guarda o restaurante no formato correto dentro do vetor
                          	i++;
                  	}
          	}

		public static  ColecaoRestaurantes lerCsv() throws Exception{
                  	File arquivo = new File("/tmp/restaurantes.csv");
                  	Scanner sc = new Scanner(arquivo);
                  	int tamanho = 0;
  
                  	while(sc.hasNextLine()){
                          	sc.nextLine();
                          	tamanho++; // conta quantas linhas o arquivo tem ( vai ser o tamanho do vetor de restaurantes)
                  	}
  
  
                  	sc.close();
  
                  	ColecaoRestaurantes novaColecao = new ColecaoRestaurantes(tamanho -1);
  
                  	novaColecao.lerCsv("/tmp/restaurantes.csv");
                  	return novaColecao;
          	}
	}//fim da classe ColecaoRestaurantes

class CelulaDupla{
    public Restaurante rest;
    public CelulaDupla prox, ant;

    public CelulaDupla(){
        this.rest = null;
        this.prox = this.ant = null;
    }

    public CelulaDupla(Restaurante rest){
        this.rest = rest;
        this.prox = null;
        this.ant = null;
    }
}// fim da classe Celula Dupla

class ListaDupla{
    public CelulaDupla primeiro, ultimo;

    public ListaDupla(){
        primeiro = new CelulaDupla();
        ultimo = primeiro;        
    }
 
    public int tamanho(){
        int tam = 0;
        
        for(CelulaDupla i = primeiro; i != ultimo; i = i.prox)
            tam++;
        return tam;
    }
 
    public void inserirFim(Restaurante x){
        ultimo.prox = new CelulaDupla(x);
        ultimo.prox.ant = ultimo;
        ultimo = ultimo.prox;
    }
 
    public void inserirInicio(Restaurante x){
        CelulaDupla tmp = new CelulaDupla(x);
        tmp.ant = primeiro;
        tmp.prox = primeiro.prox;
        primeiro.prox = tmp;
        if(ultimo == primeiro){
            ultimo = tmp;
        } else {
            tmp.prox.ant = tmp;
        }
    }
 
    public void inserir(Restaurante x, int pos) throws Exception{
        int tam = tamanho();
        if(pos < 0 || pos > tam){
            throw new Exception("Impossivel inserir"); 
        } else if(pos == 0){
            inserirInicio(x);
        } else if(pos == tam){
            inserirFim(x);
        } else {
            CelulaDupla i = primeiro.prox;
            for(int j = 0; j < pos; j++, i = i.prox);
 
            CelulaDupla tmp = new CelulaDupla(x);
            tmp.ant = i.ant;    
            tmp.prox = i;          
            i.ant.prox = tmp;      
            i.ant = tmp;
        }
    }
 
    public Restaurante removerFim() throws Exception{
        if(primeiro == ultimo){
            throw new Exception("Fila vazia");
        }
        Restaurante resp = ultimo.rest;
        ultimo = ultimo.ant;
        ultimo.prox.ant = null;
        ultimo.prox = null;
        return resp;
    }
 
    public Restaurante removerInicio() throws Exception{
        if(primeiro == ultimo){
            throw new Exception("Fila vazia");
        }
        CelulaDupla tmp = primeiro;
        primeiro = primeiro.prox;
        Restaurante resp = primeiro.rest;
        tmp.prox = primeiro.ant = null;
        tmp = null;
        return resp;
    }
 

    public Restaurante remover(int pos) throws Exception{
        int tam = tamanho();
        Restaurante resp;
        if(pos < 0 || pos >= tam){
            throw new Exception("Impossivel remover");
        } else if(pos == 0){
            resp = removerInicio();       
        } else if(pos == tam - 1){
            resp = removerFim();          
        } else {
            CelulaDupla i = primeiro.prox;
            for(int j = 0; j < pos; j++, i = i.prox);
            i.ant.prox = i.prox;
            i.prox.ant = i.ant;
            resp = i.rest;
            i.prox = i.ant = null;
            i = null;
        }
        return resp;
    }
 
    public void mostrar(){
        
        for(CelulaDupla i = primeiro.prox; i != null; i = i.prox){
            System.out.println(i.rest.formatar());
        }
    }
 
    public void mostrarInverso(){
        for(CelulaDupla i = ultimo; i != primeiro; i = i.ant){
            System.out.println(i.rest.formatar());
        }
    }
}// fim da classe Lista Dupla

	

public class PrototipoMain{		
			
	public static void main(String[] args) throws Exception{
	    Scanner sc = new Scanner(System.in);
            ColecaoRestaurantes cr = ColecaoRestaurantes.lerCsv();
            String linha = sc.next();
            ListaDupla ld = new ListaDupla();
            while(linha.compareTo("-1") != 0){
               int id = Integer.parseInt(linha);
               Restaurante r = cr.pesquisarId(id);
               if(r != null){
                  ld.inserirFim(r);
               }

               linha = sc.next();
            }
            
            int n = sc.nextInt();
            sc.useDelimiter("\\s+");
            for(int i = 0; i < n; i++){
                String entrada = sc.next();
                if(entrada.charAt(0) == 'I' && entrada.charAt(1) == 'I'){
                    int id = sc.nextInt();
                    Restaurante aux = cr.pesquisarId(id);
                    if (aux != null) ld.inserirInicio(aux);
                }else if(entrada.charAt(0) == 'I' && entrada.charAt(1) == '*'){
                    int pos = sc.nextInt();
                    int id  = sc.nextInt();
                    Restaurante aux = cr.pesquisarId(id);
                    if (aux != null) ld.inserir(aux, pos);
                }else if(entrada.charAt(0) == 'I' && entrada.charAt(1) == 'F'){
                    int id = sc.nextInt();
                    Restaurante aux = cr.pesquisarId(id);
                    if (aux != null) ld.inserirFim(aux);
                }else if(entrada.charAt(0) == 'R' && entrada.charAt(1) == 'I'){
                     System.out.println("(R)" + ld.removerInicio().getNome());
                }else if(entrada.charAt(0) == 'R' && entrada.charAt(1) == '*'){
                     int pos = sc.nextInt();
                     System.out.println("(R)" + ld.remover(pos).getNome());
                }else if(entrada.charAt(0) == 'R' && entrada.charAt(1) == 'F'){
                     System.out.println("(R)" + ld.removerFim().getNome());
                }
            }
            sc.close();
            ld.mostrar();
        }
}
