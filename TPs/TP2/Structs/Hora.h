typedef struct Hora{
	int hora;
	int minuto;
}

Hora parse_hora(char *s){
	Hora h; // cria a struct para ser retornada
	sscanf(s,"%d:%d",&h.hora,&h.minuto); //pesquisei a sintaxe correta do sscanff
	return h;
}

void formatar_hora(Hora* hora, char* buffer){
	sprintf(buffer, "%02d:%02d", hora->hora, hora->minuto); // pesquisei a sintaxe correta do sprintf
}
