import React from 'react';
import { Route, Redirect } from 'react-router-dom';
import {useSelector} from 'react-redux';

/**
 * PrivateRoute Component
 * @param Component
 * @param rest
 * @returns {*}
 * @constructor
 */
const PrivateRoute = ({ component: Component, ...rest }) => {

    const userPayload = useSelector(state => state.auth);

    return (
        <Route {...rest} render={(props) => (
            userPayload.loggedIn === true
                    ?   <Component {...rest} {...props} />
                    :   <Redirect
                        to={{
                            pathname: '/signin',
                            state: { from: props.location }
                        }}/>
        )}/>
    );
};

export default PrivateRoute;