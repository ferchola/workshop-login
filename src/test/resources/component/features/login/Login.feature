Feature: Login feature

@CTF-001
  Scenario: Ingreso con datos correctos
    Given el usuario agiledivision ingresa a la app
    And el usuario agiledivision esta registrado
    When el usuario ingresa agiledivision y 123456
    Then la aplicacion muestra la pantalla de bienvenida y los datos del usuario

@CTF-001
  Scenario: Ingreso con datos incorrectos
    Given el usuario agiledivision ingresa a la app
    And el usuario agiledivision esta registrado
    When el usuario ingresa agiledivision y 9999
    Then la aplicacion muestra un mensaje de error
