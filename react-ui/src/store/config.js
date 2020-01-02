import { createStore, applyMiddleware } from "redux";
import thunkMiddleware from "redux-thunk";
import { createLogger } from "redux-logger";
import rootReducer from "../reducers";
import { composeWithDevTools } from 'redux-devtools-extension/developmentOnly';

/**
 * Setting custom logger
 * @see https://www.npmjs.com/package/redux-logger
 * @type {Function|*}
 */
const loggerMiddleware = createLogger({
    // ...options
});

/**
 * Configure app redux store
 * @param preloadState
 * @returns {Store<unknown, AnyAction> & Store<S & {}, A> & {dispatch: Dispatch<A>}}
 */
const config = (preloadState) => {
    return createStore(
        rootReducer,
        preloadState,
        composeWithDevTools(
            applyMiddleware(thunkMiddleware, loggerMiddleware)
        )
    )
};

export default config;