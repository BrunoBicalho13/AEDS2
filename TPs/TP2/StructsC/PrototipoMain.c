#include<stdio.h>
#include<stdlib.h>
#include<stdbool.h>
#include<string.h>

typedef struct Data{
         int ano;
         int mes;
         int dia;
 }Data; 

typedef struct Hora{
         int hora;
         int minuto;
}Hora;

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


typedef struct Colecao_Restaurantes{
         int tamanho;
         Restaurante* restaurante;
}Colecao_Restaurantes;


Data parse_data(char* s){
         Data d;
         sscanf(s, "%d-%d-%d", &d.ano, &d.mes, &d.dia);
         return d;
}
 
void formatar_data(Data* data, char* buffer){
          sprintf(buffer,"%02d/%02d/%04d", data->dia, data->mes, data->ano);
}

Hora parse_hora(char *s){
         Hora h; // cria a struct para ser retornada
         sscanf(s,"%02d:%02d",&h.hora,&h.minuto); //pesquisei a sintaxe correta do sscanff
         return h;
}
 
 void formatar_hora(Hora* hora, char* buffer){
         sprintf(buffer, "%02d:%02d", hora->hora, hora->minuto); // pesquisei a sintaxe correta do sprintf
 }

Restaurante* parse_restaurante(char* s){
	Restaurante* r = (Restaurante*)malloc(sizeof(Restaurante));
    	char nome, cidade, tipo, preco[10], hora_full[20], data_a[20], aberto_str[10];

    	sscanf(s, "%d,%[^,],%[^,],%d,%lf,%[^,],%[^,],%[^,],%[^,],%s",
           	&r->id, nome, cidade, &r->capacidade, &r->avaliacao, 
           	tipo, preco, hora_full, data_a, aberto_str);

    	r->nome = strdup(nome);
    	r->cidade = strdup(cidade);
    	r->faixa_preco = strlen(preco);
    	r->aberto = (strcmp(aberto_str, "true") == 0);
    
    	char h_abertura[6], h_fechamento[6];
    	sscanf(hora_full, "%[^-]-%s", h_abertura, h_fechamento);
    	r->horario_abertura = parse_hora(h_abertura);
    	r->horario_fechamento = parse_hora(h_fechamento);
    
    	r->data_abertura = parse_data(data_a);

    	for(int i = 0; tipo[i] != '\0'; i++) if(tipo[i] == ';') tipo[i] = ',';
    	r->tipos_cozinha = (char**)malloc(sizeof(char*) * 2);
    	r->tipos_cozinha = strdup(tipo);
    	r->tipos_cozinha[1] = NULL;

    	return r;	
}

void formatar_restaurante(Restaurante* restaurante, char* buffer){
	char h_abertura[6], h_fechamento[6], d_abertura[12], f_preco[6];
    
    	formatar_hora(&restaurante->horario_abertura, h_abertura);
    	formatar_hora(&restaurante->horario_fechamento, h_fechamento);
    	formatar_data(&restaurante->data_abertura, d_abertura);

    	int i;
    	for(i = 0; i < restaurante->faixa_preco; i++) f_preco[i] = '$';
    	f_preco[i] = '\0';

    	sprintf(buffer, "[%d ## %s ## %s ## %d ## %.1lf ## [%s] ## %s ## %s-%s ## %s ## %s]",
            	restaurante->id, restaurante->nome, restaurante->cidade,
            	restaurante->capacidade, restaurante->avaliacao, restaurante->tipos_cozinha,
            	f_preco, h_abertura, h_fechamento, d_abertura, 
            	restaurante->aberto ? "true" : "false"); 
}

void ler_csv_colecao(Colecao_Restaurantes* colecao, char* path){
	FILE *arq = fopen(path, "r");
    	if(arq == NULL) return;

    	char linha;
    	fgets(linha, sizeof(linha), arq); // Pular cabeçalho

    	int i = 0;
    	while(fgets(linha, sizeof(linha), arq) != NULL && i < colecao->tamanho) {
        	Restaurante* aux = parse_restaurante(linha);
        	if(aux) {
            		colecao->restaurante[i] = *aux;
            		free(aux); // Libera apenas a struct aux, os dados internos (nome, etc) ficam na coleção
            		i++;
        	}	
    	}
    	fclose(arq);
}

ColecaoRestaurantes* ler_csv(){
	char* path = "restaurantes.csv"; // Ajuste o caminho conforme seu Linux
    	FILE *arq = fopen(path, "r");
    	if(arq == NULL) return NULL;

    	int tam = 0;
    	char linha;
    	while(fgets(linha, sizeof(linha), arq)) tam++;
    	fclose(arq);

    	if (tam <= 1) return NULL;

    	Colecao_Restaurantes* novaCole = (Colecao_Restaurantes*)malloc(sizeof(Colecao_Restaurantes));
    	novaCole->tamanho = tam - 1;
    	novaCole->restaurante = (Restaurante*)malloc(novaCole->tamanho * sizeof(Restaurante));
    
    	ler_csv_colecao(novaCole, path);
    	return novaCole;
}
void imprimir_por_id(Colecao_Restaurantes* colecao, int id_procurado) {
    	char buffer;
    	for (int i = 0; i < colecao->tamanho; i++) {
        	if (colecao->restaurante[i].id == id_procurado) {
            	formatar_restaurante(&colecao->restaurante[i], buffer);
            	printf("%s\n", buffer);
            	return;
        	}
    	}
}

void liberar_colecao(Colecao_Restaurantes* colecao) {
   	 if (colecao == NULL) return;

    	for (int i = 0; i < colecao->tamanho; i++) {
        	free(colecao->restaurante[i].nome);
        	free(colecao->restaurante[i].cidade);

        	if (colecao->restaurante[i].tipos_cozinha != NULL) {
            		for (int j = 0; colecao->restaurante[i].tipos_cozinha[j] != NULL; j++) {
                		free(colecao->restaurante[i].tipos_cozinha[j]);
            		}
            		free(colecao->restaurante[i].tipos_cozinha);
        	}
    	}

    	free(colecao->restaurante);

    	free(colecao);
}
	
int main(){
	Colecao_Restaurantes* colecao = ler_csv();
    	if (colecao == NULL) return 1;

    	int id_procurado;
    	char buffer;

    	while (scanf("%d", &id_procurado) == 1 && id_procurado != -1) {
        	for (int i = 0; i < colecao->tamanho; i++) {
            		if (colecao->restaurante[i].id == id_procurado) {
                	formatar_restaurante(&colecao->restaurante[i], buffer);
                	printf("%s\n", buffer);
                	break;
            		}
        	}
    	}

    	liberar_colecao(colecao);
    	return 0;
}
