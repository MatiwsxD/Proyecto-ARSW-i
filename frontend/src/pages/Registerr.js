import React, {useState} from 'react';
import './register.css'
import { useNavigate } from 'react-router-dom';
export let Registerr= function() {

    let [userName, setUserName] = useState('');
    let [email, setEmail] = useState('');
    let [password, setPassword] = useState('');
    let [confirmPassword, setcPassword] = useState('');
    let navigate = useNavigate();

    let checkCampos = function(){
        if(userName === '' ||  email ==='' || password === '' || confirmPassword === ''){
            console.log('Debe llenar todos los campos') //Modificar con una alerta
        }
        
        isRegistered();

        
    }

    let isRegistered = async()=>{
        let url = 'http://localhost:8080/tictac/checkUser/'+email
        let data = await fetch(url,{
            method: 'GET'
          }).then(response => response.json());
        if(!data){
            submit();
            alert("El usuario se registro correctamente")
        }
        else{
            alert("El usuario ya se encuentra registrado")
        }

    }

    let submit= async()=>{

        let url = 'http://localhost:8080/tictac/registry/'+userName+'/'+email+'/'+password;
        
        await fetch(url,{
            mode: 'no-cors',
            method: 'POST'
            });

    }

    let iniciarSesion = function(){
       
        navigate('/login')
    }

    



    return(
      <div className="form">
          <div className="form-body">
              <div className="lastname">
                  <label className="form__label" for="userName">NickName</label>
                  <input  type="text" name="" id="lastName"  className="form__input"placeholder="LastName" onChange={e=>setUserName(e.target.value)}/>
              </div>
              <div className="email">
                  <label className="form__label" for="email">Email </label>
                  <input  type="email" id="email" className="form__input" placeholder="Email" onChange={e=>setEmail(e.target.value)}/>
              </div>
              <div className="password">
                  <label className="form__label" for="password">Password </label>
                  <input className="form__input" type="password"  id="password" placeholder="Password" onChange={e=>setPassword(e.target.value)}/>
              </div>
              <div className="confirm-password">
                  <label className="form__label" for="confirmPassword">Confirm Password </label>
                  <input className="form__input" type="password" id="confirmPassword" placeholder="Confirm Password"onChange={e=>setcPassword(e.target.value)}/>
              </div>
          </div>
          <div class="footer">
              <button type="submit" class="btn" onClick={checkCampos}>Register</button>
              <button type="submit" class="btn" onClick={iniciarSesion}>Iniciar Sesion</button>
              
          </div>
      </div>      
    )       
}
