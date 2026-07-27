"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
const Circle_1 = require("./Circle");
const Rectangle_1 = require("./Rectangle");
let myCircle = new Circle_1.Circle(5, 10, 20);
let myRectangle = new Rectangle_1.Rectangle(0, 0, 3, 7);
// declare an array of shapes....initially empty
let theShapes = [];
// add shapes to the array
theShapes.push(myCircle);
theShapes.push(myRectangle);
for (let shape of theShapes) {
    console.log(shape.getInfo());
    console.log("Area = " + shape.calculateArea());
    console.log();
}
//# sourceMappingURL=ArrayDriver.js.map