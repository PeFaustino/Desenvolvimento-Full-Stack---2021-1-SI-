var bt0 = document.querySelector('.bt0');
var bt1 = document.querySelector('.bt1');
var bt2 = document.querySelector('.bt2');
var bt3 = document.querySelector('.bt3');
var bt4 = document.querySelector('.bt4');
var bt5 = document.querySelector('.bt5');
var bt6 = document.querySelector('.bt6');
var bt7 = document.querySelector('.bt7');
var bt8 = document.querySelector('.bt8');
var bt9 = document.querySelector('.bt9');

var btAdd = document.querySelector('.btAdd');
var btSub = document.querySelector('.btSub');
var btMul = document.querySelector('.btMul');
var btDiv = document.querySelector('.btDiv');

var btReset = document.querySelector('.btReset');
var btPonto = document.querySelector('.btPonto');
var btResut = document.querySelector('.btResut');

var num1 = 0;
var num2 = 0;
var op = null;
var resultado = null;
var concluido = false;
var decimal = false;
var display = document.querySelector('.display');

btAdd.addEventListener('click', function(){
    decimal = false;
    op = "+";
    addDisplay("+");
});




bt1.addEventListener('click', function(){
    addCalc(1);
    addDisplay(1);
});
bt2.addEventListener('click', function(){
    addCalc(2);
    addDisplay(2);
});



function addCalc(n){
    if(concluido){
        reset();
        concluido = false;
    }

    if(op == null){
        if(decimal){
            num1 += + n/10;
        }else{
            num1 = num1*10 + n;
        }
    }else{
        if(decimal){
            num2 += + n/10;
        }else{
            num2 = num2*10 + n;
        }
    }

    if(num1 == 0 || op == null || num2 == 0){
        btResut.disabled = true;
    }else{
        btResut.disabled = false;
    }
}


btResut.addEventListener('click', function(){
    concluido = true;
    switch (op){
        case "+" :
            soma();
            break;
    }
})


function soma(){
    setDisplay(num1 + num2);
}


function addDisplay(n){
    console.log(display.textContent.length);
    if(display.textContent.length < 12){
        display.textContent += n; 
    }
}

function setDisplay(str){
    display.textContent = str;
    if(display.textContent <= 12){
        display.textContent = display.textContent.trim();
    }else{
        display.textContent = display.textContent.substr(0, 11);
    }
}

btReset.addEventListener('click', reset);

function reset(){
    num1 = 0;
    num2 = 0;
    op = null;
    resultado = null;
    display.textContent = '';
    btResut.disabled = true;
    decimal = false;
}
