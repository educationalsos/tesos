import { ComunicationalCapability } from "app/comunicationalCapability/comunicationalCapability";

export class Behavior {
    constructor(
        public id: number,
        public name: String,
        public comunicationalCapabilities: Array<ComunicationalCapability>
    ) {
        
    }
}