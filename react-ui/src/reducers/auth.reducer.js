import { SIGNIN_REQUEST, SIGNIN_ERROR, SIGNIN_SUCCESS } from '../constants';

let user = JSON.parse(localStorage.getItem('user'));
const initialState = user ? { loggedIn: true, user } : { isAuthenticating: false, loggedIn: false};

const authReducer = (state = initialState, action) => {

    switch (action.type) {

        case SIGNIN_REQUEST:
            return {
                isAuthenticating: true
            };
        case SIGNIN_ERROR:
            return {
                isAuthenticating: false,
                status: action.response.status,
                message: action.response.message
            };
        case SIGNIN_SUCCESS:
            return {
                loggedIn: true,
                isAuthenticating: false
            };
        default:
            return state;
    }
};

export default authReducer;