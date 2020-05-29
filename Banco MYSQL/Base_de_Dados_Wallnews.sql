CREATE DATABASE portal_realnews;

USE portal_realnews;

CREATE TABLE noticia (
    id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    descricao VARCHAR(512),
    titulo VARCHAR(126),
    texto TEXT
);

CREATE TABLE comentario (
    id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(126),
    texto VARCHAR(512),
    fk_noticia_id INT NOT NULL,
    FOREIGN KEY (fk_noticia_id)
        REFERENCES noticia (id)
);

/*Inserção de algumas notícias */
INSERT INTO noticia (descricao, titulo, texto) 
VALUES ("Uma busca constante por ETs", "Novo telescópio começará a buscar vida extraterrestre", "O dia 15 de agosto de 1977 é uma data que todo astrônomo conhece: às 23h57m daquela noite, o telescópio do Observatório de Rádio da Universidade de Ohio captou um sinal que durou exatos 72 segundos, e que entraria para a História da astronomia com o nome de “Uau” (em inglês, “Wow”). Passados 43 anos, o sinal permanece um mistério. Quando os astrônomos examinam um pedaço ainda inexplorado do céu, geralmente topam com algo surpreendente que ninguém previu. Nosso objetivo é buscar sinais muito breves, mas poderosos, de uma civilização avançada”, explicou um dos envolvidos no projeto PANOSETI, o tecnólogo-chefe do SETI Research Center da Universidade da Califórnia em Berkeley, Dan Werthimer, há 45 anos envolvido na busca de vida inteligente extraterrestre."),
	   ("Os impactos da pandemia do Coronavírus na qualidade do ar", "Desaceleração global", "Que par de meses o mundo está vivendo! De ter liberdade para ir e vir, passamos à apreensão antes de mergulhar no medo e na reclusão por conta do Coronavírus, e vimos diversos países restringirem parcial e até completamente a circulação da população com a instauração de normativas de distanciamento social, quarentenas e lockdowns. Pois, em dado momento, bilhões de pessoas em todo o planeta ficaram impedidas de sair de suas casas – e o impacto no meio ambiente é dramático. Para se ter ideia, no que levamos de ano, as autoridades chinesas ordenaram que o equivalente a 7% da população mundial permanecesse em casa – e países como a Itália e a Espanha se viram obrigados a fazer o mesmo na tentativa de frear a propagação do coronavírus e desafogar seus sistemas públicos de saúde que, em diversas localidades, entraram em colapso e registraram milhares de mortes."),
	   ("Positivo lança nova lâmpada spot e plug para casas inteligentes", "Positividade dentro e fora de casa", "A Positivo Casa Inteligente, divisão de equipamentos de Internet das Coisas (IoT) da fabricante brasileira, apresentou nesta quinta-feira (23) dois novos produtos para uso doméstico ou em ambientes profissionais. Ambos já estão disponíveis em lojas de todo o Brasil e no site da companhia. O primeiro é a Smart Lâmpada Spot Wi-fi, uma LED com soquete GU10 para projetos de arquitetura com iluminação embutida. Ela é adequada para aplicações em spots, oferece luz quente de 3000K e tem efeitos de decoração com 16 milhões de cores RGB. Ele é conectado diretamente ao Wi-Fi do local, tem intensidade variável e potência de 4,5W. O preço sugerido é R$ 99."),
       ("Huawei nova 5T chega ao Brasil por R$ 2.999", "Huawei lança mais um smartphone", "Na noite da última sexta-feira (24), a Huawei anunciou a chegada de mais um smartphone ao Brasil, o nova 5T. O aparelho será comercializado pelo site da Fast Shop pelo preço sugerido de R$ 2.999 nas cores preto e azul. O nova 5T tem uma tela IPS LCD  Punch FullView de 6,26 polegadas com resolução Full HD+.  O aparelho pesa apenas 174 gramas e tem espessura de 7,87 mm. A câmera frontal de 32MP conta com recursos de Inteligência Artificial e suporte ao HDR+, enquanto o conjunto traseiro tem um sensor principal de 48MP, uma lente grande angular de 16MP, uma macro de 2MP e lente bokeh de 2MP. O processador é um Kirin 980 acompanhado de 8 GB de RAM e 128 GB de armazenamento interno.  O Huawei nova 5T conta ainda com o sistema operacional EMUI 9.1 baseado no Android 9 Pie, bateria de 3.750 mAh com suporte ao carregamento rápido SuperCharge de 22,5W, da própria Huawei."),
	   ("Como o governo decide quem tem direito ao Auxílio Emergencial?", "Auxílio emergencial", "O governo federal tem tido dificuldades para liberar a primeira parcela do Auxílio Emergencial até mesmo para os cidadãos que já confirmaram ter o direito de recebê-lo. O processo de análise dos cadastros é penoso e envolve cruzamentos das informações enviadas por todos os requerentes com os mais de 33 bilhões de registros do Cadastro Nacional de Informações Sociais (CNIS). Conheça os detalhes de como o governo faz esses cruzamentos de dados, e determina quem vai, ou não, ter direito ao benefício. A seguir, acompanhe os passos realizados entre os órgãos ligados ao governo federal no processo de análise dos cadastros: O cadastro é realizado por meio do sistema da Caixa Econômica Federal (CEF); Os dados fornecidos durante o cadastro são enviados à Dataprev, empresa pública responsável por identificar quem tem direito a receber o auxílio emergencial no valor de R$ 600; Os dados coletados pela Dataprev são cruzados com mais de 33 bilhões de registros no CNIS;
Após a conclusão da análise, a Dataprev envia a indicação daqueles considerados aptos a receber o benefício para o Ministério da Cidadania;
De posse das indicações, o Ministério da Cidadania faz a homologação dos contemplados e envia os dados de volta para a Dataprev;
Finalmente, a Dataprev envia esses dados à CEF, que é responsável por realizar o pagamento do auxílio.");

