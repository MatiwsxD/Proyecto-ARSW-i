import "./Game.css"
import { useState } from "react";
import {over} from 'stompjs';
import SockJS from 'sockjs-client';

import { useRef,useEffect} from "react";

var player = null
var turn = null
var sala = null
var stompClient = null

export let Game = function(){
    var [board, setBoard] = useState(["","","","","","","","",""])    
    useEffect(() => {
        getData();
        socketWeb();
     }, [])

    async function getData(){
        sala = localStorage.getItem("Sala")
        //console.log(sala);
        let url = 'http://localhost:8080/tictac/players/'+sala
        let players = await fetch(url,{
            method: 'GET'
            }).then(response => response.json());
        player = players;
        if(players === 1){
           turn  = true;
        }
        else{
            turn  = false;
        }
    }

    function socketWeb(){
        let Sock = new SockJS("http://localhost:8080/tictactoe")
        stompClient = over(Sock);
        stompClient.connect({},function(){
            stompClient.subscribe('/events/ws/'+sala, function(x){
                let y = x.body.split(',').map(function(item) {
                    return parseInt(item, 10);
                });
                turn  = !turn 
                chooseSquare(y[0],y[1])
                //console.log(y)                
           }) 
        })
    }
    

    let chooseSquare = function(player1, square){
        setBoard(
            board.map((val,idx)=>{
                if(idx === square && val ===""){
                    return player1
                }
                return val
            })
        )
        

    }
    let sendMessage = function(pos){
        console.log("t,",turn)
        console.log("p,",player)
        console.log("s,",sala)
        console.log("st,",stompClient)
        if(turn){

            stompClient.send('/events/ws/'+sala,{},[player,pos])
        }
        
    }




    return(
        <div className="App">
            <div className="board">
                <div className="row">
                    <Square val={board[0]} chooseSquare={()=>sendMessage(0)}/>
                    <Square val={board[1]} chooseSquare={()=>sendMessage(1)}/>
                    <Square val={board[2]} chooseSquare={()=>sendMessage(2)}/>
                </div>
                <div className="row">
                    <Square val={board[3]} chooseSquare={()=>sendMessage(3)}/>
                    <Square val={board[4]} chooseSquare={()=>sendMessage(4)}/>
                    <Square val={board[5]} chooseSquare={()=>sendMessage(5)}/>
                </div>

                <div className="row">
                    <Square val={board[6]} chooseSquare={()=>sendMessage(6)}/>
                    <Square val={board[7]} chooseSquare={()=>sendMessage(7)}/>
                    <Square val={board[8]} chooseSquare={()=>sendMessage(8)}/>
                </div>

            </div>
        </div>
        



    );

}

let Square = function({val, chooseSquare}){
    return (
        <div className="square" onClick={chooseSquare}>
            {val}
        </div>
    )
}