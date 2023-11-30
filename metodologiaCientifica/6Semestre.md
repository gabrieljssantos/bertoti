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

- **MySQL:**
  É um sistema de administração de banco de dados (SABD) relacional, ou seja, que emprega a linguagem SQL como interface. Lançado sob a licença GPL, tem como desenvolvedora a Oracle Corporation.

- **MongoDB:**
  É um banco de dados NoSQL que armazena dados em documentos adaptáveis usando um formato JSON. E proporciona escalabilidade e adaptabilidade para lidar com grandes volumes de dados e modelos de dados dinâmicos.

- **Python:**
  É uma linguagem de programação de alto nível, interpretada e de uso generalizado, conhecida por sua simplicidade, legibilidade e ampla aplicação em diferentes domínios, desde desenvolvimento web até análise de dados.

- **React:**
  É uma biblioteca JavaScript para construir interfaces de usuário dinâmicas e responsivas. Desenvolvida pelo Facebook, permite a criação de componentes reutilizáveis para construir aplicativos web eficazes.

- **Docker:**
  É uma plataforma de virtualização leve e móvel que permite empacotar, distribuir e executar aplicativos de forma isolada, garantindo a portabilidade e uniformidade do ambiente de desenvolvimento e produção.

- **GIT:**
  É uma ferramenta de design colaborativo baseada na nuvem, que possibilita criar interfaces de usuário, protótipos interativos e compartilhar facilmente os designs com equipes de trabalho, agilizando o processo de design e feedback em projetos de design de produtos e interfaces digitais.

- **Microsoft Azure:**
  É uma plataforma de serviços na nuvem que oferece recursos de computação, armazenamento e serviços relacionados para construir, implantar e gerenciar aplicativos e serviços pela internet. Ele permite que empresas hospedem seus aplicativos, armazenem dados com segurança e usem recursos poderosos, como inteligência artificial e análise de dados, para melhorar suas operações. Com o Azure, é possível escalar recursos conforme necessário, oferecendo flexibilidade e eficiência no desenvolvimento e na execução de soluções empresariais.

- **Azure Data Factory:**
  O Azure Data Factory é uma ferramenta na nuvem que facilita a criação, agendamento e gerenciamento de fluxos de trabalho de processamento de dados, seguindo o processo ETL (Extração, Transformação e Carga). Ele permite a extração de dados de diversas fontes, sua transformação de acordo com as necessidades e a carga eficiente em destinos apropriados. Com o Data Factory, é possível orquestrar e automatizar esse movimento e transformação de dados entre sistemas locais e na nuvem, construindo pipelines de dados sólidas.


## Contribuições pessoais ![Contribuições pessoais](https://img.shields.io/badge/-Contribui%C3%A7%C3%B5es%20Pessoais-blue)

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

<p align="justify">
Uma das contribuições, foi liderar a solução de envios de dados diante do desafio de processar um arquivo CSV com mais de 2 milhões de linhas. Inicialmente, tentamos enviá-lo via Jupyter em Python, mas o processo estava se estendendo demais, ultrapassando 48 horas de execução sem conclusão. Diante dessa situação, decidi estudar e implementar um fluxo de ETL (Extração, Transformação e Carga) utilizando o Azure Data Factory. 

Esse esforço resultou em um processo que anteriormente levava mais de 48 horas para rodar, agora concluído em menos de 5 minutos. Essa transição representou um ganho considerável em eficiência e velocidade no tratamento e carregamento dos dados, permitindo uma gestão muito mais ágil e eficaz das informações.

Essa contribuição foi crucial para a integridade e acessibilidade dos dados, permitindo que a equipe utilizasse informações precisas e prontamente disponíveis para análises e tomada de decisões.</p>

  <details>
    <img alt="01" src="https://github.com/gabrieljssantos/bertoti/assets/48994698/2d2c128f-6ae5-412c-aa00-ca48ac5441c7" width="70%" height="70%">
    <img alt="02" src="https://github.com/gabrieljssantos/bertoti/assets/48994698/3d1eff59-382f-4241-82b3-8cb76a1c963e" width="70%" height="70%">
    <img alt="03" src="https://github.com/gabrieljssantos/bertoti/assets/48994698/2c6252eb-8d32-48a2-889e-a18750fce819" width="70%" height="70%">
    <img alt="04" src="https://github.com/gabrieljssantos/bertoti/assets/48994698/399374ef-a914-4b68-bb33-d00d1bf1006f" width="40%" height="35%">
    <img alt="05" src="https://github.com/gabrieljssantos/bertoti/assets/48994698/020ea32f-00f6-4292-9c62-95f2d0eae1d2" width="40%" height="35%">
  </details>


## Aprendizados Efetivos ![Aprendizados efetivos](https://img.shields.io/badge/-Aprendizados%20Efetivos-blue)

<p align="justify">
Durante este projeto, adquiri conhecimentos e experiência valiosos. Liderar a solução para lidar com grandes volumes de dados, implementando uma pipeline de ETL no Azure Data Factory, foi um dos principais aprendizados. Essa experiência não apenas aprimorou minhas habilidades técnicas em manipulação e processamento de dados, mas também me mostrou a importância da otimização de fluxos de trabalho para a eficiência de processos.

A aplicação do ETL (Extração, Transformação e Carga) no contexto do Data Factory permitiu compreender profundamente como as ferramentas na nuvem podem facilitar a transformação de dados, melhorando significativamente a velocidade e a eficiência do processamento. Esse aprendizado reforçou a importância da escolha correta de tecnologias e estratégias para lidar com problemas complexos de dados.

Além disso, a experiência de implementar scripts em Python, utilizando a biblioteca Pandas, para a formatação e preparação dos dados foi crucial. Esses scripts não apenas tornaram o processo mais ágil, mas também destacaram a necessidade de habilidades de programação e manipulação de dados para lidar eficientemente com problemas do mundo real.

A liderança exercida na identificação do problema, estudo da solução e implementação da pipeline demonstrou a importância do pensamento proativo e da busca por soluções inovadoras diante de desafios complexos. Esse aprendizado ampliou minha visão sobre a importância de liderar e assumir a responsabilidade em situações críticas, buscando alternativas e soluções que agreguem valor aos projetos.
</p>
