import { Shape } from "./Shape";
export declare class Rectangle extends Shape {
    private _width;
    private _length;
    constructor(theX: number, theY: number, _width: number, _length: number);
    get width(): number;
    set width(value: number);
    get length(): number;
    set length(value: number);
    getInfo(): string;
}
//# sourceMappingURL=Rectangle.d.ts.map