import React, { useState } from 'react';
import useForm from 'react-hook-form';
import { Button, Spinner } from 'react-bootstrap';
import { SignInService } from '../apis/SignInService';
import { useSelector, useDispatch } from "react-redux";
import { userActions } from "../actions/user.action";

const SignIn = () => {

    const dispatch = useDispatch();

    const { register, handleSubmit, errors, setError } = useForm();

    const userPayload = useSelector((state) => state.user);

    const onSubmit = (data, e) => {

        /*
        setLoading(true);

        SignInService(data)
            .then(response => {
                setLoading(false);
                if(response.status === 'error') {
                    // set an error with type and message
                    setError("signin", "failed", response.message);
                }
            });
         */
        dispatch(userActions.signIn(data));

        e.target.reset();

    };

    console.log("User Payload:", userPayload);
    console.log("User Payload:", userPayload.message);

    if(userPayload.status === "error") {
        setError("signin", "failed", userPayload.message);
    }

    return(
        <div className="container text-center">
            <form className="form-signin" onSubmit={handleSubmit(onSubmit)}>
                <h1 className="h3 mb-3 font-weight-normal">Sign In</h1>
                <div>
                    <label htmlFor="inputUsername" className="sr-only">Username</label>
                    <input type="text"
                           id="inputUsername"
                           name="username"
                           className="form-control"
                           placeholder="Username"
                           ref={register({
                               required: 'Required'})
                           }
                           autoFocus/>
                    {errors.username && <div className="form-error">{errors.username.message}</div>}
                </div>
                <label htmlFor="inputPassword" className="sr-only">Password</label>
                <input  type="password"
                        name="password"
                        id="inputPassword"
                        className="form-control"
                        placeholder="Password"
                        ref={register({ required: 'Required' })}
                        />
                        {/* errors will return when field validation fails  */}
                {errors.password && <div className="form-error">{errors.password.message}</div>}
                {errors.signin && <div className="form-error">{errors.signin.message}</div>}
                <Button
                    className="btn-block"
                    variant="primary"
                    disabled={userPayload.isAuthenticating}
                    type="submit"
                >
                    {userPayload.isAuthenticating ?
                        (<Spinner
                        as="span"
                        animation="border"
                        size="sm"
                        role="status"
                        aria-hidden="true"
                    />) : 'Sign in'}
                </Button>
            </form>
        </div>
    );
};

export default SignIn;