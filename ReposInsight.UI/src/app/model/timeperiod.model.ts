export class Timeperiod {
    public start : string;
    public end : string;
    public display_label : string;

    constructor(start: string, end: string, display_label: string){
        this.start = start
        this.end = end
        this.display_label = display_label
    }
}
