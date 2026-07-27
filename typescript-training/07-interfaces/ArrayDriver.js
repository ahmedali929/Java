"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
const BasketballCoach_1 = require("./BasketballCoach");
const SwimmingCoach_1 = require("./SwimmingCoach");
let myBasketballCoach = new BasketballCoach_1.BasketballCoach();
let mySwimmingCoach = new SwimmingCoach_1.SwimmingCoach();
let theCoaches = [];
theCoaches.push(myBasketballCoach);
theCoaches.push(mySwimmingCoach);
for (let coach of theCoaches) {
    console.log(coach.getDailyWorkout());
}
//# sourceMappingURL=ArrayDriver.js.map