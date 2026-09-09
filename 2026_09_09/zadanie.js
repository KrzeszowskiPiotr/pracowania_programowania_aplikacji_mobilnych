function fibonacci(n){
    
    if(n==1){
        return 0
    }
    else if (n==2){
        return 1
    }
    let a=0
    let b=1
    for(let i=3;i<=n;i++){
        [a,b]=[b,a+b]
    }
    return b
}
function pobierzDaneIOblicz(){
    const readline = require('node:readline');
    const rl = readline.createInterface({
        input: process.stdin,
        output: process.stdout,
    });
    rl.question(`Podaj ktory element z ciagu fibonacciego chcesz poznac: `, liczba => {
        if (liczba<=0 || isNaN(liczba)){
            console.log("Nie jest to mozliwe")
        }
        else{
            let wynik=fibonacci(liczba)
            console.log(liczba+" liczba w ciagu fibonacciego to "+wynik)
        }
        
        rl.close();
    });
}
pobierzDaneIOblicz()
