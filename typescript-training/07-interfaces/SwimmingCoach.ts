import { Coach } from "./Coach";

export class SwimmingCoach implements Coach {
    getDailyWorkout(): string {
        return "Practice your butterfly strokes";
    }
}