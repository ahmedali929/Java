export declare abstract class Shape {
    private _x;
    private _y;
    constructor(_x: number, _y: number);
    get x(): number;
    set x(value: number);
    get y(): number;
    set y(value: number);
    getInfo(): string;
    abstract calculateArea(): number;
}
//# sourceMappingURL=Shape.d.ts.map