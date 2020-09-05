# DomiMall back-end
Repository designated for the back-end of DomiMall application

## Code Status

[![Build Status](https://travis-ci.com/MJAJUdeA/domimall-backend.svg?branch=develop)](https://travis-ci.com/MJAJUdeA/domimall-backend)
[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=io.mjaj%3Adomimall-backend&metric=alert_status)](https://sonarcloud.io/dashboard?id=io.mjaj%3Adomimall-backend)

## Required Technologies

* Java
* Maven
* Spring Boot
* JPA

## Description

The Clean Architecture of Robert C. Martin is being used, which is the "product" of different architectures or proposals such as Onion Architecture, Hexagonal Architecture (Ports and Adapters) and putting into practice the principles of Domain Driven Design, with good practices of code, refactoring, component packaging, SOLID principles, always trying to keep the layers decoupled and having the domain and use cases at the center.

We are also using Karate to test the api more easily, in addition to automating the tests, with reports, and with a focus on behavior (with pseudo BDD).
