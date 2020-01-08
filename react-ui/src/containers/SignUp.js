import React from 'react';
import useForm from 'react-hook-form';
import NavBar from "../components/NavBar";

/**
 * SignUp Component
 * @returns {*}
 * @constructor
 */
const SignUp = () => {

    const { register, handleSubmit, errors } = useForm();

    const onSubmit = data => {
        console.log(data)
    };

    return(
        <div>
            <NavBar/>
            <div className="container text-center">
                <form className="form-signin" onSubmit={handleSubmit(onSubmit)}>
                    <h1 className="h3 mb-3 font-weight-normal">Sign Up</h1>
                        <div>
                            <label htmlFor="inputFirstName" className="sr-only">First name</label>
                            <input type="text"
                                   name="firstName"
                                   id="inputFirstName"
                                   className="form-control"
                                   placeholder="First name"
                                   ref={register({
                                        required: 'Required',
                                        pattern: {
                                                    value: /^[A-Za-z]+$/i,
                                                    message: "Only letters are allowed"
                                        },
                                        maxLength: 20
                                   })
                                   }
                               autoFocus/>
                            {errors.firstName && <div className="form-error">{errors.firstName.message}</div>}
                            {errors.firstName && errors.firstName.type === 'maxLength' && <div className="form-error">Max length exceeded</div> }
                        </div>

                        <div>
                            <label htmlFor="inputLastName" className="sr-only">Last name</label>
                            <input type="text"
                                   name="lastName"
                                   id="inputLastName"
                                   className="form-control"
                                   placeholder="Last name"
                                   ref={register({
                                       required: 'Required',
                                       pattern: {
                                           value: /^[A-Za-z]+$/i,
                                           message: "Only letters are allowed"
                                       }})
                                   }
                            />
                            {errors.lastName && <div className="form-error">{errors.lastName.message}</div>}
                        </div>

                        <div>
                            <label htmlFor="inputEmail" className="sr-only">Email address</label>
                            <input type="text"
                               id="inputEmail"
                               name="email"
                               className="form-control"
                               placeholder="Email address"
                               ref={register({
                                   required: 'Required',
                                   pattern: {
                                       value: /^[A-Z0-9._%+-]+@[A-Z0-9.-]+\.[A-Z]{2,4}$/i,
                                       message: "Invalid email address"
                                   }})
                               }
                               />
                            {errors.email && <div className="form-error">{errors.email.message}</div>}
                        </div>
                        <div>
                            <label htmlFor="inputPassword" className="sr-only">Password</label>
                            <input type="password"
                               id="inputPassword"
                               name="password"
                               className="form-control"
                               placeholder="Password"
                               ref={register({
                                   required: 'Required',
                               })
                               }
                            />
                        </div>
                        {errors.password && <div className="form-error">{errors.password.message}</div>}
                        <button className="btn btn-lg btn-primary btn-block" type="submit">Sign up</button>
                </form>
            </div>
        </div>
    );
}

export default SignUp;