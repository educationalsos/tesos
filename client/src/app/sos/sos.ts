import { Constituent } from "app/constituents/constituent";

export class Sos {
    constructor(public id: number,
                public name: string,
                public description: string,
                public mkaos_model: string,
                public models?: Array<Constituent>
        ) {
        
    }
}