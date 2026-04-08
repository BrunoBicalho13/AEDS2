Typedef struct Data{
	int ano;
	int mes;
	int dia;
}

Data parse_data(char*){


}


void formatar_data(Data* data, char* buffer){
	sprintf(buffer,"%02d/%02d/%04d", data->dia, data->mes, data->ano);
}
