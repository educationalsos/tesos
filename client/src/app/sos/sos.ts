import { Behavior } from "app/behaviors/behavior";
import { Constituent } from "app/constituents/constituent";
import { Mission } from "app/missions/mission";

export class Sos {
    constructor(public id: number,
                public name: string,
                public description: string,
                public mkaos_model: string,
                public missions?: Array<Mission>,
                public behaviors?: Array<Behavior>,
                public constituents?: Array<Constituent>
        ) {
        
    }
}