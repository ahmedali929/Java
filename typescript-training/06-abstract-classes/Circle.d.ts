import { Shape } from './Shape';
export declare class Circle extends Shape {
    private _radius;
    constructor(theX: number, theY: number, _radius: number);
    get radius(): number;
    set radius(value: number);
    getInfo(): string;
    calculateArea(): number;
}
//# sourceMappingURL=Circle.d.ts.map