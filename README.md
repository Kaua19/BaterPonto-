⏱️ BaterPonto! — Sistema de Controle de Ponto e Banco de Horas
📌 Visão Geral

WorkTime é um sistema de controle de ponto pessoal, desenvolvido com foco em boas práticas de engenharia de software, modelagem de domínio e aprendizado profissional.

O sistema permite que o usuário registre seus 4 pontos diários de trabalho, calcule automaticamente o tempo trabalhado, o saldo diário e mantenha um banco de horas acumulado por período, respeitando regras reais de empresas.

Este projeto foi pensado não apenas para funcionar, mas para demonstrar capacidade de raciocínio técnico, arquitetura limpa e regras de negócio bem definidas.

🎯 Objetivos do Projeto

Criar um sistema realista de controle de ponto

Aplicar conceitos de Domain-Driven Design (DDD)

Separar corretamente domínio, aplicação e infraestrutura

Trabalhar regras de negócio claras e auditáveis

Servir como projeto de portfólio profissional

🧩 Funcionalidades Principais

Autenticação de usuário (login e senha)

Registro de ponto diário com 4 marcações:

Entrada

Saída para almoço

Volta do almoço

Saída final

Cálculo automático de:

Tempo trabalhado no dia

Saldo diário (positivo ou negativo)

Banco de horas acumulado por período

Tratamento de:

Faltas

Atestados (não impactam o banco de horas)

Histórico diário de registros

🏗️ Arquitetura do Sistema

O projeto segue uma arquitetura em camadas, com responsabilidades bem definidas:

📱 Mobile App (futuro)
        ↓
🌐 API REST (Spring Boot)
        ↓
🧠 Domínio
        ↓
🗄️ Banco de Dados

🧠 Modelagem de Domínio (Core)
🔹 Entidades
User

Representa o usuário do sistema.

id

nome

email

senha

RegistroDiario

Representa um dia de trabalho realmente realizado.

Criado apenas quando o primeiro ponto é batido

Controla a sequência correta dos pontos

Possui estado interno (máquina de estados)

Estados possíveis:

INICIAL

ENTRADA_REGISTRADA

SAIDA_ALMOCO_REGISTRADA

VOLTA_ALMOCO_REGISTRADA

FECHADO

🔹 Value Objects
JornadaTrabalho

Representa a carga horária esperada (ex: 8h30min)

Regra fixa do domínio

BancoHoras

Mantém o saldo acumulado do usuário

Atualizado a partir dos saldos diários

🔹 Services
RegistroPontoService

Orquestra a criação do RegistroDiario

Encaminha a batida de ponto para a entidade correta

FechamentoDiaService

Responsável por:

Identificar dias sem registro

Aplicar regra de FALTA ou ATESTADO

Atualizar o banco de horas

📐 Regras de Negócio Importantes

O dia só é considerado trabalhado se o primeiro ponto for batido

O dia é fechado automaticamente ao bater o 4º ponto

Não é permitido bater ponto fora de ordem

Um registro diário fechado é imutável

Dias sem registro são considerados falta

Faltas impactam negativamente o banco de horas

Atestados removem o impacto negativo da falta

Não existe limite para saldo positivo ou negativo

⏰ Tratamento de Tempo

Utiliza a API moderna java.time

Horários são capturados pelo sistema (não pelo usuário)

Uso de Clock para garantir:

Segurança

Testabilidade

Previsibilidade

🛠️ Tecnologias Utilizadas
Backend

Java

Spring Boot

Spring Data JPA

Spring Security (JWT)

PostgreSQL

Ferramentas

Maven

Postman / Insomnia

Git & GitHub

Mobile (planejado)

React Native ou Android nativo

📚 Conceitos Aplicados

Domain-Driven Design (DDD)

Single Responsibility Principle (SRP)

Open/Closed Principle (OCP)

Encapsulamento de regras de negócio

Máquina de estados

Arquitetura em camadas

Design orientado a domínio

🚀 Status do Projeto

🛠️ Em desenvolvimento
Foco atual: construção sólida do domínio e backend.

👨‍💻 Autor

Kauã Henrique 
"Dedico esse projeto ao maior arquiteto, engenheiro, programador de todos os tempo, meu Senhor Jesus Cristo"
Estudante de Ciência da Computação
Foco em Back-end Java e Engenharia de Software.
