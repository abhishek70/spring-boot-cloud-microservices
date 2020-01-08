import React from 'react';
import {
    Router,
    Switch,
    Route,
    Redirect
} from 'react-router-dom';
import About  from './About';
import Footer from '../components/Footer';
import SignIn from './SignIn';
import SignUp from './SignUp';
import Dashboard from './Dashboard';
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