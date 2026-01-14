
interface minutesAndSeconds {
    minutes : string,
    seconds : string
}

export const convertDecimalTime = (time:number) : minutesAndSeconds => {
    const stringTime = time.toString().split('.');
    const minutes = stringTime[0];
    const decimal = stringTime[1] || "0";

    const secondsInString =  (60 * Number.parseInt(decimal) / 10).toString();
    let seconds;
    //console.log(secondsInString + " " + secondsInString.length);
    switch (secondsInString.length){
        case 2:
            seconds = secondsInString;
            break;
        case 1:
            seconds = "0" + secondsInString;
            break;
        default:
            seconds = secondsInString.substring(0,2);
            break;
    }
    return {
        minutes,
        seconds
    }
}