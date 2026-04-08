typedef struct Restaurante{
	int id;
	char nome[100];
	char cidade[100];
	int capacidade;
	double avaliacao;
	char tipos_cozinha[2000]; //contar quantos tipos existem no csv e alterar
	int faixa_preco;
	Hora horario_abertura;
	Hora horario_fechamento;
	Data data_abertura;
	bool aberto;
}Restaurante;

Restaurante* parse_restaurante(char* s){
	Restaurante *r = (Restaurante*) malloc (sizeof(Restaurante));

	char hora_abertura[6],hora_fechamento[6],data[11]; // strings para armazenar hora e data ( precisam ser parseadas com as funções de suas Structs);

	sscanf(s, "%d;%[^;];%[^;];%d;%lf;%[^;];%d;%[^;];%[^;];%[^;]", &r->id, r->nome, r->cidade, &r->capacidade, &r->avaliacao,r->tipos_cozinha,&r->faixa_preco,hora_abertura,hora_fechamento,data); //le o arquivo usando ; como separador
	
	r->horario_abertura = parse_hora(hora_abertura); // converte as strings para seus respectivos tipos na struct
	r->horario_fechamento = parse_hora(hora_fechamento);
	r->data_abertura = parse_data(data);
	
	return r;
}

void formatar_restaurante(Restaurante* restaurante, char* buffer){
	char hora_abertura[6], hora_fechamento[6], data[11];  //formatar as strings

	formatar_hora(&restaurante->horario_abertura, h_abertura); //chamo as funções de formatação criadas nas outras structs
    	formatar_hora(&restaurante->horario_fechamento, h_fechamento);
    	formatar_data(&restaurante->data_abertura, d_abertura);

	sprintf(buffer,"%d;%s;%s;%d;%.1f;%s;%d;%s;%s;%s;%s", restaurante->id, restaurante->nome, restaurante->cidade, restaurante->capacidade, restaurante->avaliacao,restaurante->tipos_cozinha,restaurante->faixa_preco,hora_abertura,hora_fechamento,data,restaurante->aberto);
}
