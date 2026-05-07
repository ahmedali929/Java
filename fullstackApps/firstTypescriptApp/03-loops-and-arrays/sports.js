"use strict";
let sportsOne = ["Golf", "Cricket", "Tennis", "Sprinting"];
for (let i = 0; i < sportsOne.length; i++) {
    console.log(sportsOne[i]);
}
for (let tempSport of sportsOne) {
    if (tempSport == "Cricket") {
        console.log("simplified loop: " + tempSport + " <---- Favorite Sport");
    }
    console.log("simplified loop: " + tempSport);
}
