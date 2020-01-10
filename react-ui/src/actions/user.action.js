import { signInService } from '../services/signin.service';
import { SIGNIN_REQUEST, SIGNIN_ERROR, SIGNIN_SUCCESS, ACCESS_TOKEN, SIGNOUT } from '../constants';
import { history } from '../helpers/history';

/**
 * User Actions
 */
export const userActions = {
    signIn,
    signOut,
    signUp
};

/**
 * SignInRequest
 * @returns {{type: string}}
 * @constructor
 */
function SignInRequest() {
    return {
        type: SIGNIN_REQUEST
    }
}

/**
 * SignInError
 * @param response
 * @returns {{response: SignInError.props, type: string}}
 * @constructor
 */
function SignInError(response) {
    return {
        type: SIGNIN_ERROR,
        response
    }
}

/**
 * SignInSuccess
 * @param response
 * @returns {{response: SignInSuccess.props, type: string}}
 * @constructor
 */
function SignInSuccess(response) {
    return {
        type: SIGNIN_SUCCESS,
        response
    }
}

/**
 * SignIn
 * @param data
 * @returns {function(...[*]=)}
 */
function signIn(data) {

    return dispatch => {

        // Initiating login request
        dispatch(SignInRequest());

        // Passing login data to sign in service
        signInService(data)
            .then(response => {
                // If error
                if(response.status === 'error') {
                    dispatch(SignInError(response));
                } else {

                    // if success then redirect user to dashboard
                    dispatch(SignInSuccess(response));
                    history.push("/dashboard");
                }
            });
    }
}

function signOut() {
    localStorage.removeItem(ACCESS_TOKEN);
    return {
        type:SIGNOUT
    }
}

function signUp() {

}