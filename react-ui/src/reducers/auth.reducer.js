import { SIGNIN_REQUEST, SIGNIN_ERROR, SIGNIN_SUCCESS, ACCESS_TOKEN } from '../constants';

// Initial State
let access_token = localStorage.getItem(ACCESS_TOKEN);
const initialState = access_token ? { loggedIn: true} : { isAuthenticating: false, loggedIn: false};

/**
 * Auth Reducer
 * @param state
 * @param action
 * @returns {{message: *, isAuthenticating: boolean, status: *}|{loggedIn: boolean, isAuthenticating: boolean}}
 */
const authReducer = (state = initialState, action) => {

    switch (action.type) {

        case SIGNIN_REQUEST:
            return {
                loggedIn: false,
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