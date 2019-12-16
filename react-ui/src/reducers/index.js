import { combineReducers } from "redux";
import authReducer from "./auth.reducer";

/**
 * Root Reducer which will hold list of app reducers
 * @see https://redux.js.org/api/combinereducers
 * @type {Reducer<unknown>}
 */
const rootReducer = combineReducers({
    user: authReducer
});

export default rootReducer;