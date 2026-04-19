typedef struct Data{
	int ano;
	int mes;
	int dia;
}Data;

Data parse_data(char* s){
	data d;
	sscanf(s, "%d-%d-%d", &d.ano, &d.mes, &d.dia);
	return d;	
}


void formatar_data(Data* data, char* buffer){
	sprintf(buffer,"%02d/%02d/%04d", data->dia, data->mes, data->ano);
}
