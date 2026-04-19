typedef struct Restaurante{
	int id;
	char* nome;
	char* cidade;
	int capacidade;
	double avaliacao;
	char** tipos_cozinha;
	int faixa_preco;
	Hora horario_abertura;
	Hora horario_fechamento;
	Data data_abertura;
	bool aberto;
}Restaurante;

Restaurante* parse_restaurante(char* s){
	Restaurante* r = (Restaurante*)malloc(sizeof(Restaurante));// crio um restaurante novo
    		if(r == NULL){
        		printf("Nao foi possivel criar restaurante!");
        	return NULL;
    		}
    	char hora_a[6], hora_f[6], data_a[11], nome[100], cidade[100], preco[10], tipo[40], aberto[10];// crio vetores de char para leitura da string

    	sscanf(s, "%d,%[^,],%[^,],%d,%lf,%[^,],%[^,],%[^-]-%[^,],%[^,],%[^\n]",//leitura da string de restaurante
           	&r->id, nome, cidade, &r->capacidade,
           	&r->avaliacao, tipo, preco, hora_a, hora_f,
           	data_a, aberto);

    	r->aberto = (strcmp(aberto, "true") == 0);
    	r->horario_abertura = parse_hora(hora_a);
    	r->horario_fechamento = parse_hora(hora_f);
    	r->data_abertura = parse_data(data_a);
    
    	int tam = 0;//crio uma variavel para pegar o tamanho
    	while(nome[tam] != '\0') tam++;//ler ate o \0
    	r->nome = (char*)malloc((tam + 1) * sizeof(char));
                                                   
    
    	sprintf(r->nome,"%s", nome);// passo char nome, para a char da struct
    
    	tam = 0;// zero o tamanho
    	while(cidade[tam] != '\0') tam++;//pega o tamanho
    	r->cidade = (char*)malloc((tam + 1) * sizeof(char));//aloca
    
    	sprintf(r->cidade,"%s", cidade);//para para a variavel da cidade na struct

    	tam = 0;//zero o contador
    	while(preco[tam] != '\0') tam++;//pega o tamanho
    	r->faixa_preco = tam;//passo o valor exato da quantidade de $

    	tam = 0;// zera o contador
    	while(tipo[tam] != '\0') tam++;//pega o valor
    	for(int i = 0; tipo[i] != '\0'; i++){//leitura ate o \0
        	if(tipo[i] == ';') tipo[i] = ',';//substitui o ; por ,
	}
    	
	r->tipo_cozinha = (char**)malloc(1 * sizeof(char*));//cria uma posicao do char duplo
    	r->tipo_cozinha[0] = (char*)malloc((tam + 1) * sizeof(char));//aloco o tamanho da quantidade de tipos exato

    	sprintf(r->tipos_cozinha[0],"%s",tipo);//preenche
   

    	return r;

}

void formatar_restaurante(Restaurante* restaurante, char* buffer){
	char hora_fechamento[7], hora_abertura[7], data_abertura[12], str_aberto[6];// crio strings 

    	formatar_hora(&restaurante->horario_abertura, horario_abertura);//passo a hora formatada para o vetor
    	formatar_hora(&restaurante->horario_fechamento, horario_fechamento);
    	formatar_data(&restaurante->data_abertura, data_abertura);// passo a Data formatada para o veto de data
  
    	char f_preco[5];
    	int i;// i para pegar o tamanho do vetor
    	for(i = 0; i < restaurante->faixa_preco; i++){// conto
        	f_preco[i] = '$';// passo na posicao o $
    	}
    	f_preco[i] = '\0';// adiciono o \0 ao final

    	if(restaurante->aberto == true) {// verifico se é true 
        	sprintf(str_aberto, "true");// se for adiciona true a string 
    	}else{
        	sprintf(str_aberto, "false");// se nao adiciona false
    	}
    	sprintf(buffer,"[%d ## %s ## %s ## %d ## %.1lf ## [%s] ## %s ## %s-%s ## %s ## %s]",//formatacao do restaurante
        	restaurante->id, restaurante->nome, restaurante->cidade,
        	restaurante->capacidade, restaurante->avaliacao, restaurante->tipos_cozinha[0],
       		f_preco, hora_abertura, hora_fechamento, data_abertura, str_aberto);
}
