package fr.android.androidexercises;

import junit.framework.TestCase;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

/**
 * Created by evyil on 22/01/2016.
 */
public class LoginPresenterTest extends TestCase {

    @Mock
    LoginActivity activity;
    @InjectMocks
    LoginPresenter loginPresenter;

    @Test
    public void password_should_be_valid() throws
            Exception {
        // Given
        // When
        loginPresenter.checkCredentials("password");
        // Then
        Mockito.verify(activity).logged();
        Mockito.verify(activity).message(R.string.text_logged);

    }

    @Test
    public void password_should_be_invalid() throws
            Exception {
        // Given
        // When
        loginPresenter.checkCredentials(null);
        // Then
        Mockito.verify(activity).notLogged();
        Mockito.verify(activity).message(R.string.notLogged);

    }
}