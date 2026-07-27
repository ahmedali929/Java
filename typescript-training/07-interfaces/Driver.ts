import { Coach } from "./Coach";
import { BasketballCoach } from "./BasketballCoach";
import { SwimmingCoach } from "./SwimmingCoach";

let myBasketballCoach = new BasketballCoach();
console.log(myBasketballCoach.getDailyWorkout());

let mySwimmingCoach = new SwimmingCoach();
console.log(mySwimmingCoach.getDailyWorkout());