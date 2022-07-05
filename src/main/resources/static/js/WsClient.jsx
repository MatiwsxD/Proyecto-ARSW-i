function Hello(params) {
    return(
        <div>
            <FormSignup />
        </div>
    
        )
}
function FormSignup(params){
    return(
        <div className="form-content-right">
            <form className="form">
                <h1>
                    Get started with us today! Create your account.
                </h1>
                <div className="form-inputs">
                    <label htmlFor="username" className="form-label">
                        UserName
                        <input id="username" type="text" name="username" className="form-input" placeholder="Enter your username" />
                    </label>
                </div>
                <div className="form-inputs">
                    <label htmlFor="email" className="form-label">
                        Email
                        <input id="email" type="email" name="email" className="form-input" placeholder="Enter your email" />
                    </label>
                </div>
                <div className="form-inputs">
                    <label htmlFor="password" className="form-label">
                        Password
                        <input id="password" type="password" name="password" className="form-input" placeholder="Enter your password" />
                    </label>
                </div>
                <div className="form-inputs">
                    <label htmlFor="password2" className="form-label">
                        Confirm password
                        <input id="password2" type="password2" name="password2" className="form-input" placeholder="Retry your password again" />
                    </label>
                </div>
                <button className="form-input-btn" type="submit">Sign up</button>
                <span className="form-input-login">
                    Alredy have an account? Login <a href="#">here</a>
                </span>
            </form>
        </div>
    )
}
ReactDOM.render(
    <Hello />,
    document.getElementById('timer')
);