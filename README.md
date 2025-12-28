⏱️ BaterPonto! — Sistema de Controle de Ponto e Banco de Horas
📌 Visão Geral

BaterPonto! é um sistema de controle de ponto pessoal desenvolvido com foco em boas práticas de engenharia de software, modelagem de domínio e arquitetura limpa.

O sistema permite o registro dos 4 pontos diários de trabalho, calcula automaticamente o tempo trabalhado, o saldo diário e mantém um banco de horas acumulado, respeitando regras reais adotadas por empresas.

Este projeto tem como objetivo principal aprendizado técnico profundo e composição de portfólio profissional.

🎯 Objetivos

Modelar um sistema realista de controle de ponto

Aplicar conceitos de Domain-Driven Design (DDD)

Separar claramente domínio, aplicação e infraestrutura

Implementar regras de negócio claras, auditáveis e consistentes

Demonstrar maturidade em arquitetura e design de software

🧩 Funcionalidades

Autenticação de usuários (login e senha)

Registro de ponto diário:

Entrada

Saída para almoço

Volta do almoço

Saída final

Cálculo automático de:

Tempo trabalhado no dia

Saldo diário (positivo ou negativo)

Banco de horas acumulado

Tratamento de:

Faltas

Atestados (não impactam o banco de horas)

Histórico de registros diários

🏗️ Arquitetura

Arquitetura em camadas, com responsabilidades bem definidas:

📱 Mobile App (futuro)
        ↓
🌐 API REST (Spring Boot)
        ↓
🧠 Camada de Domínio
        ↓
🗄️ Banco de Dados

🧠 Modelagem de Domínio
🔹 Entidades

User
Representa o usuário do sistema.

RegistroDiario
Representa um dia efetivamente trabalhado.

Criado apenas quando o primeiro ponto é batido

Controla a sequência correta dos pontos

Possui máquina de estados interna

Estados:

INICIAL

ENTRADA_REGISTRADA

SAIDA_ALMOCO_REGISTRADA

VOLTA_ALMOCO_REGISTRADA

FECHADO

🔹 Value Objects

JornadaTrabalho

Representa a carga horária esperada (ex: 8h30min)

BancoHoras

Mantém o saldo acumulado do usuário

Atualizado a partir dos saldos diários

🔹 Services

RegistroPontoService

Orquestra a criação do registro diário

Encaminha as batidas de ponto para a entidade

FechamentoDiaService

Identifica dias sem registro

Aplica regras de falta ou atestado

Atualiza o banco de horas

📐 Regras de Negócio

O dia só é considerado trabalhado se o primeiro ponto for batido

O dia é fechado automaticamente no 4º ponto

Não é permitido bater ponto fora de ordem

Registros fechados são imutáveis

Dias sem registro são considerados falta

Faltas impactam negativamente o banco de horas

Atestados removem o impacto negativo

Não há limite para saldo positivo ou negativo

⏰ Tratamento de Tempo

Uso da API moderna java.time

Horários capturados pelo sistema

Utilização de Clock para garantir:

Segurança

Testabilidade

Previsibilidade

🛠️ Tecnologias
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

🚀 Status

🛠️ Em desenvolvimento
Foco atual: construção sólida do domínio e backend.

👨‍💻 Autor
Kauã Henrique
Estudante de Ciência da Computação
Foco em Back-end Java e Engenharia de Software

“Dedico este projeto ao maior arquiteto e engenheiro de todos os tempos, meu Senhor Jesus Cristo.
