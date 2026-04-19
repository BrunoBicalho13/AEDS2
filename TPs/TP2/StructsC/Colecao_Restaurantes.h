typedef struct Colecao_Restaurantes{
	int tamanho;
	Restaurante* restaurante;
}Colecao_Restaurantes;

void ler_csv_colecao(Colecao_Restaurantes* colecao, char* path){
	
    	FILE *arq = fopen("/tmp/restaurantes.csv", "r");// abre o arquivo

    	if(arq == NULL){//verifica se o ponteiro é null
        	printf("Erro ao abrir arquivo!");
        	return;// se for retorna nada
    	}
    	char linha[200];// pega o linha

    	fgets(linha, sizeof(linha), arq);//leio o cabecalho
    
    	int i = 0;
    	while(fgets(linha, sizeof(linha), arq) != NULL){
        	Restaurante* aux = parse_restaurante(linha); //Criei um aux para o parse_restaurante
        	colecao->restaurante[i] = *aux; //Faço as transferencia do auxiliar para o restaurente na posicao i
        	i++;
        	free(aux);//Libera a memoria
    	}

    	fclose(arq);//fecho o arquivo
}

ColecaoRestaurantes* ler_csv(){
	FILE *arq = fopen("/tmp/restaurantes.csv", "r");// abro o arquivo para leitura

        if(arq == NULL){
            printf("Erro ao abrir arquivo!");
            return NULL;
        }

        int tam = 0;//crio uma variavel para o tamanho da coleção
        char linha[200];

        while(fgets(linha, sizeof(linha), arq) != NULL){//leio ate o final do arquivo 
            tam++;//incremento tam
        }

        fclose(arq);// fecho o arquivo

        Colecao_Restaurantes* novaCole = (Colecao_Restaurantes*) malloc(sizeof(Colecao_Restaurante));// crio uma colacao
        if(novaCole == NULL){
            printf("Erro ao alocar Colecao!");
            return NULL;
        }
        novaCole->tamanho = tam - 1;// recebe o tamanho exato da coleção
        novaCole->restaurante = (Restaurante*)malloc((tam - 1) * sizeof(Restaurante));// crio o vetor de restaurante
        if(novaCole->restaurante == NULL){
            printf("Erro ao alocar restaurante!");
            return NULL;
        }
        ler_csv_colecao(novaCole,"/tmp/restaurantes.csv");

      	return novaCole*;
}
