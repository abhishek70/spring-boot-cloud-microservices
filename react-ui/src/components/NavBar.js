import React from 'react';
import {Link, NavLink} from "react-router-dom";

const NavBar = () => {

    return (
        <div className="d-flex flex-column flex-md-row align-items-center p-3 px-md-4 mb-3 bg-white border-bottom shadow-sm">
            <h2 className="my-0 mr-md-auto font-weight-normal">FoodDash</h2>
            <nav className="my-2 my-md-0 mr-md-3">
                <Link to="/" className="p-2 text-dark">About</Link>
            </nav>
            <NavLink exact activeClassName="active" to="/signin" className="btn btn-outline-primary m-2">Sign In</NavLink>
            <NavLink exact activeClassName="active" to="/signup" className="btn btn-outline-primary m-2">Sign Up</NavLink>
        </div>
    );
}

export default NavBar;