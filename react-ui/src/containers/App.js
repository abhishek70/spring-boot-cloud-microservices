import React from "react";
import { Provider } from "react-redux";
import config from "../store/config";
import {
    BrowserRouter as Router,
    Switch,
    Route
} from "react-router-dom";

import NavBar from "../components/NavBar";
import About  from "../components/About";
import Footer from "../components/Footer";
import SignIn from "../components/SignIn";
import SignUp from "../components/SignUp";


// Redux store
const store = config();

/**
 * App Container
 * @returns {*}
 * @constructor
 */
const App = () => {
    return(
        <Provider store={store}>
            <Router>
                <NavBar/>
                <Switch>
                    <Route path="/" exact component={About}/>
                    <Route path="/signin" component={SignIn}/>
                    <Route path="/signup" component={SignUp}/>
                </Switch>
                <Footer/>
            </Router>
        </Provider>
    )
};

export default App;