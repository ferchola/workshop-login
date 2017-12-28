Feature: Login feature

@CTF-001
  Scenario: Ingreso con datos correctos
    Given un usuario ingresa a la app
    When el usuario ingresa agiledivision y 123456
    Then la aplicacion muestra la pantalla de bienvenida y los datos del usuario

@CTF-001
  Scenario: Ingreso con datos incorrectos
    Given un usuario ingresa a la app
    When el usuario ingresa agiledivision y 9999
    Then la aplicacion muestra un mensaje de error
