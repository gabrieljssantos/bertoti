# Projeto 6 - 6º semestre
## Empresa parceira: MidAll 

<img src="https://github.com/TechVisionn/tech-parent/blob/main/docs/Images/Logo_Visiona.png" height="150"/>


###*Figura 11. Visiona (Fonte: https://visionaespacial.com/)*

### Visão do Projeto ![Visão do Projeto](https://img.shields.io/badge/-Visão%20Do%20Projeto-blue)

<p align="justify">
O projeto tem como objetivo a implementação de um Sistema de Informação Geoespacial (SIG) para aprimorar a eficácia das análises e otimizar os processos internos. Embora os dados necessários estejam disponíveis no ProAgro, programa do governo federal voltado ao financiamento agrícola para pequenos e médios produtores brasileiros, a falta de estruturação, a presença de informações confidenciais e o excesso de dados representam desafios significativos.

A proposta abrange uma solução completa, envolvendo a coleta e o refinamento dos dados públicos do ProAgro, a eficiente reestruturação da base de dados e o desenvolvimento de um SIG personalizado. Esse sistema busca simplificar e organizar as informações, proporcionando aos usuários uma compreensão mais acessível e facilitando a análise dos dados. Destaca-se a organização do banco de dados público do ProAgro para possibilitar consultas e análises rápidas no Sistema de Informações Geoespaciais.
</p>


## Tecnologias utilizadas ![Tecnologias utilizadas](https://img.shields.io/badge/-Tecnologias%20Utilizadas-blue)

- **MySQL:** Trata-se de um sistema de administração de banco de dados (SABD) relacional, ou seja, que emprega a linguagem SQL como interface. Lançado sob a licença GPL, tem como desenvolvedora a Oracle Corporation.
- **MongoDB:** É um banco de dados NoSQL que armazena dados em documentos maleáveis usando um formato JSON. Ele proporciona dimensionamento e flexibilidade para lidar com grandes quantidades de dados e padrões de dados dinâmicos.
- **Python** é uma linguagem de programação de alto nível, amplamente usada em aplicações da Web, desenvolvimento de software, ciência de dados e machine learning (ML).
- **React:** É uma biblioteca JavaScript para construir interfaces de utilizador interativas e reativas. Desenvolvida pelo Facebook, possibilita a criação de componentes reutilizáveis para desenvolver eficazes aplicativos web.
- **HTML** é uma linguagem de marcação utilizada para estruturar e organizar o conteúdo das páginas da web.  
- **JavaScript** é uma linguagem de programação interpretada estruturada, de script em alto nível com tipagem dinâmica fraca e multiparadigma
- **Docker** é um conjunto de produtos de plataforma como serviço que usam virtualização de nível de sistema operacional para entregar software em pacotes chamados contêineres. 
- **Figma**  é uma plataforma colaborativa para construção de design de interfaces e protótipos
- **GIT:** Trata-se de uma ferramenta de desenho colaborativo baseada na nuvem, que permite criar interfaces de utilizador, protótipos interativos e partilhar de forma simples os desenhos com equipas de trabalho, acelerando o processo de desenho e feedback em projetos de design de produtos e interfaces digitais.


## Contribuições pessoais ![Contribuições pessoais](https://img.shields.io/badge/-Contribui%C3%A7%C3%B5es%20Pessoais-blue)

<p align="justify">
Durante o projeto, minha contribuição foi focada na área de dados, onde foi utilizado Grafana para monitorar a saúde da aplicacação. Também foi desenvolvido um dashboard para acompanhamento de métricas da aplicação, dentro do LookerStudio. </p>

![Leia Mais](https://img.shields.io/badge/-Grafana%20Dashboard-orange) 
  <details>
    <img src="https://github.com/gabrieljssantos/bertoti/assets/48994698/41559113-450e-4169-a480-719eca38e263.png" width="90%" height="90%"/>

  </details>

Implementei scripts em Python, utilizando a biblioteca Pandas, para a formatação e preparação dos dados. Esses scripts são essenciais para garantir que os dados estejam estruturados de forma adequada antes de serem inseridos no banco de dados. Isso permite uma integração mais suave e eficiente, facilitando o acesso e a análise posterior dos dados por meio do banco de dados

 <details>

<summary>Script para tratamento dos dados - Referente as Glebas</summary>
 
 ```py

import pandas as pd

# Carregue os dados do CSV
csv_file_path = r"C:\Users\Gabriel\Documents\Faculdade\6-Semestre\API\03_TABS_COMP_BASICAS_OPERACOES_CREDITO_RURAL_PROAGRO_RECURSOS_PUB\Glebas.csv"
df = pd.read_csv(csv_file_path)

# Função para trocar vírgula por ponto em uma série
def replace_commas_with_points(series):
    return series.str.replace(',', '.')

# Aplicando a função aos valores de VL_LATITUDE e VL_LONGITUDE
df['VL_LATITUDE'] = replace_commas_with_points(df['VL_LATITUDE'])
df['VL_LONGITUDE'] = replace_commas_with_points(df['VL_LONGITUDE'])

# Agrupe os dados por 'NU_IDENTIFICADOR' e aplique a função de formatação
def format_coordinates(group):
    x_values = group['VL_LATITUDE'].tolist()
    y_values = group['VL_LONGITUDE'].tolist()

    # Intercalar os valores de X e Y e juntá-los com vírgulas
    coordinates = [f'{x} {y}' for x, y in zip(x_values, y_values)]

    # Juntar as coordenadas com vírgulas e espaço e retornar como uma string
    return ', '.join(coordinates)

# Aplicar a função de formatação apenas para a coluna 'NU_IDENTIFICADOR'
df['VL_VERTICES'] = df.groupby('NU_IDENTIFICADOR').apply(format_coordinates).reset_index(level=0, drop=True)

# Preencher os valores NaN em 'VL_VERTICES' com base no 'NU_IDENTIFICADOR'
df['VL_VERTICES'] = df.groupby('NU_IDENTIFICADOR')['VL_VERTICES'].transform('first')

# Verificar se cada REF_BACEN tem apenas um NU_IDENTIFICADOR
ref_bacen_identificador_count = df.groupby('REF_BACEN')['NU_IDENTIFICADOR'].nunique()
invalid_ref_bacen = ref_bacen_identificador_count[ref_bacen_identificador_count != 1].index.tolist()

if len(invalid_ref_bacen) > 0:
    print(f"REF_BACEN(s) com mais de um NU_IDENTIFICADOR: {', '.join(map(str, invalid_ref_bacen))}")
else:
    print("Todas as REF_BACEN têm apenas um NU_IDENTIFICADOR")

# Exiba o DataFrame
result = df[['REF_BACEN', 'NU_ORDEM', 'NU_IDENTIFICADOR', 'VL_VERTICES']]
print(result)

# Salvar o DataFrame resultante em um arquivo CSV
resultado_csv = r"C:\Users\Gabriel\Documents\Faculdade\6-Semestre\API\new_result.csv"
result.to_csv(resultado_csv, index=False)
print(f"Resultado salvo em {resultado_csv}")
 
 ```
 
 </details> 


## Aprendizados Efetivos ![Aprendizados efetivos](https://img.shields.io/badge/-Aprendizados%20Efeitvos-blue)

- **Tratamento de dados com Python:** Realizei a etapa de tratamento de dados utilizando Python, aplicando transformações e manipulações nos dados para prepará-los para análise e visualização. Isso incluiu a limpeza de dados inconsistentes e a padronização de formatos.
- **Consultas SQL:** Aprofundei-me em consultas SQL para extrair informações específicas do Microsoft SQL Server, otimizando consultas para obter dados relevantes para o projeto. Isso envolveu o uso de junções complexas e subconsultas para análises detalhadas.
- **Azure e Integrações:** Explorei mais afundo os serviços oferecidos pela plataforma Azure da Microsoft e suas possibilidades de integração com as ferramentas existentes no projeto. Isso incluiu a compreensão de como os serviços em nuvem podem ser usados para armazenamento, processamento e integração de dados.
Essa introdução ao Azure e às suas capacidades de integração trouxe perspectivas valiosas sobre as possibilidades de expansão e escalabilidade para projetos futuros.
- **Configuração avançada no Grafana:** Explorei a criação de dashboards altamente personalizados para monitorar a saúde da aplicação, utilizando variáveis, alertas e fontes de dados variadas. Isso incluiu a criação de painéis dinâmicos para acompanhar métricas em tempo real.
- **Integração do LookerStudio com fontes de dados em Nuvem (Azure):** Aprendi a integrar e visualizar dados complexos da aplicação dentro do LookerStudio, facilitando a análise de métricas cruciais para o projeto. Isso envolveu a criação de visualizações interativas para melhorar a compreensão dos dados.


