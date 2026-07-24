"use strict";
let sportsOne = ["Golf", "Swimming", "Basketball", "Baseball"];
for (let i = 0; i < sportsOne.length; i++) {
    console.log(sportsOne[i]);
}
// simplified For Loop
for (let tempSport of sportsOne) {
    if (tempSport == "Basketball") {
        console.log(tempSport + "<< My Favorite!");
    }
    else {
        console.log(tempSport);
    }
}
