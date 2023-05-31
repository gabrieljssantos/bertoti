# Projeto 1: 1º Semestre de 2021

### Parceiro Acadêmico

Fatec Prof. Jessen Vidal (proposta realizada pelo docente responsável pela disciplina que ordenou o projeto) <br/>

<img src="https://user-images.githubusercontent.com/80851038/118410251-e2069880-b664-11eb-9eb6-b9bdfc8526eb.png" width=75%></img>

### *Fatec São José dos Campos*

### Visão do Projeto ![Visão do Projeto](https://img.shields.io/badge/-Visão%20Do%20Projeto-blue)

<p align="justify">
O projeto consiste no desenvolvimento de um aplicativo chamado Helena, uma assistente virtual de viagens. A principal finalidade do aplicativo é fornecer uma experiência otimizada e agradável aos usuários durante suas viagens, oferecendo diversas funcionalidades úteis. Helena é capaz de responder a comandos de voz ou sons específicos, como palmas ou estalar de dedos. Ela possui no mínimo oito ações distintas e de natureza diversa, como mostrar pontos turísticos de uma cidade, abrir o mapa na localização do usuário, exibir um mapa de hotéis disponíveis com preços, permitir a criação de um roteiro pessoal, mostrar o clima e a temperatura atual, fornecer informações detalhadas sobre uma cidade, converter moedas, converter medidas de roupas entre países e traduzir textos para diferentes idiomas. O aplicativo pode ser utilizado em dispositivos móveis, na web ou em desktops, e retorna os comandos em diferentes formas, como som, texto ou ação, de acordo com o contexto específico de aplicação. Para o desenvolvimento do projeto, foram utilizadas tecnologias como React Native, Expo, JavaScript, NodeJs, Chocolatey, Java, Android Studio, Visual Studio Code e Figma.
</p>


## Tecnologias utilizadas ![Tecnologias utilizadas](https://img.shields.io/badge/-Tecnologias%20Utilizadas-blue)

### React Native

React Native é um framework de desenvolvimento de aplicativos móveis multiplataforma, que permite criar aplicativos nativos para iOS e Android utilizando JavaScript. Ele utiliza a biblioteca React para construir a interface do usuário, permitindo o reuso de componentes e a criação de aplicativos com aparência e desempenho nativos. O React Native é amplamente utilizado no desenvolvimento de aplicativos móveis modernos e oferece uma experiência de desenvolvimento eficiente e rápida.

### Expo

Expo é uma plataforma de código aberto para o desenvolvimento de aplicativos móveis com React Native. Ela fornece um conjunto de ferramentas e serviços que simplificam o processo de desenvolvimento, permitindo criar aplicativos sem a necessidade de configurar e gerenciar um ambiente de desenvolvimento nativo. O Expo oferece recursos como hot reloading, acesso a APIs nativas do dispositivo, compartilhamento fácil do aplicativo em desenvolvimento e muito mais.

### JavaScript

JavaScript é uma linguagem de programação amplamente utilizada em desenvolvimento web, análise de dados, inteligência artificial, automação de tarefas e outras áreas. Com sua sintaxe simples e intuitiva, é uma linguagem popular entre os desenvolvedores. No contexto do projeto Helena, o JavaScript é utilizado para o desenvolvimento de aplicativos móveis com React Native, aproveitando as bibliotecas e frameworks disponíveis nesse ecossistema.

### Node.js

Node.js é um ambiente de execução de JavaScript que permite rodar o código JavaScript no servidor. É amplamente utilizado no de ambientes de desenvolvimento e facilita a instalação de ferramentas e dependências necessárias para o desenvolvimento do projeto Helena.

### Java

Java é uma linguagem de programação popular e amplamente utilizada, especialmente no desenvolvimento de aplicativos Android. Com o uso do Java, é possível criar aplicativos móveis nativos e aproveitar recursos específicos da plataforma Android. No projeto Helena, o Java é utilizado em conjunto com o Android Studio para o desenvolvimento da versão Android do aplicativo.

### Android Studio

O Android Studio é o ambiente de desenvolvimento oficial para a plataforma Android. Ele fornece ferramentas poderosas para o desenvolvimento de aplicativos Android, incluindo um editor de código avançado, depurador, emulador de dispositivo e muito mais. O Android Studio é utilizado no projeto Helena para a criação e teste da versão Android do aplicativo.

### Visual Studio Code

O Visual Studio Code é um editor de código fonte leve e altamente configurável, desenvolvido pela Microsoft. Ele oferece uma ampla gama de recursos e extensões que facilitam o desenvolvimento de aplicativos em diferentes linguagens de programação. No projeto Helena, o Visual Studio Code é utilizado como ambiente de desenvolvimento para escrever e editar o código fonte do projeto.

### Figma

O Figma é uma ferramenta de design de interface do usuário baseada em nuvem. Com o Figma, é possível criar, colaborar e prototipar designs de aplicativos e interfaces de usuário de forma eficiente. No projeto Helena, o Figma é utilizado para criar e visualizar os designs das telas do aplicativo, permitindo uma melhor compreensão e comunicação entre os membros da equipe de desenvolvimento.

## Contribuições pessoais ![Contribuições pessoais](https://img.shields.io/badge/-Contribui%C3%A7%C3%B5es%20Pessoais-blue)

<p align="justify">
Durante o projeto, minha contribuição foi focada principalmente no desenvolvimento da funcionalidade de Pontos Turísticos, onde implementei a lógica para exibir os principais pontos turísticos de uma cidade, utilizando dados fornecidos por uma API. Além disso, também trabalhei na integração do aplicativo com a API de clima para exibir a temperatura e condições climáticas atuais. Participei ativamente das discussões de design e usabilidade, fornecendo sugestões e feedbacks para melhorar a experiência do usuário. Também colaborei na escrita da documentação técnica e na realização de testes e correções de bugs.
</p>

![Leia Mais](https://img.shields.io/badge/-Leia%20Mais-orange) <details><summary>Exemplo de código: Pontos Turísticos</summary>

```javascript
    // Função para obter os pontos turísticos de uma cidade
    function getPontosTuristicos(cidade) {
    // Chamada à API para obter os pontos turísticos
    fetch(`https://api.exemplo.com/pontos-turisticos?cidade=${cidade}`)
        .then(response => response.json())
        .then(data => {
        // Exibir os pontos turísticos na interface do usuário
        data.pontos.forEach(ponto => {
            console.log(ponto.nome);
            console.log(ponto.descricao);
            console.log(ponto.imagem);

        });
        })
        .catch(error => {
        console.error('Erro ao obter pontos turísticos:', error);
        });
    }
```
</details>

<details><summary>Exemplo de código: Temperatura Atual</summary>

```javascript
    import React from 'react';
import { View, Text, StyleSheet } from 'react-native';
import Proptypes from 'prop-types';
import { weatherConditions } from '../../components/Util/WeatherCondition';


const Weahter = ({ weather, temperature }) => {
    console.log(temperature)
    return (
        <View style={[styles.weatherContainer, { backgroundColor: weatherConditions[weather].color }]}>
            <View style={styles.headerContainer}>
                <Text style={styles.tempText}>{temperature}°</Text>
            </View>
            <View style={styles.bodyContainer}>
                <Text style={styles.title}>{weatherConditions[weather].title}</Text>
                <Text style={styles.subtitle}>{weatherConditions[weather].subtitle}</Text>
            </View>
        </View>
    )
};

Weahter.Proptypes = {
    temperature: Proptypes.number.isRequired,
    weather: Proptypes.string
}

export default Weahter;
```
</details>

## Aprendizados Efetivos ![Aprendizados efetivos](https://img.shields.io/badge/-Aprendizados%20Efeitvos-blue)

Durante o desenvolvimento do projeto Helena, adquiri conhecimentos significativos em diversas áreas. Aprendi a utilizar o framework React Native para desenvolvimento de aplicativos móveis, o que me permitiu criar interfaces intuitivas e responsivas para o aplicativo. Aprofundei meus conhecimentos em JavaScript, especialmente em relação ao uso de Promises e a integração com APIs externas. Também desenvolvi habilidades em design de interface do usuário (UI) e experiência do usuário (UX), trabalhando com o Figma para criar protótipos e garantir uma boa usabilidade no aplicativo. Além disso, aprendi a colaborar efetivamente em uma equipe de desenvolvimento, participando de reuniões, compartilhando ideias e contribuindo para a evolução do projeto. Por fim, destaco a importância da documentação técnica, que me proporcionou uma melhor compreensão do projeto e facilitou a comunicação com outros membros da equipe.

- [x] HTML
- [x] CSS
- [x] JavaScript
- [x] React
- [x] React Native
- [x] API Integration
- [x] UI/UX Design
- [x] Collaboration and teamwork
- [x] Documentation


