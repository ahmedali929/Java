import { Coach } from "./Coach";
import { BasketballCoach } from "./BasketballCoach";
import { SwimmingCoach } from "./SwimmingCoach";

let myBasketballCoach = new BasketballCoach();
let mySwimmingCoach = new SwimmingCoach();

let theCoaches: Coach[] = [];

theCoaches.push(myBasketballCoach);
theCoaches.push(mySwimmingCoach);

for (let coach of theCoaches) {
    console.log(coach.getDailyWorkout());
}