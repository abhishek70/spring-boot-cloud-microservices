import React from 'react';
import {NavLink} from 'react-router-dom';
import './dashboard.css';

const Dashboard = () => {

    return(
        <div>
            <div className="d-flex flex-column flex-md-row align-items-center p-3 px-md-4 bg-white border-bottom shadow-sm">
                <h2 className="my-0 mr-md-auto font-weight-normal">FoodDash</h2>
                <nav className="my-2 my-md-0 mr-md-3">
                    <NavLink exact activeClassName="active" to="/signin" className="btn btn-outline-primary m-2">Sign out</NavLink>
                </nav>
            </div>
            <div className="container-fluid">
                <div className="row">
                    <nav className="col-md-2 d-none d-md-block bg-light sidebar">
                        <div className="sidebar-sticky">
                            <ul className="nav flex-column">
                                <li className="nav-item">
                                    <span className="nav-link active">Dashboard</span>
                                </li>
                            </ul>
                        </div>
                    </nav>

                    <main role="main" className="col-md-9 ml-sm-auto col-lg-10 px-4">
                        <div
                            className="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
                            <h1 className="h2">Dashboard</h1>
                        </div>
                    </main>
                </div>
            </div>
        </div>
    );
};

export default Dashboard;