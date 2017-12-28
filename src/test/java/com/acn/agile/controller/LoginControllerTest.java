package com.acn.agile.controller;

import com.acn.agile.exception.LoginException;
import com.acn.agile.service.LoginService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class LoginControllerTest {

    @InjectMocks
    LoginController loginController;

    @Mock
    LoginService loginService;

    private static final String ERROR_MSG = "Something went wrong, please try again";


    @Test
    public void shouldShowUserDataWhenValidLogin() throws Exception {
        when(loginService.doLogin(anyString(), anyString()))
                .thenReturn("Hello friend");

        String loginResult = loginController.doLogin("myUser", "myPassword");
        assertFalse("it should not show an error message",
                loginResult.equals(ERROR_MSG));
    }

    @Test
    public void shouldShowErrorMsgWhenInvalidLogin() throws Exception {
        when(loginService.doLogin(anyString(), anyString()))
                .thenThrow(new LoginException());

        String loginResult = loginController.doLogin("myUser", "myPassword");
        assertTrue("it should not show an error message",
                loginResult.equals(ERROR_MSG));
    }

}