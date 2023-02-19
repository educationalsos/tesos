import { Constituent } from "app/constituents/constituent";

export class Service {
    constructor(
        public id: number,
        public name: String,
        public link: String,
        public constituent: Constituent,
        public satisfied: boolean
    ) {
        
    }
}