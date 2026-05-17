#include <stdio.h>
#include <string.h>
#include <stdbool.h>
#include <stdlib.h>
#include<time.h>


typedef struct Data{
    int dia;
    int mes;
    int ano;
}Data;

typedef struct Hora{
    int hora;
    int minuto;
}Hora;

typedef struct Restaurante{
    int id_restaurante;
    char* nome;
    char* cidade;
    int capacidade;
    double avaliacao;
    char** tipo_cozinha;
    int faixa_preco;
    Hora hora_abertura;
    Hora hora_fechamento;
    Data data_abertura;
    bool aberto;
}Restaurante;

typedef struct ColecaoRestaurante{
    int tamanho;
    Restaurante* restaurante;
}Colecao_Restaurante;

typedef struct No{
	Restaurante* elemento;
	struct No* dir, *esq;
}No;


No* novoNo(Restaurante* x){
	No* novo = (No*)malloc(sizeof(No));
	novo->elemento = x;
	novo->dir = novo->esq = NULL;
}

No* raiz;

void start(){
	raiz = NULL;
}

Data parse_data(char *s){
    Data d;

    sscanf(s, "%d-%d-%d", &d.ano, &d.mes, &d.dia);
    
    return d;
}

void formatar_data(Data* data, char* buffer){
    sprintf(buffer,"%02d/%02d/%04d", data->dia, data->mes, data->ano);//pega a Data e passa formatada para o buffer
}

Hora parse_hora(char *s){
    Hora h;
    
    sscanf(s,"%d:%d", &h.hora, &h.minuto);//ler Hora

    return h;// retorna uma struct de hora
}

void formatar_hora(Hora* hora, char* buffer){
    sprintf(buffer, "%02d:%02d", hora->hora, hora->minuto);// pega a Hora e passa formatada para o buffer
}

void liberar_restaurante(Restaurante* r) {//liberar os vetores alocados
    free(r->nome);
    free(r->cidade);
    free(r->tipo_cozinha[0]);
    free(r->tipo_cozinha);
}

Restaurante* parse_restaurante(char *s){
    Restaurante* r = (Restaurante*)malloc(sizeof(Restaurante));// crio um restaurante novo
    if(r == NULL){
        printf("Nao foi possivel criar restaurante!");
        return NULL;
    }
    char hora_a[6], hora_f[6], data_a[11], nome[100], cidade[100], preco[10], tipo[40], aberto[10];// crio vetores de char para leitura da string

    sscanf(s, "%d,%[^,],%[^,],%d,%lf,%[^,],%[^,],%[^-]-%[^,],%[^,],%[^\n]",//leitura da string de restaurante
           &r->id_restaurante, nome, cidade, &r->capacidade,
           &r->avaliacao, tipo, preco, hora_a, hora_f,
           data_a, aberto);


    for(int i = 0; aberto[i] != '\0'; i++){
        if(aberto[i] == '\r' || aberto[i] == '\n' || aberto[i] == ' ')//verifico se existe algo apos a string
            aberto[i] = '\0';
    }


    r->aberto = (strcmp(aberto, "true") == 0);//verifica se o char aberto e true, se for r->aberto recebe true
    r->hora_abertura = parse_hora(hora_a);//chamada da funcao parse_hora
    r->hora_fechamento = parse_hora(hora_f);
    r->data_abertura = parse_data(data_a); 
    
    int tam = 0;
    while(nome[tam] != '\0') tam++;
    r->nome = (char*)malloc((tam + 1) * sizeof(char));
                                                     
    
    sprintf(r->nome,"%s", nome);// passo char nome, para a char da struct
    
    tam = 0;
    while(cidade[tam] != '\0') tam++;
    r->cidade = (char*)malloc((tam + 1) * sizeof(char));
    
    sprintf(r->cidade,"%s", cidade);

    tam = 0;
    while(preco[tam] != '\0') tam++;
    r->faixa_preco = tam;//passo o valor exato da quantidade de $

    tam = 0;
    while(tipo[tam] != '\0') tam++;
    for(int i = 0; tipo[i] != '\0'; i++)
        if(tipo[i] == ';') tipo[i] = ',';//substitui o ; por ,

    r->tipo_cozinha = (char**)malloc(1 * sizeof(char*));//cria uma posicao do ponteiro duplo
    r->tipo_cozinha[0] = (char*)malloc((tam + 1) * sizeof(char));//aloco o tamanho exato da quantidade de tipos

    sprintf(r->tipo_cozinha[0],"%s",tipo);
   

    return r;
}

void formatar_restaurante(Restaurante* restaurante, char* buffer){
    char hora_fechamento[7], hora_abertura[7], data_abertura[12], str_aberto[6];// crio strings 

    formatar_hora(&restaurante->hora_abertura, hora_abertura);
    formatar_hora(&restaurante->hora_fechamento, hora_fechamento);
    formatar_data(&restaurante->data_abertura, data_abertura);
  
    char f_preco[5];
    int i;
    for(i = 0; i < restaurante->faixa_preco; i++){
        f_preco[i] = '$';
    }
    f_preco[i] = '\0';

    if(restaurante->aberto == true) { 
        sprintf(str_aberto, "true");
    }else{
        sprintf(str_aberto, "false");
    }
    sprintf(buffer,"[%d ## %s ## %s ## %d ## %.1lf ## [%s] ## %s ## %s-%s ## %s ## %s]",//formatação do restaurante
        restaurante->id_restaurante, restaurante->nome, restaurante->cidade,
        restaurante->capacidade, restaurante->avaliacao, restaurante->tipo_cozinha[0],
        f_preco, hora_abertura, hora_fechamento, data_abertura, str_aberto);
}

void ler_csv_colecao(Colecao_Restaurante* colecao, char* path){
    
    FILE *arq = fopen(path, "r");// abre o arquivo

    if(arq == NULL){//verifica se o ponteiro é null
        printf("Erro ao abrir arquivo!");
        return;
    }
    char linha[200];

    fgets(linha, sizeof(linha), arq);//leio o cabecalho
    
    int i = 0;
    while(fgets(linha, sizeof(linha), arq) != NULL){
        Restaurante* aux = parse_restaurante(linha); //Criei um aux para o parse_restaurante

        colecao->restaurante[i] = *aux; //Faco as transferencia do auxiliar para o restaurente na posicao i
                                         
        i++;
        free(aux);//Libera a memoria
    }

    fclose(arq);//fecho o arquivo
}

Colecao_Restaurante* ler_csv(){
        FILE *arq = fopen("/tmp/restaurantes.csv", "r");// abro o arquivo para leitura

        if(arq == NULL){
            printf("Erro ao abrir arquivo!");
            return NULL;
        }

        int tam = 0;//crio uma variavel para o tamanho da coleção
        char linha[200];

        while(fgets(linha, sizeof(linha), arq) != NULL){ 
            tam++;
        }

        fclose(arq);

        Colecao_Restaurante* novaCole = (Colecao_Restaurante*) malloc(sizeof(Colecao_Restaurante));// crio uma coleção
        if(novaCole == NULL){
            printf("Erro ao alocar Colecao!");
            return NULL;
        }
        novaCole->tamanho = tam - 1;
        novaCole->restaurante = (Restaurante*)malloc((tam - 1) * sizeof(Restaurante));
        if(novaCole->restaurante == NULL){
            printf("Erro ao alocar restaurante!");
            return NULL;
        }
        ler_csv_colecao(novaCole,"/tmp/restaurantes.csv");

      return novaCole;
}

int buscarId(Colecao_Restaurante* colecao, int id_buscado) {
    for (int i = 0; i < colecao->tamanho; i++) {
        if (colecao->restaurante[i].id_restaurante == id_buscado) {
            return i;
        }
    }
    return -1;
}

void imprimirColecao(Colecao_Restaurante* colecao){
	char leitura[300];
	for(int i = 0; i < colecao->tamanho; i++){
             printf("imprimindo\n");		 
             formatar_restaurante(&(colecao->restaurante[i]), leitura);//fomato o restaurante e passo para o char leitura
             printf("%s\n", leitura);//print do restaurante formatado

	}
}


No* inserirRec(Restaurante* x, No* i){
	if(i == NULL){
		i = novoNo(x);
	}else if(strcmp(x->nome, i->elemento->nome) < 0){
		i->esq = inserirRec(x, i->esq);
	}else if(strcmp(x->nome, i->elemento->nome) > 0){
		i->dir = inserirRec(x, i->dir);
	}else{
		printf("Erro ao inserir!\n");
		return i;
	}

	return i;
}

void inserir(Restaurante* x){
	raiz = inserirRec(x, raiz);	
}

int pesquisarRec(char* x, No* i){
int resp = 1;
	if(i == NULL){
		resp = 1;
	}else if(strcmp(i->elemento->nome, x) == 0){
		resp = 0;
	}else if(strcmp(i->elemento->nome, x) > 0){
		printf("esq ");
		resp = pesquisarRec(x, i->esq);		 	
	}else {
		printf("dir ");
		resp = pesquisarRec(x, i->dir);
	}
	return resp;
}

int pesquisar(char* x){
    printf("raiz ");
	return pesquisarRec(x, raiz);
}

void caminharCentral(No* i){
	
	if(i != NULL){	
		caminharCentral(i->esq);
		char buffer[300];
        formatar_restaurante(i->elemento, buffer);
        printf("%s\n", buffer);
		caminharCentral(i->dir);
	}
}


int main(){
	Colecao_Restaurante* cr = ler_csv();

    	start();

    	char linha[50];
    	scanf("%s", linha);
    	while(strcmp(linha, "-1") != 0){
        	int id = atoi(linha);
        	int idBuscado = buscarId(cr, id);
        	if(idBuscado != -1){
            		inserir(&cr->restaurante[idBuscado]);
        	}
        	scanf("%s", linha);
    	}
    	int c;
    	while ((c = getchar()) != '\n' && c != EOF);

    	fgets(linha,sizeof(linha), stdin);
    	for(int i = 0; linha[i] != '\0';i++){
        	if(linha[i] == '\r' || linha[i] == '\n')
            		linha[i] = '\0';
    	}

     	while(strcmp(linha, "FIM") != 0){
        	if(pesquisar(linha) != 1){
            		printf("SIM\n");
        	}else{
            		printf("NAO\n");
        	}
        	fgets(linha, sizeof(linha), stdin);
        	for(int i = 0; linha[i] != '\0';i++){
            		if(linha[i] == '\r' || linha[i] == '\n') {
                		linha[i] = '\0';
            		}
        	}
    	}
    	caminharCentral(raiz);
    	free(cr->restaurante);
    	free(cr);
}
