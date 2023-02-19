import { Service } from "app/services/service";
import { Sos } from "app/sos/sos";

export class Constituent {
    constructor(
        public id: number,
        public path: String,
        public services: Array<Service>,
        public sos: Sos
        
    ) {
        
    }
}