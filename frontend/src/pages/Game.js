import "./Game.css"
import { useState } from "react";
import {over} from 'stompjs';
import SockJS from 'sockjs-client';

import { useEffect} from "react";

export let Game = function(){
    let [board, setBoard] = useState(["","","","","","","","",""])
    let turn = null;
    useEffect(()=> {
        async function getData(){
            let sala = localStorage.getItem("Sala")
            //console.log(sala);
            let url = 'http://localhost:8080/tictac/players/'+sala
            let players = await fetch(url,{
                method: 'GET'
              }).then(response => response.json());
            if(players == 1){
                turn = true
            }
            else{
                turn = false;
            }
        }

        async function socketWeb(){
            let Sock = new SockJS("http://localhost:8080/tictactoe")
        }


    getData()},[])
        
    



    return(
        <div className="App">
            <div className="board">
                <div className="row">
                    <Square val={board[0]} chooseSquare={()=>{alert(1)}}/>
                    <Square val={board[1]} chooseSquare={()=>{alert(1)}}/>
                    <Square val={board[2]} chooseSquare={()=>{alert(2)}}/>
                </div>
                <div className="row">
                    <Square val={board[3]} chooseSquare={()=>{alert(3)}}/>
                    <Square val={board[4]} chooseSquare={()=>{alert(4)}}/>
                    <Square val={board[5]} chooseSquare={()=>{alert(5)}}/>
                </div>

                <div className="row">
                    <Square val={board[6]} chooseSquare={()=>{alert(6)}}/>
                    <Square val={board[7]} chooseSquare={()=>{alert(7)}}/>
                    <Square val={board[8]} chooseSquare={()=>{alert(8)}}/>
                </div>

            </div>
        </div>
        



    );

}

let Square = function({val, chooseSquare}){
  