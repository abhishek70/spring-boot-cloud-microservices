import { SignInService } from '../apis/SignInService';
import { SIGNIN_REQUEST, SIGNIN_ERROR, SIGNIN_SUCCESS } from '../constants';

export const userActions = {
    signIn,
    signOut,
    signUp
};

function SignInRequest() {
    return {
        type: SIGNIN_REQUEST
    }
}

function SignInError(response) {
    return {
        type: SIGNIN_ERROR,
        response
    }
}

function SignInSuccess(response) {
    return {
        type: SIGNIN_SUCCESS,
        response
    }
}

function signIn(data) {

    return dispatch => {

        dispatch(SignInRequest());

        SignInService(data)
            .then(response => {
                if(response.status === 'error') {
                    dispatch(SignInError(response));
                } else {
                    dispatch(SignInSuccess(response));
                }
            });
    }
}

function signOut() {

}

function signUp() {

}