import React from 'react';
import {
    Router,
    Switch,
    Route,
    Redirect
} from 'react-router-dom';
import NavBar from '../components/NavBar';
import About  from '../components/About';
import Footer from '../components/Footer';
import SignIn from '../components/SignIn';
import SignUp from '../components/SignUp';
import Dashboard from '../components/Dashboard';
import PrivateRoute from '../components/PrivateRoute';
import { history } from '../helpers/history';

/**
 * App Container
 * @returns {*}
 * @constructor
 */
const App = () => {

    return(
        <Router history = {history}>
            <NavBar/>
            <Switch>
                <Route path="/" exact component={About}/>
                <Route path="/signin" component={SignIn}/>
                <Route path="/signup" component={SignUp}/>
                <PrivateRoute path="/dashboard" component={Dashboard}/>
                <Redirect from="*" to="/" />
            </Switch>
            <Footer/>
        </Router>
    )
};

export default App;